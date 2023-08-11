main(){

	char *name;
	int  *age;

	name = (char *) malloc(sizeof(char) * 20);
	age  = (int  *) malloc(sizeof(int ) *  1);

/*
	scanf("%s", name);
	scanf("%d", age);
*/
	strcpy(name, "Tom");
	*age  = 20;
	*age += 10;

	printf("%s %d\n", name, *age);

	free(name);
	free(age);
}
