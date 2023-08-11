<html><head><title>EZ Phone Directory</title></head>
<body bgcolor=white>
<img src=phone.gif><img src=title.gif>
<center>
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

$sql="SELECT * FROM address WHERE uid = '$name' order by last;";
$sql2="SELECT count(*) from address WHERE uid = '$name';";

/*
Execute your statement
*/

$result_set = pg_Exec($conn, $sql);
$result_set2 = pg_Exec($conn, $sql2);

/*
Check how many rows were returned
*/

$rows = pg_NumRows($result_set);
$rows2 = pg_NumRows($result_set2);
if ((!$result_set) || ($rows < 1)) {
       //No connection or no rows returned, so print an error
       echo "<H1>Sorry the listing for $name was not found. Please redo your search. </H1><P>";
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
for ($j=0; $j < $rows2; $j++) {
echo "<table>";
echo "<table border=0 width=100%>";
$pos40 = pg_result($result_set2, $j, "count");
echo "<tr><th bgcolor=#608080 align=center><font color=white>$pos40 Listings In Phone Directory</th></tr>";
echo "</table>";

echo "<table>";
echo "<table border=0 width=100%>";
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
$pos17 = pg_result($result_set, $j, "url");
$pos12 = pg_result($result_set, $j, "fax");
$pos13 = pg_result($result_set, $j, "birthday"); 
$pos14 = pg_result($result_set, $j, "spouse"); 
$pos15 = pg_result($result_set, $j, "notes"); 
$pos16 = pg_result($result_set, $j, "uid");
$pos18 = pg_result($result_set, $j, "area_code");
$pos19 = pg_result($result_set, $j, "country");
$pos20 = pg_result($result_set, $j, "nickname");
$pos21 = pg_result($result_set, $j, "title");
$pos22 = pg_result($result_set, $j, "company");
$pos23 = pg_result($result_set, $j, "department");
$pos24 = pg_result($result_set, $j, "anniversay");

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

