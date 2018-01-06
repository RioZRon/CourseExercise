/**
 * Created by riosysm on 2018/1/2.
 */
function innerLongSize(str){
    var obj = document.getElementById(str);
    if(obj.value.length > 11)
    obj.style.width="90%";
    else{
        obj.style.width="50%";
    }
}
var showrescriptionFlag = 1;
function showrescription(){
    if(showrescriptionFlag == 1) {
        document.getElementById("showrescription").style.textShadow="0 0 1px gray";
        document.getElementById("forrescription").style.display = "block";
        showrescriptionFlag = 0;
    }
    else{
        document.getElementById("showrescription").style.textShadow="";
        document.getElementById("forrescription").style.display = "none";
        showrescriptionFlag = 1;
    }
}

var showoperationFlag = 1;
function showoperation(){
    if(showoperationFlag == 1) {
        document.getElementById("showoperation").style.textShadow="0 0 1px gray";
        document.getElementById("foroperation").style.display = "block";
        showoperationFlag = 0;
    }
    else{
        document.getElementById("showoperation").style.textShadow="";
        document.getElementById("foroperation").style.display = "none";
        showoperationFlag = 1;
    }
}

var showbeinhosFlag = 1;
function showbeinhos(){
    if(showbeinhosFlag == 1) {
        document.getElementById("showbeinhos").style.textShadow="0 0 1px gray";
        document.getElementById("forbeinhos").style.display = "block";
        showbeinhosFlag = 0;
    }
    else{
        document.getElementById("showbeinhos").style.textShadow="";
        document.getElementById("forbeinhos").style.display = "none";
        showbeinhosFlag = 1;
    }
}

function inspectTabAdd(){
    document.getElementById("inspectTable").innerHTML += " <tr>" +
        "                        <th><input type='text' class='maininput' id='a21513' name='a2151'></th>" +
        "                        <th><textarea class='maintextarea' id='a21523' name='a2152'></textarea></th>" +
        "                    </tr>"
}

function inspectTabDel() {
    //
    var tab =document.getElementById("inspectTable");
    if(tab.hasChildNodes())
    tab.lastElementChild.hidden=true;
}