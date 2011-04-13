<%
/**
 * wizard refresh flow action
 *
 * When a page (/ partial) is rendered, any DOM event handlers need to be
 * (re-)attached. The af:ajaxButton, af:ajaxSubmitJs and af:redirect tags
 * supports calling a JavaScript after the page has been rendered by passing
 * the 'afterSuccess' argument.
 *
 * Example:	af:redirect afterSuccess="onPage();"
 * 		af:redirect afterSuccess="console.log('redirecting...');"
 *
 * Generally one would expect this code to add jQuery event handlers to
 * DOM objects in the rendered page (/ partial).
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
        function onPage() {
			attachHelpTooltips();

			// handle template selects
			new SelectAddMore().init({
				rel	 : 'template',
				url	 : baseUrl + '/templateEditor',
				vars	: 'entity,ontologies',
				label   : 'add / modify..',
				style   : 'modify',
				onClose : function(scope) {
					refreshFlow();
				}
			});
        }
</script>

