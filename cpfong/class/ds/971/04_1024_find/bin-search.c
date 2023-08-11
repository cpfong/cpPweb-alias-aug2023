#include <stdlib.h>

int array[10];
main(){
	int i,s,target,index, range;

	range=20;

	s=sizeof(array)/sizeof(array[0]);
	for (i=0;i<s;i++){
		array[i]=ran(range);
		printf("%d ", array[i]); 
	}

	target=5;
	selectionSort(s);
	index = binSearch(s, target);
	if (array[index] == target){
		printf("bingo\n");
	}
	else {
		printf("%d does not exist\n", target);
	}
}

int binSearch (int n, int x){
	int mi, lo=0, hi=n-1;

	while (lo<=hi){
		mi=(lo+hi)/2;
		if (array[mi] == x){
			return(mi);
		}
		else {
			if(x <array[mi]){
				hi=mi-1;
			}
			else{
				lo=mi+1;
			}
		}
	}
	return (-1);
} 

ran(int range){
        int ret;

        srandomdev();
        ret = random()%range;
        return (ret);
}

selectionSort(int n){
        int t,m,i,j;

        for (i=0; i<n-1; i++){
                m=i;
                for (j=i+1; j<n; j++){
                        if (array[j] < array[m]){
                                m=j;
                        }
                }
                t=array[i];
                array[i]=array[m];
                array[m]=t;
        }
}
