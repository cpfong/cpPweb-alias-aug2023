
<html><head><title>EZ Phone Directory</title></head>
<body bgcolor=white link=blue alink=CC9966 vlink=purple>
<font color=black>
<br>
<center>
 
<a href=http://matrix.linux-help.org><img src=phone.gif border=0 alt="Home Page For EZ Phone Directory"></a><img src=title.gif>
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

$sql="DELETE from address where uid = '$name';";

/*Use the @ symbol here to suppress errors. Then
  use your error checking code to handle it your own way*/

@$result_set = pg_Exec ($conn, $sql);

if (!$result_set) {
        //No connection or other error, so print an error
       echo "<center>";
       echo "<H2>An Error Occurred Please Return To Main Directory</H2>";
       echo "<table>";   
       echo "<table border=1 width=50%>";
       echo "<td bgcolor=#608080 align=center><Font color=white><B>Return To Main Directory</B></td>";
       echo "<form action='phone.php3' method='POST'>";
       echo "<tr><td align=center><input type=submit value='Directory'></tr></td>";
       echo "<tr><td align=center>Main Directory Page</tr></td>";
       echo "</form>";
       echo "</table>";

       exit;  //exit the script

}
?>
<meta http-equiv="refresh" content="0;URL=phone.php3">
</body></html>

