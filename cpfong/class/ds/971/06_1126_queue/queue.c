#define	N	6

int rear,front;
int queue[N];

void enque(int d){
	queue[rear]=d;
	rear=(rear+1)%N;
}

int deque(){
	int d=queue[front];
	front=(front+1)%N;
	return(d);
}

int isEmpty(){
	if (rear == front){
		return 1;
	}
	else {
		return 0;
	}
}

int isFull(){
	if ((rear+1)%N == front){
		return 1;
	}
	else {
		return 0;
	}
}

main(){
	int d,i;

	for (i=0;i<7;i++){
		if (!isFull()){
			enque(i+'A');
		}
		else {
			printf("Error: queue is full \n");
		}
	}

	printf("the queue after putting data is \n"); 
	for (i=0; i<N;i++){
		printf("%c\t", queue[i]);
	}

	for (i=0;i<3;i++){
		if (!isEmpty()){
			d=deque();
			printf("%c\t", d);
		}
		else {
			printf("\nError: queue is empty\n");
		}
	}
}
