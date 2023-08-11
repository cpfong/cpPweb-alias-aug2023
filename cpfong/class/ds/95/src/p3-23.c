#define N 80

char stack  [N];
char infix  [N];
char postfix[N];
int  top = -1;

void push(char d){
	if (top == N-1){
		printf("stack full\n");
		exit(1);
	}
	top++;
	stack[top]=d;
}

char pop(){
	char c;
	if (top == -1){
		printf("stack is empty\n");
		exit(1);
	}
	c = stack[top];
	top--;
	return(c);
}

int p(char d){
	switch (d){
		case '*':
		case '/': return 2;
		case '+':
		case '-': return 1;
		default : return 0;
			
	}
}

void infix_to_postfix(){
	char token;
	int i=0, j=0;

	while ((token = infix[i++]) != '\0'){
		switch (token){
			case '(': 
				push(token);
				break;
			case ')':
				while ( stack[top] != '(' ){
					postfix[j++] = pop();
				}
				pop();
				break;

			case '+':
			case '-':
			case '*':
			case '/':
				while ( (top != -1) && (p(stack[top]) >= p(token)))
					postfix[j++]=pop();
				push (token);
				break;
			default:
				postfix[j++]=token;
		}
	}
	while (top != -1)
		postfix[j++]=pop();
}

main(){
	printf("input");
	scanf("%s", infix);
	infix_to_postfix();
	printf("result = %s\n", postfix);
}
