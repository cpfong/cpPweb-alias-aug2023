#include <stdio.h>

int atoi(char *);
main(){
	char a[4];

	a[0]='1';a[1]='2';a[2]='\0';
	printf("a is %d\n", atoi(a));
}

int atoi(char s[]){
	int i,n;

	n=0;
	for (i=0; s[i] >= '0' && s[i] <= '9'; i++) n=10*n+(s[i]-'0');
	return n;
}
