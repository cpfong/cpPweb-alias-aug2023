main(){
	char xx[]="125";
	int i;
	i=atoi(xx);
	printf (" i = %d\n", i);
}

int atoi(char s[]){
	int i,ans;
	ans=0;
	for (i=0; s[i] >= '0' && s[i] <= '9'; ++i)
		ans=10*ans + (s[i] - '0');
	return ans;
}
