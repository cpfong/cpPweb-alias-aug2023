/*

[a, b, c, d] 可以用 .(Head, Tail) 來表示, 這個表示法很像 binary tree
的前序表示法, 即 . 為一個 funct 有 add(a,b) 的 add 味道在
 
也可以用 [H|T] 來表示
*/
%

likes(john, [walking, tennis, climbing]).
likes(mary, .(swimming, .(golf, []))).

% query 時使用 likes(john, .(H,T)). 也可用 likes(mary, [H|T]).

print_list([]).
print_list(.(H,T)) :- nl, write(H), print_list(T).

reverse_list(.(Last,[])) :- write(Last).
reverse_list([H|T]) :- reverse_list(T),nl, write(H).
