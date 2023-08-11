/*
if A then B else C  written as
A -> B ; C
*/
max(X,Y,Z) :- ( X=< Y -> Z=Y; Z=X ).
