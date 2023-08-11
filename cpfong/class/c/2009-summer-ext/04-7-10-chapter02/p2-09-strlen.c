#include <stdio.h>

int strlen(char *s);
main(){
	printf ("lenght of abcd is %d\n", strlen("abcd"));
}

strlen(char s[]){
	int i=0;
	while (s[i] != '\0') i++;
	return i;
}
