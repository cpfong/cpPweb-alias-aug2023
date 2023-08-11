%last_name = ( 
	'John'   => 'Chen',
	'Jack'   => 'Chou',
	'Daniel' => 'Eng');

print "input name: "; chomp($n=<>);
$last_name=$last_name{$n} || "no last name";

print $last_name, "\n";
