// 定義這個臨時的暫存區 (buffer) 的大小
#define	BUFSIZE 100

// 放東西的暫存區 array
char buf[BUFSIZE];

// buffer 的指標, 用來指下一個可用的位址
int bufp = 0;

// 如果 buffer 中有東西則由 buffer 中取, 否則由 stdin 取入字元
int getch(void){
	return (bufp > 0) ? buf[--bufp] : getchar();
} // end getch

// 如果 buffer 還可以放東西, 則把一個字放入 buffer 之中
void ungetch(int c){
	if (bufp >= BUFSIZE)
		printf("ungetch: too many characters\n");
	else
		buf[bufp++] = c;
}
