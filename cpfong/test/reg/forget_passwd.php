<?php
	/****************************************************
	 function:	forget_passwd
	 object:	another way to login
	****************************************************/

	echo "忘記密碼想登入系統 <br><br>";

	form();

	function form(){
		echo '
			<form action="t.php" method="post">
				帳　　號: <input type="text" name="acc"><br>
				身份証號: <input type="text" name="pp"><br>
				生日月份: <select name="mon[]">
						<option value="jan"> 一月
						<option value="feb"> 二月
						<option value="mar"> 三月
						<option value="apr"> 四月
						<option value="may"> 五月
						<option value="jun"> 六月
						<option value="jul"> 七月
						<option value="aug"> 八月
						<option value="sep"> 九月
						<option value="oct"> 十月
						<option value="nov"> 十一月
						<option value="dev"> 十二月
					  </select><br>
						
				密碼提示: 
						<select name="cc[]">
							<option value="birthday"> 我的出生地 ?
							<option value="monther"> 我母親的姓 ?
							<option value="pri"> 我讀的小學 ?
							<option value="star"> 我最中意的明星 ?
						</select><br>
				答　　案: <input type="text" name="ans"><br><br>
				<input type="submit" value="登入">
			</form>
		';
	} // end form
?>
