<?php 

  $g_conn = 0;

  // go and connect the database
  function go_c_db(){
	global $g_conn;
	$db_str = "dbname=en_93";

  	// $connection = pg_connect("host=localhost port=5432 dbname=DATABASENAME
	//			user=USERNAME password=PASSWORD") 
  	//    or die ("Nao consegui conectar ao PostGres --> " . pg_last_error($conn)); 

  	$g_conn = pg_connect($db_str) 
      		or die ("Fail connect to PostGres --> " . pg_last_error($g_conn)); 

	// debug
	if ($g_conn) { echo "connect db ok <br>"; }
  }

  // disconnect the db
  function go_d_db(){
	global $g_conn;
	pg_close($g_conn);

	// debug
	if ($g_conn) { echo "disconnect db fine <br>"; }
  }

?> 
