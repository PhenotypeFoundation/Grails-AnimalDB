package nl.nbic.animaldb

import groovyx.net.http.*
import static groovyx.net.http.ContentType.URLENC
import org.dbnp.gdt.Template

/**
 * Molgenis Service Class
 *
 * @author Siemen Sikkema
 * @since 20110413
 *
 * Revision information:
 * $Rev$
 * $Author$
 * $Date$
 */
class MolgenisService {
    // Must be false, since the webflow can't use a transactional service. See
    // http://www.grails.org/WebFlow for more information
	static transactional = false

	/**
	 * port entity to Molgenis
	 * @param entity
	 * @param properties
	 * @return
	 */
	private def postToMolgenis(String entity, Map properties) {
		def rest = new RESTClient('http://vm7.target.rug.nl/animaldb/api/rest/json/')

		try {
			// post data to Molgenis
			def response = rest.post(path: entity,
				body: properties,
				requestContentType: URLENC)

			// check if response status was OK (200)
			if (response.status != 200) {
				throw new Exception("Invalid MOLGENIS ${response.status} response: ${response.data}")
			}

			return response.data
		} catch (Exception e) {
			// whoops!
			def message = e.getMessage()
			throw new Exception("Invalid MOLGENIS response: ${message}")
		}
	}

	/**
	 * get an investigation from AnimalDB
	 * @param entity
	 * @return
	 */
	private def getFromMolgenis(String entity) {
		def rest = new RESTClient('http://vm7.target.rug.nl/animaldb/api/rest/json/')

		try {
			def response = rest.get(path: entity)

			if (response.status != 200) {
				throw new Exception("Invalid MOLGENIS ${response.status} response: ${response.data}")
			}

			return response.data
		} catch (Exception e) {
			// Eek!
			def message = e.getMessage()
			throw new Exception("Invalid MOLGENIS response: ${message}")
		}

	}

	/**
	 * send an investigation to AnimalDB
	 * @param investigation
	 * @return
	 */
	def sendInvestigationToMolgenis(Investigation investigation) {
		try {
			def answer = postToMolgenis('investigation', [name: investigation.name])

			def molgenisInvestigationId = answer.investigation.id
			log.info ".added investigation $molgenisInvestigationId"

			investigation.animals.each { animal ->
				answer = postToMolgenis('individual', [name: animal.customId, investigation: molgenisInvestigationId])
				log.info ".added animal $answer.individual.id"
			}

			// returned id assigned by MOLGENIS
			return molgenisInvestigationId
		} catch (Exception e) {
			def message = e.getMessage()

			throw new Exception("Could not send investigation to Molgenis due to ${message}")
		}
	}

	/**
	 * fetch all investigations from AnimalDB
	 * @return
	 */
	Collection<Investigation> getInvestigationsFromMolgenis() {
		def invList = getFromMolgenis('investigation')

		// TODO: this works when there are multiple investigations in the database, if only one this will throw an error
		// MOLGENIS JSON output is not consistent
		invList.investigation.investigation.collect {
			new Investigation(name: it.name, id: it.id, template: Template.list().first())
		}
	}
}