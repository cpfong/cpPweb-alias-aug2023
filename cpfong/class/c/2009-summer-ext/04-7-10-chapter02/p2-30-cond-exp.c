#include <stdio.h>

main(){
	int r=22;
	int i;

	i =	(r<10) ? 0 : 
		(r<20) ? 1 :
		(r<30) ? 2 : 3 ;
	printf ("i = %d\n", i); 
}
