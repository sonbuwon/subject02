<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈 화면</title>
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
	<!-- navbar -->
	<nav
		class="navbar navbar-expand-lg bg-body-tertiary bg-dark border-bottom border-bottom-dark"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/Subject02/main">sonbuwon7backend</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarText"
				aria-controls="navbarText" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/Subject02/main">홈으로</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/Subject02/list">요구사항 목록</a></li>
					<li class="nav-item"><a class="nav-link" href="/Subject02/login">로그인</a></li>
				</ul>
				<span class="navbar-text">본 홈페이지 글 작성은 로그인이 필요합니다. </span>
			</div>
		</div>
	</nav>

	<!-- Main -->
	<div class="container">
		<div class="d-flex justify-content-center mt-3 mb-2">
			<h3>
				<b>??? 님 요구사항을 작성해주세요</b>
			</h3>
		</div>
		<form action="/Subject02/main" method="post">
			<div class="form-floating">
				<textarea class="form-control" placeholder="Leave a comment here"
					id="floatingTextarea2" style="height: 300px" name="content"></textarea>
				<label for="floatingTextarea2">Comments</label>
			</div>
			<div class="d-flex justify-content-end my-3">
				<button type="submit" class="btn btn-danger me-1">작성하기</button>
			</div>
		</form>
	</div>
</body>
</html>