package nl.nbic.animaldb.wizards

import nl.nbic.animaldb.*
import org.dbnp.gdt.*
import org.codehaus.groovy.grails.plugins.web.taglib.ValidationTagLib

/**
 * ajaxflow Controller
 *
 * @author	Jeroen Wesbeek
 * @since	20110413
 *
 * Revision information:
 * $Rev:  66849 $
 * $Author:  duh $
 * $Date:  2010-12-08 15:12:54 +0100 (Wed, 08 Dec 2010) $
 */
class InvestigationController {
	// the pluginManager is used to check if the Grom
	// plugin is available so we can 'Grom' development
	// notifications to the unified notifications daemon
	// (see http://www.grails.org/plugin/grom)
	def pluginManager
	
	/**
	 * index method, redirect to the webflow
	 * @void
	 */
	def index = {
		// Grom a development message
		if (pluginManager.getGrailsPlugin('grom')) "redirecting into the webflow".grom()

		/**
		 * Do you believe it in your head?
		 * I can go with the flow
		 * Don't say it doesn't matter (with the flow) matter anymore
		 * I can go with the flow (I can go)
		 * Do you believe it in your head?
		 */
		redirect(action: 'pages')
	}

	/**
	 * WebFlow definition
	 * @void
	 */
	def pagesFlow = {
		// start the flow
		onStart {
			// Grom a development message
			if (pluginManager.getGrailsPlugin('grom')) "entering the WebFlow".grom()

			// define variables in the flow scope which is availabe
			// throughout the complete webflow also have a look at
			// the Flow Scopes section on http://www.grails.org/WebFlow
			//
			// The following flow scope variables are used to generate
			// wizard tabs. Also see common/_tabs.gsp for more information
			flow.page = 0
			flow.pages = [
				[title: 'Page One'],
				[title: 'Page Two'],
				[title: 'Page Three'],
				[title: 'Page Four'],
				[title: 'Done']
			]
			flow.cancel = true;
			flow.quickSave = true;

			// instantiate a new investigation if we do not
			// yet have an investigation
			if (!flow.investigation) { 
				flow.investigation = new Investigation()
			}

			success()
		}

		// render the main wizard page which immediately
		// triggers the 'next' action (hence, the main
		// page dynamically renders the study template
		// and makes the flow jump to the study logic)
		mainPage {
			render(view: "/investigation/index")
			onRender {
				// Grom a development message
				if (pluginManager.getGrailsPlugin('grom')) "rendering the main Ajaxflow page (index.gsp)".grom()

				// let the view know we're in page 1
				flow.page = 1
				success()
			}
			on("next").to "investigation"
		}

		// first wizard page
		investigation {
			render(view: "_investigation")
			onRender {
				// Grom a development message
				if (pluginManager.getGrailsPlugin('grom')) ".rendering the partial: pages/_investigation.gsp".grom()

				flow.page = 1
				success()
			}
			on("refresh") {
				// handle form data
				investigationPage(flow, flash, params)

				// reset errors
				flash.wizardErrors = [:]
				success()
			}.to "investigation"
			on("switchTemplate") {
				// handle form data
				investigationPage(flow, flash, params)

				// reset errors
				flash.wizardErrors = [:]
				success()
			}.to "investigation"
			on("next") {
				investigationPage(flow, flash, params) ? success() : error()
			}.to "pageTwo"
			on("toPageTwo") {
				investigationPage(flow, flash, params) ? success() : error()
			}.to "pageTwo"
			on("toPageThree") {
				investigationPage(flow, flash, params) ? success() : error()
			}.to "pageThree"
			on("toPageFour") {
				investigationPage(flow, flash, params) ? success() : error()
			}.to "pageFour"
			on("toPageFive") {
				investigationPage(flow, flash, params) ? success() : error()
				flow.page = 5
			}.to "save"
		}

		// second wizard page
		pageTwo {
			render(view: "_page_two")
			onRender {
				// Grom a development message
				if (pluginManager.getGrailsPlugin('grom')) ".rendering the partial: pages/_page_two.gsp".grom()

				flow.page = 2
				success()
			}
			on("next").to "pageThree"
			on("previous").to "investigation"
			on("toPageOne").to "investigation"
			on("toPageThree").to "pageThree"
			on("toPageFour").to "pageFour"
			on("toPageFive") {
				flow.page = 5
			}.to "save"
		}

		// second wizard page
		pageThree {
			render(view: "_page_three")
			onRender {
				// Grom a development message
				if (pluginManager.getGrailsPlugin('grom')) ".rendering the partial pages/_page_three.gsp".grom()

				flow.page = 3
				success()
			}
			on("next").to "pageFour"
			on("previous").to "pageTwo"
			on("toPageOne").to "investigation"
			on("toPageTwo").to "pageTwo"
			on("toPageFour").to "pageFour"
			on("toPageFive") {
				flow.page = 5
			}.to "save"
		}

		// second wizard page
		pageFour {
			render(view: "_page_four")
			onRender {
				// Grom a development message
				if (pluginManager.getGrailsPlugin('grom')) ".rendering the partial pages/_page_four.gsp".grom()

				flow.page = 4
				success()
			}
			on("next") {
				// put some logic in here
				flow.page = 5
			}.to "save"
			on("previous").to "pageThree"
			on("toPageOne").to "investigation"
			on("toPageTwo").to "pageTwo"
			on("toPageThree").to "pageThree"
			on("toPageFive") {
				flow.page = 5
			}.to "save"
		}

		// save action
		save {
			action {
				// here you can validate and save the
				// instances you have created in the
				// ajax flow.
				try {
					// Grom a development message
					if (pluginManager.getGrailsPlugin('grom')) ".persisting instances to the database...".grom()

					// put your bussiness logic in here
					success()
				} catch (Exception e) {
					// put your error handling logic in
					// here
					flow.page = 4
					error()
				}
			}
			on("error").to "error"
			on(Exception).to "error"
			on("success").to "finalPage"
		}

		// render errors
		error {
			render(view: "_error")
			onRender {
				// Grom a development message
				if (pluginManager.getGrailsPlugin('grom')) ".rendering the partial pages/_error.gsp".grom()

				// set page to 4 so that the navigation
				// works (it is disabled on the final page)
				flow.page = 4
			}
			on("next").to "save"
			on("previous").to "pageFour"
			on("toPageOne").to "investigation"
			on("toPageTwo").to "pageTwo"
			on("toPageThree").to "pageThree"
			on("toPageFour").to "pageFour"
			on("toPageFive").to "save"

		}

		// last wizard page
		finalPage {
			render(view: "_final_page")
			onRender {
				// Grom a development message
				if (pluginManager.getGrailsPlugin('grom')) ".rendering the partial pages/_final_page.gsp".grom()
				
				success()
			}
		}
	}

