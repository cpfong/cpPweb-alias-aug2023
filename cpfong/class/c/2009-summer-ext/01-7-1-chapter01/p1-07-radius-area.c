#include <stdio.h>

/* print fahrenheit-celsius table
	for fahr = 0, 20, ..., 300 */
main(){
	int f,c;
	int l,u,s;
	
	l=1; u=5; s=1;
	f = l;

	printf ("radius\tarea\n");
	while (f <= u){
		c = 3*f*f;
		printf("%3d\t%3d\n",f,c);
		f=f+s;
	}
}
