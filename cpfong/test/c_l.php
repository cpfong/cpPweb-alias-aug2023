<?php
	echo "in c_l.php";
	if ($_POST['ss'] == 'Logout') {
		include 'login.html';
	}
	else {
		include 'welcomed.php';
	}
?>
