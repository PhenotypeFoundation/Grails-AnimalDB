<!DOCTYPE html>
<html>
<head>
	<title><g:layoutTitle default="AnimalDB Wizard"/></title>
	<meta property="og:type" content="non_profit"/>
	<meta property="og:image" content="${resource(dir: 'images', file: 'facebookLike.png', absolute: true)}"/>
	<meta property="og:site_name" content="AnimalDB wizard"/>
	<meta property="og:url" content="${resource(absolute: true)}"/>
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'animaldb.css')}"/>
	<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon"/>
    <g:javascript library="jquery" plugin="jquery"/>
	<g:layoutHead/>
	<script type="text/javascript">var baseUrl = '${resource(dir: '')}';</script>
	<script src="${createLinkTo(dir: 'js', file: 'jquery-ui-1.8.7.custom.min.js')}" type="text/javascript"></script>
	<link rel="stylesheet" href="${createLinkTo(dir: 'css/cupertino', file: 'jquery-ui-1.8.7.custom.css')}"/>
	<script src="${createLinkTo(dir: 'js', file: 'twitterfeed.js')}" type="text/javascript"></script>
	<script src="http://connect.facebook.net/en_US/all.js#xfbml=1"></script>
	<script src="http://platform.twitter.com/widgets.js" type="text/javascript"></script>
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
		<li><a href="#">menu item 1</a></li>
		<li><a href="#">menu item 2</a></li>
		<li><a href="#">menu item 3</a></li>
		<li><a href="#">menu item 4</a></li>
		<li><a href="#">...</a></li>
		<li><a href="#">menu item N</a></li>
	</ul>
</div>
<div class="pageBody">
	<g:layoutBody/>
</div>
<div class="pageFooter">
	<div class="facebook">
		<fb:like href="http://hackathon.nmcdsp.org" layout="box_count" show_faces="false" width="50" font="verdana"></fb:like>
	</div>
	<div class="twitter">
		<div>
		   <a href="http://twitter.com/share" class="twitter-share-button"
			  data-url="http://hackathon.nmcdsp.org"
			  data-text="Checking out this Hackathon project for capturing AnimalDB in Groovy & Grails! #nbic #hackathon #grails #nmc #animaldb"
			  data-count="vertical">Tweet</a>
		</div>
	</div>
	<div class="content">
		Copyright © 2008 - <g:formatDate format="yyyy" date="${new Date()}"/> NBIC, AnimalDB and Netherlands Metabolomics Centre. All rights reserved.
		<a href="https://trac.nbic.nl/gscf4molgenis/changeset/${meta(name: 'app.build.svn.revision')}" target="_new">Revision ${meta(name: 'app.build.svn.revision')}</a> <a href="https://wiki.nbic.nl/index.php/GSCF_and_Molgenis_Hackathon_project"><img src="${fam.icon(name: 'help')}"/></a>
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