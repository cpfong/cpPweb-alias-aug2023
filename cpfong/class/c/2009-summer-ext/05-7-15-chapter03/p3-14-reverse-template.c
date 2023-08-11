// reverse string s in place
//  cc -c p3-14-reverse-template.c to compile to obj (no a.out is needed
void reverse(char s[]){
	int c,i,j;

	for (i=0, j=strlen(s)-1; i<j; i++,j--){
		c=s[i];
		s[i]=s[j];
		s[j]=c;
	}
}
