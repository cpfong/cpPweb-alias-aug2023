// 定義陣列的大小

#define	N	26
int top=0;
int stack[N];

void push(int data){
	stack[top]=data;
	top++;
}

int pop(){
	top--;
	return stack[top];
}

int isFull(){
	if (top == N)
		return 1;
	else
		return 0;
}

int isEmpty(){
	if (top == 0)
		return 1;
	else
		return 0;
}

int main(){
	int d,i;
	for (i=0; i <= N; i++){
		if (!isFull())
			push(ran(26)+'A');
		// else
			// printf("Error: stack is Full\n"); 
	}

	for (i=0; i<N; i++){
		printf("%c ", stack[i]);
	}
	printf("\n");

	for (i=0; i < 2; i++){
		if (!isEmpty()){
			d = pop();
			printf("%c\t", d);
		}
		else {
			printf("\nError: stack is empty");
		}
	}

}

ran(int range){
        int ret;

        srandomdev();
        ret = random()%range;
        return (ret);
}
