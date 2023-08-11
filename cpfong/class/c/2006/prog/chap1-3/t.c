main(){
	int n, y;
	char t[]="bcdaefghi";
	char s[]="abc     ";

	printf("before = %seeee\n", s); 

	for (n=strlen(s)-1; n>=0; n--){
		if (s[n] != ' ' && s[n] != '\t' && s[n] != '\n')
			break;
		s[n+1]='\0';
	}
	printf("after  = %seeee\n", s); 

	y=0;
	for (n=0; n < strlen(t); n++){
		if (t[n] == 'a'){
			y=1;
			break;
		}
	}

	if (y == 1){
		printf("yes\n"); 
	}
	else {
		printf("NO\n"); 
	}
}
