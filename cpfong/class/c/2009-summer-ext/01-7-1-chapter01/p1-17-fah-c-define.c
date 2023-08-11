#define	LOW	0
#define UP	300
#define STEP	20

#define B	32
#define RATE	5.0/9.0
main(){
	int f;
	for (f=LOW; f<=UP; f=f+STEP){
		printf("%3d %6.1f\n", f, (RATE)*(f-B));
	}
}
