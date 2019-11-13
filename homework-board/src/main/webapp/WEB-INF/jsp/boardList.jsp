<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> BoardList</h2>
	<h2>행의수 : ${totalRow}</h2>
	<h2>현재 페이지 : ${currentPage}</h2>
	<h2>검색어 : ${searchWord}</h2>
	<h2>마지막페이지 : ${lastPage}</h2>
	<table border = "1">
		<thead>
				<tr>
					<td>No</td>
					<td>Title</td>
					<td>Date</td>
				</tr>
		</thead>
		<tbody>
			<c:forEach var="b" items ="${list}">
				<tr onclick="location.href='boardOne?no=${b.boardNo}'" style="cursor:hand">
					<td>${b.boardNo}</td>
					<td>${b.boardTitle}</td>
					<td>${b.boardDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
        <c:if test="${currentPage > 1}">
           <a href="boardList?currentPage=${currentPage-1}&&searchWord=${searchWord}">이전</a>
        </c:if>
        <c:if test="${currentPage < lastPage}">
         	<a href="boardList?currentPage=${currentPage+1}&&searchWord=${searchWord}">다음</a>
        </c:if>
        
        <form action = "boardList" method = "get">
        
            <input name="searchWord" type="text">
            <button type ="submit">검색</button>
  		</form>
  		
  	<h2>Board추가하기</h2>
  		<form action = "boardAdd" method = "post">
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