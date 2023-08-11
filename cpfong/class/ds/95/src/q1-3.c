main(){
	struct st{
		char name[10];
		int score;
	} s[3],*p;

	int i;

	for (i=0; i<=2; i++){
		printf("input name:  "); scanf("%s", &s[i].name ); 
		printf("input score: "); scanf("%d", &s[i].score);
	}

	printf("\n*** socresí ****");
	for (p=s; p<=&s[2]; p++){
		printf("\n%s", p->name);
		printf("\n%d", p->score);
	}
}
