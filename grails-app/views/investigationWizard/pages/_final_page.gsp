<%
/**
 * last wizard page / tab
 *
 * @author Jeroen Wesbeek
 * @since  20110413
 *
 * Revision information:
 * $Rev:  66849 $
 * $Author:  duh $
 * $Date:  2010-12-08 15:12:54 +0100 (Wed, 08 Dec 2010) $
 */
%>
<af:page>
<h1>Final Page</h1>
<p>
  Your study has been saved. You can now <g:link url="http://192.168.240.51:8080/molgenis_apps/molgenis.do?__target=investigation&__action=filter_set&__filter_attribute=Investigation_id&__filter_operator=EQUALS&__filter_value=${resultMolgenisId}">view the investigation in AnimalDB</g:link> or click <g:link action="index">here</g:link> to add another investigation.

  Click <g:link controller="investigation" action="postToMolgenis" id="${investigation.id}">here</g:link> to send the investigation to Molgenis.
</p>
</af:page>
