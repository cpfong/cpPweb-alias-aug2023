/*
	§â¬Y¤@¦r¦ê¤¤¥X²{¥t¤@¦r¦êªº¦a¤è¥H index ¤è¦¡¶Ç¦^
	s = "abcd" t="c" «h¶Ç¦^ 2
	¥¼¥X²{«h¶Ç¦^ -1
*/
int strindex(char s[], char t[]){
	int i,j,k;
	
	for (i=0; s[i]!='\0'; i++){
		for (j=i, k=0; t[k] != '\0' && s[j] == t[k]; j++, k++);
		if (k>0 && t[k]=='\0')
			return i;
	}
	return -1;
}	
