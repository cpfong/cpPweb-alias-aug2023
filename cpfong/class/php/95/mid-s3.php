<?php
	$a = array('¥Ò', '¤A', '¤þ', '¤B');
	print "<select name=season>";

	for ($i=0; $i < count($a); $i++){
		print "<option>$a[$i]</option>";
	}

	print "</select>";

?>
