#include <stdio.h>

int power(int,int);

main(){
	printf("range of unsigned int = 0 ~ %u\n", (power(2,sizeof(unsigned int)*8))-1);
}

int power(int base, int n){
        int i,p;
        p=1;
        for (i=1; i<=n; i++){
                p=p*base;
        }
        return p;
}
