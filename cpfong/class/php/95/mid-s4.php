<?php

print <<< _HTML_
	<form method="post" action="mid-s4-2.php">
_HTML_;

	$a = array('¥Ò', '¤A', '¤þ', '¤B');
	print "<select name=u>";

	for ($i=0; $i < count($a); $i++){
		print "<option>$a[$i]</option>";
	}

	print "</select>";

print <<< _HTML_
		<input type="submit" value="OK">
	</form>
_HTML_;
?>
