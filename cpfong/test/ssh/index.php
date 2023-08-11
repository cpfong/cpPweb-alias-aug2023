<?php

#             You have to write "URL".             #
####################################################

// $webroot ="http://URL of This program ";
// $homedir ="/ Path of This Directory";
$webroot ="http://www.fjtc.edu.tw/~cpfong/test/ssh/index.php";
$homedir ="http://www.fjtc.edu.tw/~cpfong/test/ssh";

####################################################


$admindir = "$homedir"."/admin";
$toppage="top.ihtml";


session_start();

if(!isset($auth)){
	$auth=array();
	session_register("auth");
}

// This is logout process

if($page == "logout"){
	$auth['loginID']="";
	$auth['login']="";
	header("Location: $webroot");

}

// This is login process

if($auth['login']){
	$homepage=$login;

	if(!$page){
		$homepage=$toppage;
	}else{
		$homepage="$page".".ihtml";
	}

	if($auth['loginID'] == "admin"){
		require("$admindir/$homepage");
	}else{
		
		require("$homepage");
	}

}else{
	$homepage=$login;
	include("login.php");
}
	

?>
