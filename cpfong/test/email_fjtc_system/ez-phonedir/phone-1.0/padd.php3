<html><head><title>EZ Phone Directory</title></head>
<body bgcolor=white link=blue alink=CC9966 vlink=purple>
<font color=black>
<center>
<a href=http://matrix.linux-help.org><img src=phone.gif border=0 alt="Home Page For EZ Phone Directory"></a><img src=title.gif>
<table>
<table border=0 width=100%>
<tr><th bgcolor=#608080 align=center><font color=white><font size=4>Add New Listing</font></th></tr>
<tr><td>&nbsp</tr></td>
<tr><td align=center><font color=red>*</font> Is Required Input Fields</td></tr>
</table>
<table border=0>
<form action="addphone.php3" method="GET">
       <tr><th align=left>Personal Information
       <tr><td align=right><font color=red>*</font>First: <input type="text" name="first" VALUE="">
       <td align=right><font color=red>*</font>Last: <input type="text" name="last" VALUE="">
       <td align=right>Nick Name: <input type="text" name="nick" VALUE="">
       <tr><td align=right>Area Code: <input type="text" name="area" VALUE="">
       <td align=right>Phone: <input type="text" name="phone" VALUE="">
       <td align=right>Address: <input type="text" name="address" VALUE="">
       <tr><td align=right>City: <input type="text" name="city" VALUE="">
       <td align=right>State: <input type="text" name="state" VALUE="">
       <td align=right>Zip: <input type="text" name="zip" VALUE="">
       <tr><td align=right>Country: <input type="text" name="country" VALUE="">
       <tr><td>&nbsp
       <tr><td>&nbsp
       <tr><th align=left>Contact Information
       <tr><td align=right>Company: <input type="text" name="company" VALUE="">
       <td align=right>Title: <input type="text" name="title" VALUE="">
       <td align=right>Department: <input type="text" name="dept" VALUE="">
       <tr><td align=right>Fax: <input type="text" name="fax" VALUE="">
       <td align=right>Workphone: <input type="text" name="workphone" VALUE="">
       <td align=right>Cellphone: <input type="text" name="cellphone" VALUE="">
       <tr><td align=right>Pager: <input type="text" name="beeper" VALUE="">
       <td align=right>Email: <input type="text" name="email" VALUE="">
       <tr><td colspan=3 align=left>Home Page: <input type="text" size=60 name="url" VALUE="">
       <tr><td colspan=3 align=left>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<font color=red>Use Full URL example http://matrix.linux-help.org</font>
       <tr><td>&nbsp
       <tr><td>&nbsp
       <tr><th align=left>Special Occassions
       <tr><td align=right>Birthday: <input type="text" name="birthday" VALUE="">
       <td align=right> Anniversay: <input type="text" name="anniversary" VALUE="">
       <td align=right> Spouse: <input type="text" name="spouse" VALUE="">
       <tr><td colspan=3 align=center><font color=red>For Birthday and Anniversary Fields Use Format Mon/Day example: Oct 27</font>
       <tr><td>&nbsp
       <tr><td>&nbsp
       <td><input type=hidden name=uid value='$pos17'>
       <tr><th align=left>Additional Notes:
       <tr><td colspan=3 align=center>Notes: <TEXTAREA ROWS=7 COLS=70 name=notes WRAP=virtual></TEXTAREA>
       <tr><th colspan=3 align=center><font color=#c06080><input type=submit value='Add New Listing'></font>
       </form>
       </table>
</center></html>
