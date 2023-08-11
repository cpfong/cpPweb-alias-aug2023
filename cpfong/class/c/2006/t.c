#include "stdio.h"
main(){
        int i,c;
        int a[6];
        char b[]="abcde";

        for (i=0; i<6;i++){
                a[i]=0;
        }       

        while ((c=getchar()) != EOF){

			printf("%d %d\n", c , 'a');

                        if(c >= 'a' && c <= 'e'){
                                ++a[c-'a'];
                        }
                        else {
//                                if (c != '\n') { ++a[5]; }
                               ++a[5];
                        }
        }       

        for (i=0; i<5;i++){
                printf("%c \t %d \n", b[i], a[i]); 
        } 
        printf("%s \t %d\n", "other", a[5]); 
}
