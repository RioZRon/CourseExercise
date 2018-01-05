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
    <title>病人详情</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/res/pic/icon/标签页图标.ico">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/Content/CSS/frame.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/Content/CSS/content.css">
    <script src="hr.js"></script>
</head>
<body>
<main class="frameWidth">
    <!--headder-->
    <header class="remainForFloatingWin">
        <nav class="floatingWin">
            <div class="sitewrap">
                <div class="container-fluid">
                    <div class="floatLeft">
                        <a class="floatingWin-brand" href="frame.html" >
                            <img alt="logo" style="height: 2.5rem" src="<%=basePath%>/res/pic/PNG/商标.png">
                        </a>
                    </div>
                    <div class="navigation">
                        <span class="floatingWin-bar">
                              <a style="color: #5d594d;" href="/about">主页</a>
                            <a style="color: #5d594d;" href="/episodes"class="selectPage">添加账号</a>
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/HR/accountSelect.html">修改账号</a>
                            <a style="color: #5d594d;" href="/search">登出</a>
                        </span>
                    </div>
                </div>
            </div>
        </nav>
    </header>

    <!--main-->
    <div>
        <h1 class="maintitle">账号注册</h1>
        <fieldset style="width: 50%;">
            <legend>SignUp</legend>
            <form action="/servlet/main/SignUpServlet" style="padding-top: 50px" method="post">
                <div class="inner EnterContent-group">
                    <label class="inner EnterContent-lable" for="a102">姓名</label>
                    <input type="text" class="inner EnterContent-input longwidth" style="padding-left: 15px" id="a102" name="a102" value="">
                </div>
                <div class="inner EnterContent-group">
                    <label class="inner EnterContent-lable" for="a103">账号</label>
                    <input type="text" class="inner EnterContent-input longwidth" style="padding-left: 15px" id="a103" name="a103" value="">
                </div>
                <div class="inner EnterContent-group">
                    <label class="inner EnterContent-lable" for="a104">密码</label>
                    <img src="<%=basePath%>/res/pic/PNG/眼睛%20(2).png" alt="显示密码" class="showPassword" onclick="showhide_password()" id="showpassword">
                    <input type="password" class="inner EnterContent-input longwidth" style="padding-left: 15px" id="a104" name="a104" value="">
                </div>
                <div class="inner EnterContent-group">
                    <label class="inner EnterContent-lable" for="a105">角色</label>
                    <br>
                    <select name="a105" id="a105" class="selectClass">
                        <option value="1" selected>挂号</option>
                        <option value="2">门诊</option>
                        <option value="3">病房</option>
                        <option value="4">手术</option>
                        <option value="5">管理员</option>
                    </select>
                </div>
                <input type="submit" value="保存" class="mainformsubmit" >
            </form>
        </fieldset>

    </div>


    <!--底部-->
    <div class="framefooterArea">
        <footer class="realFooterArea">
            <div class="footerHyperlinkList">
                <div class="firstRow">
                    <div class="firstRow-inner">
                        <div class="footerHyperlinkListHead">红十字医院</div>
                        <a class="footerHyperlinkListLink" href="/about">主页</a>
                        <a class="footerHyperlinkListLink" href="/Episodes">医院概览</a>
                        <a class="footerHyperlinkListLink" href="/Contact">功能介绍</a>
                        <a class="footerHyperlinkListLink" href="/Search">专家出诊</a>
                        <a class="footerHyperlinkListLink" href="/Subscribe">友情链接</a>
                    </div>
                </div>
                <div class="SeccondRow">

                    <div class="footerHyperlinkListHead">功能</div>
                    <nav class="footernavFordetalFuc">
                        <div class="footernavFordetalFuc-first">
                            <h3 class="classifyHead">按模块</h3>
                            <div class="classifyDetail">
                                <a href="/catalog/subject/web-development" class="footerHyperlinkListLink">病人管理</a>
                                <a href="/catalog/subject/web-development" class="footerHyperlinkListLink">药品管理</a>
                                <a href="/catalog/subject/web-development" class="footerHyperlinkListLink">住院管理</a>
                                <a href="/catalog/subject/web-development" class="footerHyperlinkListLink">人事管理</a>
                            </div>
                        </div>
                        <div class="footernavFordetalFuc-seccond">
                            <h3 class="classifyHead">按角色</h3>
                            <div class="classifyDetail">
                                <a href="/catalog/subject/web-development" class="footerHyperlinkListLink">挂号</a>
                                <a href="/catalog/subject/web-development" class="footerHyperlinkListLink">门诊</a>
                                <a href="/catalog/subject/web-development" class="footerHyperlinkListLink">医药</a>
                                <a href="/catalog/subject/web-development" class="footerHyperlinkListLink">住院</a>
                                <a href="/catalog/subject/web-development" class="footerHyperlinkListLink">手术</a>
                                <a href="/catalog/subject/web-development" class="footerHyperlinkListLink">财务</a>
                            </div>
                        </div>
                    </nav>
                </div>
                <div class="firstRow">
                    <div class="firstRow-inner">
                        <div class="footerHyperlinkListHead">界面接口</div>
                        <a class="footerHyperlinkListLink" href="/about">挂号</a>
                        <a class="footerHyperlinkListLink" href="/Episodes">收费</a>
                        <a class="footerHyperlinkListLink" href="/Contact">登出</a>
                    </div>
                </div>
            </div>
            <div class="SocialMediaLink">
                <a href="https://github.com/RioZRon/CourseExercise">
                    <img src="<%=basePath%>/res/pic/PNG/socialMedia/github-square.png" alt="github" class="socialmedialinkico">
                </a>
                <a href="https://github.com/RioZRon/CourseExercise">
                    <img src="<%=basePath%>/res/pic/PNG/socialMedia/微信.png" alt="wechat" class="socialmedialinkico">
                </a>
                <a href="https://github.com/RioZRon/CourseExercise">
                    <img src="<%=basePath%>/res/pic/PNG/socialMedia/qq.png" alt="qq" class="socialmedialinkico" style="height: 1.6rem; margin-bottom: .08rem; margin-left: .2rem">
                </a>
                <a href="Mailto:rioZron@outlook.com">
                    <img src="<%=basePath%>/res/pic/PNG/socialMedia/POP_Gmail.png" alt="mail" class="socialmedialinkico" style="height:1.75em; margin-bottom: .125rem; margin-left: .5rem">
                </a>
            </div>
            <div class="support">
                <div class="SourceForkLink">
                    <a class="buttonlink" href="/https://github.com/RioZRon/CourseExercise">RioZRon</a>
                    <span>/</span>
                    <a class="buttonlink" href="/https://github.com/RioZRon/CourseExercise">Team</a>

                </div>
                <div class="supportName">Made By D&T © 2017 Dec</div>
                <div class="hospitalName">青岛市黄岛区红十医院</div>
            </div>
        </footer>
    </div>
</main>
</body>
</html>