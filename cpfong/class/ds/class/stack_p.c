/*************************************
 name  : stack_p.c
 object: implement stack using pointer
 ver   : 5/30/2004 v1
 author: cpfong
**************************************/

#include "stdio.h"

struct node {
	int data;
	struct node *link;
};

struct node *top;

main(){
	init();

	push(1); push(2); push(3); pop(); push(4);
	res();
}

res(){
	
	struct node *t;
	while (top->link != NULL){
		printf("%d ", top->data);
		t = top->link;
		top=t;
	}
}

init(){
	top = (struct node *) malloc(sizeof(struct node));
	top->link = NULL;
}

push(int num){

	struct node *t;

	t = (struct node *) malloc(sizeof(struct node));
	t->link = top;
	top = t;
	top->data = num;

} // end push

pop(){
	int d;
	struct node *t;

	if (top->link == NULL){
		printf("empty \n");
		exit(0);
	}
	else {
		d = top->data;
		t = top->link;
		free(top);
		top = t;
	}
}
