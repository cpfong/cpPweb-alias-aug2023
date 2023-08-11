#define	NULL	0
struct node {
	char data;
	struct node *link;
};

struct node * new(){ // 生成一個新的節點
	struct node *p;
	p = (struct node *)malloc(sizeof(struct node));
	return p;
} // end new

main(){ // 主程式
	struct node *tree; // tree
	struct node *p, *q, *q2, *c;
	
	p =new(); p->data='a'; tree=p;
	q =new(); q->data='b'; p->link=q;
	q2=new();q2->data='c'; q->link=q2;
	q2->link=NULL;

	c=tree;
	while (c->link){
		printf("%c\n", c->data);
		c=c->link;
	}
	// last one
	printf("%c\n", c->data);
} // end main
