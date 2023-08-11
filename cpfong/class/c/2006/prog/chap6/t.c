#include "stdio.h"

main(){
	int c='5';

	// isalnum 代刚才琌璣ゅ┪计, 闽ㄧ计Τ isalpha isdigit islower isupper
	if (isdigit(c)) {
		printf("%c is digit\n", c);
	}
	else {
		printf("%c is NOT digit\n", c);
	}
}
