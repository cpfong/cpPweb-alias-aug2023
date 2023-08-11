main(){
	int i, area[10];
	for (i=1; i<11; i++){
		area[i-1]=square(i);
	}
	
	for (i=0;i < 10; i++){
		printf("square side = %d, area = %d\n", i+1, area[i]);
	}
}

square(int r){
	return r*r;
}
