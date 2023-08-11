@data=(100,1,3,4,2,22,9);
&insert_sort;

print "@data\n";

sub insert_sort
{
    for ($i = 1; $i <= @data-1; $i++){
        $value = $data[$i];

        $j = $i - 1;
        while ($j >= 0 and $data[$j] > $value)
        {
            $data[$j + 1] = $data[$j];
            $j = $j - 1;
        }

        $data[$j + 1] = $value;
    }
}
