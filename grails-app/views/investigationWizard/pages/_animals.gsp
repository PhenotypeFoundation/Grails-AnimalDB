<%@ page import="org.dbnp.gdt.TemplateEntity" %>
<%
/**
 * Animals page
 *
 * @author  Hackathonians
 * @since   20110413
 * @package wizard
 * @see     dbnp.studycapturing.WizardTagLib::previousNext
 * @see     dbnp.studycapturing.WizardController
 *
 * Revision information:
 * $Rev: 1461 $
 * $Author: work@osx.eu $
 * $Date: 2011-02-01 14:36:57 +0100 (di, 01 feb 2011) $
 */
%>
<af:page>
	<span class="info">
		<span class="title">Add animals to your investigation</span>
		Describe the animals studied with all details available. Use the template that contains the necessary fields. New templates can be defined (based on existing templates).
		To add animals to the study, select the correct species and template, input the number of animals you want to add, and click 'Add'. They will appear below the 'Add' button.
		As multiple species may be studied within one study, there is no hard link between the template and the species.
		<br/><i>Note that you can edit multiple animals at once by selecting multiple rows by either ctrl-clicking them or dragging a selection over them in the space between the fields.</i>
		<br/><i>Note that depending on the size of your browser window and the template, additional fields can be reached by the slider at the bottom of the page.</i>		
	</span>

	<af:textFieldElement name="addNumber" description="Number of animals to add" error="addNumber" value="${values?.addNumber}" size="4" maxlength="4">
		The number of animals to add to your study
	</af:textFieldElement>
	<af:termElement name="species" description="of species" value="${values?.species}" ontologies="1132" addDummy="true">
		The species of the animals you would like to add to your study
	</af:termElement>
	<af:templateElement name="template" description="with template" value="${values?.template}" error="template" entity="${nl.nbic.animaldb.Animal}" addDummy="true">
		The template to use for these animals
	</af:templateElement>
	<af:ajaxButtonElement name="add" value="Add" afterSuccess="onPage()">
	</af:ajaxButtonElement>

	<g:if test="${investigation.animals}">
		<g:each var="template" in="${TemplateEntity.giveTemplates(investigation.animals)}">
			<g:set var="showHeader" value="${true}" />
			<h1>${template} template</h1>
			<div class="tableEditor">
			<g:each var="animal" status="s" in="${investigation.giveAnimalsForTemplate(template)}">
				<g:if test="${showHeader}">
				<g:set var="showHeader" value="${false}" />
				<div class="header">
				  <div class="firstColumn"></div>
				  <af:templateColumnHeaders class="column" entity="${animal}" columnWidths="[Name:200, Species: 150]" />
				</div>
				</g:if>
				<div class="row">
					<div class="firstColumn">
						<af:ajaxButton name="delete" src="${resource(dir: 'images/icons', file: 'delete.png', plugin: 'famfamfam')}" alt="delete this animal" class="famfamfam" value="-" before="\$(\'input[name=do]\').val(${animal.getIdentifier()});" afterSuccess="onPage()" />
					</div>
					<af:templateColumns class="column" entity="${animal}" name="animal_${animal.getIdentifier()}" />
				</div>
			</g:each>
			</div>
			<div class="sliderContainer">
				<div class="slider" ></div>
			</div>
		</g:each>
	</g:if>
</af:page>