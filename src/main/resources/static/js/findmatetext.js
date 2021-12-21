//import "/static/js/jquery-3.6.0"

window.onload = function () {
    document.getElementById("showBtn").onclick = function () {
        document.getElementById("showTe").style.display = 'block';
    }
    document.getElementById("sent").onclick = function () {
        document.getElementById("showTe").style.display = 'none';
    }
    document.getElementById("showH").onclick = function () {
        document.getElementById("showIn").style.display = 'block';
    }
    document.getElementById("sure").onclick = function () {
        document.getElementById("showIn").style.display = 'none';
    }
}


//加入功能

$(document).ready(function () {
    $(".joinBtn").click(function (e) {
        let target = $(e.currentTarget);
        $.ajax({
            type: "GET",
            url: "jointeam/" + target.attr("teamid"),
            dataType: "text",
            success: function (data) {
                console.log(data);
                target.css("background-color", "#b9b9b9")
                target.text(data);
                target.off();
            },
            error: function (jqXHR) {
                console.log("发生错误：" + jqXHR.status);
            }
        })
    })
})

$("#renameClick").click(function (e) {
    e.stopPropagation();   // 阻止冒泡
    $('#back').css("display", "block");   // 显示
    $("#showRename").css("display", "block");

    $("#back").bind("click", function (e) {   // 相当于点击空白消失
        $('#back').css("display", "none");
        $("#showRename").css("display", "none");
    });
});

function invitationConfirm(){
    var r = confirm("邀请确认？")
    if (r == true) {

    } else {

    }
}