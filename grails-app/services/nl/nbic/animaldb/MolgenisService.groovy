package nl.nbic.animaldb

import groovyx.net.http.*
import grails.converters.JSON

class MolgenisService {

    static transactional = true

    def transFormInvestigationForMolgenis(investigation) {

        investigation as JSON

    }

    def sendInvestigationToMolgenis(investigation) {

//        def http = new HTTPBuilder('http://vm7.target.rug.nl:5180/animaldb/api/rest/json')
        def http = new HTTPBuilder('http://192.168.240.51:8080/molgenis_apps/api/rest/json')

        http.request( POST, ContentType.JSON ) {

            uri.path = 'investigation'

            body = [ status: 'someStatus', source: transFormInvestigationForMolgenis(investigation) ]

            response.success = { resp ->

                println "Molgenis response status: $resp.statusLine"

            }

            response.failure = { resp ->

                throw new Exception("Molgenis response status: $resp.statusLine")

            }
        }
    }
}
