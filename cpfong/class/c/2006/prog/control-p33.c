main(){
	int a,b,c;
	a = 2; b = 1;
/*
	if (a > b) {
		c = a;
	}
	else {
		c = b;
	}
*/
	c = (a > b) ? a : b;
	printf("%d and %d, the bigger is %d\n", a, b, c);
}
