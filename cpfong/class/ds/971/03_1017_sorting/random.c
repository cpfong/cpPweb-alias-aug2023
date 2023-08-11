#include <stdlib.h>

// in FreeBSD , one can use 
// man rand to get the useful info

main(){
	int i,d;

	for (i=0; i<10; i++){
		d = ran(100);
		printf("%d\n", d);
	}
}

ran(int range){
	int ret;

	srandomdev();
	ret = random()%range;
	return (ret);
}
