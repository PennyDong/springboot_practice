<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List,com.example.demo.pojo.chat" %>
    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/form_style.css">
<body>
	<div class="container">
		<div class="left-half">
		<form action="addChat" method="post">
		<table  border="1">
			<tr align="center">
				<td><h3>用戶名</h3></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr colspan="2" align="center">
				<td><h3>主題的類型</h3></td>
				<td>
					<select name="subject">
						<option value="help">求助</option>
						<option value="share">分享經歷</option>
						<option value="answer">解答</option>
						<option value="talk">隨意聊聊</option>			
					</select>
				</td>
			
			</tr>
			<tr align="center">
				<td colspan="2">
					<h3>留言</h3>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="content"  cols="50" rows="8" style="resize:none;" required>
					</textarea>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="送出">
					<input type="reset" value="重製">  
				</td>
			</tr>
		</table>
	</form>
	</div>
	

	
	<div class="right-half">
	
		<div>
		<table border="1" width="500px">
			 <thead>
                <tr>
                    <th>name</th>
                    <th>subject</th>
                    <th>content</th>
                </tr>
            </thead>
            
                <% 
                    List<chat> chatList = (List<chat>) session.getAttribute("chatList");
                    if (chatList != null) {
                        for (chat chat : chatList) {
                %>
                            <tr>
                                <td><%= chat.getName() %></td>
                                <td><%= chat.getSubject() %></td>
                                <td><%= chat.getContent() %></td>
                            </tr>
                <%
                        }
                    }
                %>
           
		</table>
	
	</div>
	
</div>
</div>	
	
	
</body>
</html>