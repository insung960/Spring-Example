<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1">
		<thead>
					<tr>
						<td>No</td>
						<td>Title</td>
						<td>Content</td>
						<td>User</td>
						<td>Date</td>
					</tr>
		</thead>
		<tbody>
				<tr>
					<td>${board.boardNo}</td>
					<td>${board.boardTitle}</td>
					<td>${board.boardContent}</td>
					<td>${board.boardUser}</td>
					<td>${board.boardDate}</td>
				</tr>			
		</tbody>
	</table>
	
	<h2>Board삭제</h2>
  		<form action = "deleteBoard" method = "post">
  			<input name="boardNo" type="hidden" value ="${board.boardNo}">
        	<div> pw
            <input name="boardPw" type="text">
            </div>
            <button type ="submit">삭제</button>
  		</form>
	
	
	<h2>Board업데이트</h2>
  		<form action = "boardUpdate" method = "post">
  			<input name="boardNo" type="hidden" value ="${board.boardNo}">
        	<div> title
            <input name="boardTitle" type="text">
            </div>
            <div> Pw
            <input name="boardPw" type="text">
            </div>
            <div> content
            <input name="boardContent" type="text">
            </div>
            <div> 	user
            <input name="boardUser" type="text">
            </div>
            
            <button type ="submit">추가</button>
  		</form>
</body>
</html>