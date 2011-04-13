<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
		<g:javascript library="jquery" plugin="jquery"/>
		<script type="text/javascript">var baseUrl = '${resource(dir: '')}';</script>
		<script src="${createLinkTo(dir: 'js', file: 'jquery-ui-1.8.7.custom.min.js')}" type="text/javascript"></script>
		<link rel="stylesheet" href="${createLinkTo(dir: 'css/cupertino', file: 'jquery-ui-1.8.7.custom.css')}"/>
    </head>
    <body>
        <div id="grailsLogo"><a href="http://grails.org"><img src="${resource(dir:'images',file:'grails_logo.png')}" alt="Grails" border="0" /></a></div>
        <g:layoutBody />
    </body>
</html>