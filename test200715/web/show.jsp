<%@ page import="java.util.*,entity.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="DealBiz" class="biz.impl.DealBizImpl" scope="page"/>
<jsp:useBean id="userBiz" class="biz.impl.UserBizImpl" scope="page"/>
<% ArrayList<Deal> dealList = DealBiz.getDeal();%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<div class="main">
    <h1>二手物品信息展示</h1>

    <% for(Deal deal:dealList){%>


    <div class="item">
        <div>
            <span style="font-size: 1.3rem;"><b><%= deal.getProductType() %></b></span>
            <span> <b style="color: #00bfa6;"><%= deal.getPrice() %></b> <span style="font-size: 1rem;">元</span></span>
            <span style="font-size: 1.1rem;color: #373645;"><%= deal.getNewLevel() %></span>
        </div>
        <div>
            <span style="font-size: 1rem;color: #686273;"><%= deal.getIntroduce() %></span>
        </div>
        <div>
					<span style="font-size: 1rem;color: #373645;">购于<span
                            style="color: #00BFA6;margin-right: 5px;"><%= deal.getBuyTimeYear() %></span>年
					<span style="color: #00BFA6;margin-right: 5px;"><%= deal.getBuyTimeMonth() %></span>月</span>
            <span style="font-size: 0.9rem;color: #373645;">联系方式：<span><%= deal.getContact() %></span></span>
            <span style="font-size: 0.9rem;color: #373645;"><%= deal.getContactPhone() %></span>
        </div>

    </div>
    <% }%>


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
        <a href="function.jsp">
            <span><b>发布交易</b></span>
        </a>
    </div>

    </div>


    </body>


    <style>

        a{
        color: #00bfa6;
            text-decoration: none;
        }

    body {
    padding: 0;
    background: url(../images/feedback.svg) no-repeat fixed 0% 0%;
    background-size: 80%;

    }

    .main {
    font-size: 1.2em;
    margin: 3rem auto;
    width: max-content;
    letter-spacing: 1px;
    text-align: center;

    }

    .main div {

    margin-top: 3rem;
    }

    .item{
    text-align: left;
    background: white;
    border: 3px #222 solid;
    border-radius: 1rem;
    padding: 1.2rem;

    }

    .item div{
    margin:0.4rem;
    }

    .item div span{
    margin-right: 1rem;

    }


    .side-bar{

    position: fixed;
    right: 3rem;
    top: 3rem;
    }


    .login-out, .publish{

    width: 6rem;
    height: 5rem;
    border: 4px #555 solid;
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
    line-height: 5rem;
    color: #00BFA6;
    font-size: 1.5rem;
    }
    .publish span{
    }
    </style>
    </html>
