<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
	crossorigin="anonymous"></script>
</head>
<body>
	<!-- 네비바 시작 -->
	<nav
		class="navbar navbar-expand-lg bg-body-tertiary bg-dark border-bottom border-bottom-dark"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/Subject02/board/main">sonbuwon7backend</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarText"
				aria-controls="navbarText" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="/Subject02/board/main">홈</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/Subject02/board/list">요구사항 목록</a></li>
					<c:if test="${empty loginInfo}">
						<li class="nav-item"><a class="nav-link"
							href="/Subject02/board/login">로그인</a></li>
					</c:if>
					<c:if test="${loginInfo.uname eq 'Admin'}">
						<li class="nav-item"><a class="nav-link active"
							href="/Subject02/manage/user">유저 관리</a></li>
					</c:if>
					<!--
					<c:if test="${not empty loginInfo}">
						<li class="nav-item">
						<li class="nav-item"><a class="nav-link" href="#">로그아웃</a></li>
						</li>
					</c:if>
					-->
				</ul>
				<c:if test="${empty loginInfo}">
					<span class="navbar-text me-3">요구사항 작성은 로그인이 필요합니다. </span>
				</c:if>
				<c:if test="${not empty loginInfo}">
					<span class="navbar-text me-3">${loginInfo.uname} 님 환영합니다.</span>
				</c:if>
			</div>
		</div>
	</nav>
	<!-- 네비바 끝 -->
	<!-- 유저목록 출력 시작 -->
	<div class="container">
		<div class="d-flex justify-content-center mt-5 mb-1">
			<h3>
				<b>사용자 목록</b>
			</h3>
		</div>

		<div class="d-flex justify-content-center mt-1">
			<c:if test="${empty userlist}">
				<h3>관리 할 사용자가 없습니다.</h3>
			</c:if>
		</div>
		<c:if test="${not empty userlist}">
			<ul class="list-group m-3">
				<c:forEach var="us" items="${ userlist }" varStatus="status">
					<c:if test="${us.uname ne 'Admin'}">
						<li class="list-group-item list-group-item-action">
							<div class="d-flex justify-content-center align-items-center">
								<div class="p-1 flex-fill">아이디: ${us.uid}</div>
								<div class="p-1 flex-fill">패스워드: ${us.upw}</div>
								<div class="p-1 flex-fill">닉네임: ${us.uname}</div>
	
								<div>
									<!-- 삭제 버튼 -->
									<!-- 아직 미구현 -->
									<c:if test="${loginInfo.uname eq 'Admin'}">
										<form action="/Subject02/manage/delete" method="post">
											<input type="hidden" name="uid" value="${us.uid}" readonly>
											<div>
												<button class="btn btn-danger" type="submit">X</button>
											</div>
										</form>
									</c:if>
								</div>
							</div>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		</c:if>
	</div>
	<!-- 유저목록 출력 끝 -->
</body>
</html>