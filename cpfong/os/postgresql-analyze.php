<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>

	<TITLE>The FreeBSD Diary -- PostgreSQL - analyzing a query to improve speed</TITLE>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" type="text/css" href="/css/site.css">

	<META NAME="description" CONTENT="PostgreSQL - analyzing a query to improve speed">
	<META NAME="keywords"    CONTENT="FreeBSD, database, PostgreSQL, analyze, analyse, explain, explain analyze, vacuum, optimize, query">

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
	<TD ALIGN="right" CLASS="sans" VALIGN="bottom">Providing practical examples since 1998<BR>Sat, 25 Oct 2003 8:43 PM PDT</TD>
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
<span class="left">PostgreSQL - analyzing a query to improve speed</span>
<span class="right">1 March 2003</span>
</div>
    </TD>
  </TR>
<TR><TD ALIGN="right"><div class="headingmoreinfo">Need more help on this topic? <A HREF="/phorum/post.php?f=1">Click here</A><BR>This article has <a href="phorum/list.php?f=3&amp;article_id=527">2 comments</a><br>Show me <a href="topics.php?aid=527">similar articles</a><br></div></TD></TR>
  <TR>
	<TD>
	<P>
	<a href="http://www.postgresql.org/">PostgreSQL</a> is the leading open source database.  Many people
	consider PostgreSQL to be a competitor to <a href="http://www.mySQL.com/">mySQL</a>.  
	People who say that don't know either product.  PostgreSQL isn't competing with mySQL; it's competing 
	with <a href="http://www.Oracle.com/">Oracle</a>.  Yes, it's being quiet about it.  But the users aren't.
	They were Oracle users and they're coming to PostgreSQL.
	
	<p>
	Of course the skeptics will ask for proof of my claims.  I don't have any.  I have anecdotal evidence.
	And third hand information.  Such as <a href="http://candle.pha.pa.us/">Bruce Momjian</a>'s recent 
	overseas trip <a href="http://archives.postgresql.org/pgsql-announce/2003-02/msg00007.php">report</a>.

	<p>
	All the <a href="http://www.google.ca/search?q=mySQL+versus+Postgresql">PostgreSQL versus mySQL</a>
	noise is moot.  What people should be concentrating on is 
	<a href="http://www.google.ca/search?q=Postgresql+versus+Oracle">PostgreSQL versus Oracle</a>
	
	<p>
	Put that in your DBMS and analyse it.
	</P>
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">What's coming up</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<P>
	Anyone who has ever written a complex query has seen that despite the best of designs, they aren't always
	fast.  Over the past day or two I've been struggling with the slowest part of 
	<a href="http://www.FreshPorts.org/">FreshPorts</a>.  I think I've come up with a relatively simple
	solution.  The trip to that solution was rather interesting.  I will reproduce it below and show you
	how it went from a query which took many seconds to a query which takes less than 0.01 seconds.
	
	<p>
	The first part of the article will cover a bit of FreshPorts introduction, the underlying database tables 
	and how they relate to each other.  Then we'll get into the queries, follow through the analyzing of the 
	query and finally the optimized result.
	
	<p>
	This article should be useful to anyone using PostgreSQL or designing databases.  It should
	also prove useful to those who wonder how database work and what it takes to make them
	run quickly. It might also provide a venue for my own education.  People reading this article
	might know a better way to do things.  Information is a two-way street.

	<p>
	You might want to read <a href="http://techdocs.postgresql.org/techdocs/pgsqldbtuning.php">PostgreSQL Database Performance Tuning</a>
	first.  It gives you a few idea about database tuning, but not much on 
	tuning a query. <a href="http://www.ca.postgresql.org/docs/momjian/hw_performance/">PostgreSQL Hardware Performance Tuning</a>
	might also interest you.
	
	<p>
	Least of all, it should show people how PostgreSQL can do this, but mySQL can't... (that's not the
	goal of the article, and I'm not going to attempt to prove it... please just accept that mySQL
	can't do this type of thing...)
	</P>
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Explain it to me...</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<p>
	I'll be making use of the PostgreSQL <a href="http://www.postgresql.org/docs/view.php?version=7.3&amp;idoc=0&amp;file=sql-explain.html">EXPLAIN</a> 
	command.  That's found in the <a href="http://www.postgresql.org/docs/view.php?version=7.3&amp;idoc=0&amp;file=reference.html">Reference Manual</a>
	of the <a href="http://www.postgresql.org/docs/view.php?version=7.3&amp;idoc=0&amp;file=index.html">PostgreSQL</a>
	online <a href="http://www.postgresql.org/docs/">documentation</a>.
	
	<p>
	If what appears below doesn't make sense, try reading the above references first.
	
	<p>
	EXPLAIN shows the show the execution plan of a statement.  You get to see what tables will be used,
	what indexes are involved, and the number of rows involved.  Execution plans make use of statistics
	generated by the VACUUM command.  If you aren't getting the results you want, try running VACUUM ANALYZE
	over the table[s] in question.
	
	<p>
	EXPLAIN ANALYZE goes one step further and actually executes the command.  This provides the actual run
	time for the various parts of the query. Be warned that EXPLAIN ANALYSE will actually delete, update, or 
	insert any data involved in the query.  Read the documentation for details.
	
	<p>
	Here are a few things to look for when reading the output of EXPLAIN:
	<ul>
	<li>Look for high costs
	<li>look for sequential scans
	<li>look for large numbers of rows
	<li>look for index scans 
	</ul>
	
	High costs are an indication of something which takes a lot of set up. Sequential scans indicate a scan
	of the entire table.  Perhaps an index is required.  Large numbers of rows might indicate a place where
	you can cut down the result set earlier in the query.  Index scans are usually a good thing as they tend
	to speed up the query (in most instances).
	
	<p>
	Items to note
	
	<ul>
	<li>For small tables, an index costs more than it is worth in many queries.  Indexes are only really
	useful for larger data sets.  Don't be upset if the query runs quickly but doesn't use an index.
	
	<li>If you think the index should be used, but it isn't being touched, try a VACUUM ANALYZE on that table.
	Then test the query again.
	</ul>
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">FreshPorts - what is it?</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<P>
	FreshPorts (and its sister <a href="http://www.FreshSource.org/">FreshSource</a> capture
	and store the commits to a source repository.  It can work with any source repository
	but at present it is restricted to the <a href="http://www.FreeBSD.org/">FreeBSD</a>
	source tree.  FreshPorts concentrates on the 
	<a href="http://www.freebsd.org/cgi/cvsweb.cgi/ports/">Ports</a> subtree, while FreshSource
	captures and records the <a href="http://www.freebsd.org/cgi/cvsweb.cgi/">entire tree</a>.
	
	<p>
	By its nature, FreshPorts is the more complex of the two sites.  It was also the first.
	Users create <i>watch lists</i> of whatever ports they wish to keep up to date with.  When a commit
	occurs against those ports, the user is sent an email notification.  Users can also
	view all commits recorded against a given port.  When a port can consist of several dozen files,
	this information is very useful when tracking updates.
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">FreshPorts - the tables and sample data</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<P>
	The most important FreshPorts table is the <CODE CLASS="code">commit_log</code> table.
	
<blockquote><code class="code">
create table commit_log<br>
(<br>
&nbsp;&nbsp;&nbsp;&nbsp;id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; serial&nbsp;&nbsp;&nbsp;&nbsp;not null,<br>
&nbsp;&nbsp;&nbsp;&nbsp;commit_date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;timestamp not null,<br>
&nbsp;&nbsp;&nbsp;&nbsp;committer&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;text&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;not null,<br>
&nbsp;&nbsp;&nbsp;&nbsp;primary key (id)<br>
);<br>
<br>
create index commit_log_commit_date on commit_log (commit_date);
</code></blockquote>

	The actual table contains more columns but the above is sufficient for demonstration purposes.
	
	<p>
	Each new commit against the FreeBSD source repository is loaded into this table.  FreshPorts is only 
	interested in commits against the ports subtree.  However,	FreshSource and FreshPorts use the same database.
	A second table is used to indicate commits against particular ports:

<blockquote><code class="code">
create table commit_log_ports<br>
(<br>
&nbsp;&nbsp;&nbsp;&nbsp;commit_log_id&nbsp;&nbsp;integer&nbsp;&nbsp;&nbsp;&nbsp; not null,<br>
&nbsp;&nbsp;&nbsp;&nbsp;port_id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;integer&nbsp;&nbsp;&nbsp;&nbsp; not null,<br>
&nbsp;&nbsp;&nbsp;&nbsp;primary key (commit_log_id, port_id)<br>
);<br>
<br>
alter table commit_log_ports<br>
&nbsp;&nbsp;&nbsp;&nbsp;add foreign key (commit_log_id)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; references commit_log (id) on update cascade on delete cascade;<br>
<br>
alter table commit_log_ports<br>
&nbsp;&nbsp;&nbsp;&nbsp;add foreign key (port_id)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; references ports (id) on update cascade on delete cascade;<br>
</code></blockquote>

<p>
I will only mention the Ports table so that you know it exists and is referred to by many other tables.
The main problem at hand concerns the <code class="code">commit_log</code> and 
<code class="code">commit_log_ports</code> table.

<p>
You can download the sample <a href="/samples/postgresql-analyze.tgz">tables and data</a> (859KB) used in this 
article should you wish to play with the results.  Please note that I have only supplied the columns necessary
to perform the queries indicated below.  As such, your results will vary. NOTE: the examples were run on 
version 7.3.

<p>
The tarball contains a .sql file which can be loaded into 
your database with the following command:

<blockquote><code class="code">
createdb test<br>
psql test < postgresql-analyze.sql
</code></blockquote>

Feedback is appreciated.  
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">So what's the problem?</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<p>
	FreshPorts, by default, displays the last 100 commits.  If you didn't think about it, you'd think this
	was the answer:

<blockquote><code class="code">
EXPLAIN ANALYZE<br>
&nbsp; SELECT *<br>
&nbsp;&nbsp;&nbsp; FROM commit_log<br>
ORDER BY commit_date<br>
&nbsp;&nbsp;&nbsp;LIMIT <b>100</b>;<br>
<br>
 <b>Limit</b>&nbsp;&nbsp;(cost=0.00..48.12 rows=100 width=252) (actual time=0.06..2.40 rows=<b>100</b> loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using commit_log_commit_date on commit_log&nbsp;&nbsp;(cost=0.00..32975.88 rows=<b>68533</b> width=252) (actual time=0.05..1.59 rows=101 loops=1)<br>
 Total runtime: <b>2.98</b> msec<br>
(3 rows)
</code></blockquote>
	<p>
	As you can see, it's rather fast to get the last 100 commits.  Just under <b>3ms</b>. That's 0.003 seconds.
	That's damn fast in my book.  Mind you, there's only <b>68533</b> rows in that table.
	
	<p>
	Note that the <b>(3 rows)</b> refers to the EXPLAIN ANALYSE output, not the number of rows in the
	result set.  Compare that to the <b>100</b> which appears in the <b>Limit</b> line in the output.
	
	<p>
	Unfortunately, that's the last 100 commits.  Not the last 100 commits against the ports subtree.
	For that, we have to use the <code class="code">commit_log_ports</code> table.

<blockquote><code class="code">
EXPLAIN ANALYZE<br>
&nbsp; SELECT distinct commit_log.id, commit_log.commit_date<br>
&nbsp;&nbsp;&nbsp; FROM commit_log, commit_log_ports<br>
&nbsp;&nbsp;&nbsp;WHERE commit_log.id = commit_log_ports.commit_log_id<br>
ORDER BY commit_log.commit_date<br>
&nbsp;&nbsp;&nbsp;LIMIT 100;<br>
<br>
 Limit&nbsp;&nbsp;(cost=13456.18..13463.68 rows=100 width=16) (actual time=4190.89..4193.10 rows=100 loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Unique&nbsp;&nbsp;(cost=13456.18..13938.43 rows=6430 width=16) (actual time=4190.88..4192.31 rows=101 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=13456.18..13616.93 rows=64300 width=16) (actual time=4190.87..4191.39 rows=113 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: commit_log.commit_date, commit_log.id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash Join&nbsp;&nbsp;(cost=4103.81..7662.06 rows=64300 width=16) (actual time=1065.79..3150.16 rows=64300 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Hash Cond: ("outer".commit_log_id = "inner".id)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on commit_log_ports&nbsp;&nbsp;(cost=0.00..1048.00 rows=64300 width=4) (actual time=0.11..434.34 rows=64300 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash&nbsp;&nbsp;(cost=3032.33..3032.33 rows=68533 width=12) (actual time=1065.08..1065.08 rows=0 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on commit_log&nbsp;&nbsp;(cost=0.00..3032.33 rows=68533 width=12) (actual time=0.10..645.86 rows=68544 loops=1)<br>
 Total runtime: 4195.82 msec<br>
(10 rows)<br>
</code></blockquote>

	<p>
	OUCH!  That's terrible.  That's four seconds!  Why did it take so long?
	
	<p>
	The query is returning all rows in the two tables, then selecting only the first one hundred rows.
	That's quite inefficient, but it's not what we want to do.  We can make things faster.
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Don't search everything; provide a starting point</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<p>
	In this example, we're going to provide a starting place for the query.  We aren't going
	to do the JOIN on the whole table. We are going to limit it to the most recent commits.
	Let's assume that in a given week, there are at least 100 commits against the ports tree.
	We will do this by adding the following condition to the WHERE clause:
	
<blockquote><code class="code">
commit_log.commit_date > now() - interval '1 week'
</code></blockquote>

	The new query is:
	
<blockquote><code class="code">
EXPLAIN ANALYZE<br>
&nbsp; SELECT distinct commit_log.id, commit_log.commit_date<br>
&nbsp;&nbsp;&nbsp; FROM commit_log, commit_log_ports<br>
&nbsp;&nbsp;&nbsp;WHERE commit_log.id = commit_log_ports.commit_log_id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AND commit_log.commit_date > now() - interval '1 week'<br>
ORDER BY commit_log.commit_date<br>
&nbsp;&nbsp;&nbsp;LIMIT 100;<br>
<br>
 Limit&nbsp;&nbsp;(cost=7425.72..7433.22 rows=100 width=16) (actual time=1238.13..1238.62 rows=21 loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Unique&nbsp;&nbsp;(cost=7425.72..7586.47 rows=2143 width=16) (actual time=1238.12..1238.44 rows=21 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=7425.72..7479.31 rows=21433 width=16) (actual time=1238.11..1238.22 rows=28 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: commit_log.commit_date, commit_log.id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash Join&nbsp;&nbsp;(cost=3603.44..5883.85 rows=21433 width=16) (actual time=1175.11..1237.71 rows=28 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Hash Cond: ("outer".commit_log_id = "inner".id)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on commit_log_ports&nbsp;&nbsp;(cost=0.00..1048.00 rows=64300 width=4) (actual time=0.10..420.66 rows=64300 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash&nbsp;&nbsp;(cost=3546.33..3546.33 rows=22844 width=12) (actual time=419.03..419.03 rows=0 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on commit_log&nbsp;&nbsp;(cost=0.00..3546.33 rows=22844 width=12) (actual time=0.19..418.47 rows=57 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Filter: (commit_date > (now() - '7 days'::interval))<br>
 Total runtime: 1238.96 msec<br>
(11 rows)
</code></blockquote>

	<p>
	Now the query takes only just over 1 second.  That's not bad.  But we can do better.
	Let's now assume we know how far back in time the 100th previous port commit was.
	It was on 18 February 2003, at 16:02:15.

<blockquote><code class="code">
EXPLAIN ANALYZE<br>
&nbsp; SELECT distinct commit_log.id, commit_log.commit_date<br>
&nbsp;&nbsp;&nbsp; FROM commit_log, commit_log_ports<br>
&nbsp;&nbsp;&nbsp;WHERE commit_log.id = commit_log_ports.commit_log_id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AND commit_log.commit_date > '2003-02-18 16:02:15.133047-05'<br>
ORDER BY commit_log.commit_date<br>
&nbsp;&nbsp;&nbsp;LIMIT 100;<br>
<br>
 Limit&nbsp;&nbsp;(cost=1562.07..1563.65 rows=21 width=16) (actual time=737.54..739.94 rows=100 loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Unique&nbsp;&nbsp;(cost=1562.07..1563.71 rows=22 width=16) (actual time=737.52..739.15 rows=101 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=1562.07..1562.62 rows=219 width=16) (actual time=737.52..738.09 rows=145 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: commit_log.commit_date, commit_log.id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash Join&nbsp;&nbsp;(cost=181.33..1553.56 rows=219 width=16) (actual time=507.25..736.43 rows=146 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Hash Cond: ("outer".commit_log_id = "inner".id)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on commit_log_ports&nbsp;&nbsp;(cost=0.00..1048.00 rows=64300 width=4) (actual time=0.10..419.82 rows=64300 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash&nbsp;&nbsp;(cost=180.74..180.74 rows=233 width=12) (actual time=5.68..5.68 rows=0 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using commit_log_commit_date on commit_log&nbsp;&nbsp;(cost=0.00..180.74 rows=233 width=12) (actual time=0.34..4.51 rows=215 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>Index Cond</b>: (commit_date > '2003-02-18 16:02:15.133047-05'::timestamp with time zone)<br>
 Total runtime: 740.66 msec<br>
(11 rows)
</code></blockquote>

	Why is this faster?  The key is in the explain output.  In the previous example, it was merely
	filtering.  But in this example, we are giving it a hard-and-fast starting point, as demonstrated
	by the <b>Index Cond:</b> output.  Essentially, we are providing a date, instead of a function call.
	This allows the query to be much faster and finding what is needed.
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">We <i>can</i> go faster</div>
    </TD>
  </TR>

  <TR>
	<TD>
	This isn't fast enough.  What if I know what the last 100 port commits are and I have them in a table?
	A table like this:
	
<blockquote><code class="code">
create table clp<br>
(<br>
&nbsp;&nbsp;&nbsp;&nbsp;commit_log_id&nbsp;&nbsp;integer&nbsp;&nbsp;&nbsp; not null,<br>
&nbsp;&nbsp;&nbsp;&nbsp;commit_date&nbsp;&nbsp;&nbsp;&nbsp;timestamp&nbsp; not null,<br>
&nbsp;&nbsp;&nbsp;&nbsp;primary key (commit_log_id)<br>
);<br>
<br>
alter table clp<br>
&nbsp;&nbsp;&nbsp;&nbsp;add foreign key (commit_log_id)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; references commit_log (id) on update cascade on delete cascade;
</code></blockquote>

	<p>
	Note that this table is not included in the example tarball.
	
	<p>
	The table is named <code class="code">clp</code> after the <code class="code">commit_log_ports</code>
	table.

	<p>
	We can populate the table with this query:
	
<blockquote><code class="code">
EXPLAIN ANALYZE<br>
INSERT INTO clp<br>
SELECT DISTINCT commit_log_id, commit_date<br>
&nbsp; FROM commit_log, commit_log_ports<br>
&nbsp;WHERE commit_log.id = commit_log_ports.commit_log_id<br>
&nbsp;ORDER BY commit_log.commit_date desc<br>
&nbsp;LIMIT 100;<br>
<br>
 Subquery Scan "*SELECT*"&nbsp;&nbsp;(cost=13456.18..13463.68 rows=100 width=16) (actual time=4165.77..4169.47 rows=100 loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Limit&nbsp;&nbsp;(cost=13456.18..13463.68 rows=100 width=16) (actual time=4165.75..4168.39 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Unique&nbsp;&nbsp;(cost=13456.18..13938.43 rows=6430 width=16) (actual time=4165.74..4167.59 rows=101 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=13456.18..13616.93 rows=64300 width=16) (actual time=4165.73..4166.48 rows=145 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: commit_log.commit_date, commit_log_ports.commit_log_id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash Join&nbsp;&nbsp;(cost=4103.81..7662.06 rows=64300 width=16) (actual time=1066.31..3157.63 rows=64300 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Hash Cond: ("outer".commit_log_id = "inner".id)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on commit_log_ports&nbsp;&nbsp;(cost=0.00..1048.00 rows=64300 width=4) (actual time=0.11..430.26 rows=64300 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash&nbsp;&nbsp;(cost=3032.33..3032.33 rows=68533 width=12) (actual time=1065.58..1065.58 rows=0 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on commit_log&nbsp;&nbsp;(cost=0.00..3032.33 rows=68533 width=12) (actual time=0.10..647.40 rows=68544 loops=1)<br>
 Total runtime: 4176.07 msec<br>
(11 rows)</code></blockquote>

	Of course, the cost to insert into this table is relatively high, because of the previously 
	mentioned examples and reasons.  The ultimate goal is to maintain this table as we go along.
	I'll explain that in a subsequent section.  For now, let's just try out this table and 
	see how things go.
	
	<p>
	We will assume that new entries are added to this table all the time.  If we query using this table:

<blockquote><code class="code">
EXPLAIN ANALYZE<br>
SELECT DISTINCT clp.commit_log_id, clp.commit_date<br>
&nbsp;&nbsp;&nbsp;FROM commit_log, commit_log_ports, clp<br>
&nbsp; WHERE commit_log.id&nbsp;&nbsp;&nbsp;&nbsp; = commit_log_ports.commit_log_id<br>
&nbsp;&nbsp;&nbsp; AND clp.commit_log_id = commit_log.id<br>
&nbsp; ORDER BY clp.commit_date desc<br>
&nbsp; LIMIT 100;<br>
<br>
 Limit&nbsp;&nbsp;(cost=5703.16..5710.66 rows=100 width=20) (actual time=<b>731.50</b>..733.90 rows=100 loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Unique&nbsp;&nbsp;(cost=5703.16..5772.32 rows=922 width=20) (actual time=731.49..733.11 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=5703.16..5726.22 rows=9221 width=20) (actual time=731.48..732.05 rows=144 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: clp.commit_date, clp.commit_log_id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash Join&nbsp;&nbsp;(cost=3714.68..5095.91 rows=9221 width=20) (actual time=503.23..730.43 rows=144 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Hash Cond: ("outer".commit_log_id = "inner".id)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on commit_log_ports&nbsp;&nbsp;(cost=0.00..1048.00 rows=64300 width=4) (actual time=0.09..417.49 rows=64300 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash&nbsp;&nbsp;(cost=3712.18..3712.18 rows=1000 width=16) (actual time=7.03..7.03 rows=0 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Nested Loop&nbsp;&nbsp;(cost=0.00..3712.18 rows=1000 width=16) (actual time=0.42..6.41 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on clp&nbsp;&nbsp;(cost=0.00..20.00 rows=1000 width=12) (actual time=0.10..0.82 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using commit_log_pkey on commit_log&nbsp;&nbsp;(cost=0.00..3.68 rows=1 width=4) (actual time=0.03..0.04 rows=1 loops=100)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Index Cond: ("outer".commit_log_id = commit_log.id)<br>
 Total runtime: 734.72 msec<br>
(13 rows)
</code></blockquote>

<p>
Note also that to get the above time, you will have to do a VACUUM ANALYZE on 
the <code class="code">clp</code> table so that the query engine will have
data regarding that table.

<p>
Look at where all the time is used up on this query, it's in the LIMIT.
That time represents almost the entire query. But we can use the same idea
but structure the query in a different way so as to increase performance.

<blockquote><code class="code">
EXPLAIN ANALYZE<br>
SELECT DISTINCT clp.commit_log_id, clp.commit_date<br>
&nbsp;&nbsp;&nbsp;FROM clp, commit_log, commit_log_ports<br>
&nbsp; WHERE clp.commit_log_id = commit_log.id<br>
&nbsp;&nbsp;&nbsp; AND commit_log.id&nbsp;&nbsp;&nbsp;&nbsp; = commit_log_ports.commit_log_id<br>
&nbsp; ORDER BY clp.commit_date desc<br>
&nbsp; LIMIT 100;<br>
<br>
 Limit&nbsp;&nbsp;(cost=6538.88..6545.86 rows=93 width=20) (actual time=934.51..936.90 rows=100 loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Unique&nbsp;&nbsp;(cost=6538.88..6545.92 rows=94 width=20) (actual time=934.50..936.10 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=6538.88..6541.23 rows=938 width=20) (actual time=934.49..935.06 rows=144 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: clp.commit_date, clp.commit_log_id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Merge Join&nbsp;&nbsp;(cost=0.00..6492.57 rows=938 width=20) (actual time=922.63..933.37 rows=144 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Merge Cond: ("outer".commit_log_id = "inner".commit_log_id)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Nested Loop&nbsp;&nbsp;(cost=0.00..3744.18 rows=1000 width=16) (actual time=0.50..6.95 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using clp_pkey on clp&nbsp;&nbsp;(cost=0.00..52.00 rows=1000 width=12) (actual time=0.31..1.21 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using commit_log_pkey on commit_log&nbsp;&nbsp;(cost=0.00..3.68 rows=1 width=4) (actual time=0.03..0.04 rows=1 loops=100)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Index Cond: ("outer".commit_log_id = commit_log.id)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using clp_cli on commit_log_ports&nbsp;&nbsp;(cost=0.00..2469.87 rows=64300 width=4) (actual time=0.31..599.70 rows=64300 loops=1)<br>
 Total runtime: 937.68 msec<br>
(12 rows)
</code></blockquote>

Well, that's not quite what i wanted to do.  But it does demonstrate a useful point.
If you rearrange the table names in the FROM clause, it can affect performance.

<p>
Now it's time to apply our old trick of providing a starting point. We will
restrict the commits to those after a certain time:

<blockquote><code class="code">
EXPLAIN ANALYZE<br>
SELECT DISTINCT clp.commit_log_id, clp.commit_date<br>
&nbsp;&nbsp;&nbsp;FROM clp, commit_log, commit_log_ports<br>
&nbsp; WHERE commit_log.id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;= commit_log_ports.commit_log_id<br>
&nbsp;&nbsp;&nbsp; AND clp.commit_log_id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;= commit_log.id<br>
&nbsp;&nbsp;&nbsp; AND commit_log.commit_date > '2003-02-18 16:02:15.133047-05'<br>
&nbsp; ORDER BY clp.commit_date desc<br>
&nbsp; LIMIT 100;<br>
<br>
 Limit&nbsp;&nbsp;(cost=299.65..299.67 rows=1 width=20) (actual time=13.27..15.66 rows=100 loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Unique&nbsp;&nbsp;(cost=299.65..299.67 rows=1 width=20) (actual time=13.26..14.87 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=299.65..299.66 rows=3 width=20) (actual time=13.25..13.81 rows=144 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: clp.commit_date, clp.commit_log_id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Nested Loop&nbsp;&nbsp;(cost=169.43..299.63 rows=3 width=20) (actual time=4.87..12.33 rows=144 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash Join&nbsp;&nbsp;(cost=169.43..194.47 rows=3 width=16) (actual time=4.64..6.69 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Hash Cond: ("outer".commit_log_id = "inner".id)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on clp&nbsp;&nbsp;(cost=0.00..20.00 rows=1000 width=12) (actual time=0.02..0.77 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash&nbsp;&nbsp;(cost=168.97..168.97 rows=186 width=4) (actual time=4.52..4.52 rows=0 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using commit_log_commit_date on commit_log&nbsp;&nbsp;(cost=0.00..168.97 rows=186 width=4) (actual time=0.45..3.37 rows=215 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Index Cond: (commit_date > '2003-02-18 16:02:15.133047-05'::timestamp with time zone)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using clp_cli on commit_log_ports&nbsp;&nbsp;(cost=0.00..38.58 rows=9 width=4) (actual time=0.02..0.03 rows=1 loops=100)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Index Cond: ("outer".commit_log_id = commit_log_ports.commit_log_id)<br>
 Total runtime: 16.44 msec<br>
(14 rows)
</code></blockquote>

Now that's fast.&nbsp;&nbsp;Very fast.  In fact, it's more than 57 times faster.


	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Another approach</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<P>
	We now have a very fast query which will return the last 100 commits to the ports tree.
	Let's now figure out how to get the list of ports associated with those commits.

<blockquote><code class="code">
EXPLAIN ANALYZE<br>
&nbsp;SELECT clp.commit_log_id, clp.commit_date, ports.name<br>
&nbsp;&nbsp; FROM clp, commit_log, commit_log_ports, ports<br>
&nbsp; WHERE commit_log.id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;= commit_log_ports.commit_log_id<br>
&nbsp;&nbsp;&nbsp; AND clp.commit_log_id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;= commit_log.id<br>
&nbsp;&nbsp;&nbsp; AND commit_log.commit_date&nbsp;&nbsp; > '2003-02-18 16:02:15.133047-05'<br>
&nbsp;&nbsp;&nbsp; AND commit_log_ports.port_id = ports.id<br>
&nbsp; ORDER BY clp.commit_date desc<br>
&nbsp; LIMIT 100;<br>
<br>
 Limit&nbsp;&nbsp;(cost=314.99..314.99 rows=2 width=78) (actual time=389.48..390.66 rows=<b>100</b> loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=314.99..314.99 rows=3 width=78) (actual time=389.46..389.86 rows=101 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: clp.commit_date<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Nested Loop&nbsp;&nbsp;(cost=169.43..314.97 rows=3 width=78) (actual time=40.67..387.90 rows=144 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Nested Loop&nbsp;&nbsp;(cost=169.43..299.63 rows=3 width=24) (actual time=16.52..24.91 rows=144 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash Join&nbsp;&nbsp;(cost=169.43..194.47 rows=3 width=16) (actual time=16.15..18.40 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Hash Cond: ("outer".commit_log_id = "inner".id)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on clp&nbsp;&nbsp;(cost=0.00..20.00 rows=1000 width=12) (actual time=10.55..11.38 rows=100 loops=1)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Hash&nbsp;&nbsp;(cost=168.97..168.97 rows=186 width=4) (actual time=5.48..5.48 rows=0 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using commit_log_commit_date on commit_log&nbsp;&nbsp;(cost=0.00..168.97 rows=186 width=4) (actual time=0.34..4.32 rows=215 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Index Cond: (commit_date > '2003-02-18 16:02:15.133047-05'::timestamp with time zone)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using clp_cli on commit_log_ports&nbsp;&nbsp;(cost=0.00..38.58 rows=9 width=8) (actual time=0.03..0.04 rows=1 loops=100)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Index Cond: ("outer".commit_log_id = commit_log_ports.commit_log_id)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using ports_pkey on ports&nbsp;&nbsp;(cost=0.00..6.00 rows=1 width=54) (actual time=2.49..2.50 rows=1 loops=144)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Index Cond: ("outer".port_id = ports.id)<br>
 Total runtime: 391.55 msec<br>
(16 rows)
</code></blockquote>

That query only returned one hundred rows.... Oh yes, we need a subselect here, we want to limit
the result set to 100 commits, not 100 ports.  This is the query we will use as a starting point:

<blockquote><code class="code">
&nbsp;EXPLAIN ANALYZE<br>
&nbsp; SELECT clp.commit_log_id<br>
&nbsp;&nbsp;&nbsp; FROM clp<br>
ORDER BY clp.commit_date DESC<br>
&nbsp; LIMIT 100;<br>
<br>
 Limit&nbsp;&nbsp;(cost=69.83..70.08 rows=100 width=12) (actual time=1.30..2.48 rows=100 loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=69.83..72.33 rows=1000 width=12) (actual time=1.29..1.69 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: commit_date<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on clp&nbsp;&nbsp;(cost=0.00..20.00 rows=1000 width=12) (actual time=0.02..0.68 rows=100 loops=1)<br>
 Total runtime: 3.02 msec<br>
(5 rows)
</code></blockquote>

With that, let's join it up with the <code class="code">commit_log</code> table:

<blockquote><code class="code">
EXPLAIN ANALYZE<br>
SELECT commit_log.id<br>
&nbsp;&nbsp;FROM commit_log JOIN<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (SELECT clp.commit_log_id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FROM clp<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ORDER BY clp.commit_date DESC<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; LIMIT 100) AS TMP<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ON commit_log.id = TMP.commit_log_id;<br>
<br>
 Nested Loop&nbsp;&nbsp;(cost=69.83..439.30 rows=100 width=8) (actual time=1.76..9.11 rows=100 loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Subquery Scan tmp&nbsp;&nbsp;(cost=69.83..70.08 rows=100 width=12) (actual time=1.38..3.50 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Limit&nbsp;&nbsp;(cost=69.83..70.08 rows=100 width=12) (actual time=1.37..2.59 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=69.83..72.33 rows=1000 width=12) (actual time=1.36..1.79 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: commit_date<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on clp&nbsp;&nbsp;(cost=0.00..20.00 rows=1000 width=12) (actual time=0.02..0.68 rows=100 loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using commit_log_pkey on commit_log&nbsp;&nbsp;(cost=0.00..3.68 rows=1 width=4) (actual time=0.03..0.04 rows=1 loops=100)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Index Cond: (commit_log.id = "outer".commit_log_id)<br>
 Total runtime: 9.69 msec<br>
(9 rows)
</code></blockquote>

	As you can see, that's still pretty fast, and still only 100 records.  Now we have the rows from
	<code class="code">commit_log</code> which relate to the last 100 commits to the ports tree.
	Let's get the ports touched by those commits.

<blockquote><code class="code">
EXPLAIN ANALYZE<br>
SELECT commit_log.id<br>
&nbsp; FROM commit_log JOIN<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (SELECT clp.commit_log_id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FROM clp<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ORDER BY clp.commit_date DESC<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; LIMIT 100) AS TMP<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ON commit_log.id = TMP.commit_log_id, commit_log_ports<br>
WHERE commit_log_ports.commit_log_id = commit_log.id;<br>
<br>
 Hash Join&nbsp;&nbsp;(cost=439.55..1810.22 rows=94 width=12) (actual time=504.90..731.12 rows=144 loops=1)<br>
&nbsp;&nbsp; Hash Cond: ("outer".commit_log_id = "inner".id)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on commit_log_ports&nbsp;&nbsp;(cost=0.00..1048.00 rows=64300 width=4) (actual time=0.09..416.59 <b>rows=64300</b> loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Hash&nbsp;&nbsp;(cost=439.30..439.30 rows=100 width=8) (actual time=9.64..9.64 rows=0 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Nested Loop&nbsp;&nbsp;(cost=69.83..439.30 rows=100 width=8) (actual time=1.84..9.09 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Subquery Scan tmp&nbsp;&nbsp;(cost=69.83..70.08 rows=100 width=12) (actual time=1.44..3.56 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Limit&nbsp;&nbsp;(cost=69.83..70.08 rows=100 width=12) (actual time=1.43..2.63 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=69.83..72.33 rows=1000 width=12) (actual time=1.42..1.82 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: commit_date<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on clp&nbsp;&nbsp;(cost=0.00..20.00 rows=1000 width=12) (actual time=0.09..0.73 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using commit_log_pkey on commit_log&nbsp;&nbsp;(cost=0.00..3.68 rows=1 width=4) (actual time=0.03..0.04 rows=1 loops=100)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Index Cond: (commit_log.id = "outer".commit_log_id)<br>
 Total runtime: 731.93 msec<br>
(13 rows)
</code></blockquote>

	Wow!  That is 75 times slower than before!  Surely we can do better!  I think the clue is the 
	<code class="code"><b>rows=64300</b></code> entry.  Let's try reducing that.  In this particular
	case, I know we're only looking at values within the <code class="code">clp</code> table.
	So let's create this function:
	
<blockquote><code class="code">
<a name="function">CREATE OR REPLACE FUNCTION Anchor_CLID() RETURNS integer</a><br>
AS '<br>
&nbsp;&nbsp; SELECT min(commit_log_id) AS RESULT<br>
&nbsp;&nbsp;&nbsp;&nbsp; FROM clp;<br><br>
' LANGUAGE SQL IMMUTABLE;
</code></blockquote>

	<P>See also how to make the above <a href="#faster">faster</a>.

	<p>
	Note that the above is for version 7.3 which first introduced the IMMUTABLE designation.
	This function obtains the minimum <code class="class">commit_log_id</code> value
	from the <code class="class">clp</code> table.  Let's use that in our query:
	
<blockquote><code class="code">
EXPLAIN ANALYZE<br>
SELECT commit_log_id, port_id FROM<br>
&nbsp;&nbsp;&nbsp; (SELECT commit_log.id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; FROM commit_log JOIN<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (SELECT clp.commit_log_id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FROM clp<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ORDER BY clp.commit_date DESC<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; LIMIT 100) AS TMP<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ON commit_log.id = TMP.commit_log_id) AS TMP2 JOIN commit_log_ports<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ON commit_log_ports.commit_log_id = TMP2.id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AND commit_log_ports.commit_log_id > Anchor_CLID();<br>
<br>
 Merge Join&nbsp;&nbsp;(cost=442.62..594.26 rows=1 width=16) (actual time=8.52..12.97 rows=141 loops=1)<br>
&nbsp;&nbsp; Merge Cond: ("outer".id = "inner".commit_log_id)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=442.62..442.87 rows=100 width=8) (actual time=8.44..8.86 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: commit_log.id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Nested Loop&nbsp;&nbsp;(cost=69.83..439.30 rows=100 width=8) (actual time=1.39..7.81 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Subquery Scan tmp&nbsp;&nbsp;(cost=69.83..70.08 rows=100 width=12) (actual time=1.32..3.41 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Limit&nbsp;&nbsp;(cost=69.83..70.08 rows=100 width=12) (actual time=1.31..2.51 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=69.83..72.33 rows=1000 width=12) (actual time=1.30..1.71 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: commit_date<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on clp&nbsp;&nbsp;(cost=0.00..20.00 rows=1000 width=12) (actual time=0.01..0.71 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using commit_log_pkey on commit_log&nbsp;&nbsp;(cost=0.00..3.68 rows=1 width=4) (actual time=0.02..0.02 rows=1 loops=100)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Index Cond: (commit_log.id = "outer".commit_log_id)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan using clp_cli on commit_log_ports&nbsp;&nbsp;(cost=0.00..149.91 rows=39 width=8) (actual time=0.03..1.35 rows=141 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Index Cond: (commit_log_id > 69061)<br>
 Total runtime: 13.81 msec<br>
(15 rows)
</code></blockquote>

	I'd say that's fast enough for my needs. The key to this function is the <code class="code">IMMUTABLE</code>
	designation.  This indicates that the function returns the same value for a given set of parameters.  This
	allow the query planner to make certain optimizations that it could not otherwise do.  With this
	designation, the query planner considers the function return value to be a constant, and therefore it
	can make use of the indexes available.
	Please refer to the <code class="class">CREATE FUNCTION</code> documentation for more information.
	
	<p>
	In fact, my function isn't really IMMUTABLE.  It's actually STABLE.  If I change the function to stable, 
	the time goes up to nearly 19 seconds.  If I add a < condition to the range, the time drops to just under
	one second, but it never gets near to the speed of the IMMUTABLE function.  Please read the CREATE FUNCTION
	documentation and pick the designation which best suits your particular application.
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">More about that clp table</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<p>
	For my specific needs, I'll be doing some more work on the <code class="class">clp</code> table
	in order to maintain it as things go along.  That may turn out to be the subject of a future article.
	
	<p>
	For now, the starting point is a couple of rules which will maintain the data:
	
	
<blockquote><code class="code">
CREATE OR REPLACE RULE commit_log_ports_insert AS<br>
&nbsp;&nbsp; ON INSERT TO commit_log_ports DO<br>
&nbsp;&nbsp; INSERT INTO clp<br>
&nbsp;&nbsp; SELECT new.commit_log_id,<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(SELECT commit_date<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FROM commit_log<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WHERE id = new.commit_log_id)<br>
&nbsp;&nbsp; WHERE NOT EXISTS<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(SELECT commit_log_id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; FROM clp<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WHERE commit_log_id = new.commit_log_id);<br>
<br>
CREATE OR REPLACE RULE commit_log_update AS<br>
&nbsp;&nbsp; ON UPDATE TO commit_log DO<br>
&nbsp;&nbsp; UPDATE clp <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SET commit_date&nbsp;&nbsp; = new.commit_date<br>
&nbsp;&nbsp;&nbsp;&nbsp;WHERE commit_log_id = new.id;
</code></blockquote>

	<p>
	The first rule will keep populating the <code class="class">clp</code> table as new ports tree commits are 
	added.  It can handle multiple ports per commit by only inserting that which does not already exist.
	The second rule will keep the <code class="class">commit_date</code> accurate should any updates
	occur.
	
	<p>
	What about deletes?  That's taken care of in the foreign key defintion of the table.  Any deletes on the
	primary table will delete the corresponding row from this table.
	
	<p>
	Here's a query which will retain the latest 100 entries:

<blockquote><code class="code">
DELETE FROM clp<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WHERE commit_log_id NOT in (<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SELECT commit_log_id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FROM clp<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ORDER BY commit_date<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; LIMIT 100);<br>
<br>
 Seq Scan on clp&nbsp;&nbsp;(cost=0.00..570.12 rows=50 width=6) (actual time=9.81..399.59 rows=400 loops=1)<br>
&nbsp;&nbsp; Filter: (subplan)<br>
&nbsp;&nbsp; SubPlan<br>
&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Materialize&nbsp;&nbsp;(cost=5.62..5.62 rows=100 width=12) (actual time=0.02..0.38 rows=90 loops=500)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Limit&nbsp;&nbsp;(cost=5.37..5.62 rows=100 width=12) (actual time=6.73..7.99 rows=100 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=5.37..5.62 rows=101 width=12) (actual time=6.72..7.14 rows=101 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: commit_date<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on clp&nbsp;&nbsp;(cost=0.00..2.01 rows=101 width=12) (actual time=0.21..3.87 rows=500 loops=1)<br>
 Total runtime: 410.57 msec
(9 rows)
</code></blockquote>

	<p>
	But as you can see, it takes quite some time.  Luckily, with some help from the 
	<a href="http://archives.postgresql.org/pgsql-sql/2003-02/msg00616.php">PostgreSQL SQL mailing list</a>, I was 
	able to find a better way:

<blockquote><code class="code">
EXPLAIN ANALYZE<br>
DELETE FROM clp<br>
WHERE commit_date < (SELECT commit_date<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; FROM clp<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ORDER BY commit_date DESC<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; OFFSET 99<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIMIT 1);<br>
<br>
 Seq Scan on clp&nbsp;&nbsp;(cost=0.00..2.26 rows=34 width=6) (actual time=7.98..11.42 rows=400 loops=1)<br>
&nbsp;&nbsp; Filter: (commit_date < $0)<br>
&nbsp;&nbsp; InitPlan<br>
&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Limit&nbsp;&nbsp;(cost=5.62..5.62 rows=1 width=8) (actual time=7.29..7.31 rows=1 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Sort&nbsp;&nbsp;(cost=5.37..5.62 rows=101 width=8) (actual time=6.49..6.90 rows=101 loops=1)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sort Key: commit_date<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on clp&nbsp;&nbsp;(cost=0.00..2.01 rows=101 width=8) (actual time=0.21..3.73 rows=500 loops=1)<br>
 Total runtime: 15.36 msec
</code></blockquote>

	That's nearly 27 times faster than my original.  Thanks folks.

	<p>
	This could be run from a perl script started by a cron job.  It's not a critical task,
	but it does keep things tidy.  I'd also VACUUM FULL ANALYSE that table at least once a week if not daily.

	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="sectionsplit">
      <span class="left"><A NAME="faster">Making that function even faster</A></span>
      <span class="right">3 March 2002</span></div>
    </div>

  <TR>
	<TD>
	<p>
	Robert Treat just reminded me of way to make that <a href="#function">function</a>
	run faster.  It uses an old trick I had forgotten about.  The original query was:

<blockquote><code class="code">
&nbsp;&nbsp; SELECT min(commit_log_id) AS RESULT<br>
&nbsp;&nbsp;&nbsp;&nbsp; FROM clp;<br><br>
 Aggregate&nbsp;&nbsp;(cost=9.25..9.25 rows=1 width=4) (actual time=5.22..5.23 rows=1 loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Seq Scan on clp&nbsp;&nbsp;(cost=0.00..8.00 rows=500 width=4) (actual time=0.02..3.02 rows=500 loops=1)<br>
 Total runtime: 5.31 msec
</code></blockquote>

	<p>
	Let's try this instead:
	
<blockquote><code class="code">
&nbsp;&nbsp;&nbsp;&nbsp;SELECT commit_log_id<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FROM clp <br>
&nbsp;&nbsp;ORDER BY commit_log DESC<br>
&nbsp;&nbsp;&nbsp;&nbsp; LIMIT 1;<br>
<br>
 Limit&nbsp;&nbsp;(cost=0.00..0.03 rows=1 width=4) (actual time=0.05..0.07 rows=1 loops=1)<br>
&nbsp;&nbsp; ->&nbsp;&nbsp;Index Scan Backward using clp_pkey on clp&nbsp;&nbsp;(cost=0.00..12.50 rows=500 width=4) (actual time=0.04..0.05 rows=2 loops=1)<br>
 Total runtime: 0.15 msec
</code></blockquote>

	<p>
	That new query is 35.4 times faster.  This clearly demonstrates the benefits of cost of an aggregate function
	versus the speed of an index.  Mind you, it could also be argued that the aggregate functions could use the index.
	</TD>
  </TR>


	<TR>
		<TD height="10"></TD>
	</TR>

  <TR>
    <TD>
    <div class="section">Is that it?</div>
    </TD>
  </TR>

  <TR>
	<TD>
	<p>
	That's it.  You've seen how adjusting the query and taking a different approach
	can often improve the speed.  It is not always clear how to adjust the query,
	but now that you have seen a few examples, that should get you started.
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
		<TR><TD ALIGN="right"><div class="headingmoreinfo">Need more help on this topic? <A HREF="/phorum/post.php?f=1">Click here</A><BR>This article has <a href="phorum/list.php?f=3&amp;article_id=527">2 comments</a><br>Show me <a href="topics.php?aid=527">similar articles</a><br></div></TD></TR>
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

