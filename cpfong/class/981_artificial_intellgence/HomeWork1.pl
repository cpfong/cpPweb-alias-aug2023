%
%name: reverse.pl
%obj:  to reverse the input list order 
%ver:  2009/11/22 cpfong N98971124
% 
% The following is the original code of printing abcde
% usage: -? print_list([a,b,c,d,e]).
%

%print_list([]).
%print_list([Head|Tail]):-write(Head),nl,print_list(Tail).

%        
% This is the reverse code of printing edcba
% usage: -? reverse_list([a,b,c,d,e]).
%
reverse_list([]).
reverse_list([LastOne]) :- write(LastOne).
reverse_list([Head|Tail]) :- reverse_list(Tail),nl,write(Head).
