children(c,a).
children(b,a).
children(d,a).
children(g,c).
children(f,b).
children(e,b).
children(h,e).
haschild(X) :- children(X,_).
