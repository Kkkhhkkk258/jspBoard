<%@page import="kr.or.ddit.board.service.BoardService"%>
<%@page import="kr.or.ddit.board.service.BoardServiceInf"%>
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
<%
	String path = pageContext.getServletContext().getContextPath();
%>
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
<script>
	$(function() {
		$(".detail").on("click", function() {
			//tr태그의 data-id 속성 값을 읽어서 input태그의 id값으로 설정
			//form태그를 submit
			$("#cont_num").val($(this).data("id"));
			$("#frm").submit();
			// 		$("#frm2").submit();
		});
		
	})
</script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<%@include file="/common/left.jsp"%>

	<form id="frm" action="/boardDetail" method="get">
		<input type="hidden" name="cont_num" id="cont_num">
	</form>
	

	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/common/main.jsp">Board</a>
				</li>
				<li class="breadcrumb-item active">Tables</li>
			</ol>
			<!-- Example DataTables Card-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> ${board.board_name }
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<div class="row">
							<form id="newPost" action="/board/boardWrite.jsp" method="post">
							<div class="col-sm-12 col-md-6">
								<button type="submit" class="btn btn-link" name="btn" id="newContent" value="new" >
									<i class="fa fa-pencil-square-o" aria-hidden="true"></i>New
								</button>
								<input type="hidden" name="board_num" value="${board.board_num }">
							</div>
							</form>
						</div>
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Number</th>
									<th>Title</th>
									<th>Writer</th>
									<th>Date</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Number</th>
									<th>Title</th>
									<th>Writer</th>
									<th>Date</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach items="${contentList }" var="content" >
									<c:choose>
										<c:when test="${content.cont_del == 'Y'}">
											<tr>	
												<td></td>
												<td>삭제된 게시글 입니다</td>
												<td></td>
												<td></td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr data-id="${content.cont_num }" class="detail">
												<td>${content.cont_num }</td>
												<td> ${content.cont_title }</td>
												<td>${content.std_id }</td>
												<td><fmt:formatDate value="${content.cont_date }"
														pattern="yyyy-MM-dd" /></td>
											</tr>
										</c:otherwise>
									</c:choose>
								</c:forEach>

							</tbody>
						</table>
						<div align="center">
							<ul class="pagination modal-5">
								<!-- 							<li><a href="#" class="prev fa fa-arrow-left"> </a></li> -->
								<%=request.getAttribute("paginatiion")%>
<!-- 								<li><a href="/boardList?page=1&pageSize=10&boardNum=1" -->
<!-- 									class="prev fa fa-arrow-left"> </a></li> -->
<!-- 								<li class="active"><a -->
<!-- 									href="/boardList?page=1&pageSize=10&boardNum=1">1</a></li> -->
<!-- 								<li><a href="/boardList?page=1&pageSize=10&boardNum=1" -->
<!-- 									"class="next fa fa-arrow-right"> </a></li> -->
<!-- 								<li><a href="#" class="next fa fa-arrow-right"></a></li> -->
							</ul>
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
		</div>
	</div>
</body>

</html>