import org.codehaus.groovy.grails.commons.GrailsApplication
import org.dbnp.gdt.*
import nl.nbic.animaldb.*

class BootStrap {
	def init = { servletContext ->

		// add ontologies
		def speciesOntology = Ontology.getOrCreateOntologyByNcboId(1132)

		/**
		 * attach ontologies in runtime. It's needed in the field description of Animal,
		 * however, it can only be added at runtime as the ontology should be an item in the database.
		 * Possible problem is that you need an internet connection when bootstrapping though.
		 * @see nl.nbic.animaldb.Animal
		 */
		TemplateEntity.getField(Animal.domainFields, 'species').ontologies = [speciesOntology]


		// developmental/test bootstrapping:
		//      - templates
		//      - ontologies
		//      - and/or investigations
		if (grails.util.GrailsUtil.environment == GrailsApplication.ENV_DEVELOPMENT ||
				grails.util.GrailsUtil.environment == GrailsApplication.ENV_TEST) {

			// add templates
			if (!Template.count()) {
				new Template(name: 'testTemplateInv', entity: Investigation).save(failOnError: true)
				new Template(name: 'testTemplateAn', entity: Animal).save(failOnError: true)
			}

			// add species?
			def hamsterTerm = Term.getOrCreateTerm('Mesocricetus auratus', speciesOntology, 'NCBITaxon:10036')

			// add example investigations, if none exist yet
			if (!Investigation.count()) {
				def testInv = new Investigation(name: 'testInvestigation')
				4.times { testInv.addToAnimals new Animal(customId: "Animal ${it}", species: hamsterTerm)}
				testInv.save(failOnError: true)
			}

		}

	}

	def destroy = {
	}
}
