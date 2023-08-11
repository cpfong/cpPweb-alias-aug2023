#include <stdio.h>

// sort v[0] ... v[n-1] into increasing order 
void shellsort(int *, int);

main(){
	int i;
	int a[]={1,3,0,5,2};
	shellsort(a, sizeof(a)/sizeof(int));

	for (i=0;i<sizeof(a)/sizeof(int); i++) printf("%d ", a[i]);
	printf("\n");
}

void shellsort(int v[], int n){
	int gap,i,j,temp;

	for (gap=n/2; gap>0; gap/=2)
		for (i=gap; i<n; i++)
			for (j=i-gap; j>=0 && v[j] >v[j+gap]; j-=gap){
				temp=v[j];
				v[j]=v[j+gap];
				v[j+gap]=temp;
			}
}
