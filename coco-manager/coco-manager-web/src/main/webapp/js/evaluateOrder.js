function checkAction(){
    var flag = true;
    var words=$('#words').val();
    var wordsLength = words.length;
    if(wordsLength > 30){
        flag = false;
    }
    var score=$('#score').val();
    var number=Number(score);
    if(number>10 || number < 0){
        flag =  false;
    }
    if(flag){
        alert("ok了")
        document.getElementById("addPetForm").action="/user/evaluate";
    }else{
        alert("错误");
        // document.getElementById("addPetForm").action="/user/editPetFail";
    }
}

$(function(){
    $('#signup-button').click(checkAction);
});