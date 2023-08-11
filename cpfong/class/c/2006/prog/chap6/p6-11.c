#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define MAXWORD 100
#define NKEYS (sizeof keytab / sizeof(keytab[0]))
#define BUFSIZE 100

struct key {
	char *word;
	int count;
} keytab[] = {
	"auto",		0,
	"break",	0,
	"case",		0,
	"char",		0,
	"const",	0,
	"continue",	0,
	"default",	0,
	/* ... */
	"unsigned",	0,
	"void",		0,
	"volatile",	0,
	"while",	0
};


int getword(char *, int);
int binsearch(char *, struct key *, int);

char buf[BUFSIZE];    /* buffer for ungetch */
int bufp = 0;         /* next free position in buf 下一個要進到那個位置 */

/* count C keywords */
main(){
	int n;
	char word[MAXWORD];

	while (getword(word, MAXWORD) != EOF)
		if (isalpha(word[0]))
			if ((n = binsearch(word, keytab, NKEYS)) >= 0)
				keytab[n].count++;
	for (n = 0; n < NKEYS; n++)
		if (keytab[n].count > 0)
			printf("%4d %s\n",keytab[n].count, keytab[n].word);
	return 0;
} //end main

/* binsearch:  find word in tab[0]...tab[n-1] */
int binsearch(char *word, struct key tab[], int n){
	int cond;
	int low, high, mid;

	low = 0;
	high = n - 1;
	while (low <= high) {
		mid = (low+high) / 2;
		if ((cond = strcmp(word, tab[mid].word)) < 0){
			high = mid - 1;
		}
		else {	if (cond > 0)
				low = mid + 1;
			else
				return mid;
		}
	}
	return -1;
} // end binsearch

/* getword:  get next word or character from input */
int getword(char *word, int lim){
	int c, getch(void);
	void ungetch(int);
	char *w = word;

	// 如進來的是空白則一直重複, 一直等到不是空白才離開
	while (isspace(c = getch()))
		;

	// 進來的不是 eof 結束符號, 也就是 ^D 則可以把東西放入
	if (c != EOF)
		*w++ = c;

	// 進來的第一個字是不是文字字元 (a-z A-Z) 則要離開, 因為關鍵字要以字元開始
	if (!isalpha(c)) {
		// 結束
		*w = '\0';
		return c;
	}

	// isalnum 測試字符是否為英文或數字, 相關函數有 isalpha isdigit islower isupper
	// 注意: 主要的讀入在此, 迴圈把一個 word 給讀入
	for ( ; --lim > 0; w++){
		if (!isalnum(*w = getch())) {
			// 已是非文字或非數字, 則把這個字放入 buf[] 中
			ungetch(*w);
			break;
		}
	}
	// 加入字串的結束字元
	*w = '\0';

	// 傳回第一個字元
	return word[0];
} // end getword

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