	/**
	 * Handle the wizard investigation page
	 *
	 * @param Map LocalAttributeMap (the flow scope)
	 * @param Map localAttributeMap (the flash scope)
	 * @param Map GrailsParameterMap (the flow parameters = form data)
	 * @returns boolean
	 */
	def investigationPage(flow, flash, params) {
		flash.values		= params
		flash.wizardErrors	= [:]

		// instantiate investigation of it is not yet present
		if (!flow.investigation) flow.investigation = new Investigation()

		// did the study template change?
		if (params.get('template').size() && flow.investigation.template?.name != params.get('template')) {
			// set the template
			flow.investigation.template = Template.findByName(params.remove('template'))
		}

		// does the study have a template set?
		if (flow.investigation.template && flow.investigation.template instanceof Template) {
			// yes, iterate through template fields
			flow.investigation.giveFields().each() {
				// and set their values
				flow.investigation.setFieldValue(it.name, params.get(it.escapedName()))
			}
		}

		// have we got a template?
		if (flow.investigation.template && flow.investigation.template instanceof Template) {
			// validate the study
			if (flow.investigation.validate()) {
				// instance is okay
				return true
			} else {
				// validation failed
				this.appendErrors(flow.investigation, flash.wizardErrors)
				return false
			}
		} else {
			// no, return an error that the template is not set
			this.appendErrorMap(['template': g.message(code: 'select.not.selected.or.add', args: ['template'])], flash.wizardErrors)
			return false
		}
	}

	/**
	 * transform domain class validation errors into a human readable
	 * linked hash map
	 * @param object validated domain class
	 * @return object  linkedHashMap
	 */
	def getHumanReadableErrors(object) {
		def errors = [:]
		object.errors.getAllErrors().each() { error ->
			// error.codes.each() { code -> println code }

			// generally speaking g.message(...) should work,
			// however it fails in some steps of the wizard
			// (add event, add assay, etc) so g is not always
			// availably. Using our own instance of the
			// validationTagLib instead so it is always
			// available to us
			errors[ error.getArguments()[0] ] = validationTagLib.message(error: error)
		}

		return errors
	}

	/**
	 * append errors of a particular object to a map
	 * @param object
	 * @param map linkedHashMap
	 * @void
	 */
	def appendErrors(object, map) {
		this.appendErrorMap(getHumanReadableErrors(object), map)
	}

	def appendErrors(object, map, prepend) {
		this.appendErrorMap(getHumanReadableErrors(object), map, prepend)
	}

	/**
	 * append errors of one map to another map
	 * @param map linkedHashMap
	 * @param map linkedHashMap
	 * @void
	 */
	def appendErrorMap(map, mapToExtend) {
		map.each() {key, value ->
			mapToExtend[key] = ['key': key, 'value': value, 'dynamic': false]
		}
	}

	def appendErrorMap(map, mapToExtend, prepend) {
		map.each() {key, value ->
			mapToExtend[prepend + key] = ['key': key, 'value': value, 'dynamic': true]
		}
	}
}