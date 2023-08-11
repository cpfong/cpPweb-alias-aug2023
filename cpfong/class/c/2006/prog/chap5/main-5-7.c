#include "stdio.h"

#define SIZE 100

main(){
	int i, n, s, array[SIZE], getint(int *);

	for (n = 0 ; n < SIZE && getint(&array[n]) != EOF; n++)
		;

	for (i=0,s=0 ; i < n; i++){
		s += array[i];
	}
	printf ("sum = %d\n", s); 
}
