<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List,com.example.demo.pojo.vote"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table align="center" border="1" width="300px" height="250">
		<tr align="center">
			<td colspan=4>投票系統</td>
		</tr>
		<tr align="center">

			<td><h3>姓名</h3></td>
			<td><h3>票數</h3></td>
			<td><h3>投票</h3></td>
		</tr>

		<%
		List<vote> voteList = (List<vote>) session.getAttribute("voteList");
		if (voteList != null) {
			for (vote vote : voteList) {
		%>
		<tr align="center">

			<td><%=vote.getName()%></td>
			<td><%=vote.getQuantity()%></td>
			<td>
				<form action="updateVote" method="post">
					<input type="submit" name="id" value=<%=vote.getId()%>>
				</form>
			</td>
		</tr>
		<%
		}
		}
		%>

	</table>
</body>
</html>