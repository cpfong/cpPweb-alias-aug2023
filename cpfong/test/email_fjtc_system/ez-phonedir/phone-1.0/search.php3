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

$sql="SELECT * FROM address WHERE lower(first) LIKE lower('$name%') OR lower(last) LIKE lower('$name%') order by last;";
$sql2="SELECT count(*) from address WHERE lower(first) LIKE lower('$name%') OR lower(last) LIKE lower('$name%');";

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
$pos25 = pg_result($result_set, $j, "name");

echo "<tr><th align=left><a href=search7.php3?name=$pos16>View Full Record</a></th><td align=left>$pos $pos2 </td><td> Phone:&nbsp( $pos18 ) $pos3</td><td> &nbsp Email: &nbsp $pos11</td></tr>";
 }
}
?>
<tr><th bgcolor=#608080 align=center COLSPAN=5><font color=white>End Of Search Results</th></tr>
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

