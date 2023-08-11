char s[]="abc    ";
main(){
	printf("before = %seeee\n", s); 
	trim();
	printf("after  = %seeee\n", s); 
}

int trim(){
	int n;
	for (n=strlen(s)-1; n>=0; n--){
		if (s[n] != ' ' && s[n] != '\t' && s[n] != '\n')
			break;
		s[n+1]='\0';
		return n;
	}
}
