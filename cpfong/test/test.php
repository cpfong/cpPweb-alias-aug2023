<?php
	$pid ='a123032958';
        $id  = strtoupper($pid);
        $left= substr($id, 1, 10);
        $ch  = $id{0};

	echo "ch = $ch <br>";
	echo "left = $left <br>";

        switch ($ch) {
                case E:
                        $t='1';
                        break;
                case S:
                        $t='2';
                        break;
                case T:
                        $t='3';
                        break;
                case R:
                        $t='4';
                        break;
                case D:
                        $t='5';
                        break;
                case A:
                        $t="6";
                        break;
                case B:
                        $t='7';
                        break;
                case G: case H: case C: case F: case Y: case O:
                        $t='8';
                        break;
                case U: case V: case W: case X: case Z: case Q:
                        $t='9';
                        break;
                case I: case J: case K: case L: case M: case N: case P:
                        $t='0';
                        break;
        }
        $tt = (string)$t .  (string)$left;
//        $tt = "test" . "xyz123";
	echo $tt;
?>
