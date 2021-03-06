/*David Schirduan 12-7-11 Homework 10*/

/* program 1 - maximum*/
maximum([A],A).
maximum([A|List],Max):-
 maxList(List,Max1),
 (A>=Max1, Max=A; A<Max1, Max=Max1).


/*program 2 - intersection*/
intersection([X|Y],Z,[X|D]):-member(X,Z),intersection(Y,Z,D).
intersection([X|Y],Z,D):- \+member(X,Z),intersection(Y,Z,D).
intersection([],Z,[]).

/*program 3 - union*/

union(List1, [Head2|Tail2]) :- union(append(List1, Head2),Tail2).

/*program 4 - last*/
last([Car|[]], Car). /*return the head when the tail is empty list*/
last([Car|Cdr], A):- last(Cdr, Car).


/*program 5 - nonMember*/
nonMember(Atom, [Atom|Tail]):- false.
nonMember(Atom, [Head|[]]) :- true.
nonMember(Atom, [Head|Tail]):- nonMember(Head, Tail).


/*program 6 - fib*/
fib(0,1).
fib(1,1).
fib(A,B) :- A > 1, A1 is A - 1, A2 is A - 2, fib(A1,B1), fib(A2,B2), B is B1 + B2.

/*program 7 - */


/*program 8 - edge*/




