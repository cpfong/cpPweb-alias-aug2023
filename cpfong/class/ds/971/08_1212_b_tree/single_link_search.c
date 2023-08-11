#define	NULL	0

struct node {
	int data;
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

int count=0;
struct node *search (struct node *l, int d){
	struct node *p;

	p=l->link;
	while (p->link != NULL && p->data != d){
		p=p->link;
		count++;
	}
	if (p->link == NULL && p->data !=d){
		return (NULL);
	}
	else {
		return (p);
	}
}

// 主程式
main(){
	struct node *t;
	int a;

	create();
	display(); printf("\n");

	printf("輸入要找的節點:"); scanf("%d", &a);
	t=search(list, a); 
	if (t != NULL){
		printf("%d 在第 %d 個點\n", t->data, count+1);
	}
	else {
		printf("%d 不在本鏈結中\n", a);
	}
} // end main
