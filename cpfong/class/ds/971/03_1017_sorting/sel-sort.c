#include <stdlib.h>

main(){
	int array[20];
	int i,s;

	s = sizeof(array)/sizeof(array[0]);
	for (i=0; i<s; i++){
		array[i]=ran(100);
		printf("%d ", array[i]);
	}
	printf("\n");

	selectionSort(array, s);
}

selectionSort(int a[], int n){
	int t,m,i,j;

	for (i=0; i<n-1; i++){
		m=i;
		for (j=i+1; j<n; j++){
			if (a[j] < a[m]){
				m=j;
			}
		}
		t=a[i];
		a[i]=a[m];
		a[m]=t;
	}

	for (i=0; i<n; i++){
		printf("%d ", a[i]);
	}
	printf("\n");
}

ran(int range){
        int ret;

        srandomdev();
        ret = random()%range;
        return (ret);
}
