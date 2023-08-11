<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>

	<TITLE>The FreeBSD Diary -- Managing an IP address change - part 2</TITLE>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" type="text/css" href="/css/site.css">

	<META NAME="description" CONTENT="Managing an IP address change - part 2">
	<META NAME="keywords"    CONTENT="FreeBSD, ifconfig, httpd.conf, DNS, named.conf, change, ip, address, tcpdump, netsaint">

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
	<TD ALIGN="right" CLASS="sans" VALIGN="bottom">Providing practical examples since 1998<BR>Sat, 25 Oct 2003 8:57 PM PDT</TD>
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
<span class="left">Managing an IP address change - part 2</span>
<span class="right">4 October 2002</span>
</div>
    </TD>
  </TR>
<TR><TD ALIGN="right"><div class="headingmoreinfo">Need more help on this topic? <A HREF="/phorum/post.php?f=1">Click here</A><BR>This article has <a href="phorum/list.php?f=3&amp;article_id=517">7 comments</a><br>Show me <a href="topics.php?aid=517">similar articles</a><br></div></TD></TR>
  <TR>
	<TD>
	<P>
	It was almost a month ago that I started changing the IP address of The FreeBSD Diary web server.  When I first
	mentioned to someone that I was going to write an article about this process, they wondered: why, all it takes
	is an ifconfig, what is there to write about?  I guess they didn't understand the whole story.  Yes, if you're
	changing the IP address of a box which is not providing services, then no, it's not much of a big deal.

	<P>
	Please read <a href="/ip-address-change.php">Part 1</A> of this article.

    </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">DNS propagation</div>
    </TD>
  </TR>

  <TR>
    <TD>
	<P>
	The key point to consider when changing an IP address is DNS.  By its very nature, DNS information is distributed.  That
	is part of how it works so well.  If someone looks up the IP address for www.freebsddiary.org, they will store that
	answer for a while.  That reduces network traffic, reduces the load on my DNS servers, and makes things faster at
	their computer (they don't have to wait for each DNS query to complete; only the first one).  It follows that the 
	downside to this efficiency comes when the information must change.  It takes time for this information to propagate.
	How much time depends upon your settings within your domain's zone files.  Look at the Expire and Refresh values
	to see just how long it can take.  It appears that these values are not strictly honored by all DNS servers.  Some
	like to cache longer than the domain settings.  That's their problem and there's nothing you can do about that.

	<P>
	The box in question (m20.unixathome.org) has several functions, which include:

	<UL>
	<LI>mail server
	<LI>web server
	<LI>ssh server
	</UL>

	If these services are interrupted because clients cannot get to the box because of IP address problems, then
	some people are going to be unhappy.  And that is going to include me.  I refer to this website many times a week for
	various things.

    </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Other IP addresses to change</div>
    </TD>
  </TR>

  <TR>
    <TD>
    <P>
	I had other domains which pointed at m20.  I wanted to update their DNS as well.   Those changes simply involved
	modifying the IP address, as opposed to adding a second value to the existing host names.  These were easy to do.
	After those changing had propagated, I was then ready to remove the old IP address from m20.

    </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Swapping primary & alias on ifconfig - failure</div>
    </TD>
  </TR>

  <TR>
    <TD>
	<P>
	On Monday, I decided it was time to go one step further in the process.  I wanted to swap the primary and alias IP 
	addresses. Although a NIC may have more than one IP address, by default, all outgoing connections will originate from 
	the primary IP address and not the alias.  This will have effects on the outside world as my box attempts to send
	out information.  Namely, it will affect firewalls which [should] filter by IP address.

	<P>
	To effect these changes, I went ahead and modified <CODE CLASS="code">/etc/rc.conf</CODE> to swap around the IP addresses which appeared in the 
	<CODE CLASS="code">ifconfig_rl0</CODE> and <CODE CLASS="code">ifconfig_rl0_alias0</CODE> directives.  Then I rebooted the box.
	This was a disaster.  The box never came back.  And I had to drive into the POP to change things back.  Of course, it
	was just before close of business, and I also had somewhere to be.  So rather than fully diagnose the problem, I 
	quickly changed the IP address information back to what it was before and rebooted.  All was well.  Things
	were back online.

	<P>
	In hindsight, the 
	messages on the console showed that routing was a problem.  Here's what I was seeing which led me to believe that:

<BLOCKQUOTE><CODE CLASS="code">
Sep 30 16:09:05 m20 named[88]: Ready to answer queries.<br>
Sep 30 16:09:05 m20 ntpd[91]: ntpd 4.1.0-a Thu Aug  1 00:21:33 EDT 2002 (1)<br>
Sep 30 16:09:05 m20 ntpd[91]: kernel time discipline status 2040<br>
Sep 30 16:09:09 m20 ntpd[91]: sendto(209.87.233.53): No route to host<br>
Sep 30 16:09:17 m20 ntpd[91]: sendto(128.100.103.17): No route to host<br>
Sep 30 16:09:18 m20 ntpd[91]: sendto(132.246.168.164): No route to host<br>
Sep 30 16:09:18 m20 ntpd[91]: sendto(199.212.17.35): No route to host<br>
Sep 30 16:09:18 m20 ntpd[91]: sendto(199.212.17.34): No route to host<br>
Sep 30 16:09:22 m20 ntpd[91]: sendto(128.100.100.128): No route to host<br>
....<br>
Sep 30 16:12:10 m20 lpd[164]: Get_local_host: hostname 'm20.unixathome.org' bad<br>
</CODE></BLOCKQUOTE>

	I guessed that routing was a problem.  Then I remembered that I had not changed the default route (i.e. 
	the <CODE CLASS="code">defaultrouter</CODE> entry in <CODE CLASS="code">/etc/rc.conf</CODE>).
	I wasn't 100% positive that this was the only problem, but it looked like a starting point.
    </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Swapping primary & alias on ifconfig - success</div>
    </TD>
  </TR>

  <TR>
    <TD>
    <P>
	It wasn't until Friday October 3 that I was ready to try again.  This time I had a cunning plan.
	I had decided to change the IP addresses via the command line rather than risk a reboot.
	But this had to be done carefully.  There was the risk that removing the IP address would
	terminate the ssh session.  And then where would I be?

	<P>
	The plan involved two cron jobs: one to change the IP address, and another to reboot the box
	in case the change locked me out.  A cunning plan indeed.

	<P>
	Here is the shell script:

<BLOCKQUOTE><CODE CLASS="code">
dan@m20:/usr/local/etc] $ less ifconfig.sh<br>
#!/bin/sh<br>
<br>
ifconfig fxp0 inet &nbsp;66.11.168.227&nbsp;&nbsp; netmask 255.255.255.128<br>
ifconfig fxp0 alias 216.187.106.227 netmask 255.255.255.255<br>
<br>
route delete default<br>
route add default 66.11.168.252
</CODE></BLOCKQUOTE>

	Yes, those are the real IP addresses.

	<P>
	And here are the cron jobs:

