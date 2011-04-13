<%
/**
 * wizard refresh flow action
 *
 * An example of a way to trigger a refresh in your ajax flow
 * to refresh the rendered page. It will trigger the 'refresh'
 * event in your webflow definition.
 *
 * I use this together with a select element, where the last
 * option is 'add more'. When you select the last element a
 * jquery-ui dialog opens where you will be able to add more
 * elements to the select element. However, when the dialog
 * is cloded, the select needs to be updated with the newly
 * added options. So I call the refreshFlow(); JavaScript
 * function to refresh the page and the select element will
 * show the newly added options.
 *
 * @author Jeroen Wesbeek
 * @since  20110413
 *
 * Revision information:
 * $Rev:  67320 $
 * $Author:  duh $
 * $Date:  2010-12-22 17:49:27 +0100 (Wed, 22 Dec 2010) $
 */
%>
<script type="text/javascript">
function refreshFlow() {
	<af:ajaxSubmitJs name="refresh" afterSuccess="onPage()" />
}
</script>
