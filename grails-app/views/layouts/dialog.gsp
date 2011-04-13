<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-EN" xml:lang="en-EN">
<head>
	<title><g:layoutTitle default="Grails"/></title><g:if env="production">
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'dialog.min.css')}"/>
</g:if><g:else>
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'dialog.css')}"/>
</g:else>
	<g:javascript library="jquery" plugin="jquery"/>
	<script type="text/javascript">var baseUrl = '${resource(dir: '')}';</script>
	<script src="${createLinkTo(dir: 'js', file: 'jquery-ui-1.8.7.custom.min.js')}" type="text/javascript"></script>
	<link rel="stylesheet" href="${createLinkTo(dir: 'css/cupertino', file: 'jquery-ui-1.8.7.custom.css')}"/>
	<g:layoutHead/>
</head>
<body>
<g:layoutBody/>
</body>
</html>