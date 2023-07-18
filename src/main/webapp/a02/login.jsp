<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
	crossorigin="anonymous"></script>
<body>
	<!-- navbar -->
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
						href="/Subject02/board/main">요구사항 작성</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/Subject02/board/list">요구사항 목록</a></li>
					<c:if test="${empty loginInfo}">
						<li class="nav-item"><a class="nav-link active"
						href="/Subject02/board/login">로그인</a></li>
					</c:if>
					<c:if test="${loginInfo.uname eq 'Admin'}">
						<li class="nav-item"><a class="nav-link"
							href="/Subject02/manage/user">유저 관리</a></li>
					</c:if>
					<!--
					<c:if test="${not empty loginInfo}">
						<li class="nav-item active"><a class="nav-link"
						href="#">로그아웃</a></li>
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

	<!-- Main -->
	<div class="container">
		<div class="d-flex justify-content-center mt-5 mb-1">
			<h3>
				<b>로그인</b>
			</h3>
		</div>
		
		<!-- 로그아웃 상태로 요구사항 목록을 클릭할경우 -->
		<c:if test="${param.in == 'no'}">
			<div class="d-flex justify-content-center">
				<div class="alert alert-danger" role="alert">
					요구사항 목록은 로그인 후 사용 가능합니다.
				</div>
			</div>
		</c:if>
		
		<div class="container mt-3" style="width: 18rem;">
			<form action="/Subject02/board/login" method="post">
				<div class="input-group mb-3">
					<input type="text" class="form-control" placeholder="아이디"
						aria-label="Username" aria-describedby="basic-addon1" name="uid" autocomplete="off">
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" placeholder="비밀번호"
						aria-label="Username" aria-describedby="basic-addon1" name="upw" autocomplete="off">
				</div>
				<div class="d-grid">
					<button type="submit" class="btn btn-secondary">로그인</button>
				</div>
				<div class="d-flex justify-content-center align-items-center my-2">
					<a href="/Subject02/board/signup">회원가입</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>