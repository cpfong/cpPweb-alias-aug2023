/*
利用 scanf 和 printf 來由 stdin 讀入二個數, 後計算
二個數的 加, 減, 乘, 除的數值
*/
main(){
        int i,j;
        printf("input2number:ex 2 3");
        scanf("%d",&i);
        scanf("%d",&j);
        printf("%d + %d=%d\n",i,j,i+j);
        printf("%d - %d=%d\n",i,j,i-j);
        printf("%d * %d=%d\n",i,j,i*j);
        printf("%d / %d=%d\n",i,j,i/j);
}
