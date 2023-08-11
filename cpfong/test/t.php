<?php

	include './inc.php';

	echo "start<br>";

	conne_3ab();
	query_3ab();
	close_3ab();
	
//	$p = crypt('test', 'xx'); echo $p . "<br>";

	echo "end<br>";

	function query_3ab(){
		$n = $_POST['nn']; $p = $_POST['pp'];
		$sql = "select * from name where n='$n' and p=password('$p')";
		echo $sql . "<br>";
		$r = mysql_query($sql) or die(mysql_error());
		$t = mysql_num_rows($r);
		echo 'rows number = ' . $t . "<br>";
	} // end query_3ab

?>
