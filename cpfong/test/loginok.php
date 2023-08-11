<?php

$n = mysql_num_rows($r)
if (!$n) {
	echo "帳號錯或密碼錯或二者皆錯\n";
	echo "如果有問題, 請來電 07-661-8851 分機 2350-2352\n";
	include "login.html";
}
else {
	xx();
}

sub function xx(){
	$name = 
	echo $name . '歡迎!' ;
	echo '
	<form action=save.php method=post>
		考生姓名<input type=text value=$v><br>
		搭乘人數<input type=select><br> (含家人)<br>
		<input type=submit value="OK">
	</form>
	'
} // end 
