#include "stdio.h"
 
/*
	把一行的資料讀入 s 陣列後傳回實際讀入的資料的長度 
	每行的最大字數不可以超過 lim
*/
int getline(char s[], int lim){
	int c,i;
	i=0;

	while(--lim>0 && (c=getchar()) != EOF && c!='\n')
		s[i++]=c;
	if (c=='\n')
		s[i++]=c;
	s[i]='\0'; // 在字串的最末加一個結束符號
	return i;
}
