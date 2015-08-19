<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
			<ul>
			<c:choose>
				<c:when test="${param.pageName=='main' }">
					<li class="selected"><a href="/">박성국</a></li>
					<li><a href="/guestbook">방명록</a></li>
					<li><a href="/board">게시판</a></li>
				</c:when>
				<c:when test="${param.pageName=='guestbook' }">
					<li><a href="/">박성국</a></li>
					<li class="selected"><a href="/guestbook">방명록</a></li>
					<li><a href="/board">게시판</a></li>				
				</c:when>
				<c:when test="${param.pageName=='user' }">
					<li><a href="/">박성국</a></li>
					<li><a href="/guestbook">방명록</a></li>
					<li><a href="/board">게시판</a></li>							
				</c:when>
				<c:when test="${param.pageName=='board' }">
					<li><a href="/">박성국</a></li>
					<li><a href="/guestbook">방명록</a></li>
					<li class="selected"><a href="/board">게시판</a></li>					
				</c:when>
				<c:otherwise>
					<li><a href="/">박성국</a></li>
					<li><a href="/guestbook">방명록</a></li>
					<li><a href="/board">게시판</a></li>							
				</c:otherwise>
			</c:choose>
			</ul>