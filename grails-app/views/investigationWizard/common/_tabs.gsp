<%
/**
 * wizard tabs
 *
 * The 'pages' and 'page' variables are defined
 * in the flow scope. See WizardController:pagesFlow:onStart
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
<af:tabs pages="${pages}" page="${page}" clickable="${investigation}" />
