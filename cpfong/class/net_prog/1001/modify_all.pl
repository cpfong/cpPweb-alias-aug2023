#!/usr/bin/perl

my $tar;

# update all *.html 
while (<*.html>){
	my $html=$_;
    my $tar="body start from here"; # searching target

	open TMP, ">./t"; # temp file to put stuff
	&sub_head(TMP);

  	open F,"<$html";
	while (<F>){ 
	  print TMP if /$tar/ .. /^<\/html>/;
	}
	close TMP;
	system "mv t $html";
} # end of while (go through *.html)

#
# subroutine to print out header
# common text for each html
#
sub sub_head{
my $file_handler = shift @_;

print $file_handler <<EOF;
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>5006504 計算機網路(一)</title>

<script type="text/javascript" src="dropdowntabfiles/dropdowntabs.js"></script>

<!-- CSS for Drop Down Tabs Menu #5 -->
<link rel="stylesheet" type="text/css" href="dropdowntabfiles/halfmoontabs.css" />

<body>

<h2 color="brown">506504: 計算機網路(一) (Fall 2011) </h2>
<div id="moonmenu" class="halfmoon">
<ul>
<li><a href="http://mail.mis.fotech.edu.tw/~cp/class/perl_class/1001">計網首頁</a></li>
<li><a href="" rel="dropmenu1_e">作業考試</a></li>
<li><a href="" rel="dropmenu2_e">班級相關</a></li>
<li><a href="" rel="dropmenu3_e">考試座位表</a></li>
<li><a href="./lectures.html">授課內容</a></li>
</ul>
</div>

<br style="clear: left;" />

<!--1st drop down menu -->                                                   
<div id="dropmenu1_e" class="dropmenudiv_e">
<a href=""></a>
<a href="./exam.html">小考大考</a>
<a href="./homework.html">作業</a>
<a href="./exercise.html">習題解答</a>
<a href="./Learning.Perl.5th.Edition.pdf">原文課本 pdf</a>
</div>

<!--2nd drop down menu -->                                                
<div id="dropmenu2_e" class="dropmenudiv_e" style="width: 150px;">
<a href="./score.html">成績</a>
<a href="./clean.html">教室值日生</a>
</div>

<!--3rd drop down menu -->                                                
<div id="dropmenu3_e" class="dropmenudiv_e" style="width: 100px;"> 
<a href="./seat.mid.html">期中考</a>
<a href="./seat.final.html">期末考</a>
</div>

<script type="text/javascript">
//SYNTAX: tabdropdown.init("menu_id", [integer OR "auto"])
tabdropdown.init("moonmenu", 3)
</script>
EOF
}