<BLOCKQUOTE><CODE CLASS="code">
36 * * * * root /usr/local/etc/ifconfig.sh<br>
40 * * * * root /sbin/reboot
</CODE></BLOCKQUOTE>

	<P>
	As you can see, at 36 past the hour, the IP addresses would change and so would the default gateway.  That gave me
	four minutes to confirm everything was healthy before the system automagically rebooted.

	<P>
	After the shell script ran, I checked the NIC details:

<BLOCKQUOTE><CODE CLASS="code">
$ ifconfig fxp0
fxp0: flags=8843&lt;UP,BROADCAST,RUNNING,SIMPLEX,MULTICAST&gt; mtu 1500<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; inet6 fe80::2a0:c9ff:fe49:baaa%fxp0 prefixlen 64 scopeid 0x1<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; inet 66.11.168.227 netmask 0xffffff80 broadcast 66.11.168.255<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; inet 216.187.106.227 netmask 0xffffffff broadcast 216.187.106.227<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ether 00:a0:c9:49:ba:aa<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; media: Ethernet autoselect (100baseTX &lt;full-duplex&gt;)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; status: active
</CODE></BLOCKQUOTE>

	Hmmm, well that certainly seems to have worked.  I ran a few other tests (e.g. made sure I could create a new ssh session to 
	the computer, and that I could run cvsup on the box and update the website).

	<P><BIG>Don't forget</BIG> to disable those cron jobs!

    </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Final /etc/rc.conf changes</div>
    </TD>
  </TR>

  <TR>
    <TD>
    <P>
	The ultimate goal in swapping primary and alias IP addresses was to make it easier to remove the old IP address.  That will
	be done later using an <CODE CLASS="code">ifconfig fxp0 delete 216.187.106.227</CODE>.  But until that time comes, I really
	should update <CODE CLASS="code">/etc/rc.conf</CODE> with the real information.  But I'd rather do that tomorrow morning 
	rather than now (4:47 pm).  That way, if something goes wrong, I can easily get access to the POP.
    </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">I'm not finished yet</div>
    </TD>
  </TR>

  <TR>
    <TD>
    <P>
	There are still a few things left to do:

	<UL>
	<LI>reboot using the new <CODE CLASS="code">/etc/rc.conf</CODE> (to ensure the changes work!)
	<LI>remove the old IP address from DNS
	<LI>let that change propogate
	<LI>remove the old IP address from fxp0 (and the alias from <CODE CLASS="code">/etc/rc.conf</CODE>)
	<LI>... I think that's all
	</UL>
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
		<TR><TD ALIGN="right"><div class="headingmoreinfo">Need more help on this topic? <A HREF="/phorum/post.php?f=1">Click here</A><BR>This article has <a href="phorum/list.php?f=3&amp;article_id=517">7 comments</a><br>Show me <a href="topics.php?aid=517">similar articles</a><br></div></TD></TR>
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

