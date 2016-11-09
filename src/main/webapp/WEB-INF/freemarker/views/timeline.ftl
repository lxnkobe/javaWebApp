<!DOCTYPE html>
<html lang="zh-CN">
<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">

<#--<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">-->
<head>
    <title>Oliver's Blogs</title>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.pager.js"></script>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/timeline_style.css" rel="stylesheet">
    <style type="text/css">
        body {
            background-color: #CCC;
        }
    </style>
</head>
<body>
<div class="container">
<#include "./common/header.ftl"/>

    <div class="row"
         style="background-color: white;border-top-left-radius:5px;border-top-right-radius:5px;line-height: 30px;padding: 20px;  ">
        <div class="col-xs-12 col-sm-12">
            <section id="cd-timeline" class="cd-container">

            <#list blogList as blog >
                <div class="cd-timeline-block">
                    <div class="cd-timeline-img cd-picture">
                        <img src="/resources/img/stack_48.png" alt="Picture">
                    </div>

                    <div class="cd-timeline-content">
                        <h2>${blog.blogTitle}</h2>
                        <p>${blog.blogContent}</p>
                        <a href="/blogdetail?id=${blog.id}" class="cd-read-more" target="_blank">阅读全文</a>
                        <span class="cd-date">${blog.createTime?string('yyyy-MM-dd HH:mm:ss')}</span>
                    </div>
                </div>
            </#list>

        </div>

    </div>
<#include "./common/footer.ftl" />
</div>


</body>
</html>