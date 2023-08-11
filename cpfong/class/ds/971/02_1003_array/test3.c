main(){
	int i,j,sum=0;
	int a[1001];

	for (i=0; i<sizeof(a)/sizeof(a[0]); i++){
		a[i]=i;
	}	
	printf("input number: ");
	scanf("%d", &j);
	for (i=0; i<j+1; i++){
		sum += a[i];
	}
	printf("sum = %d\n", sum);
}
