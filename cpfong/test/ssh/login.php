<?php
session_start();

if($check){
	if(!$userid){
		$erry="not userid";
	}else{
		$fp = fopen("user.txt","r");
			while($userinfo = fscanf($fp,"%s\t%s\t%s\n")){
				list($u_id,$u_name,$u_pass)=$userinfo;
				if($u_name  == $userid && $u_pass == $password){
					$auth['loginID']=$userid;
					$auth['login']=1;
					session_register("auth");
					header("Location: $webroot");
							
				}
			}
		}
}
	
	
include("login.ihtml");
?>
