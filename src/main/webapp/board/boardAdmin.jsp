<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>BOARD_KHK</title>
  <% String path = pageContext.getServletContext().getContextPath(); %>
  <!-- Bootstrap core CSS-->
  <link href="/common/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="/common/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="/css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <%@include file="/common/left.jsp" %>
  <div class="content-wrapper">

    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <div class="card-header">
          <i class="fa fa-table"></i>   Board Admin </div>
        <div class="card-body">
<!--     <h2>게시판 생성</h2> -->
    <hr>
		<form id="frm" action="/boardAdmin" method="get">
			<div class="col-sm-12 col-md-6">
				<label>게시판 이름 : </label> 
				<input type="text" id="newBoard"name="newBoard" class="form-control form-control-sm"> 
				<select name="newB">
					<option value="Y">사용</option>
					<option value="N">미사용</option>
				</select>
				<button type="submit" name="btn" id="btn" value="new">생성</button>
			</div>
		</form>
		<br>
			<c:forEach items="${boardAdminList }" var="board">
		<form id="updateFrm" action="/boardAdmin" method="get">
				<div>
					<label>게시판 이름 : </label> 
					<input type="text" name="boardName"id="boardName" value=${board.board_name }> 
					<select name="updB">
						<option value="Y">사용</option>
						<option value="N">미사용</option>
					</select>
					<button type="submit" name="btn" id="btn" value="${board.board_num }">수정</button>

				</div>

		</form>
			</c:forEach>



		<!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
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
</body>

</html>
