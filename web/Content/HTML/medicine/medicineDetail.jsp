<%@ page import="bean.medicine.A60" %>
<%@ page import="tools.OtherTools" %>
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
        <h1 class="maintitle">药品详情</h1>
        <form action="/servlet/medicine/MedicineDetailSaveServlet" method="post">
        <table style="margin-top: 50px" class="confermation-table" border="1px solid">
            <%
                A60 a60 = (A60)session.getAttribute("a60");
            %>
            <tr>
                <th colspan="3" style="text-align: left"><%=a60.getA602()%></th>
            </tr>
            <tr>
                <th width="15%">药品编号</th>
                <th width="35%"><input type="number" class="maininput" id="a601" name="a601" value="<%=a60.getA601()%>" readonly></th>
                <th width="15%">药品名称</th>
                <th width="35%"><input type="text" class="maininput" id="a602" name="a602" value="<%=a60.getA602()%>" ></th>
            </tr>
            <tr>
                <th width="15%">药品价格</th>
                <th width="35%"><input type="number" class="maininput" id="a603" name="a603" value="<%=a60.getA603()%>"></th>
                <th width="15%">药品厂家</th>
                <th width="35%"><input type="text" class="maininput" id="" name="a604" value="<%=a60.getA604()%>"></th>
            </tr>
            <tr>
                <th width="15%">药品类型</th>
                <th><select style="padding-left: 1%; margin-left: 1%; border: none" name="a605" id="a605" class="selectClass" >
                    <option value="1">中药材</option>
                    <option value="2">中成药</option>
                    <option value="3">中西成药</option>
                    <option value="4">化学原料药及其制剂</option>
                    <option value="5">抗生素</option>
                    <option value="6">生化药品</option>
                    <option value="7">放射性药品</option>
                    <option value="8">疫苗</option>
                    <option value="9">血液制品</option>
                </select></th>
                <th>药品保质期</th>
                <th><input type="number" id="a606" name="a606" class="maininput" value="<%=a60.getA606()%>"></th>
            </tr>
            <tr>
                <th>警戒数量</th>
                <th><input type="number" id="a608" name="a608" class="maininput" value="<%=a60.getA608()%>"></th>
                <th>药品数量</th>
                <th><input type="number" id="a607" name="a607" class="maininput" value="<%=OtherTools.RemainNumToNumber(a60)%>" readonly></th>
            </tr>
            <tr>
                <th>放置位置</th>
                <th><input type="text" id="a609" name="a609" class="maininput" value="<%=StringTools.nullToEmpty(a60.getA609())%>"></th>
                <th>仓库位置</th>
                <th><input type="text" id="a6010" name="a6010" class="maininput" value="<%=StringTools.nullToEmpty(a60.getA6010())%>"></th>
            </tr>
            <input type="number" hidden id="flag" value="<%=a60.getA605()%>">
            <script>
                var state = document.getElementById("flag").value;
                if(state == 1)
                    document.getElementById("a105").options[0].selected = true;
                else if(state == 2)
                    document.getElementById("a105").options[1].selected = true;
                else if(state == 3)
                    document.getElementById("a105").options[2].selected = true;
                else if(state == 4)
                    document.getElementById("a105").options[3].selected = true;
                else if(state == 5)
                    document.getElementById("a105").options[4].selected = true;
                else if(state == 6)
                    document.getElementById("a105").options[5].selected = true;
                else if(state == 7)
                    document.getElementById("a105").options[6].selected = true;
                else if(state == 8)
                    document.getElementById("a105").options[7].selected = true;
                else
                    document.getElementById("a105").options[8].selected = true;
            </script>
        </table>
        <input type="submit" value="保存" class="mainformsubmit" >
        </form>
        <div style="margin-bottom: 150px"></div>
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