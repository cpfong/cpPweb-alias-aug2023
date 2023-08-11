<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>

	<TITLE>The FreeBSD Diary -- Apache - virtual hosts</TITLE>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" type="text/css" href="/css/site.css">

	<META NAME="description" CONTENT="Apache - virtual hosts">
	<META NAME="keywords"    CONTENT="FreeBSD, Apache, virtualhosts, webserver">

	<LINK REL="SHORTCUT ICON" HREF="/favicon.ico" type="image/x-icon">
	<LINK REL="ICON"          HREF="/favicon.ico" type="image/x-icon">
	<meta name="MSSmartTagsPreventParsing" content="TRUE">
	<META http-equiv="Pragma"              CONTENT="no-cache">
	<META HTTP-EQUIV="Expires"             CONTENT="0">
	<META HTTP-EQUIV="Cache-Control"       CONTENT="no-cache">
	<META HTTP-EQUIV="Pragma-directive"    CONTENT="no-cache">
	<META HTTP-EQUIV="cache-directive"     CONTENT="no-cache">
	<META NAME="ROBOTS"                    CONTENT="NOARCHIVE">

	<meta http-equiv="pics-label" content='(pics-1.1 "http://www.icra.org/ratingsv02.html" comment "ICRAonline v2.0" l gen true for "http://www.freebsddiary.org/"  r (nz 1 vz 1 lz 1 oz 1 ca 1) "http://www.rsac.org/ratingsv01.html" l gen true for "http://www.freebsddiary.org/"  r (n 0 s 0 v 0 l 0))'>
	<META http-equiv="PICS-Label" content='(PICS-1.1 "http://www.classify.org/safesurf/"                             l gen true for "http://www.freebsddiary.org/"  r (SS~~000 1))'> 
	<meta http-equiv="Certification" content='"http://www.ufcws.org/license.html" l r true comment "United Federation of ChildSafe Web Sites" for "http://www.freebsddiary.org" on "2002.08.10" r"'>
	<!-- Begin ICCS Certified Web Site Statement -->
	<!-- VERIFICATION="PICS-Label / ICCS_Certification" CONTENT="ICCS Certified Web Site"
	RATING="Class 1 SafeSurf" and/or "Class 2 ICRA" TASK="ICCS-Certification under the iWatchDog Program for "http://www.freebsddiary.org" EXPIRATION_DATE="2003.08.10"//-->
	<!-- End Statement -->

</HEAD>

