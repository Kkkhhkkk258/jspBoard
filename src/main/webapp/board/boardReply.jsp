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
<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico" />

<!-- jQuery -->
<!-- <script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery-ui.min.js"></script>-->
<script src="/SE2/js/HuskyEZCreator.js"></script>
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
<title>ContentDetail</title>
<script type="text/javascript">
	var oEditors = [];
	$(document).ready(
			function() {
				// Editor Setting
				nhn.husky.EZCreator.createInIFrame({
					oAppRef : oEditors, // 전역변수 명과 동일해야 함.
					elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
					sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
					fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
					htParams : {
						// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseToolbar : true,
						// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseVerticalResizer : true,
						// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
						bUseModeChanger : true,
					}
				});
				
				// 전송버튼 클릭이벤트
				$("#savebutton").click(
						function() {
							if (confirm("저장하시겠습니까?")) {
								// id가 smarteditor인 textarea에 에디터에서 대입
								oEditors.getById["smarteditor"].exec(
										"UPDATE_CONTENTS_FIELD", []);

								// 이부분에 에디터 validation 검증
								// 			if(validation()) {
								$("#frm").submit();
								// 			}
							}
						})
			});

	//필수값 Check
	function validation() {
		var contents = $.trim(oEditors[0].getContents());
		if (contents === '<p>&nbsp;</p>' || contents === '') { // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
			alert("내용을 입력하세요.");
			oEditors.getById['smarteditor'].exec('FOCUS');
			return false;
		}

		return true;
	}
</script>

</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<%@include file="/common/left.jsp"%>

	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/common/main.jsp">Board</a>
				</li>
				<li class="breadcrumb-item active">${board.board_name}/NewPost</li>
			</ol>

			<div class="row">
				<div class="col-12">
					<h1>Write</h1>
					<form action="/boardReply" method="post" id="frm" enctype="multipart/form-data">

						<div class="form-group col-md-4">
							<label for="title">Title : </label> <input name="title"
								id="title" class="form-control form-control-lg" type="text"
								placeholder="제목을 입력하세요"> <input type="hidden"
								name="cont_num" value="${paCont.cont_num }"> <input
								type="hidden" name="btn" value="답글">
						</div>
						<div class="form-group col-md-4">
							<input type="file" name="uploadFile" multiple="multiple">
						</div>
						<div class="form-group">
							<label for="contentDetail">Detail : </label>
							<!-- ---------------------------------------------------- -->
							<textarea name="smarteditor" id="smarteditor" rows="10"
								cols="100" style="width: 766px; height: 412px;">
								
							</textarea>

							<!-- ---------------------------------------------------- -->
						</div>
						<input class="btn btn-warning" type="button" id="savebutton"
							value="저장" name="btn" /> <input type="hidden" name="board_num"
							value="${paCont.board_num }">
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