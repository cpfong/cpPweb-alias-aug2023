main(){
        int i,sum;
        i = 1;
        printf("I am john\n");
        printf("i=%d",i);
        for (i=0;i<10;i++){
                printf("i=%d\n",i);
        }
        for(i=0,sum=0;i<11;i++){
                sum=sum+i;
        }
        printf("sum = %d", sum);
        for(i=0,sum=0;i<11;i++){
                if(i % 2 ==1){
                        sum = sum + i;
                }
        }
        printf("sum=%d", sum);
}
