package nl.nbic.animaldb

import org.dbnp.gdt.*

class Investigation extends TemplateEntity {
	String name

	// an investigation is done over many animals
	static hasMany = [
		animals: Animal
	] 

	static constraints = {
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
		required: true)
	]
}
