package nl.nbic.animaldb

import groovyx.net.http.*
import static groovyx.net.http.ContentType.URLENC
import org.dbnp.gdt.Template

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

	private def getFromMolgenis(String entity) {

		def response = rest.get( path : entity )

		if (response.status != 200) {
			throw new Exception("Invalid MOLGENIS $response.status response: $response.data ")
		}

		response.data
	}

    def sendInvestigationToMolgenis(Investigation investigation) {

	    def answer = postToMolgenis('investigation', [ name: investigation.name  + System.currentTimeMillis() ])

	    def molgenisInvestigationId = answer.investigation.id
	    println "Added investigation $molgenisInvestigationId"

	    investigation.animals.each { animal ->

		    answer = postToMolgenis('individual',[name: animal.customId, investigation: molgenisInvestigationId])
		    println "Added animal $answer.individual.id"

        }
    }

	Collection<Investigation> getInvestigationsFromMolgenis() {

		def invList = getFromMolgenis('investigation')

		invList.investigation.investigation.collect {
			new Investigation(name: it.name, template: Template.get(1) )
		}

	}
}
