#!/usr/bin/perl

my @parent; # data, count, mean, varience
my @par_rand; # after randomly swap
my @g5 ; # 5  as a group, there are 6 groups
my @g10; # 10 as a group, there are 6 groups

my $times=50; #rearrange the original array for how many times
my $tmp; # temp usage

sub read_in_parent_group{
	my $sum, $count, $mean;

	while (<>){ chomp;push @parent, $_; $count++; }
	$mean=arr_mean(@parent);
	$sum=arr_xi_minus_u_square($mean,@parent);
	push @parent, $count, $mean, $sum/$count;
} # end read_in

sub arr_mean{
	my @a=@_;my $s; my $c;
	foreach (@a) { $s += $_; $c++; }
	$s/$c;
} # arr_mean 

sub arr_xi_minus_u_square{
	# (Xi-u)^2
	my $m=shift @_;
	my $s;
	foreach (@_){ $s += ($m-$_) ** 2; }
	$s;
} # arr_xi_minus_u_square

sub par_mean{
	my @a=@_;
	pop @a; # skip varience
	my $m=pop@a;
} # end par_mean

sub par_var{
	my @a=@_;
	my $v=pop @a;
} # end par_var_sd

sub rand_swap_array{
	@par_rand=@_;
	foreach (1..3){ pop @par_rand; }
	my $l=@par_rand;

	foreach (1..$times*$l){
	#foreach (1..5){
		my $s=int(rand($l));my $d=int(rand($l));
		($par_rand[$d],$par_rand[$s])=($par_rand[$s],$par_rand[$d]); # swap
	} 
} # end rand_swap_array

sub form_grp{
	my @a, $i;
	my $size=shift @_;
	my $grps=6;
	my @grp;

	@grp=();
	foreach my $g (0..$grps-1){
		@a=();
		if ($size == 5){
			foreach $i (0..$size-1){ push @a, $par_rand[$size*$g+$i]; }
		}
		else{
			# 6 than 4
			foreach $i (0..$grps-1){ push @a, $par_rand[$grps*$g+$i]; }
			foreach $i (0..($size-$grps-1)){ push @a, $par_rand[int(rand(40))]; }
		}
		push @grp, arr_mean(@a);
	}
	my $m=arr_mean(@grp);
	my $s=arr_xi_minus_u_square($m,@grp);
	push @grp, $size, $m, $s/$grps-1;

	if ($size==5){ @g5=@grp; } else { @g10=@grp; }
} # end form_grp

sub grp_mean{
	my @a=@_;
	pop @a; # skip varience
	my $m=pop@a;
} # end grp_mean

sub grp_var{
	my @a=@_;
	my $v=pop @a;
} # end grp_var

read_in_parent_group;
$tmp=par_var(@parent);

print "-- parent group --\nmean=", par_mean(@parent);
print " var=", par_var(@parent);
print " sd=", (sprintf "%.2f", sqrt(par_var(@parent))), "\n";

rand_swap_array(@parent);
form_grp(5);
print "@g5\n";
print "-- g5 group --\nmean=", (sprintf "%.2f", grp_mean(@g5));
print " var=", (sprintf "%.2f", grp_var(@g5));
print " sd=", (sprintf "%.2f", sqrt(grp_var(@g5))), "\n";

form_grp(10);
print "@g10\n";
print "-- g10 group --\nmean=", (sprintf "%.2f", grp_mean(@g10));
print " var=", (sprintf "%.2f", grp_var(@g10));
print " sd=", (sprintf "%.2f", sqrt(grp_var(@g10))), "\n";
