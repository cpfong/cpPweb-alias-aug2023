以下的全在 cmd mode 下跑的, 直接放入即可 run

/*
說明:
	[1,2] 先入 Y 再進行 member(X,Y) , Y 分別為 [1,2] 及 [3,4]
	step 1: member(X,[1,2]) -> X=1
	step 2: member(X,[1,2]) -> X=2
	step 3: member(X,[3,4]) -> X=3
	step 4: member(X,[3,4]) -> X=4
*/
% returns X=1,X=2,X=3,X=4 successively
?-member(Y,[[1,2],[3,4]]),member(X,Y).

/*
	步驟同上, ! 在此表示前面那個 process 只要成功一次即 cut 掉,
	所以 Y=[1,2] 後即停不走 [3,4]
	! 對於後面的 member(X,Y) 沒有影響, 所以 member(X,[1,2])
	全會完成, 即 X=1 , X=2
*/
% returns X=1, X=2 successively
?-member(Y,[[1,2],[3,4]]),!,member(X,Y).

/*
	步驟同上, ! 在此表示前面那個 process 只要成功一次即 cut 掉,
	所以 Y=[1,2] 後也會走 [3,4], 但是 member(X,Y) 只能跑一次
	所以 Y=[3,4] 也沒機會

	! 會讓 member(X,Y) 只跑一次, 所以 member(X,[1,2]) 只有
	X=1 會完成, X=2 無法做而 Y=[3,4] 也沒法做下去.
*/
% returns X=1 only
?-member(Y,[[1,2],[3,4]]),member(X,Y),!.

/*
	只對前有影響, 所以這個 cut 有放等於沒放
*/
% returns X=1,X=2,X=3,X=4 successively
?-!,member(Y,[[1,2],[3,4]]),member(X,Y).
