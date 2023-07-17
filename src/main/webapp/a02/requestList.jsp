<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요구사항 목록</title>
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
						href="/Subject02/board/main">홈</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/Subject02/board/list">요구사항 목록</a></li>
					<c:if test="${empty loginInfo}">
						<li class="nav-item"><a class="nav-link"
							href="/Subject02/board/login">로그인</a></li>
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

	<!-- 메인 -->
	<div class="container">
		<!-- 검색창 -->
		<div class="container" style="width: 24rem;">
			<div class="d-flex justify-content-center mt-3 mb-1">
				<h3>
					<b>검색창</b>
				</h3>
			</div>
			<form action="/Subject02/board/search" class="d-flex" role="search"
				method="post">
				<input class="form-control me-2" type="search" placeholder="검색"
					aria-label="Search" name="what" autocomplete="off">
				<button class="btn btn-outline-secondary" type="submit">📗</button>
			</form>
		</div>

		<div class="container">
			<div class="d-flex justify-content-center mt-5 mb-1">
				<h3>
					<b>요구사항 목록</b>
				</h3>
			</div>
		
			<div class="d-flex justify-content-center mt-1">
				<c:if test="${empty list}">
					<h3>작성된 요구사항이 없습니다.</h3>
				</c:if>
			</div>
			<c:if test="${not empty list}">
				<ul class="list-group m-3">
					<c:forEach var="cs" items="${ list }" varStatus="status">
						<li class="list-group-item list-group-item-action">
							<div class="d-flex justify-content-between align-items-center">
								<div class="me-auto badge bg-dark p-2">
									<div>
										${status.count}
									</div>
								</div>
								<div class="flex-grow-1 mx-2">
									${cs.content}
								</div>
								<div class="badge text-dark p-2 text-start">
									<div class="mb-1">
										${cs.author}
									</div>
									<div>
										${cs.date}
									</div>
								</div>
								<div>
									<!-- 삭제 버튼 --> 
									<c:if
										test="${loginInfo.uname eq 'Admin'}">
										<form action="/Subject02/board/remove" method="post">
											<input type="hidden" name="id" value="${cs.id}" readonly>
											<div>
												<button class="btn btn-danger" type="submit">X</button>
											</div>
										</form>
									</c:if>
								</div>
							</div>
							
						</li>
					</c:forEach>
				</ul>
			</c:if>
		</div>

		<c:if test="${not empty loginInfo}">
			<div class="container d-flex justify-content-end">
				<form action="/Subject02/board/logout" method="post">
					<button type="submit" class="btn btn-outline-secondary me-3">로그아웃</button>
				</form>
			</div>
		</c:if>
	</div>
</body>
</html>