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
	 * @since 20110413
	 *
	 * Revision information:
	 * $Rev$
	 * $Author$
	 * $Date$
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

		// handle term selects
		new SelectAddMore().init({
			rel	 : 'term',
			url	 : baseUrl + '/termEditor',
			vars	: 'ontologies',
			label   : 'add more...',
			style   : 'addMore',
			onClose : function(scope) {
				refreshFlow();
			}
		});

		// handle and initialize table(s)
		handleWizardTable();
		new TableEditor().init({
			tableIdentifier : 'div.tableEditor',
			rowIdentifier   : 'div.row',
			columnIdentifier: 'div.column',
			headerIdentifier: 'div.header'
		});
	}

	// if the wizard page contains a table, the width of
	// the header and the rows is automatically scaled to
	// the cummalative width of the columns in the header
	function handleWizardTable() {
		var that = this;
		var wizardTables = $('div.tableEditor');

		wizardTables.each(function() {
			var wizardTable = $(this);
			var sliderContainer = (wizardTable.next().attr('class') == 'sliderContainer') ? wizardTable.next() : null;
			var header = wizardTable.find('div.header');
			var width = 20;
			var column = 0;
			var columns = [];
			var resized = [];

			// calculate total width of elements in header
			header.children().each(function() {
				// calculate width per column
				var c = $(this);
				var columnWidth = c.width();
				var paddingWidth = parseInt(c.css("padding-left"), 10) + parseInt(c.css("padding-right"), 10);
				var marginWidth = parseInt(c.css("margin-left"), 10) + parseInt(c.css("margin-right"), 10);
				var borderWidth = parseInt(c.css("borderLeftWidth"), 10) + parseInt(c.css("borderRightWidth"), 10);

				// add width...
				if (paddingWidth) columnWidth += paddingWidth;
				if (marginWidth) columnWidth += marginWidth;
				if (borderWidth) columnWidth += borderWidth;
				width += columnWidth;

				// remember column
				resized[ column ] = (c.attr('rel') == 'resized');
				columns[ column ] = c.width();
				column++;
			});

			// resize the header
			header.css({ width: width + 'px' });

			// set table row width and assume column widths are
			// identical to those in the header (css!)
			wizardTable.find('div.row').each(function() {
				var row = $(this);
				var column = 0;
				row.children().each(function() {
					var child = $(this);
					child.css({ width: columns[ column] + 'px' });
					if (resized[ column ]) {
						$(':input', child).each(function() {
							$(this).css({width: (columns[ column ] - 10) + 'px'});
						});
					}
					column++;
				});
				row.css({ width: width + 'px' });
			});

			// got a slider for this table?
			if (sliderContainer) {
				// handle slider
				if (header.width() < wizardTable.width()) {
					// no, so hide it
					sliderContainer.hide();
				} else {
					sliderContainer.slider({
						value   : 1,
						min	 : 1,
						max	 : header.width() - wizardTable.width(),
						step	: 1,
						slide: function(event, ui) {
							wizardTable.find('div.header, div.row').css({ 'margin-left': ( 1 - ui.value ) + 'px' });
						}
					});
				}
			}
		});
	}
</script>

