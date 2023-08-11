/*
source: http://wwwcgi.rdg.ac.uk:8081/cgi-bin/cgiwrap/wsi14/poplog/prolog/ploghelp/print
usage : print_list([1,2,3,[4,5],6]).
ver   : 0 為 compile ok , 但不能 run, 因為 tab 要參數之故

    print_list(List) :-
        write('('),
        print_list1(List),
        write(')').

    print_list1([X]) :- !,
        print(X).
    print_list1([X|Xs]) :- !,
        print(X),
        tab(),
        print_list1(Xs).
    print_list1([]).
*/

items_out([]).
items_out([H|T]) :- print(H),nl,items_out(T).

bob_score(List) :-
        bob_score_1(List).

bob_score_1([X]) :- !,
        items_out(X).
%	print(X).

bob_score_1([X|Xs]) :- !,
        items_out(X),
%	print(X),
        tab(1),
        bob_score_1(Xs).

bob_score_1([]).


% bob_score([1,2,3,[4,5],6]).
