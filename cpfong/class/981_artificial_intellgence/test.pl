/*
portray(List) :- (List = [] ; List = [_|_]), !, print_lists(List).

print_lists(List) :- write('('),print_list(List),write(')').

print_list([X]) :- !,print(X).
print_list([X|Xs]) :- !,print(X),tab(1),print_list(Xs).

%    ?- print_lists([[bob ,[csc101,a],[csc203,b]],[bill,[csc203,b],[csc205,a]]]).
%    [
	[	bob ,[csc101,a],[csc203,b]	],
	[	bill,[csc203,b],[csc205,a]	]
     ]
*/

takeout(X,[X|R],R).
takeout(X,[F|R],[F|S]) :- takeout(X,R,S),!.

%bob(L) :- !, member(Y,L),member(X,Y). 

listsplit([H|T],H,T).
