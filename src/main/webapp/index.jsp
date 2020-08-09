<%--
  Created by IntelliJ IDEA.
  User: 15595
  Date: 2020/3/25
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> BCIRS </title>
    <!-- Bootstrap and Others CSS -->
    <link rel="stylesheet" href="../static/bootstrap-4.4.1-dist/css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="../static/css/style.css">
    <link rel="stylesheet" href="../static/css/font-awesome.min.css">
    <link rel="stylesheet" href="../static/css/webuploader.css">
    <link rel="stylesheet" href="../static/css/uploader.css">


    <!-- JavaScript files-->
    <script src="../static/jquery/jquery.js"></script>
    <script src="../static/js/jquery.form.js"></script>
    <script src="../static/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
    <%-- <script src="../static/js/webploader-0.1.5/webuploader.min.js"></script>--%>
    <script src="../static/js/feather.min.js"></script>
    <script src="../static/js/webuploader.js"></script>
    <script src="../static/js/ekko-lightbox.min.js"></script>

    <style>
        <!--
        头部样式

        -->
        .right1 {
            position: absolute;
            right: 40px;
        }

        .right2 {
            position: absolute;
            right: 120px;
        }

        .right3 {
            position: absolute;
            right: 200px;
        }

        .right4 {
            position: absolute;
            right: 280px;
        }
        .deleteResult{
            position: absolute;
            right: 200px;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #111;
        }

        .active {
            background-color: #4CAF50;
        }

        p.main {
            text-align: center;
        }

        <!--
        上传图片部分的样式
        -->
        .caret {
            display: inline-block;
            width: 0;
            height: 0;
            margin-left: 2px;
            vertical-align: middle;
            border-top: 4px dashed;
            border-top: 4px solid \9;
            border-right: 4px solid transparent;
            border-left: 4px solid transparent;
        }

        #main .block header h2 {
            font-size: 1em;
            font-weight: 600;
            text-transform: uppercase;
            border-bottom: 1px solid #d5d5d5;
            padding-bottom: 0.5em;
        }

        #bot #main .block {
            margin-bottom: 2em;
        }

        #bot #main .block h2 {
            margin-top: 0;
        }

        #bot #main .block h3 {
            margin-top: 0;
        }

        #bot #main .block p.tagline {
            font-size: 1.2em;
        }

        #bot #main .block p.link {
            color: #3f93f1;
        }

        #bot #main .block p.link a {
            color: #3f93f1;
        }

        #bot #main .block p.link a:hover {
            color: #7d7d7d;
            text-decoration: none;
        }

        #bot #main .block p.ph {
            color: #777;
            margin: 0;
        }

        #bot #main .block p.ph a {
            color: #d6573d;
        }

        #bot #main .block p.ph a:hover {
            color: #7d7d7d;
            text-decoration: none;
        }
    </style>
</head>


<body οnlοad="time()">
<!-- 动画效果 -->
<div id="animated-circle">
    <div id="animated-circle-iconContainer">
        <div id="animated-circle-icon" class="">
            <div class="animated-circle-box">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                     stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                     class="animated-circle-icon2 feather feather-codepen">
                    <polygon points="12 2 22 8.5 22 15.5 12 22 2 15.5 2 8.5 12 2"></polygon>
                    <line x1="12" y1="22" x2="12" y2="15.5"></line>
                    <polyline points="22 8.5 12 15.5 2 8.5"></polyline>
                    <polyline points="2 15.5 12 8.5 22 15.5"></polyline>
                    <line x1="12" y1="2" x2="12" y2="8.5"></line>
                </svg>
            </div>
        </div>
    </div>
</div>
<!--导航栏顶部-->
<nav class="navbar navbar-light navbar-main sticky-top navbar-expand">

    <div id="header-wrap" class="invisible"></div>

    <a class="navbar-brand mr-auto animation-popup-hover animation-popup-hover-no-shadow d-sm-block"
       href="../index.jsp">
        <img title="BCIRS software logo" alt="BCIRS software logo" class="logo1" src="../static/images/bcirs.png">
    </a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        MENU
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="no-border  btn btn-sm btn-outline-secondary right4" href="#">联系</a>
            </li>
            <li class="nav-item">
                <a class="no-border btn btn-sm btn-outline-secondary right3" href="#">指南</a>
            </li>
            <li class="nav-item btn-no-auth">
                <a class=" btn btn-sm btn-outline-secondary right2" href="#">登录</a>
            </li>
            <li class="nav-item btn-no-auth">
                <a class=" btn btn-sm btn-outline-success right1" href="#">注册</a>
            </li>
        </ul>
    </div>
</nav>
<br>
<br>
<br>
<div>
    <h3>
        <p class="main">
            在线银行卡信息识别系统
        </p>
        <%--<span id="day"> <p id="time"></p></span>--%>
    </h3>
    <h4>
        <div id="day"></div>
    </h4>
    <br>
    <br>
