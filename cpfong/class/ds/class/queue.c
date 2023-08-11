#define SIZE 5	// queue size is 5

int front, rear;// push in queue[++rear], pop out from queue[++front]
int queue[SIZE];// array to save queue

void push(int );// push only integer  
int  pop (void);// pop does not pass in any parameter
void pall(void);// print all queue content out

main(){		// main program start here
	init() ;
	push(1);
	push(2); 
	pop()  ;
	pall() ;
} // end main

init(){		// initialize all variables and queue
	int i;
	front=-1;
	rear =-1;
	for (i=0; i < SIZE; i++){
		queue[i] = -1;
	}
} // end init

void push(int t){
	if (front == (rear+1) % SIZE){
		printf("full\n");
		exit(1);
	}
	else {
		rear = (rear+1) % SIZE;
		queue[rear] = t;
	}
} // end push

int pop(){
	if (front == rear) {
		printf("empty\n");
		exit(1);
	}
	front = (front+1) % SIZE;

	queue[front]=-1;
	return (queue[front]);
} // end pop

void pall(){
	int i;

	for (i=0; i < SIZE; i++){
		printf("%d ", queue[i]);
	}
	printf("\n");

} // end pall
