package nl.nbic.animaldb

import groovyx.net.http.*
import static groovyx.net.http.ContentType.URLENC
import org.dbnp.gdt.Template

/**
 * Molgenis Service Class
 *
 * @author	Siemen Sikkema
 * @since	20110413
 *
 * Revision information:
 * $Rev:  66849 $
 * $Author:  duh $
 * $Date:  2010-12-08 15:12:54 +0100 (Wed, 08 Dec 2010) $
 */
class MolgenisService {

    static transactional = true

	def rest = new RESTClient( 'http://192.168.240.51:8080/molgenis_apps/api/rest/json/' )

	private def postToMolgenis(String entity, Map properties) {

		def response = rest.post( path : entity,
		                     body : properties,
		                     requestContentType : URLENC )


		if (response.status != 200) {
			throw new Exception("Invalid MOLGENIS $response.status response: $response.data ")
		}

		response.data
	}

	/**
	 * get an investigation from AnimalDB
	 * @param entity
	 * @return
	 */
	private def getFromMolgenis(String entity) {

		def response = rest.get( path : entity )

		if (response.status != 200) {
			throw new Exception("Invalid MOLGENIS $response.status response: $response.data ")
		}

		response.data
	}

	/**
	 * send an investigation to AnimalDB
	 * @param investigation
	 * @return
	 */
    def sendInvestigationToMolgenis(Investigation investigation) {

	    def answer = postToMolgenis('investigation', [ name: investigation.name  + System.currentTimeMillis() ])

	    def molgenisInvestigationId = answer.investigation.id
	    println "Added investigation $molgenisInvestigationId"

	    investigation.animals.each { animal ->

		    answer = postToMolgenis('individual',[name: animal.customId, investigation: molgenisInvestigationId])
		    println "Added animal $answer.individual.id"

        }
    }

	/**
	 * fetch all investigations from AnimalDB
	 * @return
	 */
	Collection<Investigation> getInvestigationsFromMolgenis() {
		def invList = getFromMolgenis('investigation')

		invList.investigation.investigation.collect {
			new Investigation(name: it.name, template: Template.get(1) )
		}

	}
}
