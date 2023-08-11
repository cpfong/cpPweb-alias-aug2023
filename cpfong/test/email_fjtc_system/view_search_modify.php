<?php
$h_ref = $HTTP_REFERER;
$h_p_v = $HTTP_POST_VARS;
$h_g_v = $HTTP_GET_VARS;

$conn  = ""; // connect_db return ID
$fid   = ""; // 職號
$pid   = ""; // 身份証字號
$fid_p1= ""; // fid as a parameter

main();

function // f main
main(){

 if (!(parse_input()))		{			exit; }
 if (!(connect_db("email2")))	{			exit; }
 if (!($res = check_passwd()))	{ clean_allstuff();	exit; }
 show_results($res);
 close_db();
 view_search_modify();

} // end main

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
 global $fid_p1;

 // case insesitive
 $f = strtoupper($fid);
 $fid_p1 = $f;

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

/***********************************************************
 * view search modfy main form 
 ***********************************************************/
function // f view_search_modify
view_search_modify() {

 global $fid_p1;

echo "

<center>
<table>
<table border=1 width=50%>
<td bgcolor=#c06080 align=center><Font color=white><B>看所有人的郵件位址</B></td>
<form action=viewall.php method=POST>
       <tr><td align=center><input type=submit value='View'></tr></td>
       <tr><td align=center>All Entries In Phonebook</td>
       </form>
</table>

<table>
<table border=1 width=50%>
<td bgcolor=#8080ff align=center><Font color=white><B>找他人的郵件位址</B></td>
<form action=paccess.php method=POST>
       <tr><td align=center><input type=submit value='Search'></tr></td>
       <tr><td align=center>Search For A Listing</td>
       </form>
</table>

<table>
<table border=1 width=50%>
<td bgcolor=#608080 align=center><Font color=white><B>更動你的郵件位址</B></td>
<form action=prt_modify_form.php?fid=$fid_p1 method=POST>
       <tr><td align=center><input type=submit value='Update'></tr></td>
       <tr><td align=center>Update</td>
       </form>
</table>
";

} // end show view_search_modify

?>
