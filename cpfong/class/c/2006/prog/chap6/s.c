main(){
	struct st {
		int x;
		float y;
	} s[]=	{
			174,50,181,60,160,50
		};
	printf("%d\n", sizeof s/sizeof (struct st)); 
	printf("s %d bytes, s[0] %d bytes\n", sizeof s, sizeof s[0]); 
	printf("int %d bytes, float %d bytes\n", sizeof(int), sizeof(float)); 
}
