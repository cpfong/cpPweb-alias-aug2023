#!/usr/bin/perl -w

my $varid;
my $cdes;
my $c=0;

#1,FEE_YM,費用年月,C,6,1,6,YYYYMM

print '<html><FORM ACTION="/cgi-bin/nhi/fields-slect.cgi" METHOD="POST"><TABLE>', "\n";
while (<>){
	chomp;
	($varid,$cdes) = (split /,/)[1,2];

	if ($c % 4 == 0){ print '<TR>'; }
	print "<TD><INPUT NAME=\"01_fields_i_wants\" TYPE=checkbox VALUE=$varid></TD><TD>$cdes</TD>";
	if ($c+1 % 4 == 0) { print "</TR>\n"; }
	$c++;
}
print "</TABLE>\n";

print '就醫年份(西元):<INPUT NAME="FUNC_DATE" SIZE=5>';
print '性別:<input NAME="ID_SEX" type="radio" value="M">Male<input NAME="ID_SEX" type="radio" value="F">Female';
print '主手術ICD碼:<INPUT NAME="ICD_OP_CODE" SIZE=3> <br>';
print '身份證統一編號:<INPUT NAME="ID">';
print '年齡由:<INPUT NAME="agef" size=2>到<INPUT NAME="aget" size=2>';

print '<br>';
print '<INPUT TYPE="submit" value="Submit"><INPUT TYPE="reset">';

print '</form></html>', "\n";
