<%@ page contentType="text/html;charset=EUC-KR" pageEncoding="EUC-KR" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>게시판 목록</title>
</head>
<form action = "regist" method = "get">
<body>
<table border="1" width="880">
  <tr>
    <td width="77">
      <p align="center">글번호</p>
    </td>
    <td width="327">
      <p align="center">제목</p>
    </td>
    <td width="197">
      <p align="center">작성자</p>
    </td>
    <td width="155">
      <p align="center">작성일</p>
    </td>
    <td width="90">
      <p align="center">조회수</p>
    </td>
  </tr>
  <c:forEach items="${list}" var="board">
    <tr>
      <td>${board.bno}</td>
      <td><a href='/read?bno=${board.bno}'>${board.title}</a></td>
      <td>${board.writer}</td>
      <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
                          value="${board.regdate}" /></td>
      <td><span class="badge bg-red">${board.viewcnt}</span></td>
    </tr>
  </c:forEach>
</table>
<button type ="submit">글쓰기</button>
</body>
</form>
</html>
