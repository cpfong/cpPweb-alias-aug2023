int top;
int stack[10];

main(){
	int i, t;

/* 先不看這兒
	for (i=0; i<10; i++){
		push(i); 
	}
*/
	// 放入字元 a, b, c 三個字元
	push('a'); push('b'); push('c');

	// 取出二個字元
	pop();
	t = pop();
	printf("pop out %c \n", t);
}

push(int t){
	stack[top]=t;
	printf("push %d into stack[%d]\n", t, top);
	top++;
}

pop(){
	int t;

	top--;
	t = stack[top];
	return (t);
}
