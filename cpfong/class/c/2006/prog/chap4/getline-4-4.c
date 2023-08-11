#include "stdio.h"

getline(char *p, int lim){

	int c;
	char *s; s=p;

	while (--lim > 0 && (c=getchar()) != EOF && c != '\n')
		*p++ = c;
/*
	if (c == '\n')
		*p++ = c;
*/
	*p = '\0';
	return p-s;
}
