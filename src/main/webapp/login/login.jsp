<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="/bootstrap-login-forms/form-3/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/bootstrap-login-forms/form-3/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="/bootstrap-login-forms/form-3/assets/css/form-elements.css">
        <link rel="stylesheet" href="/bootstrap-login-forms/form-3/assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/bootstrap-login-forms/form-3/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/bootstrap-login-forms/form-3/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/bootstrap-login-forms/form-3/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="/bootstrap-login-forms/form-3/assets/ico/apple-touch-icon-57-precomposed.png">
        
        <%@ include file="/common/jquery.jsp" %>
<script type="text/javascript">
	function getCookie(name) {
		var cookies = document.cookie;

		var cookieArr = cookies.split("; ");
		var cookieResult = "";

		for ( var i in cookieArr) {
			var cookie = cookieArr[i];
			var cookieNamevalue = cookie.split("=");

			var cookieName = cookieNamevalue[0];
			var cookieValue = cookieNamevalue[1];

			if (name == cookieName) {
				cookieResult = cookieValue;
				break;
			}
		}
		return cookieResult;
	}

	function setCookie(cookieName, cookieValue, expires) {
		var dt = new Date();
		dt.setDate(dt.getDate() + parseInt(expires));
		document.cookie = cookieName + "=" + cookieValue + "; path=/; expires="
				+ dt.toGMTString() + ";";
	}

	function deleteCookie(cookieName) {
		setCookie(cookieName, "", -1);
	}

	$(function() {
		if (getCookie("rememberMe") == "y") {
			//userId input에 userId cookie값을 설정
			$("#userId").val(getCookie("userId"));
			$("#rememberMe").attr("checked", true);
			$("#rememberMe").val(getCookie("rememberMe"));

		}

		//체크박스 클릭 이벤트
		$("#rememberMe").on("click", function() {
			if ($(this).is(":checked")) {
				setCookie("rememberMe", "y", 30);
				setCookie("userId", $("#userId").val(), 30);
			} else {
				//쿠키 제거
				deleteCookie("rememberMe");
			}

		});

	});
</script>


</head>

    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Login</h3>
                            		<p>Enter your username and password to log on:)</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="/loginServlet" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">User Id</label>
			                        	<input type="text" name="form-username" placeholder="UserId..." class="form-username form-control" id="userId">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" name="password" placeholder="Password..." class="form-password form-control" id="password">
			                        </div>
								<div class="checkbox">
									<label> <input type="checkbox" id="rememberMe"
										name="rememberMe"> Remember me
									</label>
								</div>
								<button type="submit" class="btn">Sign in!</button>
			                    </form>
			                    
			                    <%
			                    session.setAttribute("userId", request.getParameter("userId"));
			                    session.setAttribute("password", request.getParameter("password"));
			                    %>
		                    </div>
                        </div>
                    </div>
                
                </div>
            </div>
            
        </div>
        


        <!-- Javascript -->
        <script src="/bootstrap-login-forms/form-3/assets/js/jquery-1.11.1.min.js"></script>
        <script src="/bootstrap-login-forms/form-3/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="/bootstrap-login-forms/form-3/assets/js/jquery.backstretch.min.js"></script>
        <script src="/bootstrap-login-forms/form-3/assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>