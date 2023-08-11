<?php
$h_ref = $HTTP_REFERER;
$h_p_v = $HTTP_POST_VARS;
$h_g_v = $HTTP_GET_VARS;

function
main(){

 if (!($db_id = connect_db("www"))) exit;

 if (!($res = do_query($db_id))) exit;

 show_results($res);
 if (!($t = close_db($db_id))) exit;

} 

function
connect_db($dbname){ 

 if (!($id = pg_Connect("localhost", "","","",$dbname)))
    print  "pg_Connect fail <br>\n";
 else
    print  "pg_connect ok!! <br>\n";
 return ($id);

} 

function
close_db($idcl){ 

 if (!($r = pg_close($idcl)))
    print  "pg_close fail <br>\n";
 else
    print  "pg_close ok! <br>\n";
 return ($r);

}

function
do_query($id)
 {

 global $h_p_v;
 
 if ($h_p_v)
 
  {
    reset($h_p_v); $key = key($h_p_v);

    print "http_post_var[$key] = $h_p_v[$key] <br> \n";
    $t = $h_p_v[$key] . '%';


//    $pat = 'sudo_id'.',year_course_taken as year'.',needed/slected'.',course_id'.',up/down semester'.',course_credit as credit'.',score';


//    $pat = 'id' . 
//           ',year'. 
//           ',selected'.
//           ',course' .
//           ',seme' . 
//           ',credit' .
//           ',score';
            

//    $pat = 'id' . 
//           ',name'; 




//    if (!($res = pg_exec($id, "select $pat from test where id like '$t'")))
    if (!($res = pg_exec($id, "select $pat from test where name like '$t'")))
    
 

//      if (!($res = pg_exec($id, "select sudo_id,'year_course_taken as year' from test where sudo_id like '$t'")))
    



       print "pg_exec fail <br>\n";
 else
       print  "pg_exec ok! <br>\n";
    return($res);
   }

} 

function
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

} 


function
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

} 

main();

?>
