#include "stdio.h"

main(){
	int link[1000][3];
	int c=0;
	int index, val, head;
	int t;

	link[1][1]=100; link[1][2]=index=rand()%50+1;
	printf("link[1]=100,next index=%d\n", index);

	while (c < 10){
		link[index][1]=rand()%100; 
		link[index][2]=t=rand()%1000+1;
		printf("link[%d]=%d,next index=%d\n", index, link[index][1], t);
		index=t;
		c++;
	}

	link[index][1]= 0;
	link[index][2]=-1;
	printf("link[%d]=%d,next index=%d\n\n\n", index, link[index][1], link[index][2]);

	head=1;
	while (link[head][2] != -1){
		printf("link[%d]=%d,next index=%d\n", head, link[head][1], link[head][2]);
		head=link[head][2];
	}
	printf("%d\n", link[head][1]);
}
