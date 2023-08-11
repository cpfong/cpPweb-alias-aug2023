/*
usage:
findall(Ancestor, descend(martha, Ancestor), List_Ancestor_4_martha).
bagof(Offspring, descend(Offspring, Ancestor), List_Offspring_4_this_Anc).

comment:
descend: 遺傳, descend(X,Y) 表示 X 遺傳自 Y, 即 child(X,Y) Y 為父母, X 為孩子
因為有 descend 在其中, 所以這個會有所有子孫的味道, (一大串)
如果想只要 父,孩 的則不能使用 descend, 可以如此
bagof(Parent, child(Child, Parent), List_Parent).

findall(Object, Goal, Result_Array_Of_Object).
 
*/
%
child(martha,charlotte).
child(charlotte,caroline).
child(caroline,laura).
child(laura,rose).
%
descend(X,Y) :- child(X,Y).
descend(X,Y) :- child(X,Z), descend(Z,Y).

/*
	rose 老祖宗
	laura
	caroline
	charlotte
	martha 最新的一代
*/
