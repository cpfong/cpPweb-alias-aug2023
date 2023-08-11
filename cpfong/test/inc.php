<?php

define(HOSTNAME	, 'localhost'			); 
define(USER	, 'www'				); 
define(PASSWORD	, 'pwd'				);
define(DBNAME	, '3ab'				);

$conn = 0;
$db3ab= 0;

function conne_3ab(){
	global $conn;
	$conn = mysql_connect(HOSTNAME,USER,PASSWORD) or die(mysql_error());
	$db3ab= mysql_select_db(DBNAME,$conn) or die(mysql_error());
} // end conne_3ab

function close_3ab(){
	global $conn;
	mysql_close($conn);
} // end close_3ab

?>
