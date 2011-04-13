<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <g:layoutHead />
		<g:javascript library="jquery" plugin="jquery"/>
		<script type="text/javascript">var baseUrl = '${resource(dir: '')}';</script>
		<script src="${createLinkTo(dir: 'js', file: 'jquery-ui-1.8.7.custom.min.js')}" type="text/javascript"></script>
		<link rel="stylesheet" href="${createLinkTo(dir: 'css/cupertino', file: 'jquery-ui-1.8.7.custom.css')}"/>
        <g:javascript library="application" />
    </head>
    <body>
        <g:layoutBody />
    </body>
</html>