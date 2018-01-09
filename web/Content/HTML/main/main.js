/**
 * Created by riosysm on 2017/12/31.
 */
function turnblue(){
    document.getElementById("detail").style.color="#2a96db";
    document.getElementById("detailArr").style.marginLeft="7px";
    document.getElementById("detailArr").src="../../../res/pic/PNG/detailblue.png";
}

function turnback(){
    document.getElementById("detail").style.color="black";
    document.getElementById("detailArr").style.marginLeft="3px";
    document.getElementById("detailArr").src="../../../res/pic/PNG/detailB.png";
}

function focusFirst(){
    document.getElementById("overview").style.color="#2a96db";
    document.getElementById("overview").style.fontSize="24px";
    document.getElementById("overview").style.marginBottom="20px";
    document.getElementById("overview-content").style.marginBottom="20px";
}

function blurFirst(){
    document.getElementById("overview").style.color="black";
    document.getElementById("overview").style.fontSize="14px";
    document.getElementById("overview").style.marginBottom="4px";
    document.getElementById("overview-content").style.marginBottom="";
}

function focusSecond(){
    document.getElementById("expert").style.color="#2a96db";
    document.getElementById("expert").style.fontSize="24px";
    document.getElementById("expert").style.marginBottom="20px";
    document.getElementById("expert-content").style.marginBottom="20px";
}

function blurSecond(){
    document.getElementById("expert").style.color="black";
    document.getElementById("expert").style.fontSize="14px";
    document.getElementById("expert").style.marginBottom="4px";
    document.getElementById("expert-content").style.marginBottom="";
}

function focusThird(){
    document.getElementById("canlendar").style.color="#2a96db";
    document.getElementById("canlendar").style.fontSize="24px";
    document.getElementById("canlendar").style.marginBottom="20px";
    document.getElementById("canlendar-content").style.marginBottom="20px";
}

function blurThird(){
    document.getElementById("canlendar").style.color="black";
    document.getElementById("canlendar").style.fontSize="14px";
    document.getElementById("canlendar").style.marginBottom="4px";
    document.getElementById("canlendar-content").style.marginBottom="";
}

function showhide_password(){
    var pwd=document.getElementById("password");
    var img=document.getElementById("showpassword")
    if(tack == 0){
        pwd.type="text";
        img.src="../../res/png/function/眼.png";
        tack =  1;
    }
    else
    {
        img.src="../../res/png/function/眼%20(1).png";
        tack = 0;
        pwd.type="password";

    }
}

function beFocu(obj) {
    obj.style.textShadow="1px 1px 1px #e8df7e";
}

function beblue(obj) {
    obj.style.textShadow="none";
}