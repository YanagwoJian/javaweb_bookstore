<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册信息</title>
	
	<script type="text/javascript" src="js/book.js" charset="UTF-8"></script>
  	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/register.css">
  </head>
  
  <body>
  	<div class="header">
  		<h1>用户注册</h1>
  		<div class="link">
  			<a href="#">中文</a>|
  			<a href="#">English</a>|
  			<a href="/onlinebookstore/index.jsp">账号登录</a>
  		</div>
  	</div>
  	<div class="content">
	  	<div class="register">
	  	<form action = "/onlinebookstore/registerServletAction.action"
	  			method="post" name="myform" onsubmit="return userFunction()">
	  			
	  			<h2>基本信息</h2>
	  			<div>		
	  				&nbsp;&nbsp;<h4>账号</h4>
	  				<input type="text" name="id">
	  				<font>账号不能为空</font>
	  			</div>
	  			<div>
	  				&nbsp;&nbsp;<h4>密码</h4>
	  				<input type="password" name="pwd1" >
	  				<font>密码不能为空</font>
	  			</div>
	  			<div>
	  				&nbsp;&nbsp;<h4>确认</h4>
	  				<input type="password" name="pwd2" >
	  				<font>重新输入密码</font>
	  			</div>
	  			<h2>个人信息</h2>
	  			<div>
	  				&nbsp;&nbsp;<h4>姓名</h4>
	  				<input type="text" name="name" >
	  				<font>姓名不能为空</font>
	  			</div>
	  			<div style="padding-top:12px; height:28px;">
	  				&nbsp;&nbsp;<h4>性别</h4>
	  				<input type="radio" name="sex" value="man" checked="checked" id="man">
	  				<label for="man">男</label>
	  				<input type="radio" name="sex" value="womman" id="woman">
	  				<label for="woman">女</label>
	  			</div>
	  			<div>
	  				&nbsp;&nbsp;<h4>电话</h4>
	  				<input type="text" name="phone">
	  			</div>
	  			<input type="submit" value="注 册" class="registerbtn">
	  			<div id="suggest"><a href="#"><h4>“注册页面”改进建议</h4></a>
	  			</div>
	  	</form>
	  	</div>
  	</div>
  	<div class="footer">
  		<div>
  			<a href="#">关于简易</a>|
  			<a href="#">合作伙伴</a>|
  			<a href="#">营销中心</a>|
  			<a href="#">联系客服</a>|
  			<a href="#">开放平台</a>|
  			<a href="#">诚征英才</a>|
  			<a href="#">联系我们</a>|
  			<a href="#">法律声明</a>
  		</div>
  	</div>
  </body>
</html>