</div>
<div id="media" class="block">
    <header>
        <h4>
            <span data-toggle="collapse" data-target="#uploader">第一步：上传文件<span class="caret"></span></span>
            <a style="float: right;" class="text-warning" href="#" data-toggle="modal"
               data-target="#feedback">点我反馈问题？</a>
        </h4>
    </header>
    <div id="uploader">
        <div class="queueList">
            <div id="dndArea" class="placeholder" style="padding-top: 20px;min-height: 120px;">
                <div id="filePicker" class="webuploader-container">
                    <div class="webuploader-pick">选择文件</div>
                    <div id="rt_rt_1e4cp25lp1sn41rgmsj6q377ih1"
                         style="position: absolute; top: 0px; left: 271px; width: 132px; height: 44px; overflow: hidden; bottom: auto; right: auto;">
                        <input type="file" name="file" class="webuploader-element-invisible" multiple="multiple"
                               accept="">
                        <label>
                            style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background:
                            rgb(255, 255, 255);">
                        </label>
                    </div>
                </div>
                <p>或者将转换文件拖到这里</p>
                <p>允许上传格式: png/jpg/tiff/bmp/gif</p>
                <p>如果没有“按钮”请刷新</p>
            </div>
            <ul class="filelist"></ul>
        </div>
        <div class="statusBar" style="display:none;">
            <div class="progress" style="display: none;">
                <span class="text">0%</span>
                <span class="percentage" style="width: 0%;"></span>
            </div>
            <div class="info">共0张（0B），已传0张</div>
            <div class="btns">
                <form>
                    <div id="filePicker2" class="webuploader-container">
                        <div class="webuploader-pick">继续添加</div>
                        <div id="rt_rt_1e4cp25onjeso7g1m8i15u29iv6"
                             style="position: absolute; top: 0px; left: 0px; width: 1px; height: 1px; overflow: hidden;">
                            <input type="file" name="file" class="webuploader-element-invisible" multiple="multiple"
                                   accept=""><label
                                style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label>
                        </div>
                    </div>

                    <div class="uploadBtn state-pedding">
                        开始上传
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<header>
    <h4>
        <span data-toggle="collapse">第二步：开始识别<span class="caret"></span></span>
    </h4>
</header>
<div id="confirmForm" class="col-md-6">
    <div class="row">
        <%--<div class="col-md-4" style="margin-bottom:40px;">
            <form id="submitFreeForm" action="/submitOcr?type=1" method="POST" class="form-inline" role="form">
                <button id="free_button" type="submit" class="btn btn-primary col-xs-12">免费转换</button>
                <input id="free_obj_type" name="obj_type" type="hidden" value="pdf">
                <input id="free_ids" name="ids" type="hidden" value="">
                <input id="free_ts" name="ts" type="hidden" value="">
                <input id="free_pass" name="pass" type="hidden" value="">
                <input id="free_lang" name="lang" type="hidden" value="1,2">
                <input id="free_autorotation" name="autorotation" type="hidden" value="true">
                <input id="free_combine" name="combine" type="hidden" value="true">
                <input id="free_a4" name="a4" type="hidden" value="true">
                <input id="free_color" name="color" type="hidden" value="false">
            </form>
        </div>--%>

        <form id="recognize" <%--action="/submitOcr?type=2"--%>action="" method="POST" class="form-inline" role="form">
            &nbsp;&nbsp;&nbsp;
            <button id="pay_button" type="button" class="btn btn-warning col-xs-12">开始识别</button>
            <input id="pay_obj_type" name="obj_type" type="hidden" value="pdf">
            <input id="pay_ids" name="ids" type="hidden" value="">
            <input id="pay_ts" name="ts" type="hidden" value="">
            <input id="pay_pass" name="pass" type="hidden" value="">
            <input id="pay_lang" name="lang" type="hidden" value="1,2">
            <input id="pay_autorotation" name="autorotation" type="hidden" value="true">
            <input id="pay_combine" name="combine" type="hidden" value="true">
            <input id="pay_a4" name="a4" type="hidden" value="true">
            <input id="pay_color" name="color" type="hidden" value="false">
        </form>
        <form id = "deleteResult" method="post" class="deleteResult">  <button id="delete_data" action = "" type="button" class="btn btn-warning" >
            清除缓存信息</button>
        </form>
    </div>
</div>

<h3 class="text-left text-success">
    <p style="text-align: center">识别结果显示区域</p>
</h3>
<table class="table table-hover">
    <thead>
    <tr>
        <th>编号</th>
        <th>发卡行</th>
        <th>卡号</th>
        <th>日期</th>
        <th>状态</th>
    </tr>
    </thead>
    <tbody id="result">
    <%--识别结果显示处--%>
    <div id="messageDiv" style="text-align: center"></div>
    <%--<tr>
        <td>1</td>
        <td>中国农业银行</td>
        <td>62288 355648 5231 5659</td>
        <td>01/04/2012</td>
        <td>Default</td>
    </tr>--%>
    <tr class="success">
        <td>1</td>
        <td>中国银行</td>
        <td>6666666666666666666</td>
        <td>2020-06</td>
        <td>VALID</td>
    </tr>
    <%--<tr class="warning">
        <td>3</td>
        <td>中国建设银行</td>
        <td>0130 5355648 5231 5659</td>
        <td>03/04/2012</td>
        <td>Default</td>
    </tr>--%>
    </tbody>
