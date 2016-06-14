<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>DPL CRM PORTAL</title>
<style type="text/css">
<!--
.style1 {color: #FFFFFF}
-->
</style>
</head>

<body>
<!-- <div align="center"><img src="images/tmc.png" /> -->
<div align="center"><img src="images/logo_blue.jpg" /></div><br>
<div align="center"><p></p><p></p><p></p><p></p><p></p><p></p><p></p><br></br><br></br>
<FORM id="form1" name="form1" method="post" action="otp.dpl">
<table width="765" border="1" cellpadding="2">
  <tr>
    <th colspan="2" bordercolor="#F0F0F0" bgcolor="#000066" scope="row"><label>
      <div align="center"><span class="style1">SELF REGISTRATION FOR NEW DOMESTIC CONNECTION<br />
  BOTH FIELDS ARE MANDATORY </span></div>
    </label></th>
  </tr>
  <tr>
    <th width="134" bgcolor="#CCCCCC" scope="row">Name</th>
    <th width="611" bgcolor="#CCCCCC" scope="row">      <div align="left">
      <input name="textfield" type="text" size="80" />    
    </div></th>
  </tr>
  <tr>
    <th height="32" bgcolor="#CCCCCC" scope="row">Mobile Number </th>
    <th bgcolor="#CCCCCC" scope="row">
      <label>
        <div align="left">
          <input name="textfield2" type="text" size="20" maxlength="11" />
        </div>
      </label>
      </th>
  </tr>
  <tr>
    <th colspan="2" bgcolor="#CCCCCC" scope="row">
      <label>
      <input type="submit" name="Submit" value="Generate One Time Password" />
        </label>
    
    </th>
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