<?php
$fp = fopen("$homedir/user.txt","r+");

while($userinfo = fscanf($fp,"%s,%s,%s\n")){
	list($id,$name,$pass)=$userinfo;
	$u_id[$id]=$id;
	$u_name[$id]=$name;
	$u_pass[$id]=$pass;
}

		
	echo "$action";
	switch($action){
		//case "view":
			//echo "<TD>$id</TD><TD>$name</TD><TD>$pass</TD><TD>Edit</TD><TD><A href=index.php?action=del&uid=$id>Delete</A></TD>";
		case "del":
				//echo "$u_name[$uid] Delete OK?";
				include("$admindir/check_del.ihtml");
				exit;
		default:
			echo "<TABLE border=1>";
			echo "<TBODY>";
			echo "<TD>UserID</TD><TD>User Name</TD><TD>Password</TD><TD colspan=2>Action</TD>";
			for($i=1;$i<3;$i++){
			echo "<TR>";
			$result=ftell($fp);
			echo "<TD>$u_id[$i]</TD><TD>$u_name[$i]</TD><TD>$u_pass[$i]</TD><TD>Edit</TD><TD><A href=index.php?action=del&uid=$u_id[$i]>Delete</A></TD>";
			echo "</TR>";
				}
			echo "</TBODY>";
			echo "</TABLE>";
	
	}
		
		

//fwrite($fp,"test\n");

?>
