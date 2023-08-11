#include <stdio.h>

int data=07;
int bitcount(unsigned);
main(){
	printf("has %d 1\n", bitcount(data));
}

int bitcount(unsigned x){
	int b;

	for (b=0;x!=0;x>>=1)
		if (x & 01) b++;
	return b;
}
