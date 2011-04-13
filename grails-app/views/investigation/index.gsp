<%
/**
 * Wizard index page
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
<html>
<head>
	<meta name="layout" content="main"/>
	<g:javascript library="jquery" plugin="jquery"/>
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'investigation.css')}"/>
	<script type="text/javascript" src="${resource(dir: 'js', file: 'SelectAddMore.js', plugin: 'gdt')}"></script>
</head>
<body>
	<g:render template="common/ajaxflow"/>
</body>
</html>
