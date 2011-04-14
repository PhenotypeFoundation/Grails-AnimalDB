package nl.nbic.animaldb

import org.dbnp.gdt.*

/**
 * Wizard tag library
 *
 * @author Jeroen Wesbeek
 * @since 20110414
 *
 * Revision information:
 * $Rev$
 * $Author$
 * $Date$
 */
class WizardTagLib extends GdtTagLib {
	def molgenisService

	/**
	 * Investigation form element
	 * @param Map attributes
	 * @param Closure help content
	 */
	def investigationElement = { attrs, body ->
		// render study element
		baseElement.call(
			'investigationSelect',
			attrs,
			body
		)
	}

	/**
	 * render a investigation select element
	 * @param Map attrs
	 */
	def investigationSelect = { attrs ->
		// Find all studies the user has access to (max 100)
		attrs.from = molgenisService.getInvestigationsFromMolgenis()

		// got a name?
		if (!attrs.name) {
			attrs.name = "investigation"
		}

		// got result?
		if (attrs.from.size() > 0) {
			out << select(attrs)
		} else {
			// no, return false to make sure this element
			// is not rendered in the template
			return false
		}
	}
}
