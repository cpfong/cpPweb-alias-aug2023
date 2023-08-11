<?php

$conn  = ""; // connect_db return ID

main();

/***********************************************************
 * modify main entrance
 * purpose: modify the email for certain login user
 ***********************************************************/
function  // f main
main(){

 if (!(connect_db("email2")))   { exit; }
 print_out_edit_form();
 close_db(); 

} // end main

/***********************************************************
 * connect the database
 ***********************************************************/
function  // f connect_db
connect_db($dbname){ 

 global $conn;

// print  "in pg_connect<br>\n";

 if (!($conn = pg_connect ("localhost", "","","",$dbname))) {
    print  "<br>\n pg_connect fail <br>\n";
    return (FALSE);
   }
 else {
//    print  "<br>\n pg_connect $dbname ok!! <br>\n";
    return (TRUE);
   }

} // end connect_db

/***********************************************************
 * close the databse
 ***********************************************************/
function // f close_db
close_db(){ 

 global $conn;

 if (!($r = pg_close($conn)))
    print  "pg_close fail <br>\n";
 else
//    print  "pg_close ok! <br>\n";
 return ($r);

} // end close_db

/***********************************************************
 * print out the edit form to edit email
 ***********************************************************/
function // f print_out_edit_form
print_out_edit_form() {

 global $conn;
 global $fid  ; // Â¾¸¹

 // case insesitive
 $f = strtoupper($fid);

 $sql = "SELECT pname,email FROM email WHERE fid = '$f'";
 $res = pg_exec($conn, $sql);

 $pos  = pg_result($res, 0, "pname");
 $pos2 = pg_result($res, 0, "email");

 close_db();

 echo "
	<table>
	<form action=modify.php?fid=$f method=POST>
	<tr><td>©m¦W: <td>$pos
	<tr><td>Email:<td><input type=Text name=par_two size=30 value= $pos2>
	<tr><td><input type=Submit value=Update>
	</form>
	</table>
 ";

} // end print_out_edit_form

?>
