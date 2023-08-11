#define	NULL	0

struct node {
	char data;
	struct node *link;
};

// 生成一個新的節點
struct node * new(){
	struct node *p;

	p = (struct node *)malloc(sizeof(struct node));
	return p;
} // end new

struct node *list;

struct node * create(){
	struct node *p, *q; 
	int i,n,d;

	list=new(); list->link=NULL;
	p=list;

	printf("要輸入多少筆? "); scanf("%d", &n);

	for (i=0; i<n; i++){
		printf("輸入第 %d 筆資料", i+1);scanf("%d", &d);
		q=new(); q->data=d; q->link=NULL;
		p->link=q;
		p=q;
	}
} // end create

void display(){
	struct node *c;
	c = list->link;

	while (c){
		printf("%d", c->data);
		c=c->link;
	}
}

// 加新節點 q 到 p 之後
void insert(struct node *p, struct node *q){
	printf("x\n");
	q->link=p->link;
	printf("y\n");
	p->link=q;
	printf("z\n");
}

// 主程式
main(){
	struct node *t, *last;
	create();
	display(); printf("\n");

	t = new(); t->data=3; t->link=NULL;

	last = list->link;
	while (last != NULL){
		last=last->link;
	}

	insert(last,t);
	display(); printf("\n");
} // end main
