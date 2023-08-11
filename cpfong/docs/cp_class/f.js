<script type="text/javascript">
 function cpfunc(){
  document.getElementById("deviceID").style.color = "red";
  var tID=document.getElementById("deviceID").value
  var url="http://webduino.io/device/" + tID
  location.href=url
  return true
 }
</script>
