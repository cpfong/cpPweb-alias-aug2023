<html>
<head>
<title>浮動視窗實作</title>
</head>
<body>
<?
   include ("class.overlib/class.overlib.php3");
   $ol = new Overlib;

   $ol->ol_backcolor = "#111166";
   $ol->init();
?>
<br><br><br><br><br>
<a href="/~jollen/work/class.overlib/" <? echo $ol->over ("PHP 網頁程式百寶箱",
"這是一個浮動視窗!!");?>><font color="#C8C8FF">請按我</font></a>

</body>
