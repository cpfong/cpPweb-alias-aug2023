#define	NULL	0
struct tnode{
	char data;
	struct tnode *left;
	struct tnode *right;
};

struct tnode *new(){
	struct tnode *p;
	p=(struct tnode *)malloc(sizeof(struct tnode));
	return (p);
} // end new

struct tnode *make_tree(char d){
	struct tnode *tree=NULL;
	char ldata,rdata,t;

	if (d != '0'){
		tree=new();
		tree->data=d;
		printf("\ninput %c 左子節點為: ",d); ldata=getchar(); t=getchar();
		printf("\ninput %c 右子節點為: ",d); rdata=getchar(); t=getchar();
		tree->left =make_tree(ldata);
		tree->right=make_tree(rdata);
	}
	return(tree);
}// end make_tree

void preorder(struct tnode *p){
	if (p != NULL){
		printf("%2c",p->data);
		preorder(p->left);
		preorder(p->right);
	}
} // end preorder
void inorder(struct tnode *p){
	if (p != NULL){
		inorder(p->left);
		printf("%2c",p->data);
		inorder(p->right);
	}
} // end inorder
void postorder(struct tnode *p){
	if (p != NULL){
		postorder(p->left);
		postorder(p->right);
		printf("%2c",p->data);
	}
} // end postorder

main(){
	struct tnode *tree;
	char data,t;

	printf("*** 二元樹的建立 ***\n");
	printf("若這個資料下方沒有任何節點, 輸入數字 0\n\n");
	printf("輸入樹根節點資料: ");
	data=getchar(); t=getchar();
	tree=make_tree(data);
	printf("前序走訪: "); preorder (tree); printf("\n");
	printf("中序走訪: "); inorder  (tree); printf("\n");
	printf("後序走訪: "); postorder(tree); printf("\n");
} // end main
