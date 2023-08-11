#define MAXVAL 100

int sp = 0;
float val[MAXVAL];
void liststack();

void push(float f){
	if (sp < MAXVAL){
		val[sp++] = f;
	}
	else {
		printf("error: stack full\n");
	}
}

float pop(void){
	if (sp > 0){
		return val[--sp];
	}
	else {
		printf("error: stack empty\n"); 
		return 0.0;
	}
}

main(){
	int i;

	push(1); push(2);liststack();
	pop()  ;liststack();
}

void liststack(){
	int i;
	for (i=0; i < sp; i++){
		printf ("%2.1f ", val[i]);
	}
	printf("\n");
}
