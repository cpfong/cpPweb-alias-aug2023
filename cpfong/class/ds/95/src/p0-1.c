int max;

int bigger(int a, int b){
	return ( (a>=b) ? a : b );
}

int maximum(int a, int b, int c){
	bigger(bigger(a,b) , c);
}

main(){
	int x,y,z;
	printf("input 3 integer:");
	scanf("%d%d%d", &x,&y,&z);
	max=maximum(x,y,z);
	printf("the max is %d", max);
}
