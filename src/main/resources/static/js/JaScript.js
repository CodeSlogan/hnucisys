//界面加载完毕执行以下程序
$(function(){
    //定义i变量为动态控制图片轮播做准备，i的值与每张图片进行一一的对应
    var i=0;
    //时间变量，为自动轮播以及对光标的影响做出相应的反应
    var timer=null;
    //根据图片的张数动态添加圆点个数
    for (var j = 0; j < $('.img li').length; j++) {
        $('.num').append('<li></li>');
    }
    //默认情况下的第一个圆点进行背景设计
    $('.num li').first().addClass('active');
    //根据光标的影响控制按钮的显示和隐藏
    $('.banner').hover(function(){
        $('.btn').show();
    },function(){
        $('.btn').hide();
    });
    //将第一张图片复制并添加到img部分下与前五张图片相接
    var firstimg=$('.img li').first().clone(); //复制第一张图片
    $('.img').append(firstimg).width($('.img li').length*($('.img img').width()));
    //定时器自动轮播
    timer=setInterval(function(){
        i++;
        if (i==$('.img li').length) {
            i=1;
            $('.img').css({left:0});//保证无缝轮播，设置left值
        }
        //进行下一张图片
        $('.img').stop().animate({left:-i*1024},500);
        //圆点跟着变化
        if (i==$('.img li').length-1) {
            $('.num li').eq(0).addClass('active').siblings().removeClass('active');
        }else{
            $('.num li').eq(i).addClass('active').siblings().removeClass('active');
        }
    },1500);
    //鼠标移入，暂停自动播放，移出，开始自动播放
    $('.banner').hover(function(){
        clearInterval(timer);
    },function(){
        timer=setInterval(function(){
            i++;
            if (i==$('.img li').length) {
                i=1;
                $('.img').css({left:0});
            };
            //进行下一张图片
            $('.img').stop().animate({left:-i*1024},500);
            //圆点跟着变化
            if (i==$('.img li').length-1) {
                $('.num li').eq(0).addClass('active').siblings().removeClass('active');
            }else{
                $('.num li').eq(i).addClass('active').siblings().removeClass('active');
            }
        },1000)
    });
    //上一个按钮
    $('.prev').click(function(){
        i--;
        if (i==-1) {
            i=$('.img li').length-2;
            $('.img').css({left:-($('.img li').length-1)*1024});
        }
        $('.img').stop().animate({left:-i*1024},500);
        $('.num li').eq(i).addClass('active').siblings().removeClass('active');
    });
    // 下一个按钮
    $('.next').click(function(){
        i++;
        if (i==$('.img li').length) {
            i=1; //这里不是i=0
            $('.img').css({left:0});
        };
        $('.img').stop().animate({left:-i*1024},500);
        if (i==$('.img li').length-1) { //设置小圆点指示
            $('.num li').eq(0).addClass('active').siblings().removeClass('active');
        }else{
            $('.num li').eq(i).addClass('active').siblings().removeClass('active');
        };
 
    });
    //鼠标划入圆点
    $('.num li').mouseover(function(){
        var _index=$(this).index();
        //维持i变量控制的对应关系不变
        i = _index;                 
        $('.img').stop().animate({left:-_index*1024},300);
        $('.num li').eq(_index).addClass('active').siblings().removeClass('active');
    });
 
})