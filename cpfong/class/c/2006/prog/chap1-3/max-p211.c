main(){
	int a,b,c;

	printf("input 1st number: ");  a=getchar();
	printf("input 2nd number: ");  b=getchar();
	c = (b >a) ?  b : a;
	printf("%d and %d, the bigger is %d", a, b, c);
}
