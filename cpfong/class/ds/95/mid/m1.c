main(){
        struct xx{
                char name [10];
                long sale;
                long salary;
//      }e[4];
        }e[3];

        int i;
        int sn;

//      for(i=1;i<4;i++){
        for(i=0;i<3;i++){
                printf("姓名:");
                scanf("%s",&e[i].name);
                printf("銷售金額:");
                scanf("%ld",&e[i].sale);
                e[i].salary=20000+e[i].sale*0.1;
        }
        printf("輸入1,2,3其中一個：");
        scanf("%d",&sn);

	switch (sn){
		case 1:
		case 2:
		case 3:
//                	printf("%s   %ld   %ld\n",e[sn].name,e[sn].sale,e[sn].salary);
                	printf("%s   %ld   %ld\n",e[sn-1].name,e[sn-1].sale,e[sn-1].salary);
			break;
		default:
                	printf("不存在\n");
	
	}
}

