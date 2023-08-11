/**********************************
 name  : malloc_ex1.c
 object: explain how to use malloc
 ver   : 5/28/2004 v1
 author: cpfong
***********************************/

#include "stdio.h"	// standard input/output
#define NUM	50	// total students 

struct person {		// define a personal record
	int   h;	// high
	float w;	// weight
	int age;	// age
	int seat;	// seat number
};

struct person *p;	// global pointer p

main(){			// program start here

	int i,t;

	// alloc 50 records space
	p = (struct person *)malloc(50* sizeof(struct person)); 

	for (i = 0; i < NUM; i++) {
		(p+i)->seat = i+1; 
		(p+i)->h    = rand() % 190; // less 190cm
		(p+i)->w    = rand() % 80 ; // less 80kg
		(p+i)->age  = rand() % 20 ; // less 20 years old
	} 

	for (i=0; i < 4; i++) {
		printf("seat #%d --> h=%d w=%f age=%d\n", (p+i)->seat, (p+i)->h, (p+i)->w, (p+i)->age);
	}
	
} // end main
