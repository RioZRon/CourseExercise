<%@ page import="java.sql.Date" %>
<%@ page import="bean.main.A10" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="tools.StringTools" %>
<%@ page import="bean.register.A20" %>
<%@ page import="bean.medicine.A60" %>
<%@ page import="tools.OtherTools" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>处方列表</title>
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
                            <a style="color: #5d594d;" href="<%=basePath%>/servlet/medicine/SelectAllAlertMedicineServlet">警戒药品</a>
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/medicine/keeperSelect.jsp">搜索药品</a>
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/medicine/newInFlow.jsp">新药入库</a>
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/medicine/patientSelect.jsp" class="selectPage">病人取药</a>
                            <a style="color: #5d594d;" href="/servlet/main/LogOutServlet">登出</a>
                        </span>
                    </div>
                </div>
            </div>
        </nav>
    </header>
    <main class="SearchContent">
        <div class="centerSub">
            <h1 class="result-title">No. <%=session.getAttribute("a201")%>的处方</h1>
            <%
                ArrayList<A60> a60ArrayList = (ArrayList<A60>)session.getAttribute("a60ArrayList");
                Iterator<A60> a60Iterator = a60ArrayList.iterator();
            %>
            <table style="margin-top: 50px" class="confermation-table" border="1px solid">
                <tr>
                    <th colspan="6" style="text-align: left; font-weight: 400; font-size:35px; padding-left: 20px">药品明细</th>
                </tr>
                <tr>
                    <th>药品编号</th>
                    <th>药品名称</th>
                    <th>剩余数量</th>
                    <th>需要数量</th>
                    <th width="15%">售出</th>
                </tr>
                <%
                    while(a60Iterator.hasNext() ){
                        A60 nextA60 = a60Iterator.next();
                %>
                <tr>
                    <form action="">
                    <th><input type="number" class="maininput" id="a601" name="a601" value="<%=nextA60.getA601()%>" readonly></th>
                    <th><input type="text" class="maininput" id="a602" name="a602" value="<%=nextA60.getA602()%>" readonly></th>
                    <th><input type="number" class="maininput" id="a607" name="a607" value="<%=OtherTools.RemainNumToNumber(nextA60)%>" readonly></th>
                    <th><input type="number" class="maininput" id="innumber" name="innumber" value="<%=nextA60.getA608()%>"></th>
                    <th><input type="image" class="linkPic" src="<%=basePath%>/res/pic/PNG/药品/提交.png" alt="详细" onclick="form.action='/servlet/medicine/CreateFlowOutServlet';form.submit()" ></th>
                    </form>
                </tr><%
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
                                <a href="<%=basePath%>/servlet/medicine/SelectAllAlertMedicineServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">药品管理</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">住院管理</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">人事管理</a>
                            </div>
                        </div>
                        <div class="footernavFordetalFuc-seccond">
                            <h3 class="classifyHead">按角色</h3>
                            <div class="classifyDetail">
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">挂号</a>
                                <a href="/servlet/main/LogOutServle"  class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">门诊</a>
                                <a href="<%=basePath%>/servlet/medicine/SelectAllAlertMedicineServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">医药</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">HR</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink unimpLink">住院</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink unimpLink">手术</a>
                            </div>
                        </div>
                    </nav>
                </div>
                <div class="firstRow">
                    <div class="firstRow-inner">
                        <div class="footerHyperlinkListHead">界面接口</div>
                        <a class="footerHyperlinkListLink" href="<%=basePath%>/servlet/medicine/SelectAllAlertMedicineServlet" onmouseover="beFocu(this)" onmouseout="beblue(this)">警戒药品</a>
                        <a class="footerHyperlinkListLink" href="<%=basePath%>/Content/HTML/outpatientDoctor/keeperSelect.jsp" onmouseover="beFocu(this)" onmouseout="beblue(this)">搜索药品</a>
                        <a class="footerHyperlinkListLink" href="<%=basePath%>/Content/HTML/outpatientDoctor/newInFlow.jsp" onmouseover="beFocu(this)" onmouseout="beblue(this)">新药入库</a>
                        <a class="footerHyperlinkListLink" href="<%=basePath%>/Content/HTML/outpatientDoctor/patientSelect.jsp" onmouseover="beFocu(this)" onmouseout="beblue(this)">病人取药</a>
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
</div>
</body>
</html>