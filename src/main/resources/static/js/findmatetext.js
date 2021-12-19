//import "/static/js/jquery-3.6.0"

window.onload = function () {
    document.getElementById("showBtn").onclick = function () {
        document.getElementById("showTe").style.display = 'block';
    }
}
window.onload = function () {
    document.getElementById("showH").onclick = function () {
        document.getElementById("showIn").style.display = 'block';
    }
}

//加入功能

$(document).ready(function (){
    $(".joinBtn").click(function (e){
        let target = $(e.currentTarget);
        $.ajax({
            type: "GET",
            url:"jointeam/"+target.attr("teamid"),
            dataType:"text",
            success:function (data){
                console.log(data);
                target.css("background-color", "#b9b9b9")
                target.text(data);
                target.off();
            },
            error:function (jqXHR){
                console.log("发生错误："+jqXHR.status);
            }
        })
    })
})