Q:why me?
A: for dir http://cpfong.github.iso

2020.10.05 copy all file from /usr/local/www/apache24/data 

server
--
go to web GUI and create new repo call cpfong.github.io (must use cpfong) , public and no README

https://learntocodewith.me/tutorials/github-pages/
client
--
git init 
git add . 
git commit -m "2020oct5 move2 github"
git remote add origin ssh://git@github.com/cpfong/cpfong.github.io.git
git push -u origin master 
# git push origin
