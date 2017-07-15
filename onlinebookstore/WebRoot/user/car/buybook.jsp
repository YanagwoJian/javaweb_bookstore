<%@ page language="java" import="java.util.*,user.*,java.sql.*,dao.*,usercar.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>书城</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/buybook.css">
	

  </head>
  
  <body>
  	<div class="buybook">
  	<table>
  		<tr>
  			<th>书名</th>
  			<th>作者</th>
  			<th>出版社</th>
  			<th>出版日期</th>
  			<th>单价</th>
  			<th>加入购物车</th>
  		</tr>
    <%  
    	String id = (String)request.getParameter("id");
	    HttpSession session1 = request.getSession();
    
    	int pageNow = 1; //当前页
    	String spageNow = request.getParameter("pageNow");
    	
    	if(spageNow != null)
    		pageNow = Integer.parseInt(spageNow);
		int pageSize = 4;  //每页显示多少行数据
   		ResultSet rs = null;
    	String sql1 = "select count(*) from book";
    	rs = dao.query(sql1);
    	rs.next();
    	int rowCount = rs.getInt(1);	//一共有多少行数据
    	int pageCount = (rowCount-1)/pageSize+1;  //一共有多少页
    	dao.close(dao.getConn(), dao.getSt(), rs);
    	String sql2 = "select * from book where id limit "+ (pageNow-1)*pageSize +","+ pageSize;
    	rs = dao.query(sql2);
    	while(rs.next()) {
    %>
    <tr>
    <td><%=rs.getString(2) %></td>
    <td><%=rs.getString(3) %></td>
    <td><%=rs.getString(4) %></td>
    <td><%=rs.getString(5) %></td>
    <td><%=rs.getString(6) %></td>
    <td><a href="/onlinebookstore/addcar?id=<%= id %>&pageNow=<%= pageNow %>&bookid=<%= rs.getString(1) %>"><input type="button" name=<%= rs.getString(1) %> value="加入购物车" id="car"></a></td>
    </tr>
    <%
    	}
    	dao.close(dao.getConn(), dao.getSt(), rs);
    %>
    </table>
    <div class="page">
    <%
    	if(pageNow != 1) {
    %>
    		<a href="/onlinebookstore/user/car/buybook.jsp?id=<%= id %>&pageNow=<%= pageNow-1 %>">&lt;上一页</a>
    <% 	
    	}	
    	for(int i = 1; i <= pageCount; i++) {
    		if(i == pageNow) {
    %>
    			<input type="text" style="width:22px;text-align:center;" disabled="disabled" value=<%= i %>>
    <% 
    		}else {
    %>
    			<a href="/onlinebookstore/user/car/buybook.jsp?id=<%= id %>&pageNow=<%= i %>"><input type="button" value=<%= i %>></a>
    <%
    		}
    	}
    	if(pageNow != pageCount) {
    %>
    		<a href="/onlinebookstore/user/car/buybook.jsp?id=<%= id %>&pageNow=<%= pageNow+1 %>">下一页&gt;</a>
    <% 
    	}
    %>
    </div>
    </div>		
  </body>
</html>
