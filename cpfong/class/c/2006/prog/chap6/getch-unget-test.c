#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define MAXWORD 100
#define NKEYS (sizeof keytab / sizeof(keytab[0]))
#define BUFSIZE 100

char buf[BUFSIZE];    /* buffer for ungetch */
int bufp = 0;         /* next free position in buf 下一個要進到那個位置 */

/* count C keywords */
main(){
	int c, getch(void);
	void ungetch(int);
	char word[MAXWORD];
	int lim=20;
	char *w = word;

	// isalnum 測試字符是否為英文或數字, 相關函數有 isalpha isdigit islower isupper
	// 注意: 主要的讀入在此, 迴圈把一個 word 給讀入
	for ( ; --lim > 0; w++){
		if (!isalnum(*w = getch())) {
//			ungetch(*w);
			break;
		}
	}
	// 加入字串的結束字元
	*w = '\0';

	printf("word = %s", word);
} // end main

/* 
   get a (possibly pushed-back) character
   如果 buffer 內還有字則由 buf 內取, 否則由 stdin 取字
   取前先把 bufp -- 因為 bufp 定義為下一個要放入的位置
*/
int getch(void){
       return (bufp > 0) ? buf[--bufp] : getchar();
} // end getch

/* 
   push character back on input 
   把一個字元放到 buf 以給 getch 來取
*/
void ungetch(int c){
	if (bufp >= BUFSIZE)
		printf("ungetch: too many characters\n");
	else
		buf[bufp++] = c;
} // end ungetch
