<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'changepwdsuccess.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/changepwd.css">
	<script language="javascript">
	function message() {
		alert("密码修改成功，请重新登录");
		window.open("/onlinebookstore/index.jsp", "_top");
	}
	</script>

  </head>
  
  <body onload="message()">
    <div class="success">
    	<h3>密码修改成功，请重新登录</h3>
  	</div>
  </body>
</html>
