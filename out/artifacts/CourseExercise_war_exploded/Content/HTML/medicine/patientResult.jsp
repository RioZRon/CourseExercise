<%@ page import="java.sql.Date" %>
<%@ page import="bean.main.A10" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="tools.StringTools" %>
<%@ page import="bean.register.A20" %>
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
</head>
<body>
<div class="frameWidth" id="a11">
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
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/registration/register.jsp">挂号</a>
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/HR/accountSelect.html" class="selectPage">搜索病人</a>
                            <a style="color: #5d594d;" href="/search">登出</a>
                        </span>
                    </div>
                </div>
            </div>
        </nav>
    </header>
    <main class="SearchContent">
        <div class="centerSub">
            <h1 class="result-title">搜索账号</h1>
            <form action="/servlet/medicine/PatientSelectDealWithNameIdServlet" method="post">
                <label class="result-lable" for="name">姓名</label>
                <input type="text" class="result-input" id="name" name="name" value="${sessionScope.name}">
                <label class="result-lable" for="id">挂号换号</label>
                <input type="text" class="result-input" id="id" name="id" value="${sessionScope.id}">
                <input type="submit" value="搜索" class="result-submit" >
            </form>

            <hr style="margin: 80px 80px; opacity:0.5;">
            <%ArrayList<A20> a20ArrayList = (ArrayList<A20>)session.getAttribute("a20ArrayList");
                Iterator<A20> a20Iterator = a20ArrayList.iterator();
                ArrayList<String> a215list = (ArrayList<String>)session.getAttribute("a215list");
                Iterator<String> a215Iterator = a215list.iterator();
            %>

            <table style="margin-top: 50px" class="confermation-table" border="1px solid">
                <tr>
                    <th colspan="6" style="text-align: left; font-weight: 400; font-size:35px; padding-left: 20px">搜索结果</th>
                </tr>
                <tr>
                    <th>挂号编号</th>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>医生处方</th>
                    <th width="7%">出库</th>
                    <th width="7%">全部出库</th>
                </tr>
                <%
                    while(a20Iterator.hasNext() && a215Iterator.hasNext()){
                        A20 nextA20 = a20Iterator.next();
                        String nexta215 = a215Iterator.next();
                %>
                <tr>
                    <form action="" method="post">
                        <th><input type="number" class="maininput" id="a201" name="a201" value="<%=nextA20.getA201()%>" readonly></th>
                        <th><input type="text" class="maininput" id="a202" name="a202" value="<%=nextA20.getA202()%>" readonly></th>
                        <th><input type="text" class="maininput" id="a204" name="a204" value="<%=nextA20.getA204()%>" readonly></th>
                        <th><input type="text" class="maininput" id="a217" name="a217" value="<%=nexta215%>" readonly></th>
                        <th><input type="image" class="linkPic" src="<%=basePath%>/res/pic/PNG/药品/提交.png" alt="详细" onclick="form.action='/servlet/medicine/ShowAllNeededMedicineDealWith201217Servlet';form.submit()"></th>
                        <th><input type="image" class="linkPic" src="<%=basePath%>/res/pic/PNG/药品/提交.png" alt="详细" onclick="confirm('全部出库?');form.action='/servlet/medicine/DoAllFlowOutServlet';form.submit()" ></th>
                    </form>
                </tr>
                <%
                    }
                %>

            </table>

        </div>
        <div style="height: 100px"></div>
    </main>

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
                        <a class="footerHyperlinkListLink" href="/about">主页</a>
                        <a class="footerHyperlinkListLink" href="/Episodes">预约挂号</a>
                        <a class="footerHyperlinkListLink" href="/Contact">登录</a>
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
</div>
</body>
</html>