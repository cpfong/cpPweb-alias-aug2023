#define TRUE	1
#define FALSE	0
#define	SIZE	2

int top;
int stack[SIZE];
void push();

main(){
	int t, i;
	top = 0;

	push('a'); push('b'); push('c');

	for (i = 0; i < 3; i++){ 
		t = pop();
		printf("pop out %c \n", t);
	}
} // end main


void push(int t){
	if (!full()){
		stack[top]=t;
		printf("push %d into stack[%d]\n", t, top);
		top++;
	}
	else { printf("stack FULL\n"); }
	
} // end push


int pop(){
	int t;

	if (!empty()){ top--;t = stack[top];return (t); }
	else { printf("stack EMPTY\n"); }

} // end pop

int full(){
	if (top == SIZE){ return TRUE; }
	else { return FALSE; }
} // end full

int empty(){
	if (top == 0) { return TRUE; }
	else { return FALSE; }
} // end empty
