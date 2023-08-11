/*
2. 寫一程式可以計算由鍵盤輸入的所有字 (未到 EOF) 中, 有多少個 a 到 e (5 個) 
的英文字, 若輸入為U a!Zb1 輸出應為 a:1 b:1 c:0 d:0 e:0 other:5 (注意在同一行)
*/

#include "stdio.h"
main(){
        int i,c;
        int a[6];
        char b[]="abcde";

        for (i=0;i<6;i++)
                a[i]=0;

        while ((c=getchar()) != EOF){
                if(c>='a' && c<='e'){
                        ++a[c-'a'];
                }
                else{
                        if(c!='\n'){++a[5];}
                }
        }

        for (i=0;i<5;i++){
                printf("%c:%d ",b[i],a[i]);
        }
        printf("other:%d\n",a[5]);
}
