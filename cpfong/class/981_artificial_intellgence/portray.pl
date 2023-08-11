/* org is here
portray(List) :-
        (List = [] ; List = [_|_]), !,
        print_list(List).

print_list(List) :-
	write('('),
        print_list1(List),
	write(')').

%print_list1([X]) :- !,
print_list1([X]) :
        print(X).

%print_list1([X|Xs]) :- !,
print_list1([X|Xs]) :-
        print(X),
        tab(1),
        print_list1(Xs).

print_list1([]).
*/


% cpfong version

portray(List) :- (List = [] ; List = [_|_]), !, print_lists(List).

print_lists(List) :- write('('),print_list(List),write(')').

print_list([]). 
print_list([X]) :- !, write(X).
print_list([X|Xs]) :- !,print(X),tab(1),print_list(Xs).

%?- print_lists([1,2,3,[4,5],6]).
