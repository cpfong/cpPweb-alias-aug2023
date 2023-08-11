#include <stdio.h>

int trim(char *);

main(){

	char a[]="123 	";
	trim(a);
	printf("after trim:\n%s^^^\n",a);
}

// remove trailing whilte
int trim(char s[]){
	int n;

	for (n=strlen(s)-1; n>=0; n--)
		if (s[n]!=' ' && s[n]!='\t' && s[n]!='\n') break;
	s[n+1]='\0';
}
