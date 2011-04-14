<!DOCTYPE html>
<html>
<head>
	<title><g:layoutTitle default="Grails"/></title>
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'animaldb.css')}"/>
	<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon"/>
    <g:javascript library="jquery" plugin="jquery"/>
	<g:layoutHead/>
	<script type="text/javascript">var baseUrl = '${resource(dir: '')}';</script>
	<script src="${createLinkTo(dir: 'js', file: 'jquery-ui-1.8.7.custom.min.js')}" type="text/javascript"></script>
	<link rel="stylesheet" href="${createLinkTo(dir: 'css/cupertino', file: 'jquery-ui-1.8.7.custom.css')}"/>
	<script src="${createLinkTo(dir: 'js', file: 'twitterfeed.js')}" type="text/javascript"></script>
	<script src="http://connect.facebook.net/en_US/all.js#xfbml=1"></script>
</head>
<body>
<div class="pageHeader">
	<div class="content">Capturing <a href="http://www.animaldb.org/wiki/AnimaldbStart" target="_new">Animal DB</a> in <a href="http://www.grails.org" target="_new">Grails</a></div>
	<div class="twitter">
		<div id="twitterAuthor"></div>
		<div id="twitterText"></div>
		<div id="twitterDate"></div>
	</div>
</div>
<div class="pageMenu">
	<ul>
		<li>menu item 1</li>
		<li>menu item 2</li>
		<li>...</li>
		<li>menu item N</li>
	</ul>
</div>
<div class="pageBody">
	<g:layoutBody/>
</div>
<div class="pageFooter">
	<div class="facebook">
		<fb:like href="http://hacktahon.nmcdsp.org" layout="box_count" show_faces="false" width="50" font="verdana"></fb:like>
	</div>
	<div class="content">
		Copyright © 2008 - <g:formatDate format="yyyy" date="${new Date()}"/> NBIC, AnimalDB and Netherlands Metabolomics Centre. All rights reserved. More information can be found <a href="https://wiki.nbic.nl/index.php/GSCF_and_Molgenis_Hackathon_project">here</a>.
	</div>
	<div class="links">
		<ul><b>Powered by:</b>
			<li><a href="http://groovy.codehaus.org/" target="_new">Groovy</a> & <a href="http://www.grails.org" target="_new">Grails</a></li>
			<li><a href="http://www.grails.org/plugin/ajaxflow" target="_new">AjaxFlow</a></li>
			<li><a href="https://trac.nbic.nl/grails-plugins/browser/gdt/trunk" target="_new">Grails Domain Templates (GDT)</a></li>
			<li><a href="https://trac.nbic.nl/grails-plugins/browser/gdtimporter/trunk" target="_new">GDT Importer</a></li>
			<li><a href="http://www.youtube.com/watch?v=KsBa-bSGlvU" target="_new">Beer</a> & <a href="http://www.youtube.com/watch?v=bZRiGjqVAlY" target="_new">Red Bull</a></li>
		</ul>
	</div>
</div>
</body>
</html>