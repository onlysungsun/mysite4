<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<!-- mysite4 -->
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp">
			</c:import>
		</div>
		<div id="content">
			<div id="board">
				<form id="search_form" action="board/search" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
				<c:set var="count" value="${fn.lenght(list) }"></c:set>
				<c:forEach var="vo" items="${list }" varStatus="status">					
					<tr>
						<td>${count+1+status.index}</td>
						<td><a href="/board/view/${vo.no }">${vo.title }</a></td>
						<td>${vo.memberName }</td>
						<td>${vo.viewCnt }</td>
						<td>${vo.regDate }</td>
					<c:choose>
						<c:when test="${authUser.name == vo.memberName }">
							<td><a href="board/delete/${vo.no }" class="del">삭제</a></td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
					</tr>
				</c:forEach>	
				</table>
				<c:choose>
					<c:when test="${authUser.name == null }"><div class="bottom"></div></c:when>
					<c:otherwise>
					<div class="bottom">
					<a href="board/writeform" id="new-book">글쓰기</a>
					</div>
				</c:otherwise>
				</c:choose>				
			</div>

			
			<table>
				<tr>
				<td>
					<c:if test="${requestScope.startPage > 1}">
						<c:choose>
							<c:when test="${requestScope.searchflag != null}">
							 	<a href="/board/board_list_action.controller?page=${requestScope.startPage-requestScope.pageLimit}">이전</a>
							</c:when>
						</c:choose>
					</c:if>
					
					<c:forEach var="i" begin="${requestScope.startPage }" end="${requestScope.endPage}" step="1">
						<c:choose>
							<c:when test="${i == requestScope.curPage}">
                          	<span>${i}</span>
                          	</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${requestScope.searchflag != null}">
										<a href="/board/board_list_action.controller?page=${i }">${i }</a>
									</c:when>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<c:if test="${requestScope.endPage < requestScope.lastPage }">
						<c:choose>
							 <c:when test="${requestScope.searchflag != null}">
							 	<a href="/board/board_list_action.controller?page=${requestScope.endPage+1 }">다음</a>
							 </c:when>
						</c:choose>
					</c:if>
				</td>
				</tr>
			</table>


		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp">
				<c:param name="pageName" value="board"/>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp">
			</c:import>
		</div>
	</div>
</body>
</html>