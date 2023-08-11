#include <stdio.h>

main(){
	char c[]="abc\n";

	int i;
	for (i=0;i<5;i++){
		printf("c[%d]=%d\n",  i, c[i]);
	}
}
