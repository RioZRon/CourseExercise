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
        document.getElementById("forrescription").innerHTML = "<label class='inner EnterContent-lable' for='name'>处方</label>" +
            "<textarea class='maintextarea' style='height: 100px;' id='rescription' name='rescription'>维生素C咀嚼片 * 10; 吡嗪酰胺片 * 20; 云芝包内糖肽胶囊 * 20</textarea>";
        showrescriptionFlag = 0;
    }
    else{
        document.getElementById("showrescription").style.textShadow="";
        document.getElementById("forrescription").innerHTML = "";
        showrescriptionFlag = 1;
    }
}

var showoperationFlag = 1;
function showoperation(){
    if(showoperationFlag == 1) {
        document.getElementById("showoperation").style.textShadow="0 0 1px gray";
        document.getElementById("foroperation").innerHTML = "<label class='inner EnterContent-lable' for='name'>手术</label>" +
            "<textarea class='maintextarea' style='height: 100px;' id='operation' name='operation'>扁桃体切除</textarea>";
        showoperationFlag = 0;
    }
    else{
        document.getElementById("showoperation").style.textShadow="";
        document.getElementById("foroperation").innerHTML = "";
        showoperationFlag = 1;
    }
}

var showbeinhosFlag = 1;
function showbeinhos(){
    if(showbeinhosFlag == 1) {
        document.getElementById("showbeinhos").style.textShadow="0 0 1px gray";
        document.getElementById("forbeinhos").innerHTML = "<label class='inner EnterContent-lable' for='name'>住院需求</label>" +
            "<textarea class='maintextarea' style='height: 100px;' id='beinhos' name='beinhos'>普通病房 3天</textarea>";
        showbeinhosFlag = 0;
    }
    else{
        document.getElementById("showbeinhos").style.textShadow="";
        document.getElementById("forbeinhos").innerHTML = "";
        showbeinhosFlag = 1;
    }
}