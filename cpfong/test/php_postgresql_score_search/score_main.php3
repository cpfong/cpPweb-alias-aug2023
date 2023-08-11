<?php
// Name:	main.php3
// Purpost:	called by main.html, return the search result
// History:	12/3/1998 cpf	file create

/************************************************
 * global variables
 ************************************************/
$h_ref = $HTTP_REFERER  ;
$h_p_v = $HTTP_POST_VARS;
$h_g_v = $HTTP_GET_VARS ;

$inc_f1= 'db_open_close.inc';
$inc_f2= 'db_query.inc';
$inc_f3= 'db_show.inc';

$inc_fa= 'db_all.inc';

//$host_name = 'localhost';
//$db_name   = 'cpfong';

/************************************************
* include
*************************************************/
// include($inc_fa);
// include($inc_f1);
// include($inc_f2);
// include($inc_f3);

/*************************************************
 * purpose:  main control
 *************************************************/
function
main(){

// global $host_name, $db_name;
// if (!($db_id = connect_db($host_name, $db_name))) exit;

 if (!($db_id = connect_db("localhost", "www"))) exit;
 if (!(         check_pwd ($db_id))) clean_up($db_id);
 if (!($res   = do_query  ($db_id))) clean_up($db_id);
 show_results($res);
 clean_up($db_id);

} // end main

/*************************************************
 * purpose: before exit clean everything
 *************************************************/
function
clean_up($db){

 close_db($db);
 exit;

} // end clean_up 

/* **********************************************************
 * purpose : connect to the postgresql database
 * $connection = pg_Connect(host, port, options, tty, dbname)
 * **********************************************************/
function
connect_db($host, $dbname){ 

 if (!($id = pg_Connect($host, "","","",$dbname)))
    print  "pg_Connect fail <br>\n";
 return ($id);

} // end connect_db

/* **********************************************************
 * purpose : close postgresql database
 * **********************************************************/
function
close_db($id){ 

 if (!($r = pg_close($id)))
    print  "pg_close fail <br>\n";
 return ($r);

} // end connect

/* **********************************************************
 * purpose : query the database
 * **********************************************************/
function 
do_query($id) {

 global $h_p_v;
 $table = 'test';
// $table = 'ww';

 $field = 'id';

 if ($h_p_v)
   {
    reset($h_p_v); $key = key($h_p_v);
    $pat = $h_p_v[$key];

    print "table = $table filed = $field pat = $pat <br>\n";
    if (!($res = pg_exec($id, "select * from $table where $field = '$pat'")))
       print "pg_exec fail <br>\n";
    return ($res);
   }

} // end do_query

/* **********************************************************
 * purpose : Is password valid?
 * **********************************************************/
function
check_pwd($id){
  
 global $h_p_v;
 $table = 'test_pwd';
 $field = 'id';

 if ($h_p_v)
   {
    // $pat1 ==> stud_id
    reset($h_p_v); $key = key($h_p_v); $pat1 = $h_p_v[$key];
    // $pat2 ==> password
    next($h_p_v) ; $key = key($h_p_v); $pat2 = $h_p_v[$key];
    
//    print "stud_id is $pat1 <br>\n";
//    print "passwrd is $pat2 <br>\n";

    if (!($res = pg_exec($id, "select * from $table where $field = '$pat1'")))
      {
       print "in check_pwd pg_exec fail <br>\n";
       return 0;
      }
    $rows = pg_NumRows($res);
    $cols = pg_NumFields($res);

//    print "rows = $rows <br>\n";
//    print "cols = $cols <br>\n";

    if ($rows == 0) 
      {
       print "student id is not valid <br>\n";
       return 0;
      }

    $pwd = pg_result($res, 0, 1);

//  print "pwd = $pwd <br>\n";

//    if ($pwd == $pat2)  {print "password and id ok <br>\n";  return 1; }
    if ($pwd == $pat2)  { return 1; }
    print "password is not valid <br>\n";
    return 0;
   }

} // end check_pwd

/* **********************************************************
 * purpose : showing query result of postgresql database
 * **********************************************************/
function
show_results($result) {

 if ($result)
   {
     $rows = pg_NumRows($result);
     $cols = pg_NumFields($result);

     echo( "<table border=1>\n");
     /* Create the headers */
     echo( "<tr>\n");
     for ($i = 0; $i < $cols; $i++) 
         printf( "<th>%s</th>\n", pg_FieldName($result, $i));
     echo( "</tr>");
     for ($j = 0; $j < $rows; $j++)
        {
         echo( "<tr>\n");
         for ($i = 0; $i < $cols; $i++)
             printf( "<td>%s</td>\n", pg_result($result, $j, $i));
         echo( "</tr>");
        }
     echo( "</table>");
    } 
 else 
    {
     echo(pg_errormessage);
    } 

} // end show_results

print  "In PHP Now<br>\n";
main();

?>
