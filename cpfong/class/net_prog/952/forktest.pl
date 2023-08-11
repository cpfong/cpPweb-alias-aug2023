#!/usr/bin/perl

$sum = 0;
defined(my $child_pid=fork) or die "cannot fork : $!";
unless ($child_pid){
	#child process
	exec "date";
	die "cannot execute date $!";
}

#               Waits for a particular child process to terminate and returns
#               the pid of the deceased process
#parents process 
print "before waitpid ";
waitpid($child_pid, 0);
print "after waitpid ";

