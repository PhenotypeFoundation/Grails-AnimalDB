/**
 * Add a twitterfeed to the homepage
 *
 * @Author	Jeroen Wesbeek
 * @Since	20110412
 *
 * Revision information:
 * $Rev$
 * $Author$
 * $Date$
 */
var config = {
	interval: 1000,
	twitter: { interval: 1000 }
}

$(document).ready(function() {
	// run twitterfeed
	twitterfeed();
});

function twitterfeed() {
	$.getJSON("http://search.twitter.com/search.json?callback=?",
		{
			q: "#nbic",
			rpp: 1
		},
		function(data) {
			$('#twitterText').html("&#8220;" + data.results[0].text + "&#8221;");
			$('#twitterAuthor').html("<b>in the meantime <a href=\"http://twitter.com/" + data.results[0].from_user + "\" target=\"_new\">" + data.results[0].from_user + "</a> wrote on Twitter:</b>");
			$('#twitterDate').html("at " + data.results[0].created_at);
			config.twitter.interval = 5000;
		}
	);
	setTimeout("twitterfeed()", config.twitter.interval);
}
