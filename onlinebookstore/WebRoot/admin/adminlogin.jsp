<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员登录</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/adminlogin.css">
	
	<script language="javascript">
	function adminlogin() {
		if(document.form.admin.value =="") {
			alert("账号不能为空");
			return false;
		}
		else if(document.form.pwd.value =="") {
			alert("密码不能为空");
			return false;
		}
		else {
			return true;
		}
	}
	</script>

  </head>
  
  <body>
    <div class="adminlogin">
    	<form name="form" method="post" action="/onlinebookstore/adminlogin" onsubmit="return adminlogin()">
	    	<h1>管理员</h1>
	    	<div>
	    		<h2>账号：</h2><input type="text" id="admin" name="admin">
	    	</div>
	    	<div>
	    		<h2>密码：</h2><input type="password" id="pwd" name="pwd">
	    	</div>
	    	<div>
	    		<input type="submit" value="登录" id="login">
	    		<a href="/onlinebookstore/index.jsp"><input type="button" value="首页" id="login"></a>
	    	</div>
    	</form>
    </div>
  </body>
</html>
