#define	N	100
int queue[N];
int front=N-1,rear=N-1;

void add(int d){
	if (front == (rear+1)%N){
		printf("full\n");
		exit(1);
	}
	rear = (rear+1)%N;
	queue[rear]=d;
} 

int delete(){
	if (front == rear){
		printf("empty\n");
		exit(1);
	}
	front = (front+1)%N;
	return(quene[front]);
}

main(){
	int d,loop=1;
	char input[7];
	
	printf("
}
