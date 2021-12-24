//import "/static/js/jquery-3.6.0"

window.onload = function () {
/*    document.getElementById("invBtn1").onclick = function () {
        document.getElementById("showTe").style.display = 'block';
    }*/
/*    document.getElementById("sent").onclick = function () {
        document.getElementById("showTe").style.display = 'none';
    }*/
    document.getElementById("sure").onclick = function () {
        document.getElementById("showIn").style.display = 'none';
    }
}

var targetUserId = 0;

$(document).ready(function () {

    //加入功能
    $(".joinBtn").click(function (e) {
        let target = $(e.currentTarget);
        var r = confirm("确认加入？");
        if (r !== true) {
            return;
        }
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

    $('.invBtn').click(function (e) {
        let target = $(e.currentTarget);
        console.log(target.attr("userId"));
        targetUserId = target.attr("userId");
        document.getElementById("showTe").style.display = 'block';
        document.getElementById("xuhua").style.filter='blur(5px)';
    })
    $('.cancelBtn').click(function () {
        document.getElementById("showTe").style.display = 'none';
        document.getElementById("xuhua").style.filter='blur(0px)';
    })
    //发送邀请消息功能
    $('.sentBtn').click(function (e) {
        let target = $(e.currentTarget);
        console.log(targetUserId);
        var txt = document.getElementById("messageTxt").value;
        console.log(txt);
        document.getElementById("showTe").style.display = 'none';
        document.getElementById("xuhua").style.filter='blur(0px)';
        var userMessage = {
            guid: targetUserId,
            messagetext : txt,
        };
        $.ajax({
            type: "POST",
            url: "/invitemate",
            dataType: "json",
            data: JSON.stringify(userMessage),
            contentType: "application/json",
            success: function (data) {
                console.log(data)
            },
            error: function (e) {
                console.log(e)
            }
        })
    })
})
