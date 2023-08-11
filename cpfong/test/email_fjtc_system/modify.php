<?php

$h_ref = $HTTP_REFERER;
$h_p_v = $HTTP_POST_VARS;
$h_g_v = $HTTP_GET_VARS;

$conn  = ""; // connect_db return ID

main();

/***********************************************************
 * modify main entrance
 * purpose: modify the email for certain login user
 ***********************************************************/
function  // f main
main(){

 get_new_email();
 if (!(connect_db("email2")))	{ exit; }
 if (!(go_2_modify()))		{ exit; }
 close_db(); 

} // end main

/***********************************************************
 * get the user new email
 ***********************************************************/
function // f go_2_modify
go_2_modify() {

 global $conn;
 global $fid; // pass in FJTC Job # from main.php
 global $newemail; 

// print "fid = $fid <br> \n";

 if ($newemail == "") {
    $newemail = 'na';
   }
// print "newemail = $newemail <br> \n";

 $sql = "UPDATE email SET email = '$newemail'  WHERE fid = '$fid'";
 $res = pg_exec($conn, $sql);

 if (!($res)) {
    print "Update Fail!! <br>\n";
    retur (FALSE);
 }
 else {
    print "§ó·s§¹²¦ <br>\n";
    mail("rdd@center.fjtc.edu.tw", "email_system $fid $newemail", "$fid \n $newemail \nLine 3");
    return (TRUE);
 }

} // end go_2_mify

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
 * get the user new email
 ***********************************************************/
function // f get_new_email
get_new_email(){ 

 global $h_p_v;
 global $newemail; 

 reset($h_p_v);
 $t = key($h_p_v) ; $newemail= $h_p_v[$t]; 

// print "newemail is $newemail<br>\n";

} // end get_new_email

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

?>
