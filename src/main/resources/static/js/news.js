//import "/static/js/jquery-3.6.0"

window.onload = function () {

}

var targetUserId = 0;

$(document).ready(function () {

    //接受
    $(".acceptBtn1").click(function (e) {
        let target = $(e.currentTarget);
        var tuid = target.attr("tuid");
        console.log(tuid);
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
})
