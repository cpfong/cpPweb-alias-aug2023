#include "stdio.h"

typedef struct n{
	int data;
	struct n *link;
} NODE;

NODE *new();

main(){

	NODE *p1, *p2;

	p1 = new(); 
	p2 = new();

	p1->data = 111; 
	p1->link = p2;
	p2->data = 222;
	p2->link = NULL;

	printf("%d %d\n", p1->data, p1->link->data);
}

NODE *new(){
	NODE *p;
	
	p = (NODE *) malloc(sizeof(NODE));
	return(p);
}
