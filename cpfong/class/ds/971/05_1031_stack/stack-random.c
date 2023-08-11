// 定義陣列的大小

#define	N	5
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
			//push(i+'A');
			push(ran(10));
		else
			printf("Error: stack is Full\n"); 
	}

	for (i=0; i <= N; i++){
		if (!isEmpty()){
			d = pop();
			// printf("%c\t", d);
			printf("%d\t", d);
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
