var flag={"petName":false,"petAge":false,"petSex":false};

function checkPetName(){
    var addPetName=$(this).val();
    var addPetNameLength = addPetName.length;
    if(addPetNameLength > 20){
        document.getElementById("warnPetName").innerHTML='<font color="red">宠物名字超出长度限制</font>';
        flag.petName = false;
    }else{
        flag.petName = true;
    }
}

function checkPetAge(){
    var addPetAge=$(this).val();
    var number=Number(addPetAge);
    if(number>30){
        document.getElementById("warnPetAge").innerHTML='<font color="red">年龄超出限制</font>';
        flag.petAge = false;
    }else{
        flag.petAge = true;
    }
}

function checkPetSex(){
    var addPetSex=$(this).val();
    if(addPetSex != "男" && addPetSex != "女"){
        document.getElementById("warnPetSex").innerHTML='<font color="red">请输入男或者女</font>';
        flag.petSex = false;
    }else{
        flag.petSex = true;
    }
}

function checkAction(){
    var ok = flag.petName&&flag.petAge&&flag.petSex;
    if(ok){
        alert("ok了")
        document.getElementById("addPetForm").action="/user/addPet";
    }else{
        alert("注册信息填写有误，请校验!");
    }
}

$(function(){
    $("#petName").blur(checkPetName);
    $("#petAge").blur(checkPetAge);
    $("#petSex").blur(checkPetSex);
    $('#signup-button').click(checkAction);
});