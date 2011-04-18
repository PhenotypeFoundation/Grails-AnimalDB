<%
/**
 * last wizard page / tab
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
<h1>Final Page</h1>
<p>
  Your study has been saved. You can now <g:link url="http://vm7.target.rug.nl/animaldb/molgenis.do?__target=investigation&__action=filter_set&__filter_attribute=Investigation_id&__filter_operator=EQUALS&__filter_value=${resultMolgenisId}">view the investigation in AnimalDB</g:link> or click <g:link action="index">here</g:link> to add another investigation.
</p>
</af:page>
