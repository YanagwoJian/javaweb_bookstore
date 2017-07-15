<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>简易购物书城</title>

	<script type="text/javascript" src="js/book.js" charset="UTF-8"></script>
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/index.css">
	
  </head>
  
  <body>
  	<div class="header">
  		<div class="logo">
  			<img src="/onlinebookstore/images/logo.png">简易书店
  		</div>
  		<div class="link">
  			<a href="/onlinebookstore/admin/adminlogin.jsp">管理员登录</a>|
  			<a href="#">基本版</a> |
  			<a href="#">English</a> |
  			<a href="#">手机版</a> |
  			<a href="#">VIP登录</a> |
  			<a href="#">帮助</a> |
  			<a href="#">在线答疑</a>
  		</div>
  	</div>
  	<div class="content">
  		<div class="word">
  		<h2>每一次告别</h2>
  		<h2>最好用力一点</h2>
  		<h3>多说一句</h3>
  		<h3>可能是最后一句</h3>
  		<h4>多看一眼</h4>
  		<h4>可能是最后一眼</h4>
  		</div>
  		<div class="loginbar">
  			<div class="loginbar_header"><font color="#999999">快速登录</font>&nbsp;&nbsp;账号密码登录</div>
    		<form method="post" action="/onlinebookstore/loginAction.action"
    			 name="form" onsubmit="return login()">
    				<div class="inputid">
    					<input name="id" type="text" id="id" class="id_input">
    				</div>
	    			<div class="inputpwd">
	    				<input name="pwd1" type="password" class="pwd_input">
	    			</div>
	    			<div style="height:40px; width:100%;"><input type="submit" value="登 录" class="loginbtn">
	    			</div>
	    			<div class="loginbar_footer">
		    			<a href="#">忘了密码？</a>|
		    			<a href="/onlinebookstore/user/register/register.jsp">注册新账号</a>|
		    			<a href="#">意见反馈</a>
	    			</div>
    		</form>
    	</div>
    </div>
    <div class="footer">
    	<div class="footer_nav">
  			<a href="#">关于简易</a>|
  			<a href="#">服务条款</a>|
  			<a href="#">客户中心</a>|
  			<a href="#">联系我们</a>|
  			<a href="#">帮助中心</a>
  		</div>
    </div>
  </body>
</html>
