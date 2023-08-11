@a=(2,3,4,5,8,0,1,7);
@t=@a;
&bubble;

print @a;
sub bubble{
	for ($i=0; $i<@a-2;$i++){
		for ($j=0; $j<@a-$i-1;$j++){
			if ($a[$j] > $a[$j+1]){
				($a[$j],$a[$j+1])=($a[$j+1],$a[$j]);
			}
		}
	}
}
