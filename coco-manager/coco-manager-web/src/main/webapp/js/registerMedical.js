/**
 * Created by Administrator on 2017/4/9 0009.
 */

function checkAction(){
    var flag = true;
    var cid = $('#cid').val();
    var registerTime  = $('#registerTime').val();
    var time = new Date(registerTime).format("yyyy-MM-dd");
    var today = new Date();
    var today1 = today.format("yyyy-MM-dd");
    var hour = today.getHours();
    if(cid.length == 0){
        alert("请选择部门");
        flag = false;
    }
    if(registerTime.length == 0){
        alert("请选择预约时间");
        flag = false;
    }else if(time == today1&&hour >= 17){
        alert("今天已经不能挂号了，请选择明天");
        flag = false;
    }else if(time < today1){
        alert("不能选择这个时间挂号");
        flag = false;
    }else{
        alert("挂号成功");
        document.getElementById("registerMedical").action="/user/registerMedical";
    }
}

$(function(){
    $('#signup-button').click(checkAction);
});