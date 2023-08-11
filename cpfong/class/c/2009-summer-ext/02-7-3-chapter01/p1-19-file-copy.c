#include <stdio.h>

main(){
	int c;
	
	c=getchar(); // note getchar() can only get ONE char, if you input several chars , will be queued
	while (c != EOF){
		putchar(c);
		c=getchar();
	}
}
