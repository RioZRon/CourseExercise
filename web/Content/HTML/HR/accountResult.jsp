<%@ page import="java.sql.Date" %>
<%@ page import="bean.main.A10" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="tools.StringTools" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>搜索病人</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/res/pic/icon/标签页图标.ico">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/Content/CSS/frame.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/Content/CSS/content.css">
    <script src="<%=basePath%>/Content/HTML/main/main.js"></script>
</head>
<body>
<div class="frameWidth" id="a11">
    <header class="remainForFloatingWin">
        <nav class="floatingWin">
            <div class="sitewrap">
                <div class="container-fluid">
                    <div class="floatLeft">
                        <a class="floatingWin-brand" href="<%=basePath%>/Content/HTML/main/index.html" >
                            <img alt="logo" style="height: 2.5rem" src="<%=basePath%>/res/pic/PNG/商标.png">
                        </a>
                    </div>
                    <div class="navigation">
                        <span class="floatingWin-bar">
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/main/index.html">主页</a>
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/HR/signup.jsp">注册账号</a>
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/HR/accountSelect.html"  class="selectPage">搜索账号</a>
                            <a style="color: #5d594d;" href="/servlet/main/LogOutServlet">登出</a>
                        </span>
                    </div>
                </div>
            </div>
        </nav>
    </header>
    <div>
        <div class="centerSub">
            <h1 class="result-title">搜索账号</h1>
            <form action="/servlet/main/AccountSelectDealWitha102103Servlet" method="post">
                <label class="result-lable" for="a102">姓名</label>
                <input type="text" class="result-input" id="a102" name="a102" value="${sessionScope.a102}">
                <label class="result-lable" for="a103">账号</label>
                <input type="text" class="result-input" id="a103" name="a103" value="${sessionScope.a103}">
                <input type="submit" value="搜索" class="result-submit" >
            </form>

            <hr style="margin: 80px 80px; opacity:0.5;">
            <%ArrayList<A10> a10ArrayList = (ArrayList<A10>)session.getAttribute("a10ArrayList");
                Iterator<A10> a10Iterator = a10ArrayList.iterator();
            %>

            <table style="margin-top: 50px" class="confermation-table" border="1px solid">
                <tr>
                    <th colspan="6" style="text-align: left; font-weight: 400; font-size:35px; padding-left: 20px">搜索结果</th>
                </tr>
                <tr>
                    <th>人员编号</th>
                    <th>姓名</th>
                    <th>账号</th>
                    <th>角色</th>
                    <th width="7%">删除</th>
                    <th width="7%">详情</th>
                </tr>
                <%
                    while(a10Iterator.hasNext()){
                        A10 nextA10 = a10Iterator.next();
                %>
                <tr>
                    <form action="" method="post">
                        <th><input type="number" class="maininput" id="rsa101" name="rsa101" value="<%=nextA10.getA101()%>" readonly></th>
                        <th><input type="text" class="maininput" id="rsa102" name="rsa102" value="<%=nextA10.getA102()%>" readonly></th>
                        <th><input type="text" class="maininput" id="rsa103" name="rsa103" value="<%=nextA10.getA103()%>" readonly></th>
                        <th><input type="text" class="maininput" id="rsa105" name="rsa105" value="<%=StringTools.RoleTraslate(nextA10.getA105())%>" readonly></th>
                        <th><input type="image" class="linkPic" src="<%=basePath%>/res/pic/PNG/药品/提交.png" alt="详细" onclick="confirm('delete?');form.action='/servlet/main/AccountDeleteServlet';form.submit()" ></th>
                        <th><input type="image" class="linkPic" src="<%=basePath%>/res/pic/PNG/药品/提交.png" alt="详细" onclick="form.action='/servlet/main/TurnToDetailServlet';form.submit()" ></th>
                    </form>
                </tr>
                <%
                    }
                %>
            </table>

            <div style="height: 100px"></div>
        </div>
    </div>
    <footer class="realFooterArea">
        <div class="footerHyperlinkList">
            <div class="firstRow">
                <div class="firstRow-inner">
                    <div class="footerHyperlinkListHead">红十字医院</div>
                    <a class="footerHyperlinkListLink" href="<%=basePath%>/Content/HTML/main/index.html" onmouseover="beFocu(this)" onmouseout="beblue(this)">主页</a>
                    <a class="footerHyperlinkListLink" href="<%=basePath%>/Content/HTML/main/overview.html" onmouseover="beFocu(this)" onmouseout="beblue(this)">医院概览</a>
                    <a class="footerHyperlinkListLink" href="<%=basePath%>/Content/HTML/main/functionList.html" onmouseover="beFocu(this)" onmouseout="beblue(this)">功能介绍</a>
                    <a class="footerHyperlinkListLink" href="<%=basePath%>/Content/HTML/main/linkExchange.html" onmouseover="beFocu(this)" onmouseout="beblue(this)">友情链接</a>
                </div>
            </div>
            <div class="SeccondRow">

                <div class="footerHyperlinkListHead">功能</div>
                <nav class="footernavFordetalFuc">
                    <div class="footernavFordetalFuc-first">
                        <h3 class="classifyHead">按模块</h3>
                        <div class="classifyDetail">
                            <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">病人管理</a>
                            <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">药品管理</a>
                            <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">住院管理</a>
                            <a href="<%=basePath%>/Content/HTML/HR/signup.jsp" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">人事管理</a>
                        </div>
                    </div>
                    <div class="footernavFordetalFuc-seccond">
                        <h3 class="classifyHead">按角色</h3>
                        <div class="classifyDetail">
                            <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">挂号</a>
                            <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">门诊</a>
                            <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">医药</a>
                            <a href="<%=basePath%>/Content/HTML/HR/signup.jsp" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">HR</a>
                            <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink unimpLink">住院</a>
                            <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink unimpLink">手术</a>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="firstRow">
                <div class="firstRow-inner">
                    <div class="footerHyperlinkListHead" onmouseover="beFocu(this)" onmouseout="beblue(this)">界面接口</div>
                    <a class="footerHyperlinkListLink" href="<%=basePath%>/Content/HTML/HR/signup.jsp" onmouseover="beFocu(this)" onmouseout="beblue(this)">注册账号</a>
                    <a class="footerHyperlinkListLink" href="<%=basePath%>/Content/HTML/HR/accountSelect.html" onmouseover="beFocu(this)" onmouseout="beblue(this)">搜索账号</a>
                    <a class="footerHyperlinkListLink" href="/servlet/main/LogOutServlet" onmouseover="beFocu(this)" onmouseout="beblue(this)">登出</a>
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
                <a class="buttonlink" href="https://github.com/RioZRon/CourseExercise">RioZRon</a>
                <span>/</span>
                <a class="buttonlink" href="https://github.com/RioZRon/CourseExercise">Team</a>

            </div>
            <div class="supportName">Made By D&T © 2017 Dec</div>
            <div class="hospitalName">青岛市黄岛区红十医院</div>
        </div>
    </footer>
</div>
</body>
</html>