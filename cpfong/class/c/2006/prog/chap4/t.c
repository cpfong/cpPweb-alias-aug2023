int getline(char line[], int max);

main(){
	char line[100];
	int i;
	i = getline(line, 100);
	printf ("strlen of line is  %d and are: %s", i, line); 
}
