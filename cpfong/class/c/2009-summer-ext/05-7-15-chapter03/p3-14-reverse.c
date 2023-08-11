#include <stdio.h>

// put reverse in a obj, link it in by using
// cc p3-14-reverse-template.o p3-14-reverse.c

void reverse(char *);
main(){
	char a[]="12345";
	reverse(a);
	printf("%s\n", a);
}
