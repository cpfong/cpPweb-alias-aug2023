        if (! open ID, "<id.txt") { die "cannot open $!\n"; }

        while (<ID>){
                chomp;
                @a = split;
                $h{$a[0]} = $a[1];
        }
        print "input id: \n";
        chomp($in = <STDIN>);
        print $h{$in}, "\n";
