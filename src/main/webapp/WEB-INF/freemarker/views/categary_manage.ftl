<!DOCTYPE html>
<html lang="zh-CN" xmlns="http://xmlns.jcp.org/jsf/html">
<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
<#--<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">-->
<head>
    <title>博客管理 </title>
<#include "./common/base_static_file.ftl" />
    <script type="text/javascript" src="/resources/js/jquery.pager.js"></script>

    <script src="/resources/js/bootstrap-dialog.min.js" type="text/javascript"></script>
    <link href="/resources/css/bootstrap-dialog.min.css" rel="stylesheet">

    <style type="text/css">
        body {
            background-color: #CCC;
        }
    </style>
    <script type="text/javascript">
        function deleteBlog(id) {
            console.log(id);
            $.ajax({
                data: {
                    'id': id
                },
                type: "post",
                dataType: 'json',
                url: "/deleteblog",
                error: function (XMLHttpRequest, error, errorThrown) {
                    console.log("error " + error + ": " + errorThrown);
                    BootstrapDialog.show({
                        message: "error " + error + ": " + errorThrown
                    });
                },
                success: function (data) {
                    BootstrapDialog.show({
                        title: '提示',
                        message: '博客删除成功!',
                        buttons: [
                            {
                                label: '确定',
                                action: function (dialog) {
                                    refreshPage();
                                }
                            }
                        ]
                    });


                }
            });
            return false;
        }
        function refreshPage() {
            window.location.reload();
        }
    </script>
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
                <li class="active"><a href="/index">首页</a></li>
                <li><a href="/life">生活</a></li>
                <li><a href="/about">关于</a></li>
            <@shiro.user>
                <li><a href="/manage">管理</a></li>
            </@shiro.user>
            </ul>

            <ul class="nav navbar-nav navbar-right">
            <@shiro.user>
                <li><a href="#"><span class="glyphicon glyphicon-user">&nbsp;<@shiro.principal/></span> </a></li>
                <li><a href="/logout">注销</a></li>
            </@shiro.user>
            <@shiro.guest>
                <li><a href="/login"><span class="glyphicon glyphicon-user">&nbsp;游客</span> </a></li>
            </@shiro.guest>

            </ul>
        </div>

    </nav>

    <div class="row" style="background-color: white;border-radius:5px;line-height: 30px;padding: 20px;  ">
        <div class="col-xs-10 col-md-12">
            <h3>博客管理</h3>
            <hr>
            <form  action="/blogManage" method="post" class="form-inline">
                <div class="row">
                    博客类别搜索：<input type="text" class="form-control" id="searchId" name="blogseach" value="${blogseach}" placeholder="请输入文章标题或者ID" />&nbsp;&nbsp;
                    <input type="submit" class="form-control" value="搜  索"> </input>
                    <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#add_sub">添加</button>
                    <div id="add_sub" class="collapse">

                    </div>
                </div>
                <br/>
                <table class="table table-bordered thead-table">
                    <thead>
                    <th>ID</th>
                    <th>博客类别ID</th>
                    <th>类型名</th>
                    <th>配图</th>
                    <th>添加时间</th>
                    </thead>
                <#if ( category ?? && category?size>0)>
                    <#list category as item >
                        <tr>
                            <td>${item.id }</td>
                            <td>${item.categoryId}</td>
                            <td>${item.subTitle}</td>
                            <td><img src="${item.imageUrl}"></td>
                            <td>${item.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                        </tr>
                    </#list>
                </#if>
                </table>
            <#include "./common/common_pager_bar.ftl" />
            </form>

            <div id="add_sub" class="collapse">

            </div>

        </div>

    </div>
</div>

</body>
</html>