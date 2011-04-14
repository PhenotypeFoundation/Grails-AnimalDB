<%
/**
 * error page
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
<af:page>
<h1>Oops!</h1>
<p>
	We encountered an problem storing your data! You can either
	<af:ajaxButton name="toPageFive" value="try again" afterSuccess="onPage();" class="prevnext" />
	or file a bugreport.
</p>
<p>
	The error was: ${errorMessage}
</p>
</af:page>
