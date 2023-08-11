<html><head><title>EZ Phone Directory</title></head>
<body bgcolor=white link=blue alink=CC9966 vlink=purple>
<font color=black>
<br>
<center>

<a href=http://matrix.linux-help.org><img src=phone.gif border=0 alt="Home Page For EZ Phone Directory"></a><img src=title.gif>
<P>
<center>
<body>
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

$sql="UPDATE address SET first = '$first', last = '$last', phone = '$phone', address = '$address', birthday= '$birthday', email = '$email', fax = '$fax', beeper = '$beeper', cellphone = '$cell', notes = '$notes', city = '$city', state = '$state', zip = '$zip', spouse = '$spouse', workphone = '$work', name = '$first $last', url = '$url', area_code = '$area', country = '$country', nickname = '$nick', title = '$title', company = '$company', department = '$dept', anniversay = '$anniversay'   WHERE uid = '$uid';";

/*Use the @ symbol here to suppress errors. Then
  use your error checking code to handle it your own way*/

@$result_set = pg_Exec ($conn, $sql);

if (!$result_set) {
        //No connection or other error, so print an error
        echo "<H1>ERROR - update failed</H1><P>";
        exit;  //exit the script
}

$sql2="Select * from address where uid = '$uid';";
$result_set2 = pg_Exec ($conn, $sql2);
$rows2 = pg_NumRows($result_set2);

echo "<table>";
echo "<table border=0 width=100%>";
for ($j=0; $j < $rows2; $j++) {

echo "<table>";
echo "<table border=0 width=100%>";
for ($j=0; $j < $rows2; $j++) {
$pos = pg_result($result_set2, $j, "first");
$pos2 = pg_result($result_set2, $j, "last");
$pos3 = pg_result($result_set2, $j, "phone");
$pos4 = pg_result($result_set2, $j, "address");
$pos5 = pg_result($result_set2, $j, "city");
$pos6 = pg_result($result_set2, $j, "state");
$pos7 = pg_result($result_set2, $j, "zip");
$pos8 = pg_result($result_set2, $j, "beeper");
$pos9 = pg_result($result_set2, $j, "cellphone");
$pos10 = pg_result($result_set2, $j, "workphone");
$pos11 = pg_result($result_set2, $j, "email");
$pos17 = pg_result($result_set2, $j, "url");
$pos12 = pg_result($result_set2, $j, "fax");
$pos13 = pg_result($result_set2, $j, "birthday"); 
$pos14 = pg_result($result_set2, $j, "spouse"); 
$pos15 = pg_result($result_set2, $j, "notes"); 
$pos16 = pg_result($result_set2, $j, "uid");
$pos18 = pg_result($result_set2, $j, "area_code");
$pos19 = pg_result($result_set2, $j, "country");
$pos20 = pg_result($result_set2, $j, "nickname");
$pos21 = pg_result($result_set2, $j, "title");
$pos22 = pg_result($result_set2, $j, "company");
$pos23 = pg_result($result_set2, $j, "department");
$pos24 = pg_result($result_set2, $j, "anniversay");
$pos25 = pg_result($result_set2, $j, "name");

echo "<tr><th bgcolor=#8080ff align=left><font color=white>Name</font></th><th bgcolor=#c06080 align=left><font color=white>$pos $pos2 </font></th><th bgcolor=#ffff80><a href=namedel.php3?name=$pos16>Delete Record</a></th></tr>";
echo "<tr><th align=left>Nick Name</a></th><td>$pos20</td><td bgcolor=#8080ff>&nbsp</td></tr>";
echo "<tr><th align=left>Phone number</th><td>( $pos18 ) $pos3</td><th bgcolor=#ffff80><a href=nameup.php3?name=$pos16>Update Record</a></th></tr>";
echo "<tr><th align=left>Address</th><td>$pos4 $pos5 $pos6 $pos7 $pos19</td></tr>";
echo "<tr><th align=left>Email</th><td><a href=mailto:$pos11>$pos11</a></td></tr>";
echo "<tr><th align=left>Home Page</th><td><a href=$pos17>$pos17</a></td></tr>";
echo "<tr><th align=left>Company</a></th><td>$pos22</td></tr>";
echo "<tr><th align=left>Title</a></th><td>$pos21</td></tr>";
echo "<tr><th align=left>Department</a></th><td>$pos23</td></tr>";
echo "<tr><th align=left>Fax</a></th><td>$pos12</td></tr>";
echo "<tr><th align=left>Pager</th><td>$pos8</td></tr>";
echo "<tr><th align=left>Cellphone</th><td>$pos9</td></tr>";
echo "<tr><th align=left>Workphone</th><td>$pos10</td></tr>";
echo "<tr><th align=left>Birthday</th><td>$pos13</td></tr>";
echo "<tr><th align=left>Anniversary</th><td>$pos24</td></tr>";
echo "<tr><th align=left>Spouse</th><td>$pos14</td></tr>";
echo "<tr><th align=left>Notes</th><td WIDTH=75%>$pos15</td></tr>";
echo "<tr><td bgcolor=#60808>&nbsp</td><td bgcolor=#60808>&nbsp</td><td bgcolor=#60808>&nbsp</td></tr>";
 }
}
?>
<tr><th bgcolor=#608080 align=center COLSPAN=5><font color=white>End Of Updated Results</th></tr>
</table>
<br>
<center>

<table>
<table border=0 width=50%>
<form action="paccess.php3" method="POST">
       <tr><th bgcolor=#c06080 align=center><font color=white><input type=submit value='Search The Listings'></font></th>
       <td> &nbsp </td>
       </form>
<form action="padd.php3" method="POST">
       <th bgcolor=#8080ff align=center><font color=white><input type=submit value='Add A New Listing'></th></font>
       <td> &nbsp </td>
       </form>
<form action="phone.php3" method="POST">
       <th bgcolor=#608080 align=center><font color=white><input type=submit value='Main Phone Directory'></tr></th></font>
</table>



