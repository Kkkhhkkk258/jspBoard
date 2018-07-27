<%@page import="kr.or.ddit.board.model.ContentVO"%>
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
<script src="/js/jquery-1.12.4.js"></script>
<script>
$(function(){
	$("#update").on("click",function(){
		$("#frm").submit();
	});
	$("#delete").on("click",function(){
		$("#frm").submit();
	});
	$("#reply").on("click",function(){
		$("#replyFrm").submit();
	});
	$("#newC").on("click",function(){
		$("#frm").submit();
		$("#newComment").submit();
	});
	
	
	
})
</script>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<%@include file="/common/left.jsp"%>
	<form action="/boardReply" method="get" id="replyFrm">
		<input type="hidden" name="cont_num" id="cont_num"
			value="${content.cont_num }"> <input type="hidden"
			name="board_num" id="board_num" value="${board.board_num }">
		<input type="hidden" name="btn" id="btn" value="답글">
	</form>

	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/common/main.jsp">Board</a>
				</li>
				<li class="breadcrumb-item active">${board.board_name} / Detail</li>
			</ol>

			<div class="row">
				<div class="col-12">
					<h1>Detail</h1>
					<form id="frm" action="/boardWrite" method="get">
						<div class="form-group col-md-5">
							<label for="title">Title : </label> <input id="title"
								class="form-control form-control-lg" readonly type="text"
								value="${content.cont_title }">
						</div>
						<div class="form-row">
							<div class="form-group col-md-4">
								<label for="writer">Writer : </label> <input id="writer"
									class="form-control" readonly type="text" value="${writer }">
							</div>
							<div class="form-group col-md-4">
								<label for="date">Date : </label> <input id="date"
									class="form-control" readonly type="text"
									value="<fmt:formatDate value="${content.cont_date }" pattern="yyyy-MM-dd" />">

							</div>
							<div class="form-group col-md-4">
								<label for="attachment">첨부파일 : </label>
								<c:forEach items="${attachList }" var="attach">
								<li><a href="/attachDown?attach=${attach.att_name }&fileName=${attach.att_file}"> <i class="fa fa-download" aria-hidden="true"></i>${attach.att_name }
								</a></li> 
								</c:forEach>

							</div>
							<div class="form-group col-md-6">
								<input type="${type }" class="btn btn-primary" value="수정"
									name="btn" id="update"> <input type="${type }"
									class="btn btn-secondary" value="삭제" name="btn" id="delete">
								<input type="button" class="btn btn-success" value="답글"
									name="btn" id="reply">
							</div>
						</div>
						<div class="form-group">
							<label for="contentDetail">Detail : </label>
							<div class="dropdown-divider"></div>
							${content.cont_detail }
						</div>
						<input type="hidden" name="cont_num" id="cont_num"
							value="${content.cont_num }"> <input type="hidden"
							name="board_num" id="board_num" value="${board.board_num }">
					</form>
					<form action="/boardComment" method="get" id="newComment">

						<div class="form-group col-md-10">
							<label for="comment">Comments </label>
							<textarea class="form-control" id="comment" name="com_detail"
								rows="2" cols="5"></textarea>
							<input type="hidden" name="cont_num" value="${content.cont_num }">
							<button type="submit" class="btn btn-outline-info" name="btn"
								value="newComment" id="newC">write</button>
						</div>


						<input type="hidden" name="cont_num" id="cont_num"
							value="${content.cont_num }">
						<div class="form-row">
							<c:forEach items="${commentList }" var="com">
								<c:if test="${com.com_del =='Y' }">
									<div class="form-group col-md-10">
										<div class="dropdown-message small">삭제된 댓글 입니다</div>
										<div class="dropdown-divider"></div>
									</div>
								</c:if>
								<c:if test="${com.com_del == 'N' }">
									<div class="form-group col-md-10">
										<strong>${com.std_id }</strong> <span
											class="small float-right text-muted"><fmt:formatDate
												value="${com.com_date }" pattern="yyyy-MM-dd" /> <c:if
												test="${user.std_id == com.std_id }">

												<button type="submit" name="btn" value="delete"
													aria-hidden="true">
													<i class="fa fa-times" class="btn btn-link"></i> <input
														type="hidden" name="com_num" value="${com.com_num }">
												</button>
											</c:if> </span>
										<div class="dropdown-message small">${com.com_detail }</div>

										<div class="dropdown-divider"></div>
									</div>
								</c:if>
							</c:forEach>
						</div>

					</form>
				</div>
			</div>
			<!-- Logout Modal-->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
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