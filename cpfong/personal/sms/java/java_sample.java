import java.net.*; 
import java.io.*; 
import java.lang.*;

public class SMSSend
{
	public static void main(String args[])
	{
		try
		{			
			// 設定變數
			Socket		socket; 
			String		len; 
			InputStream	Is; 
			OutputStream	Os; 
			DataInputStream DIS; 
			PrintStream	PS; 

			String msg 	= "";
			String MSGData	= "";
			String GetData	= "";
			String MsgID	= "";
			
			// 設定參數
			String username = "";			// 帳號
			String password = "";			// 密碼
			String type = "now";			// 發送型態
			String mobile = "09xxxxxxxx";		// 電話
			String message = "簡訊測試";		// 簡訊內容
			String encoding = "big5";		// 簡訊內容編碼
			String popup = "";			// 使用 POPUP 顯示
			String mo = "";				// 使用雙向簡訊
			String vldtime = "";			// 簡訊有效期限
			String dlvtime = "";			// 預約時間

			int Num = 0;

			msg = "username="+username+"&password="+password+"&type="+type+"&encoding="+encoding+"&popup="+popup+"&mo="+mo+"&mobile="+mobile+"&message="+message+"&vldtime="+vldtime+"&dlvtime="+dlvtime;
			Num = msg.length();
			Message.getBytes("ISO-8859-1");
			Num = Num + Message.length();
			
			MSGData = MSGData+"POST /send.php HTTP/1.1\r\n";
			MSGData = MSGData+"Host: api.twsms.com\r\n";
			MSGData = MSGData+"Content-Length: "+Num+"\r\n";
			MSGData = MSGData+"Content-Type: application/x-www-form-urlencoded\r\n";
			MSGData = MSGData+"Connection: Close\r\n\r\n";
			MSGData = MSGData+msg+"\r\n";			

			// 開始送簡訊資料
			socket=new Socket("api.twsms.com",80); 

			//獲得對應socket的輸入/輸出流 
			Is=socket.getInputStream(); 
			Os=socket.getOutputStream(); 

			//建立數據流 
			DIS=new DataInputStream(Is); 
			PS=new PrintStream(Os); 

			PS.println(MSGData);

			int i=1;
			while(true){
				GetData = DIS.readLine();
				if (i == 10)
				{
					MsgID = GetData;
				}
				if (GetData == null)break;
				i++;
			}

			//關閉連接 
			DIS.close(); //關閉數據輸入流 
			PS.close(); //關閉數據輸出流 
			Is.close(); //關閉輸入流 
			Os.close(); //關閉輸出流 
			socket.close(); //關閉socket 
			
			// 結果輸出
			System.out.println("回傳碼:" + MsgID);

		}
		catch(Exception e){ 
			System.out.println("無法連接 TwSMS API Server!"); 
		} 
	}
}
