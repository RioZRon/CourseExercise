/**
 * Created by riosysm on 2018/1/3.
 */

var tack = 0;
function showhide_password(){
    var pwd=document.getElementById("A104");
    var img=document.getElementById("showpassword");
    if(tack == 0){
        pwd.type="text";
        img.src="../../../res/pic/PNG/眼睛%20(3).png";
        tack =  1;
    }
    else
    {
        img.src="../../../res/pic/PNG/眼睛%20(2).png";
        tack = 0;
        pwd.type="password";

    }
}