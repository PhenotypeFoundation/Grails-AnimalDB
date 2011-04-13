<!DOCTYPE html>
<html>
<head>
	<title><g:layoutTitle default="Grails"/></title>
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'animaldb.css')}"/>
	<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon"/>
	<g:layoutHead/>
	<g:javascript library="jquery" plugin="jquery"/>
	<script type="text/javascript">var baseUrl = '${resource(dir: '')}';</script>
	<script src="${createLinkTo(dir: 'js', file: 'jquery-ui-1.8.7.custom.min.js')}" type="text/javascript"></script>
	<link rel="stylesheet" href="${createLinkTo(dir: 'css/cupertino', file: 'jquery-ui-1.8.7.custom.css')}"/>
</head>
<body>
<div class="header">
	<div class="content">Capturing <a href="http://www.animaldb.org/wiki/AnimaldbStart" target="_new">Animal DB</a> in <a href="http://www.grails.org" target="_new">Grails</a></div>
</div>
<g:layoutBody/>
</body>
</html>