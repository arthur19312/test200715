<%@ page import="java.util.*,entity.*,dao.*,dao.impl.*" pageEncoding="utf-8" %>
<%
	UserDao userDao = new UserDaoImpl();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>登录</title>
	</head>
	<body>
		
		<div class="login-box">
			<div class="login-text">
				welcome
			</div>
			<form id="form1" name="form1" method="post" action="LoginServlet" onsubmit="return check()">
			<div style="text-align: left">

				<div class="input-box">
					<input class="input-text" name="userName" type="text" id="userName" required="required"/>
					<div class="trans-text">
						username
					</div>
				</div>

				<div class="input-box">
					<input class="input-text" name="userPsw" type="password" id="userPsw" required="required"/>
					<div class="trans-text">
						password
					</div>
				</div>
			</div>
			
			<div>
				<button type="submit" class="login-button"><b>LOGIN</b></button>
			</div>
			</form>

			
			
			
		</div>
		
		
		
	</body>

	<style>

		body{
			background: linear-gradient(45deg, #FEAC5E,#C779D0);
			padding: 0;
			font-family: "lucida grande";
		}

		.login-box{
			position: absolute;
			left: 50%;
			top: 50%;
			transform: translate(-50%,-50%);
			height: 30rem;
			width: 25rem;
			background: white;
			box-shadow: 0 0 30px 5px rgba(255,255,255,0.3);
			text-transform: uppercase;
			text-align: center;
		}

		.login-text{
			font-size: 2rem;
			color: #888;
			margin-top: 3rem;
		}

		.input-box{
			position: relative;
			border-bottom: #aaa 2px solid;
			width: 60%;
			height: 2rem;
			margin: 3.5rem auto;

		}
		.input-box:first-of-type{
			margin-top: 4rem;
		}


		.input-text{
			height: 100%;
			width: 95%;
			position: absolute;
			top: -25%;
			font-size: 1.2rem;
			color: #555;
			outline: none;
			border: 0;
		}

		.trans-text{
			position: absolute;
			left: 0;
			z-index:2;
			color: #999;
			pointer-events: none;

			transition: 0.5s ease;
		}

		.input-text:focus+.trans-text,.input-text:valid+.trans-text{
			transform: scale(0.8) translate(-10%,-180%);
		}

		.input-text:invalid{
			box-shadow: none;
		}


		.login-button{
			height: 3rem;
			width: 15rem;
			border: #555 2px solid;
			outline: none;
			background: white;
			color: #333;
			letter-spacing: 5px;
			font-family: "lucida grande";
		}

		.login-button:hover{
			background: #555;
			color: white;
		}







	</style>
	
	<script type="application/javascript">
		/* var transActive=(ele)=>{
			
			ele.nextElementSibling.classList.add("trans-text-active");
			
			
		} */
		
		
		
		
	</script>
</html>
