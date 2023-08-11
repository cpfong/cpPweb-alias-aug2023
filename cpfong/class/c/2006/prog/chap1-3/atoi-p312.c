#include	"ctype.h"

main(){
	int x;

	char str[20];
	printf("pls input a string: ");
	scanf("%s", str); 
	x = atoi(str);
	printf(" x = %d\n", x);
}

int atoi(char s[]){
	int i,n,sign;

	// skip the begging spaces
	for (i=0; isspace(s[i]);i++){
		;
	}

	sign = (s[i] == '-') ? -1 : 1;

	// skip the first +,- sign
	if (s[i] == '+' || s[i] == '-'){
		i++;
	}

	for (n=0; isdigit(s[i]);i++){
		n=10*n + (s[i] - '0');
	}

	return sign * n;
}
