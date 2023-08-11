<?php
/* 
Bug #12345
substr() bug. Do not return expected string.

ACTUAL OUTPUT
XYXA

EXPECTED OUTPUT
ABCD
*/

$str = "XYZABCD";
echo substr($str,3,7);

?>
