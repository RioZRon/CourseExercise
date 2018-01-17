<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
<<<<<<< HEAD
    <title>预约挂号</title>
=======
    <title>挂号</title>
>>>>>>> dfde6936bb23f7bde5940d53bdc83ec738d4e34b
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/res/pic/icon/标签页图标.ico">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/Content/CSS/frame.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/Content/CSS/content.css">
</head>
<body>
<main class="frameWidth">
    <!--headder-->
    <header class="remainForFloatingWin">
        <nav class="floatingWin">
            <div class="sitewrap">
                <div class="container-fluid">
                    <div class="floatLeft">
<<<<<<< HEAD
                        <a class="floatingWin-brand" href="index.html" >
=======
                        <a class="floatingWin-brand" href="frame.html" >
>>>>>>> dfde6936bb23f7bde5940d53bdc83ec738d4e34b
                            <img alt="logo" style="height: 2.5rem" src="<%=basePath%>/res/pic/PNG/商标.png">
                        </a>
                    </div>
                    <div class="navigation">
                        <span class="floatingWin-bar">
<<<<<<< HEAD
                            <a style="color: #5d594d;" href="./index.html">主页</a>
                            <a style="color: #5d594d;" href="./bookingPage.jsp"class="selectPage">预约挂号</a>
                            <a style="color: #5d594d;" href="signin.html">登录</a>
=======
                            <a style="color: #5d594d;" href="index.html" class="selectPage">主页</a>
                            <a style="color: #5d594d;" href="bookingPage.jsp">预约挂号</a>
                            <a style="color: #5d594d;" href="signIn.html">登录</a>
>>>>>>> dfde6936bb23f7bde5940d53bdc83ec738d4e34b
                        </span>
                    </div>
                </div>
            </div>
        </nav>
    </header>
    <main class="SearchContent">
        <div class="centerSub">
            <h1 class="maintitle">挂号预约</h1>
            <form action="/servlet/main/AfterBookingServlet" method="post">
                <label class="mainlable" for="name">姓名</label>
                <div class="inputbod">
                    <input type="text" class="maininput" id="name" name="name">
                </div>
                <label class="mainlable" for="identityCard">身份证号码</label>
                <div class="inputbod">
                    <input type="text" class="maininput" id="identityCard"  name="identityCard">
                </div>
                <label class="mainlable" for="phoneNumber">联系电话</label>
                <div class="inputbod">
                    <input type="number" class="maininput" id="phoneNumber" name="phoneNumber">
                </div>
                <input type="submit" value="提交" class="mainsubmit" >
            </form>
        </div>
    </main>
</main>
</body>
</html>
