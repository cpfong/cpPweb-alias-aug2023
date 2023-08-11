#define	SIZE 50

main(){
	int i;
	int *p;

	p = (int *) malloc( SIZE * sizeof(int) );

	for (i=0; i<SIZE; i++){
		*(p+i) = i;
	}

	printf(" *(p+20) = %d\n", *(p+20));
}
