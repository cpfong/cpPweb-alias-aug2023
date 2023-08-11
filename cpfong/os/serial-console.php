<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>

	<TITLE>The FreeBSD Diary -- Serial Consoles can be very useful</TITLE>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" type="text/css" href="/css/site.css">

	<META NAME="description" CONTENT="Serial Consoles can be very useful">
	<META NAME="keywords"    CONTENT="FreeBSD, serial, console, serial console">

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
	<TD ALIGN="right" CLASS="sans" VALIGN="bottom">Providing practical examples since 1998<BR>Sat, 25 Oct 2003 8:46 PM PDT</TD>
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
<span class="left">Serial Consoles can be very useful</span>
<span class="right">20 September 2002</span>
</div>
    </TD>
  </TR>
<TR><TD ALIGN="right"><div class="headingmoreinfo">Need more help on this topic? <A HREF="/phorum/post.php?f=1">Click here</A><BR>This article has <a href="phorum/list.php?f=3&amp;article_id=511">14 comments</a><br>Show me <a href="topics.php?aid=511">similar articles</a><br></div></TD></TR>
  <TR>
	<TD>
	<P>
	This article isn't fully complete yet.  I wanted to have two serial cables going from one box to the other.
	But what's here and in <a href="serial-console2.php">Adding a new drive via the serial console using dump/restore</a>
	should be enough to get you going.

	<P>
	Serial consoles have their uses. Unfortunately, this seems to be a hard learned lesson.  
	Especially when you have locked yourself out of the box during
	a firewall rule change, or a <CODE class="code">/etc/hosts.allow</CODE> modification, or even when you accidentally or 
	inadvertently kill <CODE class="code">sshd</CODE>.

	<P>
	During	a recent -STABLE upgrade of two remote boxes, I managed to lock myself out of the box (see my post to the  
	<A HREF="http://www.freebsd.org/cgi/getmsg.cgi?fetch=88296+0+current/freebsd-stable">mailing list</A>.  Luckily,
	the solution was rather simple, and I recovered both boxes.  The elapsed time between problem discovery and problem resolution
	was about four days (I found the problem on a Sunday, and fixed it on Thursday morning).  If a serial console had been 
	available, the problem would have been fixed within 30 minutes.  The fact that I was in Ottawa and the machines were in
	New Zealand didn't help the situation.  Luckily, the staff at <A HREF="http://www.citylink.co.nz"/>CityLink</A> have been
	very helpful and kind to me over the years...
	</P>
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">The handbook</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<P>
	Have you heard about the <A HREF="http://www.freebsd.org/doc/en_US.ISO8859-1/books/handbook/">FreeBSD Handbook</A>?
	If not, where have you been?  I count over 200 references to the handbook from within my website.  If you've never
	read this document, you need to.  In fact, as I type this, I'm about to start reading the section on serial
	communications which deals with <CODE class="code">Setting Up the Serial Console</CODE>.  You will need to read
	that document first.  If you don't, you won't find my article any use at all.
	</P>

	<P>
	I think you should 
	I will not be going into detail about what I did to get the serial console running.   I will only be providing
	points which I had to deal with for my situation.  Your needs will vary and that necessitates that you read that
	document.
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">My particular situation</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<P>
	In my situation, I have two computers, over which I have exclusive access, and which are the same location.  They have
	two serial cables between them.  Each has com1 [also known as sio0] configured to be a serial console
	and is listening on com2 to the other computer.  That is, each computer has a null modem
	cable from going from its own COM1 to the other computer's COM2.  My objective is the ability to access the
	broken box from the other box.  The assumption is that at one box will be running fine whenever the other box breaks.
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">What it looks like during the boot</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<P>
	The following is what the reboot looked like after my first attempt.  I was using <CODE CLASS="code">-D</CODE>
	in <CODE CLASS="code">/boot.config</CODE>:
<BLOCKQUOTE><CODE class="code">
cvsup reboot:Waiting (max 60 seconds) for system process vnlru' to stop...stopped<BR>
Waiting (max 60 seconds) for system process bufdaemon' to stop...stopped<BR>
Waiting (max 60 seconds) for system process syncer' to stop...stopped<BR>
<BR>
syncing disks... 3 2 2<BR>
done<BR>
Uptime: 16m38s<BR>
Rebooting...<BR>
Copyright (c) 1992-2002 The FreeBSD Project.<BR>
Copyright (c) 1979, 1980, 1983, 1986, 1988, 1989, 1991, 1992, 1993, 1994<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The Regents of the University of California. All rights reserved.<BR>
FreeBSD 4.6-STABLE #0: Sat Aug 10 04:35:41 NZST 2002<BR>
&nbsp;&nbsp;&nbsp;&nbsp;dan@cvsup.example.org:/usr/home/ncvs/usr-obj/usr/src/sys/ZEKE<BR>
</CODE></BLOCKQUOTE>

	That wasn't good enough.  I also wanted the boot sequence.  So I changed the options to <CODE CLASS="code">-Dh</CODE>.
	Then I saw this:
<BLOCKQUOTE><CODE CLASS="code">
cvsup reboot:<BR>
Waiting (max 60 seconds) for system process vnlru' to stop...stopped<BR>
Waiting (max 60 seconds) for system process bufdaemon' to stop...stopped<BR>
Waiting (max 60 seconds) for system process syncer' to stop...stopped<BR>
syncing disks...<BR>
done<BR>
Uptime: 26m44s<BR>
Rebooting...<BR>
Console: serial port<BR>
BIOS drive A: is disk0<BR>
BIOS drive C: is disk1<BR>
BIOS drive D: is disk2<BR>
BIOS 639kB/64512kB available memory<BR>
<BR>
FreeBSD/i386 bootstrap loader, Revision 0.8<BR>
(dan@cvsup.example.org, Fri Aug  2 20:21:34 NZST 2002)<BR>
Loading /boot/defaults/loader.conf<BR>
/kernel text=0x2e3775 data=0x3b4a0+0x345f4 syms=[0x4+0x3e450+0x4+0x44e15]<BR>
-<BR>
Hit [Enter] to boot immediately, or any other key for command prompt.<BR>
Booting [kernel]...<BR>
Copyright (c) 1992-2002 The FreeBSD Project.<BR>
Copyright (c) 1979, 1980, 1983, 1986, 1988, 1989, 1991, 1992, 1993, 1994<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The Regents of the University of California. All rights reserved.<BR>
FreeBSD 4.6-STABLE #0: Sat Aug 10 04:35:41 NZST 2002<BR>
&nbsp;&nbsp;&nbsp;&nbsp;dan@cvsup.example.org:/usr/home/ncvs/usr-obj/usr/src/sys/ZEKE<BR>
</CODE></BLOCKQUOTE>

	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Connecting to the serial console</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<P>
	On the other box (i.e. the one which is working and does not have the problem), enter this
	command: 
	
<BLOCKQUOTE><CODE class="code">
# tip com1
connected


FreeBSD/i386 (cvsup.example.org) (ttyd0)

login:
</CODE></BLOCKQUOTE>

	<P>
	To disconnect the serial session, type <CODE class="code">~.</CODE> (that's a tilde followed by 
	a period).  WARNING: you should
	be aware of the possible consequences of not logging out before you disconnect.  
	If the first machine is compromised, it is trivial to connect via the serial link.  If you
	have not logged out, then the second machine will be compromised as well.
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">This article brought to you by the letter A...</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<P>
	Coincidentally, my copy of <A HREF="http://www.absolutebsd.com/">Absolute BSD: The Ultimate Guide to FreeBSD</A>
	by Michael W. Lucas arrived today.  Just in time for me to use Chapter 20 which contains a section on the
	serial console.
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
		<TR><TD ALIGN="right"><div class="headingmoreinfo">Need more help on this topic? <A HREF="/phorum/post.php?f=1">Click here</A><BR>This article has <a href="phorum/list.php?f=3&amp;article_id=511">14 comments</a><br>Show me <a href="topics.php?aid=511">similar articles</a><br></div></TD></TR>
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

