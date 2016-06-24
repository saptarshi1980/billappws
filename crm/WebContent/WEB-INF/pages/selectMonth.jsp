<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<html>
<head>
<title>The Durgapur Projects Limited</title>

   <script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
<script src="js/jquery.mtz.monthpicker.js"></script>

  	<meta charset="utf-8">
    
  <script>
  $(document).ready(function() {
	  $('#monthpicker').monthpicker();

	});
  </script>
  <style>
div.header {
    background-color:#5882FA;
    color:white;
    margin:20px;
    padding:20px;
} 

div.footer {
    background-color:#5882FA;
    color:white;
    margin:20px;
    padding:20px;
} 
.style1 {
	font-size: medium;
	font-weight: bold;
}
.style2 {
	color: #000000;
	font-weight: bold;
}
  </style>
</head>
<body>
<div align="center"><img src="images/logo_blue.jpg" /></div><br>
 
 <table width="427" border="2" align="center" cellpadding="2" bgcolor="#5882FA">
   <tr>
     <td width="415"><div align="center" class="style2">New Connection Application Portal for Sub-Station, DPL</div></td>
   </tr>
 </table>
<div align="center">
  <p>&nbsp;</p>
 
</div>
<blockquote><blockquote><form name="form1" method="post" action="ApplicationList.dpl">
<table width="298" border="2" align="center" cellpadding="2">
         
         <tr>
           <td width="284">Select Month :
           <input name="monthpicker" type="text" id="monthpicker"></td>
         </tr>
         <tr>
           <td align="center">
             
               <input type="submit" name="Submit" value="Next">
           </td>
       </tr>
      </table>
     </form>
    <p>&nbsp;</p>
     <p>&nbsp;</p>
     <p>&nbsp;</p>
     <p>&nbsp;</p>
     <p>&nbsp;</p>
   </blockquote>
 </blockquote>
 <div class="footer">
<table align="center">
<tr><td><div align="center" class="style1">Portal Developed and Maintained by IT Cell, The Durgapur Projects Limited.</div></td>
</tr>
<tr><td><div align="center" class="style1">In case of any issue, please write to admin@dpl.net.in</div></td>
</tr>
</table>

</div>
</body>
</html>