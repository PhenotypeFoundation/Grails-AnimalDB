<%
/**
 * first wizard page / tab
 *
 * @author Jeroen Wesbeek
 * @since  20110413
 *
 * Revision information:
 * $Rev$
 * $Author$
 * $Date$
 */
%>
<af:page>
	<span class="info">
		<span class="title">Define the basic properties of your study</span>
		In this step of the step-by-step study capturing tool all the basic information of a study can be filled out.
		Keep in mind that the more and the more specific the information that is filled out, the more valuable the system will be.
		Only the fields with an asterisks are obligatory. Pick the study template of choice (currently a fixed set) and define your study values.
	</span>

	<af:templateElement name="template" description="Template" value="${investigation?.template}" entity="${nl.nbic.animaldb.Investigation}" addDummy="true" ajaxOnChange="switchTemplate" afterSuccess="onPage()">
		Choose the type of study you would like to create.
		Depending on the chosen template specific fields can be filled out. If none of the templates contain all the necessary fields, a new template can be defined (based on other templates).
	</af:templateElement>
	<g:if test="${investigation}">
		<af:templateElements entity="${investigation}"/>
	</g:if>
</af:page>
