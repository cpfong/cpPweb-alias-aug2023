<?php
	/****************************************************
	 function:	login.php
	 object:	allow those who have account to login
	****************************************************/

	echo "和春技術學院網路報名系統 <br>";

	name_passwd_form();

	function name_passwd_form(){
		echo '
			<form action="t.php" method="post">
				帳號: <input type="text" name="acc"><br>
				密碼: <input type="password" name="pp"><br>
				<input type="submit" value="登入"><br>
			</form>
			<a href=./apply_new_acc.php><font color="red">立即註冊</font></a>(第一次登入, 尚無帳號者)<br>
			<a href=./forget_passwd.php>忘記密碼</a><br>
		';
	}
?>