</table>
<%--<div id="resultFrame" class="block hidden">
    <div class="row">
        <div  class="col-md-8 col-sm-12 col-xs-12" style="margin-bottom: 10px;">
            <header>
                <h2 class="text-danger">最后：等待结果</h2>
            </header>
            <div id="result" class="col-md-12 text-center text-danger">

            </div>
            <div id="download" class="hidden">
                <form id="download_form" method="POST" action="/downResult" target="_blank">
                    <input type="hidden" name="id" id="download_id" value="">
                    <input type="hidden" name="t" id="download_t" value="">
                    <input type="hidden" name="type" value="title">
                    <button class="btn btn-primary col-xs-3" type="submit" style="margin-right: 10px;" title="原始标题下载">下载(1)</button>
                </form>
                <a id="download_link" class="btn btn-primary col-xs-3" href="#" target="_blank" style="margin-right: 10px;" title="原始标题下载">下载(2)</a>
                <a id="download_link_via_id" class="btn btn-primary col-xs-3" href="#" target="_blank" title="若标题发生标题乱码，用ID作为标题下载">下载(3)</a>
            </div>
        </div>

        <div class="col-md-4 col-sm-12 col-xs-12" style="margin-bottom: 10px;">
            <header>
                <h2>重新上传？</h2>
            </header>
            <div id="next">
                <a class="btn btn-success col-xs-12" href="#&lt;%&ndash;javascript:location.reload()&ndash;%&gt;;">刷新页面(F5)</a>
            </div>
        </div>
    </div>
</div>--%>
<footer>
    <div class="container">
        <div class="row">
            <div class="col-sm-9 center-xs">
                <p style="margin-top: 10px;">
                    CQUPT, GSD , 中国 ggtms@qq.com<br/>
                    Copyright © 2020 GGTMS.
                </p>
            </div>
        </div>
    </div>

</footer>
</body>
<script>
    function getResult(json) {
        var temp = [
            '<tr class="success">',
            "<td>", json.number, "</td>",
            "<td>", json.issuer, "</td>",
            "<td>", json.accout, "</td>",
            "<td>", json.date, "</td>",
            "<td>", json.statu, "</td>",
            "</tr>",].join("\n");

        $("#result").append($(temp));
    }
    $('#recognize').click(function () {
        var url = "getRecognizeResult";
        $.post(url,
        function (data) {
            var jsons = JSON.parse(data);
            Object.keys(jsons).forEach(function(key){
                getResult(jsons[key]);
            })
        });
    });
    /*$('#recognize').click(function () {
        var url = "getRecognixeResult";
        $.post(
            url,
            function (data) {
                var json = JSON.parse(data);
                /!*var jq = jQuery.parseJSON(json);
                var number = json.card.number;
                var issuer = json.card.issuer;
                var account = json.card.accout;
                var date = json.card.date;
                var status = json.card.statu;
                $("#messageDiv").html(
                    "序号:" + number
                    + "<br>发卡行:" + issuer + "<br>账户:" + account
                    + "<br>日期:" + date + "<br>状态:" + status
                );*!/
                getResult(json);

    });
    });
*/
</script>
<script>
    $('#deleteResult').click(function () {
        var url = "delete";
        $.post(url);
    });
</script>

<%--<script language="JavaScript" type="text/javascript">
    // window.onload = time();

    function time() {
        //获得显示时间的div
        t_div = document.getElementById('showtime');
        var now = new Date()
        //替换div内容
        t_div.innerHTML = "现在时间 " + now.getFullYear()
            + "年 " + (now.getMonth() + 1) + "月" + now.getDate()
            + "日 " + now.getHours() + "时 " + now.getMinutes()
            + "分 " + now.getSeconds() + "秒";
        //等待一秒钟后调用time方法，由于settimeout在time方法内，所专以可以无限调用
        setTimeout(time, 1000);
    }
</script>--%>
<script type="text/javascript">
    window.onload = showtime();

    function gettime() {
        var date = new Date();
        var weekDay = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        var hours = date.getHours();
        var minutes = date.getMinutes();
        var seconds = date.getSeconds();
        var week = weekDay[date.getDay()];
        $("#day").html("今天的是：" + year + " 年" + month + " 月" + day + " 日&nbsp&nbsp" + week + "&nbsp"
            + hours + ":" + minutes + ":" + seconds);
        //$("#time").html(hours+":"+minutes+":"+seconds);
    }

    function showtime() {
        setInterval(function () {
            gettime();
        }, 1000);
    }
</script>


<!-- 控制导航栏显示的JS  -->
<%--<script>
    feather.replace();
    $(document).ready(function () {
        $.ajax({
            url: 'https://www.timecamp.com/auth/token',
            type: 'GET',
            data: {},
            success: function (response) {
                console.log(response);
                $('#navbarNav .navbar-nav .nav-item').each(function () {
                    if ($(this).hasClass('btn-no-auth')) $(this).hide();
                    if ($(this).hasClass('btn-auth')) $(this).show();
                })
            },
            error: function () {

            },

        });
    });
</script>--%>

