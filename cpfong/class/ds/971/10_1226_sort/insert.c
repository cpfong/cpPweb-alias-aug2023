#include <stdio.h>
#include <stdlib.h>

#define RANGE	 100
#define DATAS	 15

main(){
	int i;
	int array[DATAS];

	i=0;
	while (i<DATAS){
		array[i] = get_an_int(RANGE);
		i++;
	}
	
	printf("the data are: ");
	for (i=0; i<DATAS; i++){
		printf("%d ", array[i]);
	}
	printf("\n");

	insert(array);
} // end main


int get_an_int(int r){
        srandomdev();
	return(random() % r) ;
} // end get_an_int

insert(int *p){
	int i,j, tmp;

	for (i=0; i<DATAS; i++){
		tmp=*(p+i);
		j=i;
		while (j>0 && *(p+j-1) >tmp){
			*(p+j) = *(p+j-1);
			j--;
		}
		*(p+j)=tmp;
	}

	for (i=0; i<DATAS; i++){
		printf("%d ", *(p+i));
	}
	printf("\n");
}
