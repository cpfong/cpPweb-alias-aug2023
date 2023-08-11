main(){
	int i,sum=0;
	int a[101];

	for (i=0; i<sizeof(a)/sizeof(a[0]); i++){
		a[i]=i;
	}	

	for (i=0; i<sizeof(a)/sizeof(a[0]); i++){
		sum += a[i];
	}
	printf("sum = %d\n", sum);
}
