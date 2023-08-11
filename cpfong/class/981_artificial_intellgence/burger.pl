/*
vincent like all burger but big_kahuna_burger
*/
enjoys(vincent,X) :- big_kahuna_burger(X),!,fail.
enjoys(vincent,X) :- burger(X).
% 
burger(X) :- big_mac(X).
burger(X) :- big_kahuna_burger(X).
burger(X) :- whopper(X). % 特大號的
%
big_mac(a).
big_mac(b).
big_kahuna_burger(c).
whopper(d).
whopper(e).
%
