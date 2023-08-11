main(){
	int i,c=0;
	int a[]={-5, 1, 10, -100, 85};

	for (i=0; i < 5; i++){
		if (a[i] < 0) {
			continue;
		}
		else {
			c++;
		}
	}
	printf(" %d >=0 \n", c);
}
