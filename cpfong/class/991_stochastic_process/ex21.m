%
% Simulation of Tossing a Fair Die
%
n=100; % Num of tosses
X=ceil(6*rand(1,n));
minX=min(X);
maxX=max(X);
e=[minX:maxX+1]-0.5;
H=histc(X,e);
nbins=length(e)-1;
bin_centers=[minX:maxX];
bar(bin_centers,H(1:nbins),'w')
