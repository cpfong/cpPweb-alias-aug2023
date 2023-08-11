main(){
	struct xx {
		int no;
		char name[10];
		long sale;
		long salary;
	} e[3];

	int i;
	int sn;
	int tar=-1;

	for (i=0; i<3; i++){
		printf("input %d sales number: ", i+1); scanf("%d" , &e[i].no  );
		printf("input            name: "     ); scanf("%s" , &e[i].name);
		printf("input           sales: "     ); scanf("%ld", &e[i].sale);

		e[i].salary = 20000+e[i].sale*0.1;
	}

	printf("input sales number: "); scanf("%d", &sn);
	
	for (i=0; i<3; i++){
		if (sn == e[i].no){
			tar = i;
		}
	}

	if (tar == -1){
		printf("¤£¦s¦b\n");
	}
	else {
		printf("%d %s %ld %ld", e[tar].no, e[tar].name, e[tar].sale, e[tar].salary);
	}
/*
	printf("\n ----------------- ");
	printf("\nnumberi\tname\tsales\tsalary\n");
	for (i=0; i<3; i++){
		printf("%d \t" , e[i].no);
		printf("%s \t" , e[i].name);
		printf("%ld\t" , e[i].sale);
		printf("%ld\n" , e[i].salary);
	}
*/

}
