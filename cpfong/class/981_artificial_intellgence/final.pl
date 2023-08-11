/* *****************************************************************************
 Prolog Final Exercise 5 & Game of turtle turning
 studend ID: N98971124
 Author Name: 馮治平
 File Name: final.pl
 Due Day: 2010/2/5
 Version: 2010/1/25 version 1 
 note: 
 第一部份五題: 分別為題 a,b,c,d,e 每題都寫了三部份: 題目, 解答, 程式跑的結果
 第二部份一題: 放置在最後
********************************************************************************/

/* 題目 a
-------------------------------
split(L,N,LESSN,GEN).
split L into two parts: LESSN, GEN
LESSN is less than N, GEN is greater than N
split([8,6,10,3,9,12],7,L,G).
L=[6,3]
G=[8,10,9.12]
-------------------------------
*/
%%%%%%%%%% a 題程式部份如下: %%%%%%%% 
split([], _, [], []).
split([H|T], N, [H|Z], R) :- H >= N, !, split(T,N,Z,R).
split([H|T], N, R, [H|Z]) :- H  < N, split(T,N,R,Z). 

/* a 題的執行結果如下: :
?- split([-2,2,1,3,4,5,7,8,9,-3], 5,L1,L2).
L1 = [5, 7, 8, 9],
L2 = [-2, 2, 1, 3, 4, -3].
*/


/* 題目 b
-------------------------------
dotProduct(L1,L2,N)
dotProduct([1,2,3,4],[2,4,6,8],N).
N=60
-------------------------------
*/
%%%%%%%%%% b 題程式部份如下: %%%%%%%% 
dotProduct([], [], 0).
dotProduct([A|As],[B|Bs],N) :- dotProduct(As, Bs, Ns), N is Ns + (A * B). 

/* b 題的執行結果如下: :
?- dotProduct([1,2,3,4],[2,4,6,8],N).
N = 60.
*/


/* 題目 c
-------------------------------
c
merge(L1,L2,L3) (note: L1 L2 are sorted)
merge([2,4,8,16],[1,2,3,8,10],L3).
L3=[1,2,2,3,4,8,8,10,16]
-------------------------------
*/
%%%%%%%%%% c 題程式部份如下: %%%%%%%% 
merge(A,[],A).
merge([],B,B).
merge([A|Ra],[B|Rb],[A|M]) :-  A =< B, merge(Ra,[B|Rb],M).
merge([A|Ra],[B|Rb],[B|M]) :-  A > B,  merge([A|Ra],Rb,M).

/* c 題的執行結果如下: :
?- merge([2,4,8,16],[1,2,3,8,10],L3).
L3 = [1, 2, 2, 3, 4, 8, 8, 10, 16] ;
*/


/* 題目 d
-------------------------------
print out contents of sublist
[[bob ,[csc101,a],[csc203,b]],[bill,[csc203,b],[csc205,a]]].

    ?- print_lists([[bob ,[csc101,a],[csc203,b]],[bill,[csc203,b],[csc205,a]]]).
    [
        [       bob ,[csc101,a],[csc203,b]      ],
        [       bill,[csc203,b],[csc205,a]      ]
     ]

bob
csc101 a
csc203 b

bill
csc203 b
csc205 a

*/
%%%%%%%%%% d 題程式部份如下: %%%%%%%% 
portray(List) :- (List = [] ; List = [_|_]), !, print_lists(List).
print_lists(List) :- nl,print_list(List).
print_list([]). 
print_list([X]) :- !, print(X).
print_list([X|Xs]) :- !,print(X),tab(1),print_list(Xs).

/* d 題的執行結果如下: :
?- print_lists([[bob ,[csc101,a],[csc203,b]],[bill,[csc203,b],[csc205,a]]]).


bob 
csc101 a 
csc203 b 
bill 
csc203 b 
csc205 a
true.

?- 
*/



/* 題目 e
--------------------------------------
[Family1, Family2, ...]
each family has [Father, Mother, [Child1, Child2,...]]

ex:
[
	[bob,martha,[fred,jenny,phil]],
	[john,chris,[]],
	[fred,wilma,[bambam]]
]

printMothers(L) predicate that prints the name of all mothers
martha
chris
wilma

printFamilySizes(L) that print father, mother and the number of kids
bob martha 3
john chris 0
fred wilma 1
*/

%%%%%%%%%% e 題程式部份如下: %%%%%%%% 
printMothers(List) :- member(Item,List), nth_member(2,Item,_).
nth_member(1,[M|_],M) :- write(M), tab(1).
nth_member(N,[_|T],M) :- N>1, N1 is N-1, nth_member(N1,T,M).

printFamilySizes(List) :- member(Item,List), nth_member(1,Item,_), nth_member(2,Item,_), kids_in_family(1,Item,_,_).

kids_in_family(3,[M|_],M,S) :- length(M,S),write(S). 
kids_in_family(N,[_|T],M,S) :- N<3, N1 is N+1, kids_in_family(N1,T,M,S).

/* e 題的執行結果如下: :
?- printMothers([[bob,martha,[fred,jenny,phil]],[john,chris,[]],[fred,wilma,[bambam]]]).
martha 
true ;
chris 
true ;
wilma 
true ;
false.

?- printFamilySizes([[bob,martha,[fred,jenny,phil]],[john,chris,[]],[fred,wilma,[bambam]]]).
bob martha 3
true ;
john chris 0
true ;
fred wilma 1
true ;
false.

*/

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% part B: Game of Turtle Turning
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 
/* 題目
play(Game) :- 
	initialize(Game,Position,Player),
	display_game(Position,Player),
	play(Position,Player,Result).
play(Position,Player,Result) :-
	game_over(Position,Player,Result),!announce(Result).
play(Position,Player,Result) :-
	choose_move(Position,Player,Move),
	move(Move,Position,Position1),
	display_game(Position1,Player),
	next_player(Player,Player1),
	!,
	play(Position1,Player1,Result).

initialize(turning-turtle,[0,0,0,0,0,0,0,0,0,0],opponent).
display_game(Position,X) :- write(Position),nl.
game_over([1,1,1,1,1,1,1,1,1,1],Player,Player).
announce(computer) :- write('You won! Congratulations'),nl.
announce(opponent) :- write('I won'),nl.
要求把其它的 predicate 完成

答案:
------------------------------------------------------------------
本題的正確答案無法做出, 在此試著把一些想法寫出來.
想法:
	在 10 個要翻動的 turtles 中保持自已可能 win 的 status 即是
想把 turtles 的量變成奇數個, 如此則希望對手可能出錯(對方留下 turtle 
為偶數) 以勝出.
參考書: The art of prolog, author: Leon Sterling
------------------------------------------------------------------

choose_move(Position,opponent,Move) :-
	write('pls make your move'), read(Move).
choose_move(computer,Move) :-
	unsafe(Sum), safe_move(Sum,Move).
choose_move(computer,1) :-	% 任意移動
	safe().

next_player(computer,opponent).
next_player(opponent,computer).

move(M,[N|Ns],[N,Ns1]) :-
	move(M, Ns, Ns1).
move(

safe() :- not unsafe(Sum).
unsafe(Sum) :- nim_sum([],Sum), not zero(Sum).
zero([]).
zero([0|Zs]) :- zero(Zs).

save_move(NimSum, Move) :- 
	save_move(
*/
