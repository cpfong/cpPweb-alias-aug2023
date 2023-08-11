#define SIZE 5		// 堆疊的大小
int stack[SIZE];	// 宣告一陣列大小為 5 可以放 5 個整數
int top=0;		// 堆疊最上指標 (內容為空)

// 主程式開始
main(){

	int t;
	int i=1;

	// 先放入六個數至堆疊, 分別為 1 2 3 4 5 6 
	for (i=1; i <= 6; i++){
		push(i);
	}

	// 叫用 pop 三次以取出三個數, 且印出來
	for (i=1; i <= 3; i++){
		t= pop(); printf(" %d \n", t);
	}

	push(7); // 放入 7

	for (i=1; i <= 6; i++){
		t= pop();
		if (t != -1){
			printf(" %d \n", t);
		}
	}


} // 主程式結束

// push 副程式, 用來把內容推入堆疊中
push(int t){

	if (top == SIZE) {
		// 我不能再裝了, 因為已滿了
		printf("%d 放不下因為滿了 \n", t);
	}
	else {
		// 尚有空位
		stack[top] = t;
		top++;
	}

} // end push

// 取出的副程式, 用來把內容取出
int pop(void){
	int t;

	if (top == 0) {
		// 堆疊內容已空
		printf(" 空了 \n");
		return(-1);
	}
	else {
		return stack[--top];
	}

} // end pop
