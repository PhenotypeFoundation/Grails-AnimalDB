package nl.nbic.animaldb

import groovyx.net.http.*
import static groovyx.net.http.ContentType.URLENC
import org.dbnp.gdt.Template
import grails.converters.JSON

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


	private def postToMolgenis(String entity, Map properties) {
		def rest = new RESTClient( 'http://vm7.target.rug.nl/animaldb/api/rest/json/' )

		try {
			def response = rest.post( path : entity,
								 body : properties,
								 requestContentType : URLENC )
			if (response.status != 200) {
				throw new Exception("Invalid MOLGENIS $response.status response: $response.data ")
			}

			return response.data
		}
		catch(Exception e) {
			throw new Exception("Invalid MOLGENIS response: ${e.getMessage()}")
		}

	}

	/**
	 * get an investigation from AnimalDB
	 * @param entity
	 * @return
	 */
	private def getFromMolgenis(String entity) {
		def rest = new RESTClient( 'http://vm7.target.rug.nl/animaldb/api/rest/json/' )

		try {
			def response = rest.get( path : entity )

			if (response.status != 200) {
				throw new Exception("Invalid MOLGENIS $response.status response: $response.data ")
			}

			return response.data
		}
		catch(Exception e) {
			throw new Exception("Invalid MOLGENIS response: ${e.getMessage()}")
		}

	}

	/**
	 * send an investigation to AnimalDB
	 * @param investigation
	 * @return
	 */
    def sendInvestigationToMolgenis(Investigation investigation) {

	    def answer = postToMolgenis('investigation', [ name: investigation.name ])

	    def molgenisInvestigationId = answer.investigation.id
	    println "Added investigation $molgenisInvestigationId"

	    investigation.animals.each { animal ->

		    answer = postToMolgenis('individual',[name: animal.customId, investigation: molgenisInvestigationId])
		    println "Added animal $answer.individual.id"

        }

	    // returned id assigned by MOLGENIS
	    return molgenisInvestigationId
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
			new Investigation(name: it.name, id: it.id, template: Template.list().first() )
		}

	}
}
