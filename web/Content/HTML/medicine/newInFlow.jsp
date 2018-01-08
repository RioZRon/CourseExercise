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
                            <a style="color: #5d594d;" href="/episodes" class="selectPage">警戒药品</a>
                            <a style="color: #5d594d;" href="/episodes">搜索药品</a>
                            <a style="color: #5d594d;" href="/episodes">病人取药</a>
                            <a style="color: #5d594d;" href="/search">登出</a>
                        </span>
                    </div>
                </div>
            </div>
        </nav>
    </header>
    <main class="SearchContent">
        <h1 class="maintitle">药品入库</h1>

        <form action="/servlet/medicine/DoNewFlowInServlet" method="post">
            <%
                A60 a60 = (A60)session.getAttribute("a60");
            %>
            <table style="margin-top: 30px" class="confermation-table" border="1px solid">
                <tr>
                    <th colspan="4" style="text-align: center; font-weight: 400; font-size:35px">新进药品</th>
                </tr>
                <tr>
                    <th>药品名称<font color="red">*</font></th>
                    <th><input type="text" class="maininput" id="a602" name="a602" value=""></th>
                    <th>药品类型<font color="red">*</font></th>
                    <th><select style="padding-left: 1%; margin-left: 1%; border: none" name="a605" id="a605" class="selectClass" >
                        <option value="1" selected>中药材</option>
                        <option value="2">中成药</option>
                        <option value="3">中西成药</option>
                        <option value="4">化学原料药及其制剂</option>
                        <option value="5">抗生素</option>
                        <option value="6">生化药品</option>
                        <option value="7">放射性药品</option>
                        <option value="8">疫苗</option>
                        <option value="9">血液制品</option>
                    </select></th>
                </tr>
                <tr>
                    <th>进价<font color="red">*</font></th>
                    <th><input type="number" id="a627" name="a627" class="maininput"></th>
                    <th>定价<font color="red">*</font></th>
                    <th><input type="number" id="a603" name="a603" class="maininput"></th>
                </tr>
                <tr>
                    <th>入库数量<font color="red">*</font></th>
                    <th><input type="number" id="a625" name="a625" class="maininput"></th>
                    <th>产地</th>
                    <th><input type="text" id="a626" name="a626" class="maininput"></th>
                </tr>
                <tr>
                    <th>生产商</th>
                    <th colspan="3"> <input type="text" id="a604" name="a604" class="maininput"></th>
                </tr>
                <tr>
                    <th>保质期<font color="red">*</font></th>
                    <th><input type="number" step="0.01" id="a606" name="a606" class="maininput"></th>
                    <th>警戒数量</th>
                    <th><input type="number" step="0.01" id="a608" name="a608" class="maininput"></th>
                </tr>
                    <th>放置位置</th>
                    <th><input type="text" class="maininput" id="a609" name="a609"></th>
                    <th>仓库位置</th>
                    <th><input type="text" id="a6010" name="a6010" class="maininput"></th>
                <tr>
                    <th>入库日期</th>
                    <th><input type="date" id="a624" name="a624" class="maininput"> </th>
                    <script>
                        document.getElementById('a624').valueAsDate = new Date();
                    </script>
                    <th>药品生产日期<font color="red">*</font></th>
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