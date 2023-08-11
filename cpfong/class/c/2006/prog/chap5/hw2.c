main(){
	int in;
	int i;
	char a[6][9]=	{
				"891506100",
				"891506101",
				"891506102",
				"891506103",
				"891506104",
				"891506106",
			};
	printf("input #:\n");
	scanf ("%d", &in);

	for (i=0; i < 9; i++){
		printf("%c", a[in][i]);
	}
}
