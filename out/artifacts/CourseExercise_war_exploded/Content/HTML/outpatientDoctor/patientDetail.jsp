<%@ page import="java.sql.Date" %>
<%@ page import="bean.register.A20" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="bean.outpatientdocter.A21" %>
<%@ page import="tools.StringTools" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
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
    <script src="<%=basePath%>/Content/HTML/outpatientDoctor/optpatientDoctor.js"></script>
    <script src="<%=basePath%>/Content/HTML/main/main.js"></script>
</head>
<body>
<main class="frameWidth">
    <!--headder-->
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
                            <a style="color: #5d594d;" href="<%=basePath%>/servlet/outpatientDoctor/BeforPatientListServlet">候诊病人</a>
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/outpatientDoctor/patientSelect.jsp"  class="selectPage">搜索病人</a>
                            <a style="color: #5d594d;" href="/servlet/main/LogOutServlet">登出</a>
                        </span>
                    </div>
                </div>
            </div>
        </nav>
    </header>

    <!--main-->
    <div>
        <h1 class="maintitle">病历</h1>
        <fieldset>
            <%
                A20 a20 = (A20)session.getAttribute("a20");
                A21 a21 = (A21)session.getAttribute("a21");
                SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                String a2012str = simFormat.format(a20.getA2012());
            %>
            <legend><%=a20.getA202()%></legend>
            <form action="" method="post">
                <div class="displayFlex">
                    <div class="flex-first">
                        <div class="inner EnterContent-group">
                            <label class="inner EnterContent-lable" for="a202">姓名</label>
                            <input type="text" class="inner EnterContent-input shortwidth" id="a202" name="a202" value="<%=StringTools.nullToEmpty(a20.getA202())%>">
                        </div>
                        <div class="inner EnterContent-group">
                            <label class="inner EnterContent-lable" for="a203">年龄</label>
                            <input type="number" class="inner EnterContent-input shortwidth" id="a203" name="a203" value="<%=a20.getA203()%>">
                        </div>
                        <div class="inner EnterContent-group">
                            <label class="inner EnterContent-lable" for="a204">电话</label>
                            <input type="text" class="inner EnterContent-input shortwidth" id="a204" name="a204" value="<%=StringTools.nullToEmpty(a20.getA204())%>">
                        </div>
                        <div class="inner EnterContent-group">
                            <label class="inner EnterContent-lable" for="a208" >常住住址</label>
                            <input type="text" class="inner EnterContent-input longwidth" id="a208" name="a208"  value="<%=StringTools.nullToEmpty(a20.getA208())%>" onkeyup="innerLongSize('a208')">
                            <script>
                                innerLongSize("a208");
                            </script>
                        </div>
                        <div class="inner EnterContent-group">
                            <label class="inner EnterContent-lable" for="a209">初查</label>
                            <input type="text" class="inner EnterContent-input longwidth"  id="a209" name="a209" value="<%=StringTools.nullToEmpty(a20.getA209())%>" onkeyup="innerLongSize('a209')">
                            <script>
                                innerLongSize("a209");
                            </script>
                        </div>
                        <div class="inner EnterContent-group">
                            <label class="inner EnterContent-lable" for="a2011">特殊情况备注</label>
                            <input type="text" class="inner EnterContent-input longwidth" id="a2011" name="a2011" value="<%=StringTools.nullToEmpty(a20.getA2011())%>" onkeyup="innerLongSize('a2011');">
                            <script>
                                innerLongSize("a2011");
                            </script>
                        </div>

                    </div>
                    <div class="flex-first">
                        <div class="inner EnterContent-group">
                            <label class="inner EnterContent-lable" for="a212">病症</label>
                            <input type="text" class="inner EnterContent-input longwidth" id="a212" name="a212" value="<%=StringTools.nullToEmpty(a21.getA212())%>" onkeyup="innerLongSize('a212');">
                            <script>
                                innerLongSize("a212");
                            </script>
                        </div>
                        <div class="inner EnterContent-group">
                            <label class="inner EnterContent-lable" for="a213">病史</label>
                            <input type="text" class="inner EnterContent-input longwidth" id="a213" name="a213" value="<%=StringTools.nullToEmpty(a21.getA213())%>" onkeyup="innerLongSize('a213');">
                            <script>
                                innerLongSize("a213");
                            </script>
                        </div>
                        <div class="inner EnterContent-group">
                            <label class="inner EnterContent-lable" for="a214">体检</label>
                            <input type="text" class="inner EnterContent-input longwidth" id="a214" name="a214" value="<%=StringTools.nullToEmpty(a21.getA214())%>" onkeyup="innerLongSize('a214');">
                            <script>
                                innerLongSize("a214");
                            </script>
                        </div>

                    </div>
                </div>
                <hr style="margin: 80px 80px;opacity:0.5">

                <table style="margin-top: 50px" class="confermation-table" border="1px solid" id="inspectTable">
                    <tr>
                        <th colspan="2" style="text-align: left; font-weight: 400; font-size:24px; padding-left: 20px"><%=StringTools.nullToEmpty(a20.getA202())%>的检查结果
                            <input type="image" class="linkPic" style="width:15px" src="<%=basePath%>/res/pic/PNG/加.png" onclick="inspectTabAdd()">
                            <%--<input type="image" class="linkPic" style="width:15px" src="<%=basePath%>/res/pic/PNG/加.png" onclick="inspectTabDel()">--%>
                        </th>
                    </tr>
                    <tr>
                        <th width="30%">检查名称</th>
                        <th width="70%">现象</th>
                    </tr>
                    <%
                        String a215 = a21.getA215();;
                        HashMap<String,String> hashMap = StringTools.A215StrToMap(a215);
                        if (hashMap != null){
                            for(Map.Entry<String, String> entry : hashMap.entrySet()){
                    %>
                    <tr>
                        <th><input type="text" class="maininput" id="a21511" name="a2151" value="<%=entry.getKey()%>"></th>
                        <th><textarea class="maintextarea" id="a21521" name="a2152"><%=entry.getValue()%></textarea></th>
                    </tr>
                    <%
                            }
                        }
                    %>
                    <tr>
                        <th><input type="text" class="maininput" id="a21512" name="a2151" value=""></th>
                        <th><textarea class="maintextarea" id="a21522" name="a2152"></textarea></th>
                    </tr>
                    <tr>
                        <th><input type="text" class="maininput" id="a21513" name="a2151" value=""></th>
                        <th><textarea class="maintextarea" id="a21523" name="a2152"></textarea></th>
                    </tr>

                </table>

                <hr style="margin: 80px 80px; opacity:0.5">
                <div class="inner EnterContent-group">
                    <label class="inner EnterContent-lable" for="a216">诊断</label>
                    <textarea class="maintextarea" style="height: 150px;" id="a216" name="a216"><%=StringTools.nullToEmpty(a21.getA216())%></textarea>
                    <span class="functionbutton" id="showrescription" onclick="showrescription()">处方</span>
                    <span class="functionbutton" id="showoperation" onclick="showoperation()">安排手术</span>
                    <span class="functionbutton" id="showbeinhos" onclick="showbeinhos()">安排住院</span>
                    <div style="height: 50px"></div>
                    <div id="forrescription" style="display: none;">
                        <label class="inner EnterContent-lable" for="a217">处方</label>
                        <textarea class="maintextarea" style="height: 100px;" id="a217" name="a217"><%=StringTools.nullToEmpty(a21.getA217())%></textarea>
                        <!--<hr style="margin: 30px 80px">-->
                    </div>
                    <div id="foroperation" style="display: none;">
                        <label class="inner EnterContent-lable" for="a218">手术</label>
                        <textarea class="maintextarea" style="height: 100px;" id="a218" name="a218"><%=StringTools.nullToEmpty(a21.getA218())%></textarea>
            
                    </div>
                    <div id="forbeinhos" style="display: none;">
                        <label class="inner EnterContent-lable" for="a219">住院需求</label>
                        <textarea class="maintextarea" style="height: 100px;" id="a219" name="a219"><%=StringTools.nullToEmpty(a21.getA219())%></textarea>
                    </div>
                    <hr style="margin: 30px 80px;opacity:0.5">
                </div>

                <input type="submit" value="保存" class="mainformsubmit" onclick="form.action='/servlet/outpatientDoctor/PrescriptionDetailSaveServlet';form.submit()">
                <input type="submit" value="打印" class="mainformsubmit" style="margin-left: 5%" onclick="form.action='/servlet/outpatientDoctor/PrescriptionDetailPrintServlet';form.submit()">

            </form>

        </fieldset>


    </div>


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
                                <a href="<%=basePath%>/servlet/outpatientDoctor/BeforPatientListServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">病人管理</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">药品管理</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">住院管理</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">人事管理</a>
                            </div>
                        </div>
                        <div class="footernavFordetalFuc-seccond">
                            <h3 class="classifyHead">按角色</h3>
                            <div class="classifyDetail">
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">挂号</a>
                                <a href="<%=basePath%>/servlet/outpatientDoctor/BeforPatientListServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">门诊</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">医药</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">HR</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink unimpLink">住院</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink unimpLink">手术</a>
                            </div>
                        </div>
                    </nav>
                </div>
                <div class="firstRow">
                    <div class="firstRow-inner">
                        <div class="footerHyperlinkListHead" onmouseover="beFocu(this)" onmouseout="beblue(this)">界面接口</div>
                        <a class="footerHyperlinkListLink" href="<%=basePath%>/servlet/outpatientDoctor/BeforPatientListServlet" onmouseover="beFocu(this)" onmouseout="beblue(this)">候诊病人</a>
                        <a class="footerHyperlinkListLink" href="<%=basePath%>/Content/HTML/outpatientDoctor/patientSelect.jsp" onmouseover="beFocu(this)" onmouseout="beblue(this)">搜索病人</a>
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
</main>
</body>
</html>
