parent(tom, jim).
parent(jim, gus).
parent(jim, pam).
parent(pam, pat).
parent(pam, jan).
parent(liz, ann).
parent(ann, jon).
parent(ann, bob).
parent(jon, pat).
parent(jon, jan).
female(pam).
female(pat).
female(liz).
female(ann).
female(jan).
male(tom).
male(jim).
male(gus).
male(jon).
male(bob).
mother(X,Y):-parent(X,Y),female(X).
