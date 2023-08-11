#include <stdio.h>

void itoa(int , char *);
void reverse(char *);

// cc p3-14-reverse-template.o p3-17-itoa.c
main(){
	int i=-2345;
	char a[10];
	itoa(i, a);
	printf("result is:\n%s\n", a);

}

// convert n to character in s
void itoa(int n, char s[]){
	int i,sign;

	if ((sign=n)<0) n=-n;
	i=0;
	do {
		s[i++]=n%10+'0';
	} while ((n/=10)>0);

	if (sign<0) s[i++]='-';
	s[i]='\0';
	reverse(s);
}
