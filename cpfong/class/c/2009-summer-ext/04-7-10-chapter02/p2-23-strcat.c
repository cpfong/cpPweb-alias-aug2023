void sstrcat(char s[], char t[]){
	int i=0,j=0;

	while (s[i] != '\0') i++;
	while ( (s[i++]=t[j++]) != '\0');
}

main(){
	char b[]="def";
	char c[20]="abc";

	sstrcat(c,b);
	printf("%s\n", c);
}
