<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>BOARD_KHK</title>
<% String path = pageContext.getServletContext().getContextPath(); %>
<!-- Bootstrap core CSS-->
<link href="/common/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="/common/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="/css/style.css">
<script src="/js/jquery-1.12.4.js"></script>
<title>ContentDetail</title>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<%@include file="/common/left.jsp"%>

	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/common/main.jsp">Board</a>
				</li>
				<li class="breadcrumb-item active">  ${board.board_name} / NewPost</li>
			</ol>

			<div class="row">
				<div class="col-12">
					<h1>Write</h1>
					<form action="/boardWrite" method="post" id="frm" enctype="multipart/form-data">
					
						<c:if test="${content != null }">
						
						<div class="form-group col-md-4">
							<label for="title">Title : </label> <input name="title" id="title"
								class="form-control form-control-lg" type="text" value="${content.cont_title }"
								>
						</div>
						</c:if>
						<c:if test="${content == null }">
						<div class="form-group col-md-4">
							<label for="title">Title : </label> <input name="title" id="title"
								class="form-control form-control-lg" type="text" placeholder="제목을 입력하세요"
								>
						</div>
						</c:if>
						<div class="form-group col-md-4">
							<input type="file" name="uploadFile" multiple="multiple">
						</div>
						<div class="form-group">
							<label for="contentDetail">Detail : </label>
							<%@include file="/SE2/index.jsp" %>
						</div>
						<input class="btn btn-warning" type="button" id="savebutton" value="저장" name="btn" />
						<input type="hidden" name="board_num" value="${board.board_num }">
					</form>
				</div>
			</div>
			
			<!-- Logout Modal-->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Ready to
										Leave?</h5>
									<button class="close" type="button" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">×</span>
									</button>
								</div>
								<div class="modal-body">Select "Logout" below if you are
									ready to end your current session.</div>
								<div class="modal-footer">
									<button class="btn btn-secondary" type="button"
										data-dismiss="modal">Cancel</button>
									<a class="btn btn-primary" href="/login/login.jsp">Logout</a>
								</div>
							</div>
						</div>
					</div>

					<!-- Bootstrap core JavaScript-->
					<script src="/common/vendor/jquery/jquery.min.js"></script>
					<script src="/common/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
					<!-- Core plugin JavaScript-->
					<script src="/common/vendor/jquery-easing/jquery.easing.min.js"></script>
					<!-- Custom scripts for all pages-->
					<script src="/js/js/sb-admin.min.js"></script>
			

		</div>
	</div>

</body>
</html>