<html><head><title>EZ Phone Directory</title></head>
<body bgcolor=white link=blue alink=CC9966 vlink=purple>
<font color=black>
<br>
<center>
       
<a href=http://matrix.linux-help.org><img src=phone.gif border=0 alt="Home Page For EZ Phone Directory"></a><img src=title.gif>
</center>
<P>
<?php
$conn = pg_connect("host=localhost user=xxxxxx password=yyyyyy dbname=phonelist");

/* Check for errors. Actually, if there is an error the script 
would have died above. I do this out of habit, and I actually have the 
code in an include so I don't have to retype it. */

if (!$conn) {
     echo "An error occured.\n";
     exit;
}

/*
Create your SQL statement
*/

$sql="SELECT * FROM address WHERE uid = $name;";

/*
Execute your statement
*/

$result_set = pg_Exec($conn, $sql);

/*
Check how many rows were returned
*/

$rows = pg_NumRows($result_set);

if ((!$result_set) || ($rows < 1)) {
       echo "<center>";
       echo "<H2>Sorry your EZ Phone Directory can not find an entry for that listing </H2><P>";
       echo "<table>";
       echo "<table border=1 width=50%>";
       echo "<td bgcolor=#608080 align=center><Font color=white><B>Return To Main Directory</B></td>";
       echo "<form action='phone.php3' method='POST'>";
       echo "<tr><td align=center><input type=submit value='Directory'></tr></td>";
       echo "<tr><td align=center>Main Directory Page</td>";
       echo "</form>";
       echo "</table>";
       exit;  //exit the script
}

/*
Display the results. The easiest way is to use pg_result
pg_result uses the $result_set created above and you give
it the column name and row number that you want to retrieve

The following code loops through the result set displaying
a particular column. $rows was created in an earlier step.

Of course, you can get really elaborate and incorporate
HTML into this. I'm leaving that out to simplify the code.
*/
/* for ($j=0; $j < $rows; $j++) */


for ($j=0; $j < $rows; $j++) {
$pos = pg_result($result_set, $j, "first");
$pos2 = pg_result($result_set, $j, "last");
$pos3 = pg_result($result_set, $j, "phone");
$pos4 = pg_result($result_set, $j, "address");
$pos5 = pg_result($result_set, $j, "city");
$pos6 = pg_result($result_set, $j, "state");
$pos7 = pg_result($result_set, $j, "zip");
$pos8 = pg_result($result_set, $j, "beeper");
$pos9 = pg_result($result_set, $j, "cellphone");
$pos10 = pg_result($result_set, $j, "workphone");
$pos11 = pg_result($result_set, $j, "email");
$pos18 = pg_result($result_set, $j, "url");
$pos12 = pg_result($result_set, $j, "fax");
$pos13 = pg_result($result_set, $j, "birthday"); 
$pos14 = pg_result($result_set, $j, "spouse"); 
$pos15 = pg_result($result_set, $j, "notes"); 
$pos16 = pg_result($result_set, $j, "name");
$pos17 = pg_result($result_set, $j, "uid");
$pos25 = pg_result($result_set, $j, "area_code");
$pos19 = pg_result($result_set, $j, "country");
$pos20 = pg_result($result_set, $j, "nickname");
$pos21 = pg_result($result_set, $j, "title");
$pos22 = pg_result($result_set, $j, "company");
$pos23 = pg_result($result_set, $j, "department");
$pos24 = pg_result($result_set, $j, "anniversay");


echo "<center>";
echo "<table border=0>
<tr><th colspan=3 bgcolor=#8080ff><font color=white><H2>Update Information For $pos16</font> </H2>

<form action=update.php3 method=POST>
<tr><th align=left>Personal Information
<tr><td align=right>First Name: <input type=text name=first value='$pos'>
<td align=right>Last Name: <input type=text name=last value='$pos2'>
<td align=right>Nick Name: <input type=text name=nick value='$pos20'>
<tr><td align=right>Area Code: <input type=text name=area value='$pos25'>
<td align=right>Phone No: <input type=text name=phone value='$pos3'>
<td align=right>Address: <input type=text name=address value='$pos4'>
<tr><td align=right>City: <input type=text name=city value='$pos5'>
<td align=right>State: <input type=text name=state value='$pos6'>
<td align=right>Zip: <input type=text name=zip value='$pos7'>
<tr><td align=right>Country: <input type=text name=country value='$pos19'>
<tr><td>&nbsp
<tr><td>&nbsp
<tr><th align=left>Contact Information
<tr><td align=right>Company: <input type=text name=company value='$pos22'>
<td align=right>Title: <input type=text name=title value='$pos21'>
<td align=right>Department: <input type=text name=dept value='$pos23'>
<tr><td align=right>Fax: <input type=text name=fax value='$pos12'>
<td align=right>Workphone: <input type=text name=work value='$pos10'>
<td align=right>Cellphone: <input type=text name=cell value='$pos9'>
<tr><td align=right>Pager: <input type=text name=beeper value='$pos8'>
<td align=right colspan=2>Email Address: <input type=text size=40 name=email value='$pos11'>
<tr><td align=left colspan=3>Home Page: <input type=text size=60 name=url value='$pos18'>
<tr><td>&nbsp
<tr><td>&nbsp
<tr><th align=left>Special Occassions
<tr><td align=right>Birthday: <input type=text name=birthday value='$pos13'>
<td align=right>Anniversary: <input type=text name=anniversay value='$pos24'>
<td align=right>Spouse: <input type=text name=spouse value='$pos14'>
<tr><td>&nbsp
<tr><td>&nbsp
<tr><th align=left>Additional Notes:
<tr><td colspan=3 align=center>Notes: <TEXTAREA ROWS=10 COLS=50 name=notes WRAP=virtual>
$pos15
</TEXTAREA>
<tr><td><input type=hidden name=uid value='$pos17'>
       <tr><th colspan=3 align=center bgcolor=#608080><font color=white><input type=submit value='Update Listing'></font></th>
       </form>
</table>";

}



?>


</body></html>
