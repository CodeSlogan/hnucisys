//import "/static/js/jquery-3.6.0"

window.onload = function () {

}

var targetMessageId = 0;

$(document).ready(function () {

    //接受
    $(".acceptBtn1").click(function (e) {
        let target = $(e.currentTarget);
        var tuid = target.attr("tuid");
        console.log(tuid);
        var r = confirm("确认接受？");
        if (r !== true) {
            return;
        }
        $.ajax({
            type: "POST",
            url: "/news/acceptMate",
            dataType: "json",
            data: JSON.stringify(tuid),
            contentType: "application/json",
            success: function (data) {
                console.log(data);
                $("#content-wrapper").html(data);
            },
            error: function () {
                console.log("发生错误");
            }
        })
    })
    //拒绝
    $(".refuseBtn1").click(function (e) {
        let target = $(e.currentTarget);
        var tuid = target.attr("tuid");
        console.log(tuid);
        var r = confirm("确认拒绝？");
        if (r !== true) {
            return;
        }
        $.ajax({
            type: "POST",
            url: "/news/refuseMate",
            dataType: "json",
            data: JSON.stringify(tuid),
            contentType: "application/json",
            success: function (data) {
                console.log(data);
                $("#content-wrapper").html(data);
            },
            error: function () {
                console.log("发生错误");
            }
        })
    })
    //
    $('.acceptBtn2').click(function (e) {
        let target = $(e.currentTarget);
        targetMessageId = target.attr("messageId");
        console.log(targetMessageId);
        document.getElementById("showTe").style.display = 'block';
    })
    $('.cancelBtn').click(function () {
        document.getElementById("showTe").style.display = 'none';
    })
    $('.sentBtn').click(function (e) {
        let target = $(e.currentTarget);
        var txt = document.getElementById("replyMessageTxt").value;
        console.log(txt);
        document.getElementById("showTe").style.display = 'none';
        var userMessage = {
            messageid: targetMessageId,
            replymessage : txt,
        };
        $.ajax({
            type: "POST",
            url: "/news/replyinvitation",
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
