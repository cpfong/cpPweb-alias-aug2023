#include <stdio.h>

#define MAX_CHARS_IN_ONE_LINE	1000

int getline(void); // after prototype here, func copy can put after main
void copy(void);

int max;
char line   [MAX_CHARS_IN_ONE_LINE];
char longest[MAX_CHARS_IN_ONE_LINE];

main(){
	int len;

	max=0;
	while ((len=getline()) >0 ){
		if (len > max){
			max=len;
			copy();
		}	
	}
	if (max>0) printf("longest line: \n%s\n", longest); 
	return 0;
}

void copy(void){
	int i=0;
	
	while ( (longest[i]=line[i]) != '\0' ) i++;
}


int getline(){
	int i, c;
	
	for (i=0; i<MAX_CHARS_IN_ONE_LINE-1 && (c=getchar())!=EOF && c!='\n'; i++)
		line[i]=c;

	if (c=='\n') { line[i]=c; i++; }
	line[i]='\0';
	return i;
} 
