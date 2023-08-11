#include <stdio.h>

/* print fahrenheit-celsius table
	for fahr = 0, 20, ..., 300 */
main(){
	int f,c;
	int l,u,s;
	
	l=0; u=300; s=20;
	f = l;
	while (f <= u){
		c = 5*(f-32) / 9; // note: (f-32)*(5/9)
		printf("%3d\t%3d\n",f,c);
		f=f+s;
	}
}
