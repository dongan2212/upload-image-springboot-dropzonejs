<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" name="viewport"
          content="width=device-width, initial-scale=1">
    <title>Spring Boot + Dropzone.js Example</title>

    <link rel="stylesheet" type="text/css"
          href='<c:url value="/resources/libs/bootstrap-3.1.1/css/bootstrap.min.css"/>'>
    <link rel="stylesheet" type="text/css"
          href='<c:url value="/resources/libs/bootstrap-dialog/css/bootstrap-dialog.min.css"/>'>
    <link rel="stylesheet" type="text/css"
          href='<c:url value="/resources/css/style.css"/>'>

</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h3>Spring Boot + Dropzone.js Example</h3>
        </div>
        <div class="panel-body">
            <div>
                <form id="dropzone-form" class="dropzone" enctype="multipart/form-data">
                    <div class="dz-default dz-message file-dropzone text-center well col-sm-12">
                        <span class="glyphicon glyphicon-paperclip"></span> <span>
								To attach files, drag and drop here</span><br> <span>OR</span><br>
                        <span>Just Click</span>
                    </div>

                    <!-- this is were the previews should be shown. -->
                    <div class="dropzone-previews"></div>
                </form>
                <hr>
                <button id="upload-button" class="btn btn-primary">
                    <span class="glyphicon glyphicon-upload"></span> Upload
                </button>
                <a class="btn btn-primary pull-right" href="/v1/api/uploadFile/list">
                    <span class="glyphicon glyphicon-eye-open"></span> View All Uploads
                </a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript"
        src='<c:url value="/resources/libs/jquery/jquery-2.1.1.js"/>'></script>
<script type="text/javascript"
        src='<c:url value="/resources/libs/bootstrap-3.1.1/js/bootstrap.js"/>'></script>
<script type="text/javascript"
        src='<c:url value="/resources/libs/bootstrap-dialog/js/bootstrap-dialog.min.js"/>'></script>
<script type="text/javascript"
        src='<c:url value="/resources/libs/dropzone.js"/>'></script>
<script type="text/javascript"
        src='<c:url value="/resources/js/app.js"/>'></script>
</body>
</html>