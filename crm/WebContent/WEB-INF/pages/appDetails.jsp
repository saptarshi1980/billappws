<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Details</title>
</head>
<body>
<div align="center">
<p><img src="images/logo_blue.jpg" /></p><br><br>
<div align="center">
<table border="1">
      <TH bgcolor="#CCCCCC">Application Date</th>
      <TH bgcolor="#CCCCCC">Application Number</th>
      <TH bgcolor="#CCCCCC">Applicant Name</th>
      <TH bgcolor="#CCCCCC">Address</th>
      <TH bgcolor="#CCCCCC">Load</th>
      <TH bgcolor="#CCCCCC">Phase</th>
      <TH bgcolor="#CCCCCC">Mobile</th>
      <TH bgcolor="#CCCCCC">Download File</th>
        
      <c:forEach items="${list}" var="row">
        <tr>
        
          <td><c:out value="${row.applicationDate}" /></td>
          <td><c:out value="${row.applicationNumber}" /></td>
          <td><c:out value="${row.applicatantName}" /></td>
          <td><c:out value="${row.address}" /></td>
          <td><c:out value="${row.connectionLoad}" /></td>
          <td><c:out value="${row.phase}" /></td>
          <td><c:out value="${row.mobile}" /></td>
          <td><a href="downloadFile.dpl?file_path=${row.filePath}&app_no=${row.applicationNumber}">Download Documents</a></td>
          
        </tr>
      </c:forEach>
      
      
  </table>
    
      <br><br>
      <br>
    <table width="562" border="1">
    <tr>
    <td bgcolor="#999999"><div align="center">Select Substation to which this application is to be forwarded</div></td>
    <td><select name="ss">
  	<c:forEach items="${ssList}" var="ssValue">
    <option value="${ssValue}">
        ${ssValue}    </option>
  </c:forEach>
</select></td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#996666"><div align="center">
        <form name="form1" method="post" action="">
          <label>
            <input type="submit" name="Submit" value="Forward">
            </label>
        </form>
      </div></td>
      </tr>
    </table>
    <p>&nbsp;</p>
</div>

<p><br>
  <br>
  </br>
</p>
</body>
</html>