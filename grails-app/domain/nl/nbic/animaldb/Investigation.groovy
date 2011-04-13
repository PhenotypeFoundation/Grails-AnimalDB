package nl.nbic.animaldb

import org.dbnp.gdt.*

class Investigation extends TemplateEntity {
	String name			// the name of an investigation

	// an investigation is done over many animals
	static hasMany = [
		animals: Animal
	] 

	static constraints = {
		name(nullable:false, blank: false, maxSize: 255)
	}

	/**
	 * return the domain fields for this domain class
	 * @return List
	 */
	static List<TemplateField> giveDomainFields() { return Investigation.domainFields }

	static final List<TemplateField> domainFields = [
		new TemplateField(
		name: 'name',
		type: TemplateFieldType.STRING,
		comment: 'an investigation should have a name describing the investigation',
		required: true)
	]
}
