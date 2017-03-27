var flag={"registerUserName":false,"registerPassWord":false,
    "comfirmPassWord":false,"registerNickName":false,"registerTelePhone":false};
//验证用户名
function checkUserName(){
    var registerUserName=$(this).val();
    var pattern1 = /^1(3[0-9]|5[0-35-9]|8[025-9])\d{8}$/;
    var pattern2 = /^([a-z0-9]*[-_]?[a-z0-9]+)*@([a-z0-9]*[-_]?[a-z0-9]+)+[\.][a-z]{2,3}([\.][a-z]{2})?$/i;
    if(!pattern1.test(registerUserName) && !pattern2.test(registerUserName)){
        document.getElementById("warnRegisterName").innerHTML='<font color="red">请输入您的手机号或者邮箱进行注册</font>';
        flag.registerUserName = false;
        return;
    }
    //验证用户名是否存在
    $.ajax(
        {
            type:"POST",
            url:"/register/checkRegisterName",
            data:{
                registerName:$("#registerUserName").val()
            },
            dataType:"text",
            success:function(data){
                if(data=="true" && pattern1.test(registerUserName)){
                    document.getElementById("warnRegisterName").innerHTML='<font color="red">该手机号已经注册</font>';
                    flag.registerUserName = false;
                    return;
                }else if(data=="true" && pattern2.test(registerUserName)){
                    document.getElementById("warnRegisterName").innerHTML='<font color="red">该邮箱已经注册</font>';
                    flag.registerUserName = false;
                    return;
                }else if(data=="false"){
                    document.getElementById("warnRegisterName").innerHTML='<font color="green">该用户名可以使用</font>';
                    flag.registerUserName = true;
                }
            }
        }
    )
}

function checkRegisterPassWord(){
    var pwd=$(this).val();
    var pattern2=/((?=.*\d)(?=.*\D)|(?=.*[a-zA-Z])(?=.*[^a-zA-Z]))^.{8,16}$/;
    if(!pattern2.test(pwd)){
        document.getElementById("warnRegisterPassword").innerHTML='<font color="red">密码长度必须在8-16位,必须包含字母、数字、符号至少两种字符</font>';
        flag.registerPassWord = false;
    }else{
        document.getElementById("warnRegisterPassword").innerHTML='<font color="green">密码格式正确</font>';
        flag.registerPassWord = true;
    }
}

function checkComfirmPassWord(){
    var comfirmPwd=$(this).val();
    var pwd = $("#registerPassWord").val();
    if(comfirmPwd != pwd){
        document.getElementById("warnComfirmPassWord").innerHTML='<font color="red">两次密码输入不一致</font>';
        flag.comfirmPassWord = false;
    }else{
        document.getElementById("warnComfirmPassWord").innerHTML='<font color="green">两次密码输入一致</font>';
        flag.comfirmPassWord = true;
    }
}

function checkNickName(){
    var nickName = $("#nickName").val();
    var nickNameLength = nickName.length;
    if(nickNameLength >= 38){
        document.getElementById("warnNickName").innerHTML='<font color="red">该昵称超出长度限制</font>';
        return ;
    }
    //验证用户名是否存在
    $.ajax(
        {
            type:"POST",
            url:"/register/checkNickName",
            data:{
                registerNickName:$("#nickName").val()
            },
            dataType:"text",
            success:function(data){
                if(data=="true"){
                    document.getElementById("warnNickName").innerHTML='<font color="red">该昵称已经存在</font>';
                    flag.registerNickName = false;
                }else{
                    document.getElementById("warnNickName").innerHTML='<font color="green">该昵称可以使用</font>';
                    flag.registerNickName = true;
                }
            }
        }
    )
}

function checkTelePhone(){
    var registerTelephone=$(this).val();
    var pattern1 = /^1(3[0-9]|5[0-35-9]|8[025-9])\d{8}$/;
    if(!pattern1.test(registerTelephone)){
        document.getElementById("warnPhone").innerHTML='<font color="red">请输入正确格式的手机号进行注册</font>';
        flag.registerTelePhone = false;
    }else{
        document.getElementById("warnPhone").innerHTML='<font color="green">手机格式正确</font>';
        flag.registerTelePhone = true;
    }
}

function checkAction(){
    var ok = flag.registerUserName&&flag.registerPassWord&&flag.comfirmPassWord&&flag.registerNickName&&flag.registerTelePhone;
    if(ok){
        alert("ok了")
        document.getElementById("userRegisterForm").action="/register/userRegister";
    }else{
        alert("注册信息填写有误，请校验!");
    }
}

$(function(){
    $("#registerUserName").blur(checkUserName);
    $("#registerPassWord").blur(checkRegisterPassWord);
    $("#comfirmPassWord").blur(checkComfirmPassWord);
    $("#nickName").blur(checkNickName);
    $("#telePhone").blur(checkTelePhone);
    $('#signup-button').click(checkAction);
});








