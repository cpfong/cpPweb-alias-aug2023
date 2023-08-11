void st(char *, char *);

main(){
	char a[]="abc";
	char b[3];

	st(a, b);
	printf("%s\n", b);
}

void st(char *s, char *d){
	while ( *d++ = *s++ )
		;
}
