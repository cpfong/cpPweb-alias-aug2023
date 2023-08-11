<html>
<head>
<title>class.tree 應用實例</title>
<?
   require ("class.tree/class.tree.php3");
   $tree = new Tree();
?>
</head>
<body>
<?
   /* 樹狀目錄的設計, 使用 PHP 與 class.tree */

   //產生根目錄

   $root  = $tree->open_tree("PHP 網頁程式百寶箱", "");

   //在根目錄上新增資料夾

   $node1 = $tree->add_folder($root, "生活資訊", "");

   //在資料夾裡面加上新的項目

   $tree->add_document($node1, "奇摩氣象", "http://weather.kimo.com.tw/");
   $tree->add_document($node1, "奇摩股市", "http://stock.kimo.com.tw/");
   $tree->add_document($node1, "台北縣電子地圖", "http://gis.tpc.gov.tw/Map/index.asp");
   $tree->add_document($node1, "即時路況", "http://road.iot.gov.tw/");
   $tree->add_document($node1, "票據資料庫", "http://www.acce.com.tw/");

   //再新增另一個資料夾 (node2), 一樣是新增在 "PHP 網頁程式設計百寶箱"
   //這個標題下, 因此 parent 還是 $root

   //點取 "PHP 優質網站" 資料夾會鍊結至 PHP 官方網站 (www.php.net)

   $node2 = $tree->add_folder($root, "PHP 優質網站", "http://www.php.net");

   //在 $node2 底下增加項目
   $tree->add_document($node2, "PHP Wizard", "http://www.phpwizard.com/");
   $tree->add_document($node2, "PHP Builder", "http://www.phpbuilder.com/");

   //最後要記得呼叫 close_tree() 這個 member function
   $tree->close_tree ( );
?>
</body>
</html>
