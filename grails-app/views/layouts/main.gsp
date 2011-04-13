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
	<script type="text/javascript">
		var config = {
			interval: 1000,
			twitter: { interval: 1000 }
		}

		$(document).ready(function() {
			// run engine
			setInterval("engine()", config.interval);

			// run twitterfeed
			twitterfeed();
		});

		function engine() {
			// handle engine
		}

		function twitterfeed() {
			$.getJSON("http://search.twitter.com/search.json?callback=?",
				{
					q: "#nbic",
					rpp: 1
				},
				function(data) {
					$('#twitterText').html(data.results[0].text);
					$('#twitterAuthor').html(
						"wrote " + data.results[0].from_user + " at " + data.results[0].created_at
					);
					config.twitter.interval = 5000;
				}
			);
			setTimeout("twitterfeed()", config.twitter.interval);
		}
	</script>
</head>
<body>
<div class="pageHeader">
	<div class="content">Capturing <a href="http://www.animaldb.org/wiki/AnimaldbStart" target="_new">Animal DB</a> in <a href="http://www.grails.org" target="_new">Grails</a></div>
	<div class="twitter">
		<div id="twitterTitle"><b>in the meantime on Twitter:</b></div>
		<div id="twitterText"></div>
		<div id="twitterAuthor"></div>
	</div>
</div>
<g:layoutBody/>
<div class="pageFooter">
	<div class="content">
		Copyright © 2008 - <g:formatDate format="yyyy" date="${new Date()}"/> NBIC, AnimalDB and Netherlands Metabolomics Center. All rights reserved. More information can be found <a href="https://wiki.nbic.nl/index.php/GSCF_and_Molgenis_Hackathon_project">here</a>.
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