<script type="text/javascript">
    /*$(".payment-type > input[type=radio]").on('click', function () {
        var prize = $(this).parent().parent().find("h4");
        if ($(this).is("#monthly")) {
            prize.html("<span>$</span>0");
        } else if ($(this).is("#yearly")) {
            prize.html("<span>$</span>0");
        } else if ($(this).is("#monthly2")) {
            prize.html("<span>$</span>7");
        } else if ($(this).is("#yearly2")) {
            prize.html("<span>$</span>5.25");
        } else if ($(this).is("#monthly3")) {
            prize.html("<span>$</span>10");
        } else if ($(this).is("#yearly3")) {
            prize.html("<span>$</span>7.50");
        }
    });
    $(".js-offer-form").on('submit', function (e) {

        $('#offerBtn2').attr('disabled', 'disabled');
        $('#offerBtn').attr('disabled', 'disabled');

        $.ajax({
            type: "POST",
            url: "https://www.timecamp.com/ajax/sendFormToSales",
            crossDomain: true,
            data: {
                inputName: $('input[name=inputName]').val(),
                inputCompany: $('input[name=inputCompany]').val(),
                inputEmail: $('input[name=inputEmail]').val(),
                inputPhone: $('input[name=inputPhone]').val(),
                inputSeats: $('#inputSeats').val(),
                currentPage: $('input[name=currentPage]').val(),
                resources: $('input[name=resources]').val()
            },
            complete: function (data, type) {
                window.location.replace("/sukces/");
            }
        });

        e.preventDefault();
        return false;
    });
    (function ($, win) {
        $.fn.inViewport = function (cb) {
            return this.each(function (i, el) {
                function visPx() {
                    var H = $(this).height(),
                        r = el.getBoundingClientRect(), t = r.top + 100, b = r.bottom;
                    return cb.call(el, Math.max(0, t > 0 ? H - t : (b < H ? b : H)));
                }

                visPx();
                $(win).on("resize scroll", visPx);
            });
        };
    }(jQuery, window));

    $(".anim").inViewport(function (px) {
        if (px) $(this).addClass("on");
    });*/
    $(document).ready(function () {
        /*if (location.hash === "#form") {
            scrollTop: $(window).scrollTop() - 170;
        }
        if ($('.sticky-scroll-box').length) {
            var top = $('.sticky-scroll-box').offset().top;
            var boxHeight = $('.sticky-scroll-box').height();
            var bodyHeight = $('body').height();
            $(window).scroll(function (event) {
                var y = $(this).scrollTop();
                if (y >= top && y + boxHeight <= bodyHeight - boxHeight - 200)
                    $('.sticky-scroll-box').addClass('fixed margin-top-80');
                else
                    $('.sticky-scroll-box').removeClass('fixed margin-top-80');
                $('.sticky-scroll-box').width($('.sticky-scroll-box').parent().width());
            });
            var y = $(this).scrollTop();
            if (y >= top && y + boxHeight <= bodyHeight - boxHeight - 200)
                $('.sticky-scroll-box').addClass('fixed margin-top-80');
            else
                $('.sticky-scroll-box').removeClass('fixed margin-top-80');
            $('.sticky-scroll-box').width($('.sticky-scroll-box').parent().width());
        }

        var parallax = document.querySelectorAll(".parallax"),
            speed = 0.2;*/
        /*window.onscroll = function () {
            [].slice.call(parallax).forEach(function (el, i) {
                var windowYOffset = window.pageYOffset,
                    elBackgrounPos = -200 + (windowYOffset * speed);
                //el.style.top = elBackgrounPos + "px";
            });
        };*/

        <!-- 控制导航栏缩小时的显示的JS  -->
        var headerWrapState = false;

        function showHideNavBar() {
            if ($(window).scrollTop() > 20) {
                if (headerWrapState == false) {
                    $('#header-wrap').addClass('visible');
                    $('#header-wrap').removeClass('invisible');
                    headerWrapState = true;
                    console.log(headerWrapState);
                }
            } else {
                if (headerWrapState == true) {
                    $('#header-wrap').addClass('invisible');
                    $('#header-wrap').removeClass('visible');
                    headerWrapState = false;
                    console.log(headerWrapState);
                }
            }
        }

        $(window).scroll(function () {
            showHideNavBar();
        });
        showHideNavBar();

        $('[data-toggle="tooltip"]').tooltip();
    });

</script>

