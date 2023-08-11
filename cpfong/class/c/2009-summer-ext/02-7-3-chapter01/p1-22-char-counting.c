#include <stdio.h>

main(){
	long nc; 
	int c;

	nc=0;
	while ((c=getchar()) != EOF){
		if (c == '\n' )nc++;
	}
	printf("%ld ENTER \n", nc);
}
