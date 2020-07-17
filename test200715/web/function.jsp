<%@ page import="java.util.*,entity.*,dao.*,dao.impl.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<div class="main">
			<h1>二手物品信息发布</h1>
			<form name="postForm" method="post"	action="/PostServlet">
			<div>
				<b>产品类型：</b>
				<span class="radio">
					<input id="radio-1" name="productName" value="台式机" type="radio">
					<label for="radio-1" class="radio-label">台式机</label>
				</span>
				<span class="radio">
					<input id="radio-2" name="productName" value="笔记本" type="radio">
					<label for="radio-2" class="radio-label">笔记本</label>
				</span>
				<span class="radio">
					<input id="radio-3" name="productName" value="none" type="radio" disabled>
					<label for="radio-3" class="radio-label">不能点</label>
				</span>
			</div>
			
			<div>
				
				<b>购买年月：</b>
				<span class="input-box">
					<input class="input-text" name="buyTimeYear"  required="required"/>
				</span>
				年
				<span class="input-box">
					<input class="input-text" name="buyTimeMonth"  required="required"/>
				</span>
				月
			</div>
			
			<div>
				
				<b>转让价格：</b>
				<span class="input-box">
					<input class="input-text"name="price"   required="required"/>
				</span>
				元
			</div>
			
			<div>
				
				<b>新旧程度：</b>
				
				<select name="newLevel">
				  <option value="全新">全新</option>
				  <option value="95成新">95成新</option>
				  <option value="9成新">9成新</option>
				  <option value="8成新">8成新</option>
				  <option value="7成新及以下">7成新及以下</option>
				</select>
			</div>
			
			<div>
				
				<b>详细介绍：</b>
				
				<textarea rows="3" maxlength="140" name="introduce" style="vertical-align: top;"></textarea>
			</div>
			
			<div>
				
				<b>联系人：</b>
				<span class="input-box" style="width: 8rem;">
					<input class="input-text" name="contact" required="required"/>
				</span>
			</div>
			
			<div>
				
				<b>联系电话：</b>
				<span class="input-box"  style="width: 12rem;">
					<input class="input-text" name="contactPhone" required="required"/>
				</span>
			</div>
			
			<div>
				<button name="submit" type="submit" class="login-button"><b>发 布</b></button>
			</div>

			</form>

		</div>
<div class="side-bar">
		<div class="login-out">
			<c:choose>
				<c:when test="${sessionScope.loginUser == null}">
					<div class="in">
						<a href="/LoginServlet">
							登录
						</a>
					</div>
				</c:when>
				<c:otherwise>
					<jsp:useBean id="loginUser" class="entity.User" scope="session"/>

					<div class="username">
						<b>${sessionScope.loginUser.getUserName()}</b>
					</div>
					<div class="out">
						<a href="/LogoutServlet">
							退出登录
						</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="publish">

			<a href="show.jsp">
			<span><b>进入展板</b></span>
			</a>
		</div>

	</div>
		




	</body>

	<style>

		a{
			color: #00BFA6;
			text-decoration: none;
		}

		body{
			padding: 0;
			background: url(../images/select.svg) no-repeat fixed 0% 60%;
			background-size: 40%;
			
		}
		
		
		.radio {
			margin: 0.5rem;
		}

		.radio input[type="radio"] {
			position: absolute;
			opacity: 0;
		}

		.radio input[type="radio"]+.radio-label:before {
			content: '';
			background: #f4f4f4;
			border-radius: 100%;
			border: 1px solid #00bfa6;
			display: inline-block;
			width: 1.2em;
			height: 1.2em;
			margin-right: 1em;
			vertical-align: top;
			cursor: pointer;
			text-align: center;
			-webkit-transition: all 250ms ease;
			transition: all 250ms ease;
		}

		.radio input[type="radio"]:checked+.radio-label:before {
			background-color: #00bfa6;
			box-shadow: inset 0 0 0 4px #f4f4f4;
		}

		.radio input[type="radio"]:focus+.radio-label:before {
			outline: none;
			border-color: #00bfa6;
		}

		.radio input[type="radio"]:disabled+.radio-label:before {
			box-shadow: inset 0 0 0 4px #f4f4f4;
			border-color: #b4b4b4;
			background: #b4b4b4;
		}
		
		.main{
			padding-left: 45%;font-size: 1.2em;margin-top: 3rem;
			
			
			}
			.main div{
				
				margin-top: 3rem;
				}
		.input-box{
			margin: 0.2em;
			border-bottom: #aaa 1px solid;
			width: 4rem;
			display: inline-block;
		}
		
		.input-text{
			height: 100%;
			width: 95%;
			font-size: 1.2rem;
			color: #222;
			outline: none;
			border: 0;
			text-align: center;
		}
		
		.login-button{
			margin-top: 2rem;
			height: 3rem;
			width: 15rem;
			border: #222 2px solid;
			outline: none;
			background: white;
			color: #333;
			cursor: pointer;
			font-size:1.1rem;
		}
		.login-button:hover{
			background: #474665;
			color: #fff;
		}
		
		
		.side-bar{
		
			position: fixed;
			right: 3rem;
			top: 3rem;
		}
		
		
		.login-out, .publish{
		
			width: 6rem;
			height: 5rem;
			border: 2px #00BFA6 solid;
			border-radius: 6px;
			padding: 1rem;
		
		}
		.login-out .username{
			margin-bottom: 1rem;
		}
		.login-out .in{
			color: #00BFA6;
			text-decoration: underline;
		}
		.login-out .out{
			color: #00BFA6;
			text-decoration: underline;
		}


        .publish{
            margin-top: 3rem;
            color: #00BFA6;
            font-size: 0.8rem;
            box-sizing: border-box;
        }
		.publish span{
		}
				
				
		
	</style>
</html>
