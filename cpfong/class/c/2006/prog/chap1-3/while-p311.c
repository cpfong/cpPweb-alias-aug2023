main(){
	int c;

	while (	(c=getchar()) == ' '	||
		c == '\n'		||
		c == '\t');

	printf("%c", c);
}
