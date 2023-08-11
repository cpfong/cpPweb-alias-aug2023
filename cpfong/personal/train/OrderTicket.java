import java.net.*;
import java.io.*;

public class OrderTicket {
	private static String url="http://railway.hinet.net/trw24/order_kind1.jsp?";

	public static void order() throws IOException {
		URL website = new URL(url);
		int count=1;
		while(true) {
			System.out.println("開始第" + count + "次嚐試訂票...");
			// debug
			// System.out.println("\n" + url);
			count++;
			URLConnection connection = website.openConnection();
			BufferedReader in_buf = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line = null;
			String content = "";

			while( (line=in_buf.readLine()) != null ) {
				content += line;
			} // end while 
			in_buf.close();

			if(content.indexOf("您的車票已訂到")!=-1) {
				BufferedWriter buf_out = new BufferedWriter(new FileWriter("result.html"));
				buf_out.write(content);
				buf_out.close();
				System.out.println("票 ok 了, 請看 result.html");
				System.exit(0);
			}
			else {
				System.out.println("票尚未定到，一分鐘之後將會再次嚐試...");
				try {
					Thread.sleep(60000); // sleep 1 minute, and try it again later.
				} // end try
				catch(InterruptedException e) {
					e.printStackTrace();
				}
      			}
    		} // end while(true)
  	} // end order

	public static void main(String[] args) {
		String pid	= "A123032958"	;	//身份證字號
		String from	= "004"		;	//台東
		String to	= "185"		;	//高雄
		String date	= "2004/06/24"	;
		String startTime= "11:00"	;
		String endTime	= "12:00"	;
		String quantity	= "1"		;
		String kind	= "*1"		;
		String buy_rtn_t= "0"		;

		url += "personId=" 	+ pid 		+ "&";
		url += "fromStation="	+ from		+ "&";
		url += "toStation="	+ to		+ "&";
		url += "getinDate="	+ date		+ "&";
		url += "getinStartTime="+ startTime	+ "&";
		url += "getinEndTime="	+ endTime	+ "&";
		url += "orderQty="	+ quantity	+ "&";
		url += "trainKindIn="	+ kind		+ "&";
		url += "returnTicket="	+ buy_rtn_t          ;

		try {
			order();
		} // end try

		catch(IOException e) {
			System.out.println("連線失敗，請檢查你的網路連線。");
    		} // end catch
  	} // end main
} // end class OrderTicket
