#define	NULL	0
struct tnode{
	int data;
	struct tnode *left;
	struct tnode *right;
};

struct tnode *new(){
	struct tnode *p;
	p=(struct tnode *)malloc(sizeof(struct tnode));
	return (p);
} // end new

struct tnode *make_tree(int d){
	struct tnode *tree=NULL;
	int ldata,rdata,t;

	if (d != -1){
		tree=new();
		tree->data=d;
		printf("\ninput %d 左子節點為: ",d); scanf("%d", &ldata);
		printf("\ninput %d 右子節點為: ",d); scanf("%d", &rdata);
		tree->left =make_tree(ldata);
		tree->right=make_tree(rdata);
	}
	return(tree);
}// end make_tree

void preorder(struct tnode *p){
	if (p != NULL){
		printf("%d",p->data);
		preorder(p->left);
		preorder(p->right);
	}
} // end preorder
void inorder(struct tnode *p){
	if (p != NULL){
		inorder(p->left);
		printf("%d",p->data);
		inorder(p->right);
	}
} // end inorder
void postorder(struct tnode *p){
	if (p != NULL){
		postorder(p->left);
		postorder(p->right);
		printf("%d",p->data);
	}
} // end postorder

main(){
	struct tnode *tree;
	char data,t;

	printf("*** 二元樹的建立 ***\n");
	printf("若這個資料下方沒有任何節點, 輸入 -1\n\n");
	printf("輸入樹根節點資料: ");
	scanf("%d", &data);
	tree=make_tree(data);
	printf("前序走訪: "); preorder (tree); printf("\n");
	printf("中序走訪: "); inorder  (tree); printf("\n");
	printf("後序走訪: "); postorder(tree); printf("\n");
} // end main
