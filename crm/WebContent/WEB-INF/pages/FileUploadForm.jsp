<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <title>Upload The Scanned Document in PDF Format</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251" >
        <script type="text/javascript">
  function CheckFileName() {
        var fileName = document.getElementById("file").value
        var size=document.getElementById("file").files.item(0).size
        if (fileName == "") {
            alert("Browse to upload a valid File with .pdf extension");
            return false;
        }
        else if (fileName.split(".")[1].toUpperCase() == "PDF")
            return true;
        else if (fileName.split(".")[1].toUpperCase() == "PDF")
            return true;
        else if (size>524880){
        	alert("File Size can not be more than 5 MB");
        	return false;
  			}
        else {
            alert("File with " + fileName.split(".")[1] + " is invalid. Upload a validfile with .pdf extensions");
            return false;
        }
        return true;
    }
  </script>
        <style type="text/css">
<!--
.style1 {color: #FF0000}
.style2 {color: #0000CC}
-->
        </style>
</head>
    <body>
    <div align="center"><img src="images/logo_blue.jpg" /><br><br></br>
        <h2 class="style2">Upload The Scanned Document in PDF Format</h2>
        <span class="style1"><br />
        <!-- <br>
        <h4>
        <strong>Maximum File Size is 5 MB, System will discard data provided by you if file size exceeds 5 MB
        </h4> -->
        <div align="center"><img src="images/filesize.gif" /><br><br></br>
        <div align="center"><img src="images/file_size_detail.gif" /><br><br></br>
        </strong><br />
        <br>
        <form:form commandName="FORM"  action="FileUploadForm.dpl" enctype="multipart/form-data" method="POST" onsubmit="return CheckFileName()">
        <input type="hidden" name="name" value="<c:out value="${name}" />" />
    	<input type="hidden" name="mobile" value="<c:out value="${mobile}" />" />
    	<input type="hidden" name="load" value="<c:out value="${load}" />" />
    	<input type="hidden" name="phase" value="<c:out value="${phase}" />" />
    	<input type="hidden" name="pin_code" value="<c:out value="${pin_code}" />" />
    	<input type="hidden" name="landmark" value="<c:out value="${landmark}" />" />
    	<input type="hidden" name="landline" value="<c:out value="${landline}" />" />
    	<input type="hidden" name="address1" value="<c:out value="${address1}" />" />
    	<input type="hidden" name="address2" value="<c:out value="${address2}" />" />
        </span>
        <table border="1" cellpadding="2">
         <tr><td colspan="2" style="color: red;"><form:errors path="*" cssStyle="color : red;"/>
         ${errors}
         </td></tr>
         <tr><td bgcolor="#CCCCCC"><form:input type="file" path="file" /></td></tr>
         <tr><td colspan="2" bgcolor="#000066"><input type="submit" value="Upload File" /></td></tr>
        </table>
    </div>
        </form:form>
    </body>
</html>
