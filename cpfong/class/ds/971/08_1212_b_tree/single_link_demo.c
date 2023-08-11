#define	NULL	0

struct node {
	int data;
	struct node *link;
};

// 生成一個新的點
struct node * new(){
	struct node *p;
	p = (struct node *) malloc(sizeof(struct node));
	if (p == NULL){
		printf("out of memory");
		exit(1);
	}
	return(p);
} // end new

// 生成一些點
struct node * create(){
	struct node *list, *p, *q;
	int i, n, d;

	list=new(); list->link=NULL;
	p=list;

	printf("想生成多少個節點? ");
	scanf("%d", &n);
	for (i=1; i<=n; i++){
		printf("輸入第 %d 筆: ", i);
		scanf("%d", &d);;
		q=new(); q->data=d; q->link=NULL;
		p->link=q;
		p=q;
	}
	return (list);
} // end create

// 找特定資料
struct node * search (struct node *list, int d){
	struct node *p;
	p=list->link;

	while(p != NULL && p->data != d){
		p=p->link;
	}
	return (p);
} // end search 

// 找 q 點的前一個節點 p
struct node * prenode(struct node *list, struct node *q){
	struct node *p;
	p=list;
	while (p != NULL && p->link != q){
		p=p->link;
	}
	return (p);
} // end prenode

void insert (struct node *p, struct node *q){
	q->link=p->link;
	p->link=q;
} // end insert

void delete (struct node *p, struct node *q){
	p->link=q->link;
	free(q);
}  // end delete

int length(struct node *list){
	struct node *p;
	int count=0;

	p=list->link;
	while(p != NULL){
		count++;
		p=p->link;
	}
	return(count);
} // end leght

void display(struct node *list){
	struct node *p;

	p=list->link;
	while (p != NULL){
		printf("%5d", p->data);
		p=p->link;
	}
	printf("\n");
} // end display

main(){
	struct node *list, *p, *q;
	int loop=1, d, d1;
	char input[8];

	printf("*** 鏈結 ***\n");
	printf("輸入以上的動作: create insert delete display length exit\n\n"); 
	list =NULL;

	while (loop){
		printf("===>");
		scanf("%s", input);
		if (strcmp(input, "create") == 0){
			list = create();
		}
		else if (strcmp(input, "insert") == 0){
			printf("你想輸入的資料: ");
			scanf("%d", &d);
			q=new(); q->data=d;
			printf("在那一筆資料之後? ");
			scanf("%d", &d1);
			p=search(list, d1);
			if (p == NULL){
				printf("cannot find %d, insert to front\n", d1);
				p=list;
			}
			insert(p,q);
		}
		else if (strcmp(input, "delete") == 0){
			printf("想刪那一筆? ");
			scanf("%d", &d);
			q=search(list, d);
			if (q == NULL){
				printf("cannot find %d, cannot delete\n", d);
			}
			else {
				p=prenode(list,q);
				delete(p,q);
			}
		} 
		else if (strcmp(input, "display") == 0){
			display(list);
		}
		else if (strcmp(input, "length") == 0){
			printf("本鏈結的長度為 %d\n", length(list));
		}
		else if (strcmp(input, "exit") == 0){
			loop=0;
		}
		else {
			printf("輸入錯誤, 重輸\n");
		}
	} // end of while
} // end main
