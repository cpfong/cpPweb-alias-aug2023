#include <stdio.h>
#include <stdlib.h>

#define RANGE	 6
#define NODES	 4
#define	TARGET	 3

struct tem {
	int data;
	struct tem * left ;
	struct tem * right;
};

typedef struct tem node;

node *new_node		(void);
void insert_node	(node **, node *);
int  get_an_int		(int);
void pre_order_addr	(node **);
void pre_order		(node *);
int  b_search		(int);
int  b_search_rec	(node *, int);

node *root, *pt;

main(){
	int i;
	node *cur;

	root=NULL;

	for (i=0; i<NODES; i++){
		cur = new_node();
		insert_node(&root, cur);
	}

	printf("target is %d\n", TARGET);
	printf("data traverse by pre order is: ");
	pre_order(root); printf("\n");

	i=b_search(TARGET);

	printf("\nusing binary search method: ");
	if (i){ printf("found\n"); }
	else { printf("Not found!\n"); }

	printf("binary search recursive: ");
	b_search_rec(root, TARGET);
	if (pt){
		printf("pt->data = %d\n", pt->data);
	}
	else { printf("no luck!\n"); }
} // end main

node *new_node(void){
	node *p;

	p = (node *) malloc(sizeof(node));
	p->left = p->right = NULL;
	p->data = get_an_int(RANGE);
	return ( p );
} // end new_node

void insert_node(node **tree, node *new_coming){
	if ( *tree == NULL){
		*tree = new_coming;
		return;
	}
	// when (*tree)-> data ==  new_coming-> data) juse skip this
	// since they are identical
	if( (*tree)->data > new_coming->data ) // new_coming is smaller, so put it in left
		insert_node(&(*tree)->left, new_coming);
	else if( (*tree)->data < new_coming->data )
		insert_node(&(*tree)->right, new_coming);
} // end insert_node

int get_an_int(int r){
	int t;

        srandomdev();
	return(random() % r) ;

        t= random() % r ;
	printf("%d ", t);
        return ( t );
} // end get_an_int

void pre_order_addr(node **p){
	if (*p != NULL){
		printf("%d ", (*p)->data); 	
		pre_order_addr(&(*p)->left );
		pre_order_addr(&(*p)->right);
	}
} // end pre_order

void pre_order(node *p){
	if (p){
		printf("%d ", p->data); 	
		pre_order(p->left );
		pre_order(p->right);
	}
} // end pre_order

b_search(int n){
	node *p=root;

	while (!(p->left == NULL && p->right == NULL)){
		if (p->data == n) { break; }
		if (p->data > n) { 
			if (p->left) p=p->left;
			else break;
		}
		else 	if (p->data < n) { 
				if (p->right) p=p->right;
				else break;
			}
	}
	// leaf here
	if (p->data == n){ return 1; }
	else { return 0; }

} // end b_search

b_search_rec(node *p, int n){
	if (p == NULL){ return; }
	if ( p->data > n)
		b_search_rec(p->left, n);
	else	if( p->data < n)
			b_search_rec(p->right, n);
		else pt=p;
} // end b_search_rec
