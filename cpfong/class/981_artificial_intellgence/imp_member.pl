/*
we implement member ourself
member(john, [john, mary, tom)).
*/
%

my_mem(X, [X|Tail]).
my_mem(X, [Head|Tail]) :- my_mem(X, Tail).