<BODY BGCOLOR="#FFFFFF" TEXT="#000000">
<script language="JavaScript" type="text/javascript"> 
<!-- /* Copyright 1997-2003 BURST! Media, LLC. All Rights Reserved. (Version 1.0J) */ 
function ShowBurstAd(adcode, width, height, sizes, intrusive, bgcolor, background) {
var bN = navigator.appName;
var bV = parseInt(navigator.appVersion);
var base='http://www.burstnet.com/';
var Tv=''; var Itr='';
var sz=''; var bkgd='';
var bgc=''; var rfr='';
var vr='v=1.0J';
var agt=navigator.userAgent.toLowerCase();

if (sizes.length!=0) {sz='/sz='+sizes;} else {sz='';}
if (bgcolor.length!=0) {bgc='/zg' + bgcolor;} else {bgc='';}
if (background.length!=0) {bkgd='/bgi='+(escape(escape(background))).replace(/\//gi,'%252F');} else {bkgd='';}
rfr='/r='+(escape(escape(top.location.href))).replace(/\//gi,'%252F');
                            
if (bV>=4) {
  ts=window.location.pathname+window.location.search;
  i=0; Tv=0; while (i< ts.length)
    { Tv=Tv+ts.charCodeAt(i); i=i+1; } Tv="/"+Tv;
} else {Tv=escape(window.location.pathname);
  if( Tv.charAt(0)!='/' ) Tv="/"+Tv;
    else if (Tv.charAt(1)=="/")
 Tv="";
  if( Tv.charAt(Tv.length-1) == "/")
   Tv = Tv + "_";
}

var fCode='<ifr'+'ame id="BURST" src="'+base+
 'cgi-bin/ads/'+adcode+'.cgi/NI/if/'+vr+bgc+sz+bkgd+
 rfr+Tv+'/RETURN-CODE" width="'+width+'" height="'+
 height+'"'+'marginwidth="0" marginheight="0"'+
 'hspace="0" vspace="0" frameborder="0" '+
 'scrolling="no">';
 var gCode = '<'+'a href="'+base+'ads/'+adcode+'-map.cgi/'+
 vr+sz+rfr+Tv+'" target=_top><im'+'g src="'+base+
 'cgi-bin/ads/'+adcode+'.cgi/'+vr+sz+rfr+Tv+
 '" border="0" alt="Click Here"><\/a>';
var fCodeEnd = '<\/ifr'+'ame>';

if ((adcode.charAt(0)=="a")&&(intrusive=="1")) {
 Itr='<di'+'v><scr'+'ipt src="'+base+'cgi-bin/ads/'+adcode+
 '.cgi/sz=0X0MN/'+vr+rfr+Tv+'/RETURN-CODE/JS/"><\/scr'+'ipt><\/d'+'iv>';
}

if (agt.indexOf("mac")==-1) {
  document.write(fCode+gCode+fCodeEnd+Itr);
} else {
  document.write(gCode);
}
}
//-->
</script>
<!-- END BURST CODE -->

<div align="center">

<!-- BEGIN RICH-MEDIA BURST! CODE --> 
<script language="JavaScript" type="text/javascript">
<!--
ShowBurstAd('ad4556a','728','90','468x60A|728x90A','2', '', '');
// --></script>
<noscript><a href="http://www.burstnet.com/ads/ad4556a-map.cgi/ns/v=1.0J/sz=468x60A|728x90A/" target="_top">
<img src="http://www.burstnet.com/cgi-bin/ads/ad4556a.cgi/ns/v=1.0J/sz=468x60A|728x90A/" border="0" alt="Click Here"></a> 
</noscript>
<!-- END BURST CODE -->
</div>

<TABLE WIDTH="100%" CELLPADDING="0" CELLSPACING="0" BORDER="0">
<TR>
	<TD ALIGN="left" VALIGN="top"><A HREF="/"><IMG SRC="/images/freebsddiary-logo.gif" ALT="The FreeBSD Diary" WIDTH="431" HEIGHT="98" BORDER="0"></A> <small><a href="/other-copyrights.php">(R)</a></small><TD>
	<TD ALIGN="right" CLASS="sans" VALIGN="bottom">Providing practical examples since 1998<BR>Sat, 25 Oct 2003 9:02 PM PDT</TD>
</TR>
</TABLE>


<div id="linksheader" align="right">
[ <A HREF="/">HOME</A> | <A HREF="/topics.php">TOPICS</A> | <A HREF="/chronological.php">INDEX</A> | <A HREF="/help.php">WEB RESOURCES</A> | <A HREF="/booksmags.php">BOOKS</A> | <A HREF="/contribute.php">CONTRIBUTE</A> | <A HREF="/search.php">SEARCH</A> | <A HREF="/feedback.php">FEEDBACK</A> | <A HREF="/faq.php">FAQ</A> | <A HREF="/phorum/">FORUMS</A> ]
</div>

<TABLE WIDTH="100%" ALIGN="center" BORDER="0">
		<TR><TD VALIGN="top">
		<TABLE WIDTH="100%" BORDER="0">
		
  <TR>
    <TD>

<div class="heading">
<span class="left">Apache - virtual hosts</span>
<span class="right">26 September 1998</span>
</div>
    </TD>
  </TR>
<TR><TD ALIGN="right"><div class="headingmoreinfo">Need more help on this topic? <A HREF="/phorum/post.php?f=1">Click here</A><BR>This article has <a href="phorum/list.php?f=3&amp;article_id=40">2 comments</a><br>Show me <a href="topics.php?aid=40">similar articles</a><br></div></TD></TR>
  <TR>
    <TD>See also <a href="topics.php#apache">Apache topics</A>.<P>If you want to know more
    about virtual machines, see <a href="http://cybernut.com/guides/virtual.html">http://cybernut.com/guides/virtual.html</A></TD>
  </TR>
  <TR>
    <TD height="10"></TD>
  </TR>


  <TR>
    <TD>
    <div class="section">Virtual hosts</div>
    </TD>
  </TR>

  <TR>
    <td>A web server is both software and hardware.&nbsp; The machine on which the web site
    resides is referred to as a web server.&nbsp; The software which runs the web site is also
    referred to as a web server.&nbsp; In our case, Apache (the web server) runs on our
    FreeBSD box (also, our web server).&nbsp; But a given web server can run more than one web
    site.&nbsp; It can achieve this multi-use by using virtual hosting.<P>Virtual hosting is
    the ability for a website to act as if it is the only web site on the machine.&nbsp; Given
    that some web site can be idle for long periods of time, allowing many web sites to share
    the same hardware is a great way to reduce costs.&nbsp; </P>
    <P>A <a href="http://www.apache.org/docs/vhosts/index.html">very good explanation</A>
    appears within the Apache documentation.&nbsp; For more detail, please refer to that
    document.</TD>
  </TR>
  <TR>
    <TD height="10"></TD>
  </TR>


  <TR>
    <TD>
    <div class="section">Name-based virtual hosts</div>
    </TD>
  </TR>

  <TR>
    <td>For this example, we'll be making use of name-based virtual hosts.&nbsp; Again, the
    Apache documentation <a href="http://www.apache.org/docs/vhosts/name-based.html">explains
    this term</A> very well.&nbsp; We will also be making use of <a href="http://www.apache.org/docs/vhosts/examples.html#name">their example</A>.<P>In this
    example, I've registered two names both of which translate to my FreeBSD box. &nbsp; For
    more information on how I actually did this, see <a href="newdomains.php">httpd/dns</A>.
    &nbsp; The two host names in question are:<ul>
      <li>http://freebsddiary.yi.org - no longer in use</li>
      <li><a href="http://test.freebsddiary.org">http://test.freebsddiary.org</A></li>
    </ul>
    <P>The server machine has one IP address, 192.168.0.45 which resolves to the name
    test.freebsddiary.org.&nbsp; Here is what I've ensured is in my configuration file <kbd>(/usr/local/etc/apache/httpd.conf</kbd>):</P>
    <P>NOTE: See the notes after this example.</P>
    <blockquote>
      <Pre>...
<kbd>Port 80

ServerName test.freebsddiary.org</kbd></pre>
      <P><kbd>NameVirtualHost 192.168.0.45</kbd></P>
      <P><kbd>&lt;VirtualHost 192.168.0.45&gt;<br>
      &nbsp;&nbsp;&nbsp; DocumentRoot&nbsp;/usr/local/www/data/freebsddiary<br>
      &nbsp;&nbsp;&nbsp; ServerName&nbsp;&nbsp;&nbsp;<a href="http://test.freebsddiary.org">test.freebsddiary.org</A><br>
      &nbsp;&nbsp;&nbsp; ErrorLog &nbsp;&nbsp;&nbsp;&nbsp;/var/log/freebsddiary-error.log <br>
      &nbsp;&nbsp;&nbsp; TransferLog&nbsp;&nbsp;/var/log/freebsddiary-access.log<br>
      &lt;/VirtualHost&gt;<br>
      <br>
      &lt;VirtualHost 192.168.0.45&gt;<br>
      &nbsp;&nbsp;&nbsp; DocumentRoot&nbsp;/usr/local/www/data/freebsddiary.yi.org<br>
      &nbsp;&nbsp;&nbsp; ServerName&nbsp;&nbsp;&nbsp;freebsddiary.yi.org<br>
      &nbsp;&nbsp;&nbsp; ErrorLog &nbsp;&nbsp;&nbsp;&nbsp;/var/log/freebsddiary.yi.org-error.log
      <br>
      &nbsp;&nbsp;&nbsp; TransferLog &nbsp;/var/log/freebsddiary.yi.org-access.log<br>
      &lt;/VirtualHost&gt;</kbd></P>
    </blockquote>
    <P><kbd>DocumentRoot</kbd> is the location of the html files for the given virtual
    website.</P>
    <P>Newer versions of Apache can use combined logs.&nbsp; Search for <kbd>CustomLog</kbd>
    in your Apache configuration file in order to see if you can use this format instaed.
    &nbsp; In which case, these entries will be helpful as an example:</P>
    <blockquote>
      <Pre>ErrorLog        /var/log/freebsddiary-error.log
CustomLog       /var/log/freebsddiary-access.log combined</pre>
    </blockquote>
    <P>The log and error files will be recorded in the directory <kbd>/var/log/</kbd>. &nbsp;
    But you can put them anywhere you want.</P>
    <P>If you specify an IP address for <kbd>VirtualHost</kbd> and supply the <kbd>ServerName</kbd>,
    then you can avoid failures should DNS be unavailable when the configuration file is
    parsed.&nbsp; For more detail, please see <a href="http://www.apache.org/docs/dns-caveats.html">Issues Regarding DNS and Apache</A> at
    the <a href="http://www.apache.org/">Apache website</A>.</P>
    <P>This also assumes that you have pointed <kbd>freebsddiary.yi.org</kbd> and <kbd>test.freebsddiary.org</kbd>
    to the same IP.&nbsp; In this case, 192.168.0.45.</P>
    <P>So far so good.&nbsp; However, I've been unable to publish to my Apache Fp webserver.
    &nbsp; I think that's because I've not told Apache which users <b>can</b> publish.
    &nbsp; For details on how I did that, see <a href="publishing.php">Apache - who can
    publish what?</A>.</P>

    <P>NOTE: I found that specifying <kbd>NameVirtualHost</kbd> as shown above, caused a
    problem with the version of Apache I was using.&nbsp; So I removed it and virtual hosts
    still worked.</P>

	<P>
	<BIG>NOTE:</BIG> Although I am adding an IP address below, there is an <A HREF="#easier">easier way</A>.
	Thanks to James A. Peltier for pointing this out.

    <P>You should also see <a href="virtualhosts2.php">Apache - virtual hosts (continued)</A>.


      </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="sectionsplit">
      <span class="left"><A NAME="easier">An easier way</A></span>
      <span class="right">10 September 2002</span></div>
    </div>

  <TR>
    <TD>
    <P>
	As mentioned above, there is an easier way.  Instead of declaring your virtual hosts
	with a predefined IP address, you can use * instead.  For example, I started out with this:

	<BLOCKQUOTE><CODE CLASS="code">
	&lt;VirtualHost 192.168.0.56&gt;
	</CODE></BLOCKQUOTE>

	But I could use this instead::

	<BLOCKQUOTE><CODE CLASS="code">
	&lt;VirtualHost *&gt;
	</CODE></BLOCKQUOTE>

	<P>Similarly, you can use * in the <CODE CLASS="code">NameVirtualHost</CODE> declaration instead of an IP address:

	<BLOCKQUOTE><CODE CLASS="code">
	NameVirtualHost *
	</CODE></BLOCKQUOTE>


      </TD>
  </TR>

  <TR>
    <TD height="10"></TD>
  </TR>

</TABLE>



			</TD><TD VALIGN="top" WIDTH="165">
<div align="center">
<a href="http://www.amazon.ca/exec/obidos/registry/1UO11T8NUWD4F/702-9027378-3004044/thefreebsdd01-20"><b>My Wish List!</b></a>
</div>
			<TABLE BORDER="0" CELLPADDING="5">
			<TR><TD ALIGN="center">

		
<!-- BEGIN RICH-MEDIA BURST! CODE --> 
<script language="JavaScript" type="text/javascript">
<!--
ShowBurstAd('sk4556a','160','600','120x600A|160x600A','0', '', '');
// --></script>
<noscript><a href="http://www.burstnet.com/ads/sk4556a-map.cgi/ns/v=1.0J/sz=120x600A|160x600A/" target="_top">
<img src="http://www.burstnet.com/cgi-bin/ads/sk4556a.cgi/ns/v=1.0J/sz=120x600A|160x600A/" border="0" alt="Click Here"></a> 
</noscript>
<!-- END BURST CODE -->
</TD></TR>
			</TABLE>
			</TD></TR>
			</TABLE>
			<TABLE WIDTH="100%" CELLPADDING="3" CELLSPACING="0" BORDER="0">
		<TR><TD ALIGN="right"><div class="headingmoreinfo">Need more help on this topic? <A HREF="/phorum/post.php?f=1">Click here</A><BR>This article has <a href="phorum/list.php?f=3&amp;article_id=40">2 comments</a><br>Show me <a href="topics.php?aid=40">similar articles</a><br></div></TD></TR>
		<TR>
			<TD ALIGN="center">
			<div id="linksfooter">
			[ <A HREF="/">HOME</A> | <A HREF="/topics.php">TOPICS</A> | <A HREF="/chronological.php">INDEX</A> | <A HREF="/help.php">WEB RESOURCES</A> | <A HREF="/booksmags.php">BOOKS</A> | <A HREF="/contribute.php">CONTRIBUTE</A> | <A HREF="/search.php">SEARCH</A> | <A HREF="/feedback.php">FEEDBACK</A> | <A HREF="/faq.php">FAQ</A> | <A HREF="/phorum/">FORUMS</A> ]
			</div>
			</TD>
		</TR>
		</TABLE>
		
<div class="footer">
<span class="left">
Server and bandwidth provided by <A HREF="http://www.bchosting.com/" TARGET="_new">BChosting.com</A>
</span>
<span class="right">
Valid 
<a href="http://validator.w3.org/check/referer">HTML</a>, 

<a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a>
, and
<a href="http://feeds.archive.org/validator/check?url=http://www.freebsddiary.org:80/news.php">RSS</a>.<BR>
<A HREF="/legal.php">Copyright</a> &copy; 1997 - 2003 <A HREF="http://www.dvl-software.com/">DVL Software Ltd.</A><BR>All rights reserved.
</span>
</div>
<div align="center">
<br>

<!-- BEGIN RICH-MEDIA BURST! CODE --> 
<script language="JavaScript" type="text/javascript">
<!--
ShowBurstAd('ba4556a','468','60','468x60B','0', '', '');
// --></script>
<noscript><a href="http://www.burstnet.com/ads/ba4556a-map.cgi/ns/v=1.0J/sz=468x60B/" target="_top">
<img src="http://www.burstnet.com/cgi-bin/ads/ba4556a.cgi/ns/v=1.0J/sz=468x60B/" border="0" alt="Click Here"></a> 
</noscript>
<!-- END BURST CODE -->
</div>

</body>
</html>
