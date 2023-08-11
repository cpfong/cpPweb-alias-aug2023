<?
        $input_num  = $_POST['phone_self'];
	$pre_num    = $_POST['phone_num'];

	$self = strcmp($pre_num, '1234567890');
	if ($self == 0){$g_mobile = $input_num;}
	else {$g_mobile = $pre_num;}

        $g_message= $_POST['msg'];
	$username = "cpfong";		# 帳號
	$password = "640601";		# 密碼
	$type =	 "now";			# 發送型態
	$mobile = $g_mobile;		# 電話
	$message = $g_message;		# 簡訊內容
	$encoding = "big5";		# 簡訊內容編碼
	$popup = "";			# 使用 POPUP 顯示
	$mo = "";			# 使用雙向簡訊
	$vldtime = "";			# 簡訊有效期限
	$dlvtime = "";			# 預約時間

	$msg = "username=".$username."&password=".$password."&type=".$type."&encoding=".$encoding."&popup=".$popup."&mo=".$mo."&mobile=".$mobile."&message=".$message."&vldtime=".$vldtime."&dlvtime=".$dlvtime;
$num = strlen($msg);		

	// debug
	// echo $msg;
	// return 0;

	// 打開 API 閘道
	$fp = fsockopen ("api.twsms.com", 80);
	if ($fp) {
		$MSGData .= "POST /send.php HTTP/1.1\r\n";
		$MSGData .= "Host: api.twsms.com\r\n";
		$MSGData .= "Content-Length: ".$num."\r\n";
		$MSGData .= "Content-Type: application/x-www-form-urlencoded\r\n";
		$MSGData .= "Connection: Close\r\n\r\n";
		$MSGData .= $msg."\r\n";
		fputs ($fp, $MSGData);

		// 取出回傳值
		while (!feof($fp)) $Tmp[]=fgets ($fp,128); 

		// 關閉閘道
		fclose ($fp);

		// 顯示回傳值
		$CheckRes = split("=",$Tmp[9]);

		if (intval($CheckRes[1]) <= 0){
			echo "傳送失敗:".$CheckRes[1];
		}
		else {
			echo "傳送完成:".$CheckRes[1];
		}
	}
	else {
		echo "您無法連接 TwSMS API Server";
	}
?>
