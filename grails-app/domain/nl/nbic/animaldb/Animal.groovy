package nl.nbic.animaldb

import org.dbnp.gdt.*

class Animal extends TemplateEntity {

	String customId
	Term species

	// an animal belongs to an investigation, this
	// means that animals are cascadedly deleted if
	// the investigation is deleted
	static belongsTo = [investigation: Investigation]

	static constraints = {
		// Check if the customId is really unique within the parent investigation of this animal.
		// This feature is tested by integration test SampleTests.testSampleUniqueNameConstraint
		customId(unique: ['investigation'], nullable: false, blank: false)
		species(nullable: false)
	}

	/**
	 * return the domain fields for this domain class
	 *
	 * We need to implement this function for gdt, so
	 * that gdt knows which domain fields this class
	 * contains.
	 *
	 * This is used to address both domain fields and
	 * template fields the same way. Also see
	 * TemplateEntity::giveFields(...)
	 *
	 * @return List
	 */
	static List<TemplateField> giveDomainFields() { Animal.domainFields }

	// We have to specify an ontology list for the species property. However, at compile time, this ontology does of course not exist.
	// Therefore, the ontology is added at runtime in the bootstrap, possibly downloading the ontology properties if it is not present in the database yet.
	static List<TemplateField> domainFields = [

		new TemplateField(
			name: 'customId',
			type: TemplateFieldType.STRING,
			comment: 'Unique string to identify an animal within an investigation',
			required: true),

		new TemplateField(
			name: 'species',
			type: TemplateFieldType.ONTOLOGYTERM,
			comment: "The species name is based on the NCI Thesaurus / NCBI organismal classification ontology, a taxonomic classification of living organisms and associated artifacts. If a species is missing, please add it by using 'add more'",
			required: true)
	]
}
