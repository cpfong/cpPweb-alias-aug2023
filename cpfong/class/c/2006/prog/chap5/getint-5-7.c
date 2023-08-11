#include "stdio.h"
#include "ctype.h"

int getch(void);
void ungetch(int);

/* 
	由 stdin 讀入一個 integer 且放入 *pn
	呼叫人把變數位址傳入, 程式以 pointer 把值放回.
	傳回值則表示是否為 EOF 的狀態, 0 表不是 EOF, 
	否則表示是 EOF
*/

int getint(int *pn){
	int c, sign;

	// 先把空白給跳掉
	while (isspace(c=getch()))
		;

	// 不是所謂的數字, 即不是 + - EOF 0-9
	if (!isdigit(c) && c != EOF && c != '+' && c!= '-'){
		ungetch(c);
		// debug
		// printf("pre-return, *pn not defined yet!\n");
		return 0;
	}

	// 正負號, 則 sign 變數為 1 或 -1 以便等一下用
	sign = (c == '-') ? -1 : 1;

	// 如果第一字元為正負號, 則取入第二字元
	if (c == '+' || c == '-')
		c=getch();

	for (*pn=0; isdigit(c); c=getch())
		*pn = 10 * *pn + (c - '0');

	*pn *= sign;

	if (c != EOF)
		ungetch(c);
	return c;
}
