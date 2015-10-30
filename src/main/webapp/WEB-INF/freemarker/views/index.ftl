<!DOCTYPE html>
<html lang="zh-CN">
<meta charset="utf-8">
<head>
    <title>Twitter Bootstrap Tutorial - A responsive layout tutorial</title>
    <link href="/resources/css/bootstrap-combined.min.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            background-color: #CCC;
        }

        #content {
            background-color: #FFF;
            border-radius: 5px;
        }

        #content .main {
            padding: 20px;
        }

        #content .sidebar {
            padding: 10px;
        }

        #content p {
            line-height: 30px;
        }
    </style>

</head>
<body>
<div class="container">
    <h1>Oliver's Blogs</h1>

    <div class="navbar navbar-inverse">
        <div class="navbar-inner nav-collapse" style="height: auto;">
            <ul class="nav">
                <li class="active"><a href="/index">Home</a></li>
                <li><a href="/addblog">Page One</a></li>
                <li><a href="#">Page Two</a></li>
            </ul>
        </div>
    </div>
    <div id="content" class="row-fluid">
        <div class="span9 main" >
            <#if blogList?size &gt; 0>
                <#list blogList as blog >
                  <div >
                      <a href="/blogdatial?id=${blog.id}"> <h3>${blog.blogTitle}</h3> </a>
                      <p>${blog.createTime?string('yyyy-MM-dd HH:mm:ss')}</p>
                      <p>${blog.blogContent}</p>
                      <span>${blog.tags}</span>
                  </div>
                  <div style="background-color: white;height:30px"></div>
                </#list>
            </#if>

            <#--<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut-->
                <#--laoreet dolore magna aliquam erat volutpat. Ut wi快递费si enim ad minim veniam, quis nostrud exerci tation-->
                <#--ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor-->
                <#--in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at-->
                <#--vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis-->
                <#--dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil-->
                <#--imperdiet doming id quod mazim placerat facer possim assum.</p>-->

            <#--<p>-->
            <#--</p>-->

            <#--<p>Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes-->
                <#--demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus,-->
                <#--qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus-->
                <#--parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima.-->
                <#--Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.</p>-->

        </div>
        <div class="span3 sidebar">
            <h2>Sidebar</h2>
            <ul class="nav nav-tabs nav-stacked">
                <li><a href="#">Another Link 1</a></li>
                <li><a href="#">Another Link 2</a></li>
                <li><a href="#">Another Link 3</a></li>
            </ul>
        </div>
    </div>
</div>


</body>
</html>