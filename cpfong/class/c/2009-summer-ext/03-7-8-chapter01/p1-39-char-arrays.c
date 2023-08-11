#include <stdio.h>

#define MAX_CHARS_IN_ONE_LINE	1000

void copy(char dst[], char src[]){
	int i=0;
	
	while ( (dst[i]=src[i]) != '\0' ) i++;
}


int getline(char in[], int limit){
	int i, c;
	
	for (i=0; i<limit-1 && (c=getchar())!=EOF && c!='\n'; i++)
		in[i]=c;

	if (c=='\n') { in[i]=c; i++; }
	in[i]='\0';
	return i;
} 

main(){
	int len, max;
	char line   [MAX_CHARS_IN_ONE_LINE];
	char longest[MAX_CHARS_IN_ONE_LINE];

	max=0;
	while ((len=getline(line, MAX_CHARS_IN_ONE_LINE)) >0 ){
		if (len > max){
			max=len;
			copy(longest, line);
		}	
	}
	if (max>0) printf("longest line: \n%s\n", longest); 
	return 0;
}
