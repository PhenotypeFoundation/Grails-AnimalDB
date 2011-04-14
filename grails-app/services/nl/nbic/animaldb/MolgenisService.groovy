package nl.nbic.animaldb

import groovyx.net.http.*
import static groovyx.net.http.ContentType.URLENC

class MolgenisService {

    static transactional = true

    def sendInvestigationToMolgenis(investigationId) {

        def investigation = Investigation.get(investigationId)

println investigation
        
        def molgenisInvestigationId

        def http = new HTTPBuilder('http://192.168.240.51:8080')

        def req = http.request( groovyx.net.http.Method.POST, ContentType.JSON ) {

            uri.path = '/molgenis_apps/api/rest/json/investigation'

//            body = "name=$investigation.name" //[ name: investigation.name ]

//            requestContentType = ContentType.URLENC

            send URLENC, [ name: investigation.name + System.currentTimeMillis() ]

            println 'asd:' + this
            response.success = { resp ->

                println "Molgenis response status: $resp.statusLine"
                println resp.data
                println resp.data?.investigation

                molgenisInvestigationId = resp.data.investigation.id

            }

            response.failure = { resp ->

                println resp
                println "Molgenis response status: $resp.statusLine"
//                throw new Exception("Molgenis response status: $resp.statusLine")

            }


        }

println req
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
