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
    <title>药品详情</title>
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
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/medicine/keeperSelect.jsp" class="selectPage">搜索药品</a>
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/medicine/newInFlow.jsp">新药入库</a>
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/medicine/patientSelect.jsp">病人取药</a>
                            <a style="color: #5d594d;" href="/servlet/main/LogOutServlet">登出</a>
                        </span>
                    </div>
                </div>
            </div>
        </nav>
    </header>
    <main class="SearchContent">
        <h1 class="maintitle">药品入库</h1>

        <form action="/servlet/medicine/DoOldFlowInServlet" method="post">
            <%
                A60 a60 = (A60)session.getAttribute("a60");
            %>
            <table style="margin-top: 30px" class="confermation-table" border="1px solid">
                <tr>
                    <th colspan="4" style="text-align: center; font-weight: 400; font-size:35px">旧药品入库</th>
                </tr>
                <tr>
                    <th>药品编号</th>
                    <th><input type="number" class="maininput" id="a622" name="a622" value="<%=a60.getA601()%>" readonly></th>
                    <th>药品名称</th>
                    <th><input type="text" class="maininput" id="a623" name="a623" value="<%=a60.getA602()%>" readonly></th>
                </tr>
                <tr>
                    <th>进价</th>
                    <th><input type="number" step="0.01" id="a627" name="a627" class="maininput"></th>
                    <th>入库数量</th>
                    <th><input type="number" id="a625" name="a625" class="maininput" value="<%=(int)request.getAttribute("innumber")%>"></th>
                </tr>
                <tr>
                    <th>产地</th>
                    <th colspan="3"> <input type="text" id="a626" name="a626" class="maininput"></th>
                </tr>
                <tr>
                    <th>入库日期</th>
                    <th><input type="date" id="a624" name="a624" class="maininput"> </th>

                    <th>药品生产日期</th>
                    <th><input type="date" id="a628" name="a628" class="maininput" value=""></th>
                    <script>
                        document.getElementById('a624').valueAsDate = new Date();
                        document.getElementById('a628').valueAsDate = new Date();
                    </script>
                </tr>
            </table>
            <input type="submit" value="保存" class="mainformsubmit" >
        </form>


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