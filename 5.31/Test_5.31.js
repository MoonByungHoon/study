var i = 0;

$("#aa").mouseover(function() {
    $("#a", this).hide();
    const rand= Math.floor(Math.random() * 4) + 1;
    switch(rand){
        case 1:
            $("#b").show();
            break;
        case 2:
            $("#c").show();
            break;
        case 3:
            $("#d").show();
            break;
        case 4:
            $("#e").show();
            break;
    }
})

$("#bb").mouseover(function() {
    $("#b", this).hide();
    const rand= Math.floor(Math.random() * 4) + 1;
    switch(rand){
        case 1:
            $("#a").show();
            break;
        case 2:
            $("#c").show();
            break;
        case 3:
            $("#d").show();
            break;
        case 4:
            $("#e").show();
            break;
    }
})
$("#cc").mouseover(function() {
    $("#c", this).hide();
    const rand= Math.floor(Math.random() * 4) + 1;
    switch(rand){
        case 1:
            $("#b").show();
            break;
        case 2:
            $("#a").show();
            break;
        case 3:
            $("#d").show();
            break;
        case 4:
            $("#e").show();
            break;
    }
})
$("#dd").mouseover(function() {
    $("#d", this).hide();
    const rand= Math.floor(Math.random() * 4) + 1;
    switch(rand){
        case 1:
            $("#b").show();
            break;
        case 2:
            $("#c").show();
            break;
        case 3:
            $("#a").show();
            break;
        case 4:
            $("#e").show();
            break;
    }
})
$("#ee").mouseover(function() {
    $("#e", this).hide();
    const rand= Math.floor(Math.random() * 4) + 1;
    switch(rand){
        case 1:
            $("#b").show();
            break;
        case 2:
            $("#c").show();
            break;
        case 3:
            $("#d").show();
            break;
        case 4:
            $("#a").show();
            break;
    }
})
$("#a").click(function() {
    $("#ff").text("축하드립니다 공짜커피 획득");
})
$("#b").click(function() {
    $("#ff").text("축하드립니다 공짜커피 획득");
})
$("#c").click(function() {
    $("#ff").text("축하드립니다 공짜커피 획득");
})
$("#d").click(function() {
    $("#ff").text("축하드립니다 공짜커피 획득");
})
$("#e").click(function() {
    $("#ff").text("축하드립니다 공짜커피 획득");
})