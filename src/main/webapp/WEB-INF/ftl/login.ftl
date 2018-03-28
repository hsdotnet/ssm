<#import "/common/common.macro.ftl" as common>
<!DOCTYPE html>
<html>
<head>
    <@common.commonHead/>
    <title>用户登录</title>
    <@common.commonStyle/>
</head>
<body>
<div class="container-fluid">
    <input type="text" class="form-control" id="username"/>
    <input type="password" class="form-control" id="password"/>
    <button id="btn-login" class="btn btn-primary btn-sm">登录</button>
</div>
    <@common.commonScript/>
<script type="text/javascript">
    $(function () {
        $('#btn-login').click(function () {
            var loginData = {
                username: $('#username').val(),
                password: $('#password').val()
            };
            $.ajax({
                type: 'post',
                url: '${request.contextPath}/doLogin',
                data: loginData,
                success: function (response) {
                    if (response.code === 0) {
                        window.location.href = '${request.contextPath}/';
                    } else {
                        alert(response.message);
                    }
                }
            })
        });
    })
</script>
</body>
</html>