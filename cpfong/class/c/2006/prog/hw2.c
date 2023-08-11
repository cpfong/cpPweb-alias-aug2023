main(){
	int n;
	char *p;
	p = (char *) malloc (5 * 9 * sizeof(char));

	strcpy (p   , "891506101"); *(p +  9) = '\0';
	strcpy (p+10, "891506102"); *(p + 19) = '\0';
	strcpy (p+20, "891506103"); *(p + 29) = '\0';
	strcpy (p+30, "891506104"); *(p + 39) = '\0';
	strcpy (p+40, "891506105"); *(p + 49) = '\0';

	printf("pls input number:"); scanf("%d", &n);
	printf("num = %d id is %s\n", n, p+10*(n-1));
}
