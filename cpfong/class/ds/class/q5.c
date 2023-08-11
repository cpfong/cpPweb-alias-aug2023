main(){
        // add ten number

        int i; 
        int sum=0;
	int size=10;

        int arr[]={1,2,3,4,5,6,7,8,9,10};

        for (i=0; i < size; i++) {
                sum += arr[i];
        }
        printf("add 1 to 10  = %d\n", sum);
}
