<%
/**
 * page header template
 *
 * This template is actually rendered by the AjaxflowTagLib using
 * the following tags:
 *
 * <af:pageHeader>
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
<g:hiddenField name="do" value="" />
<h1><g:if test="${jump.action == 'edit'}">Edit</g:if><g:else>Create</g:else> an investigation: step ${page} of ${pages.size()}</h1>
<g:render template="common/tabs"/>
<div class="content">
