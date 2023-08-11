/*
usage:
setof(Person, age(Person, Age), List_Persons_At_Certain_Age).
想要把 13 的全聚一起則可以使用 setof

findall(Person, age(Person, Age), All_Age_Persons).
在 age 的例子中使用 findall 變得較沒意義, 它只是一個大集合而己
*/
age(harry,13).
age(draco,14).
age(ron,13).
age(hermione,13).
age(dumbledore,60).
age(hagrid,30).
age(ron,13).
