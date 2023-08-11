<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>

	<TITLE>The FreeBSD Diary -- Managing an IP address change</TITLE>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" type="text/css" href="/css/site.css">

	<META NAME="description" CONTENT="Managing an IP address change">
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
<span class="left">Managing an IP address change</span>
<span class="right">3 September 2002</span>
</div>
    </TD>
  </TR>
<TR><TD ALIGN="right"><div class="headingmoreinfo">Need more help on this topic? <A HREF="/phorum/post.php?f=1">Click here</A><BR>This article has <a href="phorum/list.php?f=3&amp;article_id=514">4 comments</a><br>Show me <a href="topics.php?aid=514">similar articles</a><br></div></TD></TR>
  <TR>
	<TD>
	<P>
	Have you ever changed the IP address of your computer?  For those of you with a dynamic IP address, such changes 
	are transparent.  You don't see it.  Hopefully that's what will happen when we change the IP address of the 
	server which hosts this website.  It should just happen and nobody will notice.
	</P>

	<P>
	If you're just interested in setting the IP address of your FreeBSD computer, then this article is way too
	much information.  Just read the next section and it will show you.  Please ignore the rest of the article
	as it is beyond the scope of what you are trying to do.

	<P>
	In this article, I will use 192.168.0.56 as the original IP address and 192.168.0.57 as the new IP address.  In reality,
	the change is from a.b.c.56 to x.y.z.56 (i.e. all but the last octet will change).

	<P>
	Here is a brief outline of the plan we are going to use.  Please think carefully about your own situation but this list will
	be helpful.  In short, we will make the server respond to both the new and the old IP address, then change the DNS, and let 
	it propagate before we remove the old IP address.  This should minimize any down time for users of the system.

	<OL>
	<LI><CODE CLASS="code">/etc/rc.conf</CODE> - add a new IP address to the NIC</LI>
	<LI><CODE CLASS="code">/etc/ipf.rules</CODE> - modify the firewall rules</LI>
	<LI><CODE CLASS="code">/usr/local/etc/apache/httpd.conf</CODE> - alter the <A HREF="./virtualhosts.php">virtual hosts</A></LI>
	<LI>test</LI>
	<LI><CODE CLASS="code">/etc/namedb/*.db</CODE> - update the DNS</LI>
	<LI>let things propagate</LI>
	<LI>remove references to the old IP address</LI>
	</OL>

    </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Adding an IP address to a NIC</div>
    </TD>
  </TR>

  <TR>
    <TD>
	<P>
	A NIC (Network Interface Card) can handle more than one IP address.  
	<CODE CLASS="code"><A HREF="http://www.freebsd.org/cgi/man.cgi?query=ifconfig&amp;apropos=0&amp;sektion=0&amp;manpath=FreeBSD+4.6-stable&amp;format=html">ifconfig (8)</A></CODE>
	manages IP addresses.  We will use that command to manually add an alias, but we will set a hook in <CODE CLASS="code">/etc/rc.conf</CODE>
	to add it at boot time.

	<P>
	You probably already know how to assign an IP address to a NIC at boot time. That can
	be done by adding this line to <CODE CLASS="code">/etc/rc.conf</CODE>:

	<BLOCKQUOTE><CODE CLASS="code">
	ifconfig_<B>rl0</B>="inet <B>192.168.0.56</B>  netmask <B>255.255.255.0</B>"
	</CODE></BLOCKQUOTE>

	<P>
	This assigns an IP address of <B>192.168.0.56</B> to <B>rl0</B>.  The netmask will be <B>255.255.255.0</B>.  You can issue
	this command manually:

	<BLOCKQUOTE><CODE CLASS="code">
	ifconfig <B>rl0</B> inet <B>192.168.0.56</B>  netmask <B>255.255.255.0</B>
	</CODE></BLOCKQUOTE>


	   </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Adding the alias to the NIC</div>
    </TD>
  </TR>

  <TR>
    <TD>
	<P>
	The next step is to add an additional IP address.  This is done with the <CODE CLASS="code">alias</CODE> parameter.
	Here is the line added to <CODE CLASS="code">/etc/rc.conf</CODE>:

	<BLOCKQUOTE><CODE CLASS="code">
	ifconfig_rl0_alias0="192.168.0.57 netmask 0xffffffff"
	</CODE></BLOCKQUOTE>

	NOTE: that the netmask shown is what you should use.  Don't use the same netmask as the main IP address.
	Please read this extract from <CODE CLASS="code"><A HREF="http://www.freebsd.org/cgi/man.cgi?query=ifconfig&amp;apropos=0&amp;sektion=0&amp;manpath=FreeBSD+4.6-stable&amp;format=html">ifconfig (8)</A></CODE>

<BLOCKQUOTE><CODE CLASS="code">
&nbsp; alias&nbsp;  Establish an additional network address for this interface.  This<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; is sometimes useful when changing network numbers, and one wishes<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     to accept packets addressed to the old interface.If the address<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     is on the same subnet as the first network address for this<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     interface, a non-conflicting netmask must be given.  Usually<BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     0xffffffff is most appropriate.
</CODE></BLOCKQUOTE>

	The manual equivalent of this <CODE CLASS="code">/etc/rc.conf</CODE> entry is:

	<BLOCKQUOTE><CODE CLASS="code">
	ifconfig rl0 alias 192.168.0.57 netmask 0xffffffff
	</CODE></BLOCKQUOTE>

	<P>
	After doing that, here is what my NIC looked like:


<BLOCKQUOTE><PRE CLASS="code">
$ ifconfig rl0
rl0: flags=8843&lt;UP,BROADCAST,RUNNING,SIMPLEX,MULTICAST&gt; mtu 1500
        inet 192.168.0.56 netmask 0xffffff00 broadcast 192.168.0.255
        inet6 fe80::250:fcff:fe50:5688%rl0 prefixlen 64 scopeid 0x1
        inet <B>192.168.0.57</B> netmask <B>0xffffffff</B> broadcast 192.168.0.57
        ether 00:50:fc:50:56:88
        media: Ethernet autoselect (100baseTX &lt;full-duplex&gt;)</PRE></BLOCKQUOTE>
       </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Firewall rules</div>
    </TD>
  </TR>

  <TR>
    <TD>
	<P>
	I use <A HREF="http://coombs.anu.edu.au/~avalon/">ipf</A> which is in the base system for FreeBSD.  It's a great
	firewall tool, my packet filter of choice, and is what I recommend to others.

	<P>
	You may have to modify your firewall rules to cater for the additional IP address.  You will have to decide for
	yourself.

	<P>
	For my firewall rules, I searched for rules which referred to the old IP address, then duplicated those rules for the new
	IP address.  After making those changes, I implemented the rules using this command:

	<BLOCKQUOTE><CODE CLASS="code">
	ipf -s -Fa -f /etc/ipf.rules && sleep 10 && ipf -s
	</CODE></BLOCKQUOTE>

	After issuing the command, I typed a few characters, noticed that they echo'd to the screen, then pressed control-C.  I had
	10 seconds to do this, during the <CODE CLASS="code">sleep</CODE> command.  See <A HREF="http://www.freebsd.org/cgi/man.cgi?query=ipf&amp;apropos=0&amp;sektion=0&amp;manpath=FreeBSD+4.6-stable&amp;format=html">man 8 ipf</A>
	for more detail.

	I then tested the various services to make sure I could contact them on the new IP address.  I did simple tests such as
	<CODE CLASS="code">telnet 192.168.0.56 25</CODE> to ensure I could get to my mail server.

       </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Apache virtual hosts</div>
    </TD>
  </TR>

  <TR>
    <TD>
    <P>
	This web server uses <A HREF="/virtualhosts.php">virtual hosts</A>.  That allows multiple websites to share the same
	web server and IP address.  I will modify the configuration to respond to multiple IP addresses.  Luckily, that appears
	to be quite simple to do.

	<P>
	I am using name-based virtual hosts.  There are also IP-based hosts. A 
	<a href="http://www.apache.org/docs/vhosts/index.html">very good explanation</A>
    appears within the Apache documentation.&nbsp; For more detail, please refer to that
    document.

	<P>
	<BIG>NOTE:</BIG> Although I am adding an IP address below, there is an <A HREF="#easier">easier way</A>.
	Thanks to James A. Peltier for pointing this out.

	<P>
	My first place to look was <CODE CLASS="code">/usr/local/etc/apache/httpd.conf</CODE>.
	I found all references to the old IP address, and added references to the new IP
	address.  For example, I found this old line:

	<BLOCKQUOTE><CODE CLASS="code">
	&lt;VirtualHost 192.168.0.56&gt;
	</CODE></BLOCKQUOTE>

	Which became:

	<BLOCKQUOTE><CODE CLASS="code">
	&lt;VirtualHost 192.168.0.56 192.168.0.57&gt;
	</CODE></BLOCKQUOTE>

	<P>
	I did this for all other <CODE CLASS="code">VirtualHost</CODE> entries.

      </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
     <TD>
     <div class="section"><a href="easier">Apache virtual hosts - an easier way</a></div>
     </TD>
  </TR>

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

  <TR>
    <TD>
    <div class="section">Apache virtual hosts - testing the changes</div>
    </TD>
  </TR>

  <TR>
    <TD>

	<P>
	It was then time to test what I'd done:

<BLOCKQUOTE><CODE CLASS="code">
# /usr/local/sbin/apachectl configtest<BR>
[Tue Sep  3 10:30:21 2002] [warn] VirtualHost 192.168.0.57:80 overlaps with VirtualHost 192.168.0.57:80, the first has precedence, perhaps you need a NameVirtualHost directive
</CODE></BLOCKQUOTE>

	<P>
	DOH!  I knew about that.  I just forgot it.  You have to explicitly declare each IP address in an NameVirtualHost directive.
	Here is what I now have:

<BLOCKQUOTE><CODE CLASS="code">
NameVirtualHost 192.168.0.56<BR>
NameVirtualHost 192.168.0.57
</CODE></BLOCKQUOTE>

	<P>
	Of course, if I'd been using *, this problem would not have occurred.

	<P>
	Another quick retest of the configuration:

<BLOCKQUOTE><CODE CLASS="code">
# /usr/local/sbin/apachectl configtest<BR>
Syntax OK
</CODE></BLOCKQUOTE>

	<P>
	Then Apache was restarted:

<BLOCKQUOTE><CODE CLASS="code">
# /usr/local/sbin/apachectl graceful<BR>
/usr/local/sbin/apachectl graceful: httpd gracefully restarted
</CODE></BLOCKQUOTE>

    </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">HOT TIP: use NetSaint for testing!</div>
    </TD>
  </TR>

  <TR>
    <TD>
	<P>
	<A HREF="/netsaint.php">NetSaint</A> is a great tool.  But it wasn't until I was almost finished
	writing this article that I realised I could use it for testing my changes.  I added a new host
	to the configuration file, gave it a new name, and used all the same values from the existing
	host, but I changed the IP address.

	<P>
	Of course, this tip isn't much use unless you already have NetSaint installed and running...
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Testing the http changes</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<P>
	Now that I have the server configured with the new IP address, it needs to be tested.  I'm going to do this with my
	local DNS server. I will change that server to refer to the new IP addresses and get one of my test workstations
	to use it.  This will allow me to confirm that the server is answering on the new IP address.  If you don't want to
	test this using DNS, you could also	do this with just <CODE CLASS="code">/etc/hosts</CODE>.
	</P>

	<P>
	After making the local DNS changes, I was ready to test.  To ensure that I was seeing traffic on the new IP address
	I used <CODE CLASS="code">tcpdump</CODE> to verify:

<BLOCKQUOTE><CODE CLASS="code">
# tcpdump -i rl0 host 192.168.0.57
</CODE></BLOCKQUOTE>

	<P>
	When I first browsed to this new IP address, I didn't see the website I expected.  Instead, I saw my default website.
	That's what you'll see if you browse to the IP address associated with www.freebsddiary.org instead of browsing
	by hostname.   The use of virtual hosts involves the HTTP\1.1 protocol passing the host name within the headers
	of the request.  If this host name is not present or is unknown, the default website would be displayed.

	<P>
	The problem was I had forgotten to modify the VirtualHost entry for the website in question.  Once I did that,
	browsing worked as expected.

    </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Testing the SMTP changes</div>
    </TD>
  </TR>

  <TR>
    <TD>
    <P>
	Along with changes to the IP addresses of various websites, mail is also affected.  This server handles mail for
	many domains.  To test that the SMTP server is responding to the new IP address, I added another entry to the 
	<CODE CLASS="code">/etc/hosts</CODE> file which set the new IP address of the mail server.  Then I sent myself
	a message to a domain for which the MX record used that mail server.  Checking <CODE CLASS="code">/var/log/maillog</CODE>
	on both the server and the client, I found that the client had contacted the new IP address and that the server
	had received the message.
	</TD>
  </TR>



	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Changing the DNS server (for real this time)</div>
    </TD>
  </TR>

  <TR>
    <TD>
    <P>
	I'm happy with the results of the testing.  So now it's time to make the changes to the production DNS server.
	The goal is not to change the IP address, but to give each host two IP addresses.   This will have the effect
	of splitting the traffic between the old and new IP addreses.  If there is a problem with the new IP address
	(i.e. I forgot something during the setup), clients out there will hopefully retry another time with the
	new IP address.  Or that's the theory....

	<P>
	So here are the two A records for my main mail server:

<BLOCKQUOTE><PRE CLASS="code">
m20    IN  A       192.168.0.56
m20    IN  A       192.168.0.57
</PRE></BLOCKQUOTE>

	<P>
	After making changes to the DNS, I started monitoring the new IP address using tcpdump to ensure
	traffic was slowing increasing.  So far so good.  I'll update this article as new issues come
	to light.

    </TD>
  </TR>



	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Other things to remember</div>
    </TD>
  </TR>

  <TR>
    <TD>
    <P>
	Here are a few things to remember when you do this.

	<UL>
	<LI>
	If you filter things by IP address, remember to change other firewalls under your control to allow access
	from the new location.
	</LI>

	<LI>
	If you are using <A HREF="/netsaint.php">NetSaint</A> then remember to update that too.  In fact, I think that's an easy
	way to check that everything is running.  Add the host to NetSaint under the new IP address.
	</LI>

	<LI>
	With https, be sure to specify the right IP adresss in the right place.  If you are using a name in the VirtualHost
	declaration, that might be a little difficult.  I swapped from a name to an IP address.

<BLOCKQUOTE><CODE CLASS="code">
&lt;VirtualHost www.freebsddiary.org:443&gt;
</CODE></BLOCKQUOTE>

became

<BLOCKQUOTE><CODE CLASS="code">
&lt;VirtualHost 129.168.0.57:443&gt;
</CODE></BLOCKQUOTE>
	</LI>
	</UL>
    </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="sectionsplit">
      <span class="left">Other things to consider</span>
      <span class="right">15 September 2002</span>
    </div>

  <TR>
    <TD>
    <P>
	You may want to update these files with your new IP address:

	<UL>
	<LI><CODE CLASS="code">/etc/hosts</CODE>
	<LI><CODE CLASS="code">/etc/hosts.allow</CODE>
	<LI><CODE CLASS="code">/usr/local/etc/smb.conf</CODE>
	</UL>

	It might also be wise to run a <CODE CLASS="code">grep</CODE> on <CODE CLASS="code">/etc/</CODE> looking
	for your old IP address.
    </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="sectionsplit">
      <span class="left">I'm not finished yet</span>
      <span class="right">15 September 2002</span>
    </div>

  <TR>
    <TD>
	<P>
	You will notice that I've not completed this article.  That's because I've been waiting for the DNS to propogate.
	Then I'll remove the old IP address.  Then I will update the article.

   </TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="sectionsplit">
      <span class="left">Part 2</span>
      <span class="right">3 October 2002</span>
    </div>

  <TR>
    <TD>
	<P>
	<a href="./ip-address-change2.php">Part 2</A> of this article is now available.
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
		<TR><TD ALIGN="right"><div class="headingmoreinfo">Need more help on this topic? <A HREF="/phorum/post.php?f=1">Click here</A><BR>This article has <a href="phorum/list.php?f=3&amp;article_id=514">4 comments</a><br>Show me <a href="topics.php?aid=514">similar articles</a><br></div></TD></TR>
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

