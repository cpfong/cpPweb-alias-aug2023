<html>
<?php
$h_ref = $HTTP_REFERER;
$h_p_v = $HTTP_POST_VARS;
$h_g_v = $HTTP_GET_VARS;

$conn  = ""; // connect_db return ID
$fid   = ""; // 職號
$pid   = ""; // 身份証字號

main();

function // f main
main(){

 if (!(parse_input()))		{			exit; }
 if (!(connect_db("email2")))	{			exit; }
 if (!($res = check_passwd()))	{ clean_allstuff();	exit; }
 show_results($res);
 print_out_edit_form();

} // end main

/***********************************************************
 * print out the edit form to edit email
 ***********************************************************/
function // f print_out_edit_form
print_out_edit_form() {

 global $conn;
 global $fid  ; // 職號

 // case insesitive
 $f = strtoupper($fid);

 $sql = "SELECT pname,email FROM email WHERE fid = '$f'";
 $res = pg_exec($conn, $sql);

 $pos  = pg_result($res, 0, "pname");
 $pos2 = pg_result($res, 0, "email");

 close_db();

 echo "
	<table>
	<form action=modify.php?fid=$f method=POST>
	<tr><td>姓名: <td>$pos
	<tr><td>Email:<td><input type=Text name=par_two size=30 value= $pos2>
	<tr><td><input type=Submit value=Update>
	</form>
	</table>
 ";

} // end print_out_edit_form

/***********************************************************
 * connect the database
 ***********************************************************/
function  // f connect_db
connect_db($dbname){ 

 global $conn;

// print  "in pg_connect<br>\n";

 if (!($conn = pg_connect ("localhost", "","","",$dbname))) {
    print  "<br>\n pg_connect fail <br>\n";
    return (FALSE);
   }
 else {
//  print  "<br>\n pg_connect $dbname ok!! <br>\n";
    return (TRUE);
   }

} // end connect_db

/***********************************************************
 * clean tmp stuff
 ***********************************************************/
function // f clean_allstuff
clean_allstuff() {

 global $conn;

 close_db($conn);

} // end clean_allstuff

/***********************************************************
 * close the databse
 ***********************************************************/
function // f close_db
close_db(){ 

 global $conn;

 if (!($r = pg_close($conn)))
    print  "pg_close fail <br>\n";
 else
//    print  "pg_close ok! <br>\n";
 return ($r);

} // end close_db

/***********************************************************
 * get the user input 1.fid 2. pid
 ***********************************************************/
function // f parse_input
parse_input(){ 

 global $h_p_v;
 global $fid  ; // 職號
 global $pid  ; // 身份証字號

 reset($h_p_v);
 $t = key($h_p_v) ; $fid = $h_p_v[$t]; 

// print "fid is $fid <br>\n";

 reset($h_p_v);
 next($h_p_v); $t = key($h_p_v);
 $pid="";
 $pid= $h_p_v[$t]; 

// print "pid is $pid <br>\n";

 if ($fid == "" || $pid == ""){
    print "Oops! 你可能忘了打職號或身份証字號!<br>\n";
    return (0);
 }
 else {
    return (1);
 }

} // end parse_input

/***********************************************************
 * is password ok?
 ***********************************************************/
function // f check_passwd
check_passwd(){

 global $conn;
 global $fid  ; // 職號
 global $pid ; // 身份証字號

 // case insesitive
 $f = strtoupper($fid);

 $sql = "SELECT pid,pname FROM pinfo WHERE fid = '$f'";
 $res = pg_exec($conn, $sql);

 if (!($res)) {
    print "Not a valid connection <br>\n";
    retur (FALSE);
 }
 $rows = pg_NumRows($res);
 if ($rows == 0) {
    print "可能是職號錯了! <br>\n";
    print "如果您確定職號 (ex T01001) 是正確的, 請洽技合處馮治平 2820 <br>\n";
    return (FALSE);
 }

 // password checking CAP already
 $rr = pg_result($res, 0, 0);

 // case insesitive
 $s  = strtoupper($pid);
 $r2 = strcmp($rr, $s); 

/*
 print "rr is $rr \n";
 print "s is $s \n";
*/

 if (!($r2)){
//   print "<br>\n身份証字號 ok!<br>\n";
    return ($res);
 }
 else {
    print "可能是身份証字號錯了 <br>\n";
    print "如果您確定身份証 (ex a123032xxx ) 是正確的, 請洽技合處馮治平 2820 <br>\n";
    return (FALSE);
 }

} // end check_passwd

/***********************************************************
 * show the table
 ***********************************************************/
function // f show_table
show_table($id){ 

 global $h_p_v;
 
 if ($h_p_v)
   {
    reset($h_p_v); $key = key($h_p_v);
    print "http_post_var[$key] = $h_p_v[$key] <br> \n";
    $t = $h_p_v[$key] . '%';
    if (!($res = pg_exec($id, "select * from test where stud_id like '79151130'")))
       print "pg_exec1 fail <br>\n";
 else
       print  "pg_exe1c ok! <br>\n";
    if (($num = pg_numRows($res)) == -1)
       print "select from test fail <br> \n";

    for ($i = 0; $i < $num; $i++)
       {
        echo pg_result($res, $i, "name");
        echo "\n";
        echo ("<BR>");
       }  

   }

} // end show_table

/***********************************************************
 * show the result
 ***********************************************************/
function // f show_results
show_results($result) {

 if ($result)
   {
     $rows = pg_NumRows($result);
     $cols = pg_NumFields($result);

     echo( "<table border=1>\n");
     echo( "<tr>\n");
     for ($i = 0; $i < $cols; $i++) {
         printf( "<th>%s</th>\n", pg_FieldName($result, $i));
        }
     echo( "</tr>");
     for ($j = 0; $j < $rows; $j++) {
         echo( "<tr>\n");
         for ($i = 0; $i < $cols; $i++) {
             printf( "<td>%s</td>\n", pg_result($result, $j, $i));
            }
         echo( "</tr>");
        }
     echo( "</table>");
    } 
 else
   {
     echo(pg_errormessage);
    } 

} // end show_results

?>
</html>
