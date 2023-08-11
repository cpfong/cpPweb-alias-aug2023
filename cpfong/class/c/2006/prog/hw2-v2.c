#define ID	9
#define ST	5

main(){
	int i;
	char *p[ST+1];
	char a[ST+1][ID+1]= {	"891506100",
				"891506101",
				"891506102",
				"891506103",
				"891506104",
				"891506105" };

	for (i=0; i < (ST+1); i++){
		p[i] = &a[i][0];
	} 

	printf ("pls input 1-%d:", ST);  scanf("%d",  &i);

	if (i > 0 & i < ST+1){
		printf ("%s\n", p[i]);
	}
	else {
		printf ("out of number\n");
	}

	printf("a[4][8] = %c\n", a[4][8]); 
}
