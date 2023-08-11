#include "stdio.h"

main(){
	int link[50][3];
	int i,j;
	int index, val, head=1;

	link[1][1]= 100; link[1][2]=2;

	for (i=2; i<=9; i++){
		for (j=1; j<=2; j++){
			if (j==1){
				val=rand()%100;
				link[i][j]=val;
			}
			else {
				link[i][j]=i+1;
			}
		}
	}
	link[10][1]=0; link[10][2]=-1;

	while (link[head][2] != -1){
		printf("%d ", link[head][1]);
		head=link[head][2];
	}
	printf("%d\n", link[head][1]);
}
