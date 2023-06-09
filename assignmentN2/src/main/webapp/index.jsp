<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container contact-form">

    <form method="post" action="<%=request.getContextPath()%>/post-servlet">
        <h3>Write Post</h3>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <input type="text" name="title" class="form-control" placeholder="Title *" value="" />
                </div>
                <div class="form-group">
                    <input type="text" name="author" class="form-control" placeholder="Author *" value="" />
                </div>
                <div class="form-group">
                    <input type="submit" name="btnSubmit" class="btnContact" value="Save Post" />
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <textarea name="content" class="form-control" placeholder="Content *" style="width: 100%; height: 150px;"></textarea>
                </div>
            </div>
        </div>
    </form>
    <form method="get" action="<%=request.getContextPath()%>/post-servlet">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                <input type="submit" name="btnSubmit" class="btnContact" value="Show Posts" />
            </div></div>
        </div>
    </form>
</div>
</body>
</html>