#define	OFFSET 48

main(){
	int i;

	i = getchar(); // i -= OFFSET; 
	if (i%2 == 0){
		printf("%d is a even number\n",i);
	} 
	else {
		printf("%d is a  odd number\n",i);
	}
}
