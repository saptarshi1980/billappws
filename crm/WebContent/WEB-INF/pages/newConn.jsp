<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="ShowError.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>General Information For New industrial Connection</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
<style type="text/css">
<!--
.style1 {
	color: #0000CC;
	font-weight: bold;
}
-->
</style>
<style>
div.header {
    background-color:#5882FA;
    color:white;
    margin:10px;
    padding:5px;
    height:90px;
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
.style6 {color: #FFFFFF}
.style7 {font-size: medium; font-weight: bold; color: #FFFFFF; }
</style>
<script type="text/javascript"> 
 
function message(){ 

	
		
		alert("Please Enter a Valid Mobile Number, the OTP will be sent to this number");
		
		
	    
	}

</script>
<script type="text/javascript">
function validateForm()
{
var x=document.forms["form1"]["load"].value;

if (x==null || x=="")
  {
  alert("Fields must be entered properly");
  return false;
  }
  
var phase=document.forms["form1"]["phase"].value;

if (phase==null || phase=="")
  {
  alert("Fields must be entered properly");
  return false;
  }
  
var name=document.forms["form1"]["name"].value;

if (name==null || name=="")
  {
  alert("Fields must be entered properly");
  return false;
  }
var address1=document.forms["form1"]["address1"].value;  
if (address1==null || address1=="")
{
alert("Fields must be entered properly");
return false;
}

var address2=document.forms["form1"]["address2"].value;  
if (address2==null || address2=="")
{
alert("Fields must be entered properly");
return false;
}

var pin_code=document.forms["form1"]["pin_code"].value;  
if (pin_code==null || pin_code=="")
{
alert("Fields must be entered properly");
return false;
}

var landmark=document.forms["form1"]["landmark"].value;  
if (landmark==null || landmark=="")
{
alert("Fields must be entered properly");
return false;
}
  
var mobile=document.forms["form1"]["mobile"].value;  
if (mobile==null || mobile=="")
{
alert("Fields must be entered properly");
return false;
}

var applicant_first_name=document.forms["form1"]["applicant_first_name"].value;  
if (applicant_first_name==null || applicant_first_name=="")
{
alert("Fields must be entered properly");
return false;
}

var applicant_last_name=document.forms["form1"]["applicant_last_name"].value;  
if (applicant_last_name==null || applicant_last_name=="")
{
alert("Fields must be entered properly");
return false;
}

var applicant_address1=document.forms["form1"]["applicant_address1"].value;  
if (applicant_address1==null || applicant_address1=="")
{
alert("Fields must be entered properly");
return false;
}

var applicant_address2=document.forms["form1"]["applicant_address2"].value;  
if (applicant_address2==null || applicant_address2=="")
{
alert("Fields must be entered properly");
return false;
}

var applicant_pincode=document.forms["form1"]["applicant_pincode"].value;  
if (applicant_pincode==null || applicant_pincode=="")
{
alert("Fields must be entered properly");
return false;
}

var applicant_mobile=document.forms["form1"]["applicant_mobile"].value;  
if (applicant_mobile==null || applicant_mobile=="")
{
alert("Fields must be entered properly");
return false;
}

var referee1_name=document.forms["form1"]["referee1_name"].value;  
if (referee1_name==null || referee1_name=="")
{
alert("Fields must be entered properly");
return false;
}

var referee2_name=document.forms["form1"]["referee2_name"].value;  
if (referee2_name==null || referee2_name=="")
{
alert("Fields must be entered properly");
return false;
}


var referee1_address=document.forms["form1"]["referee1_address"].value;  
if (referee1_address==null || referee1_address=="")
{
alert("Fields must be entered properly");
return false;
}

var referee2_address=document.forms["form1"]["referee2_address"].value;  
if (referee2_address==null || referee2_address=="")
{
alert("Fields must be entered properly");
return false;
}



}
</SCRIPT>
<script type="text/javascript">
function validateLoad()
{
   if(isNaN(form1.load.value))
  { 
      alert("A Numerical value must be entered ");
      form1.load.value="";
      form1.load.focus();
      return false;
  } 

}

function validatePhase()
{
   if(isNaN(form1.phase.value))
  { 
      alert("A Numerical value must be entered ");
      form1.phase.value="";
      form1.phase.focus();
      return false;
  } 

}

function validatePin()
{
   if(isNaN(form1.pin_code.value))
  { 
      alert("A Numerical value must be entered ");
      form1.pin_code.value="";
      form1.pin_code.focus();
      return false;
  } 

}

function validateLand()
{
   if(form1.landline.value=="" || form1.landline.value==null)
  { 
      alert("A value must be entered, Enter N/A if not Applicable ");
      form1.landline.value="";
      form1.landline.focus();
      return false;
  } 

}

function validateAddress1()
{
   if(form1.address1.value=="" || form1.address1.value==null)
  { 
      alert("A value must be entered, Enter N/A if not Applicable ");
      form1.landline.value="";
      form1.landline.focus();
      return false;
  } 

}

function validateAddress2()
{
   if(form1.address2.value=="" || form1.address2.value==null)
  { 
      alert("A value must be entered, Enter N/A if not Applicable ");
      form1.landline.value="";
      form1.landline.focus();
      return false;
  } 

}

function validateMobile()
{
   if(isNaN(form1.mobile.value))
  { 
      alert("A Numerical value must be entered ");
      form1.mobile.value="";
      form1.mobile.focus();
      return false;
  } 

}

function applicantPin()
{
   if(isNaN(form1.applicant_pincode.value))
  { 
      alert("A Numerical value must be entered ");
      form1.applicant_pincode.value="";
      form1.applicant_pincode.focus();
      return false;
  } 

}

function applicantLand()
{
   if(isNaN(form1.applicant_landline.value))
  { 
      alert("A Numerical value must be entered ");
      form1.applicant_landline.value="";
      form1.applicant_landline.focus();
      return false;
  } 

}

</script>
</head>
<body onLoad="document.form1.load.focus();">

<A HREF="index.dpl">HOME</A>
<div align="center"><img src="images/logo_blue.jpg" /></div><br>

<form name="form1" method="post" action="UploadForm.dpl" >
<!-- <form name="form1" method="post" action="FileUploadForm.dpl" onSubmit="return validateForm()"> -->
<table width="657" height="466" border="1" align="center" cellpadding="2" bgcolor="#CCCCFF">
  
  <tr>
    <td colspan="3" bgcolor="#000066"><div align="center" class="style1 style6">General Information of the New Consumer </div></td>
  </tr>
  <tr>
    <td width="314" height="28" bgcolor="#CCCCCC"><div align="left">Load (KVA) Applied for </div></td>
    <td width="323" bgcolor="#CCCCCC">
      <input type="text" name="load" id="load" onBlur="return validateLoad()">
    </td>
  </tr>
  <tr>
    <td height="28" bgcolor="#CCCCCC">Phase</td>
    <td bgcolor="#CCCCCC"><input type="text" name="phase" onBlur="return validatePhase()"></td>
  </tr>
  <tr>
    <td height="28" bgcolor="#CCCCCC"><table cellspacing="0" cellpadding="0">
    <td height="20" width="246">Name of the Consumer </td>
    </table></td>
    <td bgcolor="#CCCCCC"><input name="name" type="text" size="50" value="<c:out value="${name}" />"></td>
  </tr>
  <tr>
    <td height="28" bgcolor="#CCCCCC"><table cellspacing="0" cellpadding="0">
  <td height="20" width="246">Address: Line 1</td>
    </table></td>
    <td bgcolor="#CCCCCC"><input name="address1" type="text" size="50" onBlur="return validateAddress1()"></td>
  </tr>
  <tr>
    <td height="28" bgcolor="#CCCCCC"><table cellspacing="0" cellpadding="0">
  <td height="20" width="246">Address: Line 2</td>
    </table></td>
    <td bgcolor="#CCCCCC"><input name="address2" type="text" size="50" onBlur="return validateAddress2()"></td>
  </tr>
  <tr>
    <td height="28" bgcolor="#CCCCCC">Pin Code </td>
    <td bgcolor="#CCCCCC"><input name="pin_code" type="text" size="10" maxlength="6" onBlur="return validatePin()"></td>
  </tr>
  <tr>
    <td height="28" bgcolor="#CCCCCC">Landmark</td>
    <td bgcolor="#CCCCCC"><input name="landmark" type="text" size="50"></td>
  </tr>
  <tr>
    <td height="28" bgcolor="#CCCCCC">Phone Number (Land Line) </td>
    <td bgcolor="#CCCCCC"><input type="text" name="landline" onBlur="return validateLand()"></td>
  </tr>
  <tr>
    <td height="28" bgcolor="#CCCCCC"><table cellspacing="0" cellpadding="0">
    <td height="20" width="246">Mobile</td>
    </table></td>
    <td bgcolor="#CCCCCC"><input name="mobile" type="text" maxlength="10" onBlur="return validateMobile()" value="<c:out value="${mobile}" />"></td>
  </tr>
  
  <tr>
    <td height="28" bgcolor="#CCCCCC"><table cellspacing="0" cellpadding="0">
      <td height="20" width="246">Dummy Field </td>
    </table></td>
    <td bgcolor="#CCCCCC"><input name="applicant_first_name" type="text" size="50"></td>
  </tr>
  <tr>
    <td height="28" bgcolor="#CCCCCC"><table cellspacing="0" cellpadding="0">
    <td height="20" width="246">Dummy Field </td>
    </table></td>
    <td bgcolor="#CCCCCC"><input name="applicant_last_name" type="text" size="50"></td>
  </tr>
  <tr>
    <td height="28" bgcolor="#CCCCCC"><table cellspacing="0" cellpadding="0">
  <td height="20" width="246">Dummy Field </td>
    </table></td>
    <td bgcolor="#CCCCCC"><input name="applicant_address1" type="text" size="50"></td>
  </tr>
  <tr>
    <td height="28" bgcolor="#CCCCCC"><table cellspacing="0" cellpadding="0">
  <td height="20" width="246">Dummy Field </td>
    </table></td>
    <td bgcolor="#CCCCCC"><input name="applicant_address2" type="text" size="50"></td>
  </tr>
  
  <tr>
    <td height="12" colspan="3" bgcolor="#000066"><div align="center">
      <input type="submit" name="Submit" value="Submit">
    </div></td>
  </tr>
</table>
</form>
<br><br>
<div align="center">
<table align="center">
<tr><td bgcolor="#000066"><div align="center" class="style7">Portal Developed and Maintained by IT Cell, The Durgapur Projects Limited.</div></td>
</tr>
<tr><td bgcolor="#000066"><div align="center" class="style7">In case of any issue, please write to admin@dpl.net.in</div></td>
</tr>
</table>
</div>
</body>
</html>