package nl.nbic.animaldb

import groovyx.net.http.*
import static groovyx.net.http.ContentType.URLENC

class MolgenisService {

    static transactional = true

    def sendInvestigationToMolgenis(investigationId) {

        def investigation = Investigation.get(investigationId)

	    def rest =  new RESTClient( 'http://192.168.240.51:8080/molgenis_apps/api/rest/json/' )

	    def response = rest.post( path : 'investigation',
	                         body : [ name: investigation.name  + System.currentTimeMillis() ],
	                         requestContentType : URLENC )


	    if (response.status != 200) {
		    throw new Exception("Invalid MOLGENIS $response.status response: $response.data ")
	    }

	    def molgenisInvestigationId = response.data.investigation.id
	    println "Added investigation $molgenisInvestigationId"
//
//        investigation.animals.each { animal ->
//            http.request( POST ) {
//
//                uri.path = 'individual'
//
//                body = [ name: animal.customId, investigation: molgenisInvestigationId ]
//
//                response.success = { resp ->
//
//                    println "Molgenis response status: $resp.statusLine"
//                    molgenisInvestigationId = resp.investigation.id
//
//                }
//
//                response.failure = { resp ->
//
//                    throw new Exception("Error posting animal $animal.customId. Molgenis response status: $resp.statusLine")
//
//                }
//            }
//        }
    }
}
