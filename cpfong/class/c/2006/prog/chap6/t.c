#include "stdio.h"

main(){
	int c='5';

	// isalnum 測試字符是否為英文或數字, 相關函數有 isalpha isdigit islower isupper
	if (isdigit(c)) {
		printf("%c is digit\n", c);
	}
	else {
		printf("%c is NOT digit\n", c);
	}
}
