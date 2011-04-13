import org.codehaus.groovy.grails.commons.GrailsApplication
import org.dbnp.gdt.*
import nl.nbic.animaldb.*

class BootStrap {
	def init = { servletContext ->

                // developmental/test bootstrapping:
		//      - templates
		//      - ontologies
		//      - and/or investigations
		if (    grails.util.GrailsUtil.environment == GrailsApplication.ENV_DEVELOPMENT ||
                grails.util.GrailsUtil.environment == GrailsApplication.ENV_TEST) {
			// add ontologies?
			def testOntology = Ontology.getOrCreateOntologyByNcboId(1132)

			// add templates?
			if (!Template.count()) {
                            new Template(name: 'testTemplateInv', entity: Investigation).save(failOnError: true)
                            new Template(name: 'testTemplateAn', entity: Animal).save(failOnError: true)
                        }

			// add example investigation?
			if (!Investigation.count()) new Investigation(name: 'testInvestigation').save(failOnError: true)

                        // add species?
                        if (!Term.count()) Term.getOrCreateTerm('Mesocricetus auratus', testOntology, 'blaat')
		}

		/**
		 * attach ontologies in runtime. Possible problem is that you need
		 * an internet connection when bootstrapping though.
		 * @see nl.nbic.animaldb.Animal
		 */
		TemplateEntity.getField(Animal.domainFields, 'species').ontologies = [Ontology.getOrCreateOntologyByNcboId(1132)]
	}

	def destroy = {
	}
}
