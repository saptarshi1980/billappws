<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application List</title>
</head>
<body>
<div align="center"><img src="images/logo_blue.jpg" /><br><br></br>
<div align="center">
<table border="1">
      <TH>Application Date</th>
      <TH>Application Number</th>
      <TH>Applicant Name</th>
      <TH>Address</th>
      <TH>Load</th>
      <TH>Phase</th>
      <TH>Mobile</th>
      <TH>Download File</th>
        
      <c:forEach items="${list}" var="row">
        <tr>
        
          <td><c:out value="${row.applicationDate}" /></td>
          <td><a href="viewApp.dpl?app_no=${row.applicationNumber}"><c:out value="${row.applicationNumber}" /></a></td>
          <td><c:out value="${row.applicatantName}" /></td>
          <td><c:out value="${row.address}" /></td>
          <td><c:out value="${row.connectionLoad}" /></td>
          <td><c:out value="${row.phase}" /></td>
          <td><c:out value="${row.mobile}" /></td>
          <td><a href="downloadFile.dpl?file_path=${row.filePath}&app_no=${row.applicationNumber}">Download Documents</a></td>
          
        </tr>
      </c:forEach>
    </table>
    </div>
</body>
</html>