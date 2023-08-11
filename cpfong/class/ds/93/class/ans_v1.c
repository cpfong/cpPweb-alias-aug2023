#include "stdio.h"

struct node {
	int data;
	struct node *link;
};

int main(){
	int i,n,ii;
	struct node *top, *t, *tt;

	printf("input how many: ");
	scanf("%d", &n);

	top = (struct node *) malloc(sizeof(struct node));
	tt  = top;

	for (i=0; i < n; i++) {
		ii = (rand() % 20) + 40;
		t = (struct node *) malloc(sizeof(struct node));
		t->data = ii;
		tt->link= t;
		tt=t;
		t->link  = NULL;
	}

	while (top->link != NULL){
		printf("%d ", top->link->data);
		top = top->link;
	}
}
