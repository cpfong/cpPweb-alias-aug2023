<?php

$conn  = ""; // connect_db return ID

main();

function // f main
main(){

 if (!(connect_db("email2")))	{ exit; }
 viewnow(); 
 show_results($res);

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
 * view all name
 ***********************************************************/
function // f 
viewnow(){

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

?>
