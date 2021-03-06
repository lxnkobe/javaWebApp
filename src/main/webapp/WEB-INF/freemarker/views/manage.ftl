<!DOCTYPE html>
<html lang="zh-CN">
<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
<#--<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">-->
<head>
    <title>后台管理</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        body {
            background-color: #CCC;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Keep calm and Carry on</h1>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    <img alt="Brand" src="/resources/img/Dolphin.png" width="25" height="25">
                </a>
            </div>
            <ul class="nav navbar-nav">
                <li ><a href="/index">首页</a></li>
                <li><a href="/life">生活</a></li>
                <li><a href="/about">关于</a></li>
                <@shiro.user>
                <li class="active"><a href="/manage">管理</a></li>
                </@shiro.user>
            </ul>
        </div>

    </nav>

    <div class="row" style="background-color: white;border-radius:5px;line-height: 30px;padding: 20px;  ">
        <div class="col-sm-12 col-md-12">
            <h3>博客管理</h3>
            <hr>
            <div class="row">
                <div class="col-sm-2 col-md-2">
                    <div class="thumbnail">
                        <a href="/blogManage"><img src="/resources/img/Calendar.png" width="50" height="50" alt="100*80"></a>

                        <div class="caption" align="center">
                            <h4>博客管理</h4>
                        </div>
                    </div>
                </div>
                <div class="col-sm-2 col-md-2">
                    <div class="thumbnail">
                        <a href="/addblog"><img src="/resources/img/Coffee.png" width="50" height="50" alt="100*80"></a>

                        <div class="caption" align="center">
                            <h4>添加博客</h4>
                        </div>
                    </div>
                </div>
                <div class="col-sm-2 col-md-2">
                    <div class="thumbnail">
                        <a href="/categoryManage"><img src="/resources/img/Line.png" width="50" height="50" alt="100*80"></a>

                        <div class="caption" align="center">
                            <h4>类别管理</h4>
                        </div>
                    </div>
                </div>


            </div>
        </div>

    </div>
</div>

</body>
</html>