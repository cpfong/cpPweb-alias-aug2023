物件導向程式設計(二)期中考

1. 寫一程式使用陣列清單的方法, 宣告一個清單長度為 3 的陳列清單.  
由 stdin 讀入整數以為清單內容, 後加總合印出結果. 假定輸入為
1 2 3 則印出 1+2+3=6  

import java.awt.*;
import java.io.*;
import java.util.*;

public class Mid1{
        public static void main (String args[]){
                ArrayList <String>  list = new ArrayList <String> ();
                int in=0, sum=0;

                System.out.println("input 3 number: ");
                for (int i=0; i<3; i++){
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        try {
                                in = Integer.parseInt(br.readLine());
                                list.add(""+in);
                        } catch (IOException ioe) {
                                System.out.println("IO error trying to read your name!");
                                System.exit(1);
                        }
                }

                for (String item : list){
                        in = Integer.parseInt(item);
                        sum += in;
                }       
                System.out.println("Totoal is " + sum);
        }
}


2. 撰寫一個查詢的程式: 由鍵盤輸入 3 組學號和姓名存入後,  輸入要查的學號
   應出現姓名


3. 何謂 constructor ?

4. 變數型態為何要宣告成 protected


5. 撰寫可讓使用者輸入文字的程式, 並判斷輸入的文字是 int 或 double
(在此假設 double 具有小數點)
