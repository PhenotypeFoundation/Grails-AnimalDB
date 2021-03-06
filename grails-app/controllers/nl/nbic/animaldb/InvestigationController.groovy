package nl.nbic.animaldb

import grails.converters.deep.XML

class InvestigationController {

    def molgenisService

	def index = {
		render Investigation.list() as XML
	}

	def show = {
		render Investigation.get(params.id) as XML
	}

    def postToMolgenis = {

        molgenisService.sendInvestigationToMolgenis Investigation.find(params.id)

        render 'iets'

    }

	def list = {
		render molgenisService.investigationsFromMolgenis as XML
	}
}
