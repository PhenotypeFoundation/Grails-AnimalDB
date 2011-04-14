package nl.nbic.animaldb

import org.dbnp.gdt.*

class Investigation extends TemplateEntity {
	String name			// the name of an investigation
	List animals		// keep animals in order

	// an investigation is done over many animals
	static hasMany = [
		animals: Animal
	]

	static constraints = {
		name(nullable: false, blank: false, maxSize: 255)
	}

	/**
	 * Delete an animal from the investigation
	 * @param animal
	 */
	void deleteAnimal(Animal animal) {
		// This should remove the animal itself too, because of the cascading belongsTo relation
		this.removeFromAnimals(animal)

		// But apparently it needs an explicit delete() too
		animal.delete()
	}

	/**
	 * Return all animals for a specific template
	 * @param Template
	 * @return ArrayList
	 */
	def Collection<Animal> giveAnimalsForTemplate(Template template) {
		animals.findAll { it.template.equals(template) }
	}

	/**
	 * return the domain fields for this domain class
	 * @return List
	 */
	static List<TemplateField> giveDomainFields() { Investigation.domainFields }

	static final List<TemplateField> domainFields = [
		new TemplateField(
			name: 'name',
			type: TemplateFieldType.STRING,
			comment: 'an investigation should have a name describing the investigation',
			required: true)
	]

	/**
	 *
	 * @return name representation of the investigation
	 */
	String toString() {
		name
	}
}
