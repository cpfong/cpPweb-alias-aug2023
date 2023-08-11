while (<>){
        chomp;
        my @aa=split;
        $h{$aa[2]} = ($aa[3]+$aa[4]+$aa[5])/3;
}

@b = sort {$h{$b} <=> $h{$a}} keys %h;
print "$b[0] $h{$b[0]} \n", "$b[1] $h{$b[1]} \n", "$b[2] $h{$b[2]} \n";
