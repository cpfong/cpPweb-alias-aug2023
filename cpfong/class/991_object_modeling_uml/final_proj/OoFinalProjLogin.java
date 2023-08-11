/*
File:	OoFinalProjLogin.java
Obj:	User login, verify and send msg out
Ver:	12/29/2010 draft
*/

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class OoFinalProjLogin extends JFrame {
	private HttpURLConnection sms_gw = null;
	private JTextField tF, tF1, tF2, tF3;
	private JPasswordField pF;
	private JComboBox jC;
	private JLabel l1, l2, l3;
	private JButton jB, jB2, jBm, jB3, jB4, jBs;
	private JCheckBox jC1,jC2,jC3;
	private int bjC1,bjC2,bjC3;
	private JTextArea jTA;
	private String jC1mob="0937367051";
	private String jC2mob="0928449643";
	private String jC3mob="0928766969";

	public OoFinalProjLogin(){
		super( "校園行政系統登入" );

		String[] acc = {"教師", "職員", "學生"};
		Container container = getContentPane();container.setLayout( new FlowLayout() );
		
		l1=new JLabel("帳號:") ; container.add(l1); tF =new JTextField("T0000");container.add(tF);
		l2=new JLabel("密碼:") ; container.add(l2); pF =new JPasswordField("secret");container.add(pF);
		l3=new JLabel("身份:") ; container.add(l3); jC =new JComboBox(acc);container.add(jC); 
		jB=new JButton("登入") ; container.add(jB); jB2=new JButton("重新登入"); container.add(jB2);
      
		MainLoginHandler handler = new MainLoginHandler(); 
		jB.addActionListener(handler); jC.addActionListener(handler);
		setSize( 325, 100 );setVisible( true );
	} // end constructor OoFinalProjLogin

	public static void main( String args[] ){
		OoFinalProjLogin application = new OoFinalProjLogin();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	} // end main

	private class MainLoginHandler implements ActionListener {
		public void actionPerformed( ActionEvent event ){
			String pwd = new String(pF.getPassword());
			if ( event.getSource() == jB && tF.getText().equals("T0000") && pwd.equals("secret") ){
				String selName = (String)jC.getSelectedItem();
				if (selName.equals("教師")){
					TeacherMenu ap = new TeacherMenu();
				}
			}
		}
	} // end MainLoginHandler

	private class TeacherMenu extends JFrame {
		public TeacherMenu(){
			super( "教師選項" );
			Container container = getContentPane();container.setLayout( new FlowLayout() );
			jB3=new JButton("課程資訊"); container.add(jB3) ;
			jB4=new JButton("課程助教"); container.add(jB4) ;
			jBm=new JButton("簡訊輔導"); container.add(jBm) ;
			TeacherMenuHandler h = new TeacherMenuHandler(); jBm.addActionListener(h);
			setSize( 325, 100 );setVisible( true );
		}
	} // end class TeacherMenu

	private class TeacherMenuHandler implements ActionListener {
		public void actionPerformed( ActionEvent event ){
			if ( event.getSource() == jBm ){
				 smsDialog ap = new smsDialog();
			}
		}
	} // end TeacherMenuHandler

	private class smsDialog extends JFrame {
		public smsDialog (){
			super( "學生輔導簡訊傳送" );
			Container c=getContentPane();c.setLayout( new FlowLayout() );
			jC1=new JCheckBox("許任銘:工科所:" + jC1mob);c.add(jC1);
			jC2=new JCheckBox("陳冠偉:製造所:" + jC2mob);c.add(jC2);
			jC3=new JCheckBox("馮治平:工科所:" + jC3mob);c.add(jC3);
			jTA=new JTextArea("你好! 我是成大導師陳老師", 8, 15); c.add(jTA);
			jBs=new JButton("確定發送"); c.add(jBs);

			SmsCheckBoxHandler h = new SmsCheckBoxHandler();
			jC1.addItemListener(h);jC2.addItemListener(h);jC3.addItemListener(h);
			SmsActionHandler h2 = new SmsActionHandler(); jBs.addActionListener(h2);

			setSize( 250, 350 );setVisible( true );
		}
	} // end class smsDialog

	private class SmsActionHandler implements ActionListener {
		//String m;
		//m = jTA.getText();
		public void actionPerformed( ActionEvent event ){
			if ( event.getSource() == jBs ){
				if (bjC1 != 0) {SendSMS(jC1mob, jTA.getText());}
				if (bjC2 != 0) {SendSMS(jC2mob, jTA.getText());}
				if (bjC3 != 0) {SendSMS(jC3mob, jTA.getText());}
			}
		}
	} // end SmsActionHandler 

	private class SmsCheckBoxHandler implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			if (e.getSource() == jC1){
				bjC1 = jC1.isSelected() ? 1 : 0;
			}
			if (e.getSource() == jC2){
				bjC2 = jC2.isSelected() ? 1 : 0;
			}
			if (e.getSource() == jC3){
				bjC3 = jC3.isSelected() ? 1 : 0;
			}
		}
	} // end SmsCheckBoxHandler

	private void SendSMS(String mob, String msg){
		try{
			// 設定變數
			StringBuffer MSGData = new StringBuffer();

			// 動這二個即可
			String mobile  = mob;
			String message = msg;
			String password = "640601";

			// debug
			// System.out.println("phone=" + mobile + " msg=" + message);

			// 設定參數 fix
			String username = "cpfong";
			String type = "now";
			String encoding = "big5";
			String popup = "";
			String mo = "";
			String vldtime = "";
			String dlvtime = "";

			MSGData.append("username="+username);
			MSGData.append("&password="+password);
			MSGData.append("&type="+type);
			MSGData.append("&encoding="+encoding);
			MSGData.append("&popup="+popup);
			MSGData.append("&mo="+mo);
			MSGData.append("&mobile="+mobile);
			MSGData.append("&vldtime="+vldtime);
			MSGData.append("&dlvtime="+dlvtime);
			MSGData.append("&message=");
			MSGData.append(UrlEncode(message.toString().getBytes("big5")));
			SendToGW(MSGData.toString());
		}
		catch(Exception e){
			System.out.println("程式錯誤!");
		}
	} // end SendSMS

	// 傳送至 TwSMS API server
	private boolean SendToGW(String post){
		try {
			URL url = new URL("http://api.twsms.com/send_sms.php");
			sms_gw = (HttpURLConnection)url.openConnection();
			sms_gw.setDoInput(true);
			sms_gw.setDoOutput(true);
			sms_gw.setUseCaches(false);
			sms_gw.setRequestMethod("POST");
			DataOutputStream dos = new DataOutputStream(sms_gw.getOutputStream());
			dos.writeBytes(post);
			dos.flush();
			dos.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(sms_gw.getInputStream()));
			String strResponse = "";
			String readLine;
			while ((readLine = br.readLine()) != null) {
				strResponse += readLine;
			}
			br.close();
			System.out.println("回傳碼:" + strResponse);
			return true;
		}
		catch (Exception e) {
			System.out.println("無法連接 TwSMS API Server!");
			return false;
		}
	} // end SendToGW

	// UrlEncode Function
	private String UrlEncode(byte[] src){
		byte[] ASCIIMAP ={48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
		int pivot = 0;
		byte[] data = new byte[src.length * 3];
		for(int i = 0; i < src.length; i++){
			if(src[i] == 0){
				data[pivot++] = 37;
				data[pivot++] = 48;
				data[pivot++] = 48;
			}
			else 	if(src[i] < 0){
					data[pivot++] = 37;
					data[pivot++] = ASCIIMAP[(src[i] >> 4) & 0x0f];
					data[pivot++] = ASCIIMAP[src[i] & 0x0f];
				}
				else{
					char cc = (char)src[i];
					if(Character.isLetterOrDigit(cc)){
						data[pivot++] = src[i];
					}
					else 	if(cc == ' '){
						data[pivot++] = 43;
						}
						else if(cc == '.' || cc == '-' || cc == '*' || cc == '_'){
							data[pivot++] = src[i];
							}
							else{
								data[pivot++] = 37;
								data[pivot++] = ASCIIMAP[(src[i] >> 4) & 0x0f];
								data[pivot++] = ASCIIMAP[src[i] & 0x0f];
							}
						}
		}
		if(pivot > 0) return new String(data, 0, pivot);
		return "";
	} // end UrlEncode
} // end class OoFinalProjLogin
