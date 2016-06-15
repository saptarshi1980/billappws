<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>DPL CRM PORTAL</title>
<style type="text/css">
<!--
.style1 {color: #FFFFFF}
.style3 {color: #FFFFFF; font-weight: bold; }
-->
</style>
</head>

<body>
<div align="center"><img src="images/logo_blue.jpg" /></div><br>
<div align="center"><p></p><p></p><p></p><p></p><p></p><p></p><p></p><br></br><br></br>

<FORM id="form1" name="form1" method="post" action="otpValidator.dpl">
<table width="509" border="1" cellpadding="2">
  <tr>
    <td colspan="2" bordercolor="#F0F0F0" bgcolor="#000066" scope="row">
       
              <div align="center"><span class="style3">Application Submitted Succesfully  </span>              </div></td>
  </tr>
  <tr>
    <th colspan="2" bgcolor="#CCCCCC" scope="row">Please Note your Temporary Consumer No for Future Reference
      <div align="left"></div></th>
    </tr>
  
  <tr>
    <th width="239" bgcolor="#CCCCCC" scope="row">
      <label></label>        Temporary Consumer No</th>
    <th width="250" bgcolor="#CCCCCC" scope="row"><c:out value="${conNo}" /></th>
  </tr>
  <tr>
    <th colspan="2" bgcolor="#CCCCCC" scope="row"><A HREF="index.dpl">HOME</A></th>
    </tr>
</table>
<div>
</form>
<p>&nbsp;</p>
<table width="767" border="1" cellpadding="2">
  <tr>
    <td bgcolor="#000066"><div align="center"><span class="style1">In case of Technical Difficulty contact admin@dpl.net.in </span></div></td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>