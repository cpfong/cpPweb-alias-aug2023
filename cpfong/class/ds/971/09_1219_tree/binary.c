#include<stdlib.h>
#include<stdio.h>

struct tree_template {
	int val;
	struct tree_template *right, *left;
};

typedef struct tree_template node;

//
// 秨﹍竊翴
// 猔種: 材把计, 材把计夹, 穝玻ネ竊翴
// ex: insert(&root, curr);
//

void insert(node **tree, node *item) {
	if(!(*tree)) { // hit the end, rebound back
		*tree = item;
		return;
	}
	if(item->val < (*tree)->val) {
		insert(&(*tree)->left, item);
	}
	else if(item->val > (*tree)->val) {
		insert(&(*tree)->right, item);
	}
} // end insert

void printout(node * tree) {
	if(tree->left) { printout(tree->left) ; }
	printf("%d ",tree->val);
	if(tree->right){ printout(tree->right); }
} // end printout

main() {
	node *curr, *root;
	int i;

	root = NULL;

	for(i=0;i<10;i++) {
		curr = (node *)malloc(sizeof(node));
		curr->left = curr->right = NULL;
		curr->val  = (int)rand()%100;
		insert(&root, curr);
	}
	printout(root);
	printf("\n");
} // end main
