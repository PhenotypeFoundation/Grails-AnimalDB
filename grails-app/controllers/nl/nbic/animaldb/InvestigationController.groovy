package nl.nbic.animaldb

import grails.converters.deep.XML

class InvestigationController {

	def index = {
		render Investigation.list() as XML
	}

	def show = {
		render Investigation.get(params.id) as XML
	}
}