<%--控制选择文件上传的JS--%>
<script type="text/javascript">
    //系统必要参数
    islogin = 1;                                        //1表示已登录，0表示未登录
    ismobile = 0;                                        //是否在移动端操作
    if (islogin) {
        par_upload_size = 500 * 1024 * 1024;            //限制图像文件的识别的大小
        par_file_num_limit = 500;                       //限制图像文件的识别数量
    } else {
        if (ismobile) {
            par_upload_size = 500 * 1024 * 1024;        //移动端的限制
            par_file_num_limit = 1;
        }
        else {
            par_upload_size = 1024 * 1024;               //未登录用户的限制
            par_file_num_limit = 1;
        }
    }
    intv = 0;
    count = 0;      //记录等待的总时间
    isRequest = 0;  //判断是否已准备好数据的识别
    newid = '';
    newtime = '';
    //PaySubmit
    $('#submitPayForm').ajaxForm({
        beforeSerialize: modifyData,  //edit var
        beforeSubmit: beforeSubmit,
        success: complete,  // post-submit callback
        dataType: 'json',
    });
    //FreeSubmit

    //各个功能函数//Function

    //①修改数据的转换语言，暂时用不上
    function modifyData() {
        str = '';
        str = $('input:radio[name="optionsRadios"]:checked').val();
        $('#free_obj_type').val(str);
        $('#pay_obj_type').val(str);

        str = '';
        lang_cnt = 0;
        $('input:checkbox[name="lang"]:checked').each(function () {
            if (str == '') {
                str += $(this).val();
            }
            else {
                str += ',' + $(this).val();
                lang_cnt++;
                if (lang_cnt > 3) {
                    alert('对不起，不能超过3种语言，请减少');
                    return false;
                }
            }
        });
        $('#pay_lang').val(str);
        $('#free_lang').val(str);
        str = $('input:radio[name="optionsColors"]:checked').val();
        $('#free_color').val(str);
        $('#pay_color').val(str);

        if ($('#option_combine1').is(':checked')) {
            $('#free_combine').val('true');
            $('#pay_combine').val('true');
        }
        if ($('#option_combine2').is(':checked')) {
            $('#free_combine').val('false');
            $('#pay_combine').val('false');
        }

        if ($('#autorotation').is(':checked')) {
            $('#free_autorotation').val('true');
            $('#pay_autorotation').val('true');
        } else {
            $('#free_autorotation').val('false');
            $('#pay_autorotation').val('false');
        }

        if ($('#a4').is(':checked')) {
            $('#free_a4').val('true');
            $('#pay_a4').val('true');
        } else {
            $('#free_a4').val('false');
            $('#pay_a4').val('false');
        }

        $('#pay_pass').val($('#pass').val());
        $('#free_pass').val($('#pass').val());

    }

    //②提交上传图片之前的验证准备，是否已准备好数据的提交，暂时用不上
    function beforeSubmit() {
        if (isRequest == 1) return false;
        $('#free_button').addClass('disabled');
        $('#pay_button').addClass('disabled');

        if (ismobile) {
            var h = $(document).height() - $(window).height() - 200;
            $(document).scrollTop(h);
        }

        $('#resultFrame').removeClass('hidden');
        $('#result').html('...系统处理中...请稍后...（如果页数较多，则时间较长）');
        isRequest = 1;
        return true;
    }

    //识别结果出来前的准备，会调用函数waitResult(id,time)
    function complete(data) {
        //console.log(data);
        if (data.errno != 0) {
            $('#result').html(data.desc);
            $('#free_button').removeClass('disabled');
            $('#pay_button').removeClass('disabled');
            isRequest = 0;
            alert(data.desc);
        } else {
            $('#uploader').removeClass('in');
            $('#convparam').removeClass('in');
            $('#remind').removeClass('in');
            count = 0;
            //等待回复
            $('#result').html('正在转换...(已等待' + count + '秒)');
            intv = setInterval("wait()", 1000);
            //提交等候申请
            newid = data.id;
            newtime = data.time;
            //waitResult(data.id,data.time);
            setTimeout(function () {
                waitResult(data.id, data.time)
            }, 1000);
        }
    }

    //在识别过程中的等待
    //Wait
    function waitResult(id, time) {
        var timestamp = new Date().getTime();
        $.ajax({
            //url: '/waitResult2?id=' + id + '&_t=' + timestamp,
            url: '/waitResult2?id=' + id + '&_t=' + timestamp,
            type: 'POST',
            timeout: 10000,
            data: {check: 'yes'},
        })
        //看文件是否上传成功

            .done(function (data) {
                if (data.errno != 0) {
                    clearInterval(intv);
                    $('#result').html(data.desc);
                }
                if (data.errno == 0) {
                    if (data.status == 0) {
                        setTimeout(function () {
                            waitResult(id, time)
                        }, 1000);
                    } else if (data.status == 1) {
                        clearInterval(intv);
                        $('#result').addClass('hidden');
                        $('#download_link').attr({href: "/downResult?id=" + id + "&t=" + time + "&type=title"});
                        $('#download_link_via_id').attr({href: "/downResult?id=" + id + "&t=" + time + "&type=other"});
                        $('#download_id').val(id);
                        $('#download_t').val(time);
                        $('#download').removeClass('hidden');
                        $('#next').removeClass('hidden');
                    }
                    else if (data.status == 2) {
                        clearInterval(intv);
                        if (data.desc == "fail") {
                            $('#result').html("转换失败，请再试一次，如果有问题，建议联系网站底部");
                        } else {
                            $('#result').html(data.desc);
                        }
                    } else {
                        $('#result').html('未知错误请刷新再试');
                    }
                }
            })
            .fail(function () {
                $('#result').html('请到“转换记录”中查看（左侧导航）');
            })
            .always(function () {
                //console.log("complete");
            });
    }

    //waitFunction
    function wait() {
        count++;
        if (count > 60) {
            $('#result').html('正在转换...(已等待' + count + '秒)<br>如页数较多时间可能较长，可到左侧“转换记录”查看（限注册用户）');
        } else {
            $('#result').html('正在转换...(已等待' + count + '秒)' + "<br>可以继续等待或稍等后到“转换记录”查看（限注册用户）");
        }
    }

    //给识别结果指定语言，暂时用不上
    function select_lang(type) {
        lang_cnt = 0;
        $('input:checkbox[name="lang"]:checked').each(function () {
            lang_cnt++;
            if (lang_cnt > 3) {
                $('#lang_' + type).removeAttr("checked");
                alert('最多3种');
                return false;
            }
        });
    }

    //Uploader  选择文件上传时所发生的响应事件函数
    uploadApi = '/Upload';               //与UploadController里的RequestMapping一致
    jQuery(function () {
        var $ = jQuery,    // just in case. Make sure it's not an other libaray.
            $wrap = $('#uploader'),
            $queue = $('<ul class="filelist"></ul>').appendTo($wrap.find('.queueList')),     //多个文件上传时的文件队列
            $statusBar = $wrap.find('.statusBar'),
            $info = $statusBar.find('.info'),
            $upload = $wrap.find('.uploadBtn'),
            $placeHolder = $wrap.find('.placeholder'),
            $progress = $statusBar.find('.progress').hide(),
            fileCount = 0,               //文件数
            fileSize = 0,                //文件大小
            ratio = window.devicePixelRatio || 1,
            thumbnailWidth = 110 * ratio,
            thumbnailHeight = 110 * ratio,
            state = 'pedding',
            percentages = {},
            supportTransition = (function () {
                var s = document.createElement('p').style,
                    r = 'transition' in s ||
                        'WebkitTransition' in s ||
                        'MozTransition' in s ||
                        'msTransition' in s ||
                        'OTransition' in s;
                s = null;
                return r;
            })(),
            //init
            uploader;
        if (!WebUploader.Uploader.support()) {
            alert('Web Uploader 不支持您的浏览器！如果你使用的是IE浏览器，请尝试升级 flash 播放器');
            throw new Error('WebUploader does not support the browser you are using.');
        }
        $('#free_ids').val('');
        $('#free_ts').val('');
        $('#pay_ids').val('');
        $('#pay_ts').val('');
        uploader = WebUploader.create({
            pick: {
                id: '#filePicker',
                label: '选择文件'
            },
            dnd: '#uploader .queueList',
            paste: document.body,
            accept: {
                title: '图片/PDF文件',
                extensions: 'png,jpg,pdf,jpeg,tiff,bmp,gif,tif,heic,heif,zip',
                mimeTypes: '',
            },
            swf: '../static/images/Uploader.swf',
            threads: 1,
            disableGlobalDnd: true,
            chunked: false,
            server: uploadApi,
            fileNumLimit: par_file_num_limit,
            fileSizeLimit: par_upload_size,
            fileSingleSizeLimit: par_upload_size,
            compress: false,
            resize: false,
        });
        uploader.addButton({
            id: '#filePicker2',
            label: '继续添加'
        });

        // 当有文件添加进来时执行，负责view的创建
        function addFile(file) {
            var $li = $('<li id="' + file.id + '">' +
                '<p class="title">' + file.name + '</p>' +
                '<p class="imgWrap"></p>' +
                '<p class="progress"><span></span></p>' +
                '</li>'),

                $btns = $('<div class="file-panel">' +
                    '<span class="cancel">删除</span>' +
                    '</div>').appendTo($li),
                $prgress = $li.find('p.progress span'),
                $wrap = $li.find('p.imgWrap'),
                $info = $('<p class="error"></p>'),

                showError = function (code) {
                    switch (code) {
                        case 'exceed_size':
                            if (islogin) {
                                text = '单个文件大小超出最大限制（' + par_upload_size / 1024 / 1024 + 'M）';
                            }
                            else {
                                text = '未注册用户仅能上传最大 ' + par_upload_size / 1024 / 1024 + 'M 文件'
                            }

                            break
                        case 'interrupt':
                            text = '上传暂停';
                            break;

                        default:
                            text = '上传失败，请重试';
                            break;
                    }

                    $info.text(text).appendTo($li);
                };
            if (file.getStatus() === 'invalid') {
                showError(file.statusText);
            } else {
                // @todo lazyload
                $wrap.text('预览中');
                uploader.makeThumb(file, function (error, src) {
                    if (error) {
                        $wrap.text('文件无预览');
                        return;
                    }

                    var img = $('<img src="' + src + '">');
                    $wrap.empty().append(img);
                }, thumbnailWidth, thumbnailHeight);

                percentages[file.id] = [file.size, 0];
                file.rotation = 0;
            }
            file.on('statuschange', function (cur, prev) {
                if (prev === 'progress') {
                    $prgress.hide().width(0);
                } else if (prev === 'queued') {
                    $li.off('mouseenter mouseleave');
                    $btns.remove();
                }

                // 成功
                if (cur === 'error' || cur === 'invalid') {
                    //console.log( file.statusText );
                    showError(file.statusText);
                    percentages[file.id][1] = 1;
                } else if (cur === 'interrupt') {
                    showError('interrupt');
                } else if (cur === 'queued') {
                    percentages[file.id][1] = 0;
                } else if (cur === 'progress') {
                    $info.remove();
                    $prgress.css('display', 'block');
                } else if (cur === 'complete') {
                    $li.append('<span class="success"></span>');
                }

                $li.removeClass('state-' + prev).addClass('state-' + cur);
            });
            $li.on('mouseenter', function () {
                $btns.stop().animate({height: 30});
            });
            $li.on('mouseleave', function () {
                $btns.stop().animate({height: 0});
            });
            $btns.on('click', 'span', function () {
                var index = $(this).index(),
                    deg;

                switch (index) {
                    case 0:
                        uploader.removeFile(file);
                        return;

                    case 1:
                        file.rotation += 90;
                        break;

                    case 2:
                        file.rotation -= 90;
                        break;
                }

                if (supportTransition) {
                    deg = 'rotate(' + file.rotation + 'deg)';
                    $wrap.css({
                        '-webkit-transform': deg,
                        '-mos-transform': deg,
                        '-o-transform': deg,
                        'transform': deg
                    });
                } else {
                    $wrap.css('filter', 'progid:DXImageTransform.Microsoft.BasicImage(rotation=' + (~~((file.rotation / 90) % 4 + 4) % 4) + ')');
                    // use jquery animate to rotation
                    // $({
                    //     rotation: rotation
                    // }).animate({
                    //     rotation: file.rotation
                    // }, {
                    //     easing: 'linear',
                    //     step: function( now ) {
                    //         now = now * Math.PI / 180;

                    //         var cos = Math.cos( now ),
                    //             sin = Math.sin( now );

                    //         $wrap.css( 'filter', "progid:DXImageTransform.Microsoft.Matrix(M11=" + cos + ",M12=" + (-sin) + ",M21=" + sin + ",M22=" + cos + ",SizingMethod='auto expand')");
                    //     }
                    // });
                }
            });
            $li.appendTo($queue);    //将图片添加到待上传的列表里
        }

        // 负责view的销毁
        function removeFile(file) {
            var $li = $('#' + file.id);

            delete percentages[file.id];
            updateTotalProgress();
            $li.off().find('.file-panel').off().end().remove();
        }

        //在添加多个图片的总数计算过程
        function updateTotalProgress() {
            var loaded = 0,
                total = 0,
                spans = $progress.children(),
                percent;

            $.each(percentages, function (k, v) {
                total += v[0];
                loaded += v[0] * v[1];
            });

            percent = total ? loaded / total : 0;

            spans.eq(0).text(Math.round(percent * 100) + '%');
            spans.eq(1).css('width', Math.round(percent * 100) + '%');
            updateStatus();
        }

        //更新状态
        function updateStatus() {
            var text = '', stats;

            if (state === 'ready') {
                text = '选中' + fileCount + '份文件，共' +
                    WebUploader.formatSize(fileSize) + '。';
            } else if (state === 'confirm') {
                stats = uploader.getStats();
                if (stats.uploadFailNum) {
                    text = '已上传' + stats.successNum + '份，' +
                        stats.uploadFailNum + '份文件上传失败，<a class="retry" href="#">重新上传</a>失败的文件或<a class="ignore" href="#">忽略</a>'
                }

            } else {
                stats = uploader.getStats();
                text = '共' + fileCount + '张（' +
                    WebUploader.formatSize(fileSize) +
                    '），已上传' + stats.successNum + '张';

                if (stats.uploadFailNum) {
                    text += '，失败' + stats.uploadFailNum + '张';
                }
            }

            $info.html(text);
        }

        function setState(val) {
            var file, stats;

            if (val === state) {
                return;
            }

            $upload.removeClass('state-' + state);
            $upload.addClass('state-' + val);
            state = val;
            //不同状态对应的不同的处理
            switch (state) {
                case 'pedding':
                    $placeHolder.removeClass('element-invisible');
                    $queue.parent().removeClass('filled');
                    $queue.hide();
                    $statusBar.addClass('element-invisible');
                    uploader.refresh();
                    break;

                case 'ready':
                    $placeHolder.addClass('element-invisible');
                    $('#filePicker2').removeClass('element-invisible');
                    $queue.parent().addClass('filled');
                    $queue.show();
                    $statusBar.removeClass('element-invisible');
                    uploader.refresh();

                    break;

                case 'uploading':
                    $('#filePicker2').addClass('element-invisible');
                    $progress.show();
                    $upload.text('暂停上传');
                    break;

                case 'paused':
                    $progress.show();
                    $upload.text('继续上传');
                    break;

                case 'confirm':
                    $progress.hide();
                    $upload.text('开始上传').addClass('disabled');

                    stats = uploader.getStats();
                    if (stats.successNum && !stats.uploadFailNum) {
                        setState('finish');
                        return;
                    }
                    break;
                case 'finish':
                    stats = uploader.getStats();
                    if (stats.successNum) {
                        //alert( '上传成功' );
                    } else {
                        // 没有成功的图片，重设
                        state = 'done';
                        location.reload();
                    }
                    break;
            }
            updateStatus();
        }

        uploader.onUploadProgress = function (file, percentage) {
            var $li = $('#' + file.id),
                $percent = $li.find('.progress span');

            $percent.css('width', percentage * 100 + '%');
            percentages[file.id][1] = percentage;
            updateTotalProgress();
        };

        uploader.onFileQueued = function (file) {
            fileCount++;
            fileSize += file.size;
            if (fileCount === 1) {
                $placeHolder.addClass('element-invisible');
                $statusBar.show();
            }
            addFile(file);
            setState('ready');
            updateTotalProgress();
        };

        uploader.onFileDequeued = function (file) {
            fileCount--;
            fileSize -= file.size;

            if (!fileCount) {
                setState('pedding');
            }

            removeFile(file);
            updateTotalProgress();
        };
        //所有文件上传完成
        uploader.on('uploadComplete', function (file) {
            //$('#selectForm').removeClass('hidden');
            //$('#confirmForm').removeClass('hidden');
        });
        //单个文件上传返回
        uploader.on('UploadResults', function (file, response) {     //此地址决定文件是否上传成功对应servlet中的UploadResults
            //console.log(response);
            if (response.errno != 0) {
                console.log("上传失败，原因：(" + response.desc + ")请截图并发送邮件到ggtms@qq.com可快速解决问题");
                $.ajax({
                    url: '/upload_report',
                    type: 'POST',
                    dataType: 'json',
                    data: response._raw,
                })
                    .done(function () {
                        //console.log("success");
                    })
                    .fail(function () {
                        //console.log("error");
                    })
                    .always(function () {
                        //console.log("complete");
                    });

                return false;
            } else {
                if (!$('#free_ids').val())
                    $('#free_ids').val(response.data.id);
                else
                    $('#free_ids').val($('#free_ids').val() + ',' + response.data.id);

                if (!$('#pay_ids').val())
                    $('#pay_ids').val(response.data.id);
                else
                    $('#pay_ids').val($('#pay_ids').val() + ',' + response.data.id);

                if (!$('#free_ts').val())
                    $('#free_ts').val(response.data.time);
                else
                    $('#free_ts').val($('#free_ts').val() + ',' + response.data.time);

                if (!$('#pay_ts').val())
                    $('#pay_ts').val(response.data.time);
                else
                    $('#pay_ts').val($('#pay_ts').val() + ',' + response.data.time);
            }
        });

        uploader.on('all', function (type) {
            var stats;
            switch (type) {
                case 'uploadFinished':
                    setState('confirm');
                    break;

                case 'startUpload':
                    setState('uploading');
                    break;

                case 'stopUpload':
                    setState('paused');
                    break;

            }
        });
        //识别过程中出现的错误信息处理
        uploader.onError = function (code) {
            if (code == 'Q_TYPE_DENIED') {
                alert('对不起，该后缀文件不支持');
            }
            else if (code == 'Q_EXCEED_NUM_LIMIT') {
                if (!islogin) {
                    alert('对不起，未注册登录用户不能使用批量上传');
                    $(window).attr('location', 'https://www.wdku.net/user/reg');
                } else {
                    alert("对不起，最大允许上传" + par_file_num_limit + "份文件");
                }
            }
            else if (code == 'F_EXCEED_SIZE') {
                if (!islogin) {
                    alert('对不起，未注册登录用户最大仅能上传 ' + par_upload_size / 1024 / 1024 + 'M 文件');
                    $(window).attr('location', 'https://www.wdku.net/user/reg');
                } else {
                    alert("对不起，单个上传文件尺寸最大只能上传" + par_upload_size / 1024 / 1024 + 'M');
                }
            }
            else if (code == 'Q_EXCEED_SIZE_LIMIT') {
                if (!islogin) {
                    alert('对不起，未注册登录用户最大仅能上传 ' + par_upload_size / 1024 / 1024 + 'M 文件');
                    $(window).attr('location', 'https://www.wdku.net/user/reg');
                } else {
                    alert("对不起，所有上传文件总尺寸最大" + par_upload_size / 1024 / 1024 + 'M，请缩小');
                }
            }
            else {
                alert('Error: ' + code);
            }
        };
        //提添加的点击事件
        $upload.on('click', function () {
            if ($(this).hasClass('disabled')) {
                return false;
            }
            if (state === 'ready') {
                uploader.upload();
            } else if (state === 'paused') {
                uploader.upload();
            } else if (state === 'uploading') {
                uploader.stop();
            }
        });
        //显示信息的点击事件
        $info.on('click', '.retry', function () {
            uploader.retry();
        });

        $info.on('click', '.ignore', function () {
            alert('todo');
        });
        //状态标志，是ready、paused、or uploading
        $upload.addClass('state-' + state);
        updateTotalProgress();
    });
</script>
<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?c28bc0ecf7d4c8b69eafd431fdf653e0";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
<script type="text/javascript">
    $(function () {
        $(".dropdown").mouseover(function () {
            $(this).addClass("open");
        });
        $(".dropdown").mouseleave(function () {
            $(this).removeClass("open");
        })
    });
</script>
</html>

<%--<h2>Hello World!</h2>
<a href="card/outDisplayTest">测试Controller层(查询)</a>

<form action="card/save" method="post">
    编号：<input type="text" name="number" /><br/>
    发卡行：<input type="text" name="issuer" /><br/>
    卡号:<input type="text" name="account" /><br/>
    日期:<input type="text" name="date" /><br/>
    状态:<input type="text" name="status" /><br/>
    <input type="submit" value="保存"/><br/>
</form>
</body>
</html>--%>
