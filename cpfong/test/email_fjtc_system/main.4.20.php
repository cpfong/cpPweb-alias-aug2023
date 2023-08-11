<?php
$h_ref = $HTTP_REFERER;
$h_p_v = $HTTP_POST_VARS;
$h_g_v = $HTTP_GET_VARS;

$fid   = ""; // 職號
$pid   = ""; // 身份証字號

// fid or pid been forgot
$errormessage="<br><br><b>Oops! 你可能忘了打職號或身份証字號!</b><br>";

function main(){

 if (!(parse_input()))                 exit; 
 if (!($db_id = connect_db("email2"))) exit;
 if (!($res   = check_passwd($db_id))) clean_allstuff($db_id);
 show_results($res);
 modify($db_id);
 if (!($t = close_db($db_id)))        exit;

} // end main

function modify ($db_id) {

 print_out_edit_form($db_id);
 update_email($db_id);

} // end modify

function print_out_edit_form($dbid) {

 global $fid  ; // 職號

 // case insesitive
 $f = strtoupper($fid);

 $sql = "SELECT pname,email FROM email WHERE fid = '$f'";
 $res = pg_exec($dbid, $sql);

 $pos  = pg_result($res, 0, "pname");
 $pos2 = pg_result($res, 0, "email");

 echo "<table>";
 echo "<form method='POST'>";
 echo "<form action='modify.php3' method='POST'>";
 echo "<tr><td>姓名: <td>$pos";
 echo "<tr><td>Email:<td><input type='Text' size=30 value= '$pos2'>";
 echo "<tr><td><input type='submit' value='Update'";
 echo "</form>";
 echo "</table>";

} // end print_out_edit_form

function update_email($dbid) {

 global $fid  ; // 職號

 // case insesitive
 $f = strtoupper($fid);
 $sql = "SELECT pname,email FROM email WHERE fid = '$f'";
 $res = pg_exec($dbid, $sql);

 $pos2 = pg_result($res, 0, "email");

 $sql = "UPDATE email set email = '$pos2';";
 $res = pg_exec ($dbid, $sql);

} // end update_email

function connect_db($dbname){ 

 print  "in pg_connect<br>\n";

 if (!($id = pg_connect ("localhost", "","","",$dbname))) 
    print  "<br>\n pg_connect fail <br>\n";
 else
    print  "<br>\n pg_connect $dbname ok!! <br>\n";
 return ($id);

} // end connect_db

function clean_allstuff($idcl) {

 close_db($idcl);

} // end clean_allstuff

function close_db($idcl){ 

 if (!($r = pg_close($idcl)))
    print  "pg_close fail <br>\n";
 else
    print  "pg_close ok! <br>\n";
 return ($r);

} // end close_db

function parse_input(){ 

 global $h_p_v;
 global $fid  ; // 職號
 global $pid  ; // 身份証字號
 global $errormessage;

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

function check_passwd($dbid){

 global $fid  ; // 職號
 global $pid ; // 身份証字號

 // case insesitive
 $f = strtoupper($fid);

 $sql = "SELECT pid,pname FROM pinfo WHERE fid = '$f'";
 $res = pg_exec($dbid, $sql);

 if (!($res)) {
    print "Not a valid connection <br>\n";
    retur (FALSE);
 }
 $rows = pg_NumRows($res);
 if ($rows == 0) {
    print "職號錯了! <br>\n";
    return (FALSE);
 }
// print "職號 ok!<br>\n";

 // password checking CAP already
 $rr = pg_result($res, 0, 0);

 // case insesitive
 $s  = strtoupper($pid);
 $r2 = strcmp($rr, $s); 

 print "rr is $rr \n";
 print "s is $s \n";

 if (!($r2)){
    print "<br>\n身份証字號 ok!<br>\n";
    return ($res);
 }
 else {
    print "身份証字號錯了 <br>\n";
    return (FALSE);
 }

} // end check_passwd


function show_table($id){ 

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


function show_results($result) {

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

main();

?>
