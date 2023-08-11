<?php 

define(HOSTNAME	, "localhost"		); 
define(USER	, "cpfong"		); 
define(PASSWORD	, "640601"		);
define(DBNAME	, "pbook"		);

// golbal variable
$g_conn = 0;

function go_c_db(){			// go and connect the database
	global $g_conn;
	$g_conn = mysql_connect(HOSTNAME, USER, PASSWORD)
		or die('Could not connect: ' . mysql_error());
	// debug
	// if ($g_conn) { echo "connect db ok <br>"; }

} // end go_c_db

function go_d_db(){			// disconnect the db
	global $g_conn;
	mysql_close($g_conn);
} // end go_d_db

function sql_query($sql) {		// whether this query has result
	global $g_conn; $rows = 0;

	// debug
	/*
	echo "g_conn = $g_conn <br>";
	echo "pass in sql string = $sql <br>";
	*/

	mysql_select_db(DBNAME, $g_conn);
        $res = mysql_query($sql, $g_conn);

        $rows = mysql_num_rows($res);	// how many matches
        return($rows);

} // end sql_query

?> 
