package nl.nbic.animaldb

import groovyx.net.http.*

class MolgenisService {

    static transactional = true

    def sendInvestigationToMolgenis(investigationId) {

        def investigation = Investigation.get(investigationId)
        
        def molgenisInvestigationId

        def http = new HTTPBuilder('http://192.168.240.51:8080/molgenis_apps/api/rest/json')

        http.request( 'POST' ) {

            uri.path = 'investigation'

            body = [ name: investigation.customId ]

            response.success = { resp ->

                println "Molgenis response status: $resp.statusLine"
                molgenisInvestigationId = resp.investigation.id

            }

            response.failure = { resp ->

                throw new Exception("Molgenis response status: $resp.statusLine")

            }
        }
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
