
function checkPetName(){
    var addPetName=$(this).val();
    var addPetNameLength = addPetName.length;
    if(addPetNameLength > 20){
        alert("222222222222");
        document.getElementById("warnPetName").innerHTML='<font color="red">宠物名字超出长度限制</font>';
        flag = false;
    }
}

function checkPetAge(){
    alert("4444444444444444");
    var addPetAge=$(this).val();
    var number=Number(addPetAge);
    if(number>30){
        document.getElementById("warnPetAge").innerHTML='<font color="red">年龄超出限制</font>';
        flag =  false;
    }
}

function checkPetSex(){
    var addPetSex=$(this).val();
    if(addPetSex != "男" && addPetSex != "女"){
        document.getElementById("warnPetSex").innerHTML='<font color="red">请输入男或者女</font>';
        flag = false;
    }
}

function checkAction(){
    var flag = true;
    var addPetName=$('#petName').val();
    var addPetNameLength = addPetName.length;
    if(addPetNameLength > 20){
        alert("222222222222");
        document.getElementById("warnPetName").innerHTML='<font color="red">宠物名字超出长度限制</font>';
        flag = false;
    }
    var addPetAge=$('#petAge').val();
    var number=Number(addPetAge);
    if(number>30){
        document.getElementById("warnPetAge").innerHTML='<font color="red">年龄超出限制</font>';
        flag =  false;
    }
    var addPetSex=$('#petSex').val();
    if(addPetSex != "公" && addPetSex != "母"){
        document.getElementById("warnPetSex").innerHTML='<font color="red">请输入公或者母</font>';
        flag = false;
    }
    if(flag){
        alert("ok了")
        document.getElementById("addPetForm").action="/user/editPet";
    }else{
        document.getElementById("addPetForm").action="/user/editPetFail";
    }
}

$(function(){
    $('#signup-button').click(checkAction);
});