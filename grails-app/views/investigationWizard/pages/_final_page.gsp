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
  Your study has been saved. You can now <g:link controller="investigation" action="show" id="${investigation.id}">view the investigation</g:link> or click <g:link action="index">here</g:link> to add another investigation.

  Click <g:link controller="investigation" action="postToMolgenis" id="${investigation.id}">here</g:link> to send the investigation to Molgenis.
</p>
</af:page>
