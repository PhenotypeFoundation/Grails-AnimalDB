<%
/**
 * modify investifation page
 *
 * @author Jeroen Wesbeek
 * @since  20110413
 *
 * Revision information:
 * $Rev:  67319 $
 * $Author:  duh $
 * $Date:  2010-12-22 17:45:42 +0100 (Wed, 22 Dec 2010) $
 */
%>
<af:page>
	<span class="info">
		<span class="title">Load an investigation</span>
		Please select the investigation below you would like to edit and click <i>next</i> to continue, or
		select <i>create a new investigation</i> from the menu if you would like to start creating a new
		investigation.
	</span>

	<af:investigationElement name="investigation" description="Investigation" error="investigation" value="">
		The investigation you would like to load and edit
	</af:investigationElement>
</af:page>
