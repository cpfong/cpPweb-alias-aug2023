void st(char *, char *);

main(){
	char a[]="abc";
	char *p;
	int i=0;

	// string copy , but don't need to know the size before hand
	p = (char *) malloc ( strlen(a) * sizeof (char));
	
	st(a,p);

	while (*(p+i)){
		printf ("%c", *(p+i));
		i++;
	}
}

void st(char *s, char *d){
	while ( *d++ = *s++ )
		;
}
