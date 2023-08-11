#include <stdio.h>

int binsearch(int, int *, int); 
main(){
	int a[]={1,2,3,4};
	int index;
	
	index=binsearch(2,a,sizeof(a)/sizeof(int));
	if (index == -1) printf("NOT found\n");
	else printf("a[%d]= %d \n", index, a[index]);
}

int binsearch(int x, int v[], int n){
	int low, high, mid;

	low=0;
	high=n-1;

	while (low <= high){
		mid=(low+high)/2;
		if (x < v[mid]) high=mid-1;
		else if (x > v[mid]) low=mid+1;
		else return mid;
	}
	return -1;
}
