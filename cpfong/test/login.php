<?php

//-------------- define -----------------
define(HOSTNAME	, "localhost"	); 
define(USER	, "www"		); 
define(PASSWORD	, "pwd"		);
define(DBNAME	, "3ab"		);

//-------------- global variable --------
$conn = 0;
$db3ab= 0;

//-------------- program start here -----
conne_3ab();
login_ok();
close_3ab();
//--------------

function conne_3ab(){
	global $conn;
	$conn = mysql_connect(HOSTNAME,USER,PASSWORD) or die(mysql_error());
	$db3ab= mysql_select_db(DBNAME,$conn) or die(mysql_error());
} // end conne_3ab

function close_3ab(){
	global $conn;
	mysql_close($conn);
} // end close_3ab

function login_ok() {
	
	$id	= $_POST['tt'];
	$pwd	= $_POST['pp'];

	$t = "select id from car where id = $id and pwd = $pwd";
	$r = mysql_query($t) or die(mysql_error());

	$n = mysql_num_rows($r);
	if ($n) {
	}
	mysql_free_result($r);

} // end test

?>
