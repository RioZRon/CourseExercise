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
    <title>挂号</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/res/pic/icon/标签页图标.ico">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/Content/CSS/frame.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/Content/CSS/content.css">
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
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/registration/register.jsp" class="selectPage">挂号</a>
                            <a style="color: #5d594d;" href="<%=basePath%>/Content/HTML/registration/patientSelect.jsp">搜索病人</a>
                            <a style="color: #5d594d;" href="/servlet/main/LogOutServlet">登出</a>
                        </span>
                    </div>
                </div>
            </div>
        </nav>
    </header>

    <!--main-->
    <div>
        <h1 class="maintitle">病人挂号栏</h1>
        <fieldset>
            <legend>挂号</legend>
            <form action="/servlet/registration/AfterRegisterServlet" method="post">
                <div class="EnterContent">
                    <div class="EnterContent-group">
                        <label class="EnterContent-lable" for="a202">姓名</label>
                        <input type="text" class="EnterContent-input shortwidth" id="a202" name="a202">
                    </div>
                    <div class="EnterContent-group">
                        <label class="EnterContent-lable" for="a203">年龄</label>
                        <input type="number" class="EnterContent-input shortwidth" id="a203" name="a203">
                    </div>
                    <div class="EnterContent-group">
                        <label class="EnterContent-lable" for="a204">电话</label>
                        <input type="number" class="EnterContent-input shortwidth" id="a204" name="a204">
                    </div>
                    <div class="EnterContent-group">
                        <label class="EnterContent-lable" for="a205">联系人</label>
                        <input type="text" class="EnterContent-input shortwidth" id="a205" name="a205">
                    </div>
                    <div class="EnterContent-group">
                        <label class="EnterContent-lable" for="a206">联系人电话</label>
                        <input type="number" class="EnterContent-input shortwidth" id="a206" name="a206">
                    </div>
                    <div class="EnterContent-group">
                        <label class="EnterContent-lable" for="a207">身份证号</label>
                        <input type="text" class="EnterContent-input longwidth" id="a207" name="a207">
                    </div>
                    <div class="EnterContent-group">
                        <label class="EnterContent-lable" for="a208">常住住址</label>
                        <input type="text" class="EnterContent-input longwidth" id="a208" name="a208">
                    </div>

                    <hr style=" margin-right: 12%; margin-top: 80px; margin-bottom: 80px">
                    <div class="EnterContent-group">
                        <label class="EnterContent-lable" for="a209">初查</label>
                        <input type="text" class="EnterContent-input longwidth" id="a209" name="a209">
                    </div>
                    <div class="EnterContent-group">
                        <label class="EnterContent-lable" for="a2010">建议分科</label>
                        <%--<input type="text" class="EnterContent-input longwidth" id="a2010" name="a2010">--%>
                        <select name="a2010" id="a2010" class="selectClass" style="margin-left: 3%;  width: 54%">
                            <option value="1" selected>内科</option>
                            <option value="2">外科</option>
                            <option value="3">儿科</option>
                            <option value="4">妇科</option>
                            <option value="5">耳鼻喉科</option>
                            <option value="6">口腔科</option>
                            <option value="7">皮肤科</option>
                            <option value="8">中医科</option>
                        </select>
                    </div>
                    <div class="EnterContent-group">
                        <label class="EnterContent-lable" for="a2011">特殊情况备注</label>
                        <input type="text" class="EnterContent-input longwidth" id="a2011" name="a2011">
                    </div>
                    <div class="EnterContent-group">
                        <label class="EnterContent-lable" for="a2012">挂号时间</label>
                        <input type="datetime-local" class="EnterContent-input longwidth" id="a2012" name="a2012">
                        <script>
                            var date = new Date();
                            function turn(num){
                                return ((new Array(3)).join('0') + num).slice(-2);
                            }
                            //                        alert(turn(date.getMonth()+1));
                            var datetime = date.getFullYear() +"-"+ turn(date.getMonth()+1)+"-"+ turn(date.getDate())+"T"+ turn(date.getHours()) +":"+ turn(date.getMinutes());
                            //                        alert(datetime);
                            document.getElementById('a2012').value= datetime;
                        </script>
                    </div>

                    <input type="submit" value="缴费确认" class="mainformsubmit" >
                </div>
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
                                <a href="<%=basePath%>/Content/HTML/registration/register.jsp" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">病人管理</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">药品管理</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">住院管理</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">人事管理</a>
                            </div>
                        </div>
                        <div class="footernavFordetalFuc-seccond">
                            <h3 class="classifyHead">按角色</h3>
                            <div class="classifyDetail">
                                <a href="<%=basePath%>/Content/HTML/registration/register.jsp" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">挂号</a>
                                <a href="/servlet/main/LogOutServlet" class="footerHyperlinkListLink" onmouseover="beFocu(this)" onmouseout="beblue(this)">门诊</a>
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
                        <a class="footerHyperlinkListLink" href="<%=basePath%>/Content/HTML/registration/register.jsp" onmouseover="beFocu(this)" onmouseout="beblue(this)">挂号</a>
                        <a class="footerHyperlinkListLink" href="<%=basePath%>/Content/HTML/registration/patientSelect.jsp" onmouseover="beFocu(this)" onmouseout="beblue(this)">搜索病人</a>
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
