import org.dbnp.gdt.*
import nl.nbic.animaldb.*

class BootStrap {
	def init = { servletContext ->
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
