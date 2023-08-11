<?php
	/****************************************************
	 function:	apply_new_acc.php
	 object:	1st time login
	****************************************************/

	echo "申請帳號 <br><br>";

	form();

	function form(){
		echo '
			<form action="t.php" method="post">
				帳　　號: <input type="text" name="acc"><br>
				（請填入3至16個字元的小寫英文字母、數字、以及 _ 符號，第一個字元需為英文字母。）<br><br>


				密　　碼: <input type="password" name="pp"><br>
				（填入 6 個字元以上的英文字母、數字、以及各種符號組合，但不含空白鍵、及「"」。）<br><br>
				

				密碼確認: <input type="password" name="con"><br>
				（請再輸入一次密碼）<br><br>

				密碼提示: 
						<select name="cc[]">
							<option value="birthday"> 我的出生地 ?
							<option value="monther"> 我母親的姓 ?
							<option value="pri"> 我讀的小學 ?
							<option value="star"> 我最中意的明星 ?
						</select><br>
				答　　案: <input type="text" name="ans"><br>
				（當你忘記密碼時使用）<br><br>
				<input type="submit" value="送出資料">
			</form>
		';
	} // end form
?>
