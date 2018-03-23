<#import "/common/common.macro.ftl" as common>
<!DOCTYPE html>
<html>
<head>
    <@common.commonHead/>
    <title>首页</title>
    <@common.commonStyle/>
</head>
<body>
    <div class="container-fluid">
        <table id="userGrid"></table>
        <div id="userGridPager"></div>
    </div>
    <@common.commonScript/>
    <script type="text/javascript">
        $(function () {
            user.init();
        })
        var user = {
            init:function () {
                user.loadUserGrid();
            },
            loadUserGrid:function () {
                $('#userGrid').jqGrid({
                    url: '${request.contextPath}/user/list',
                    datatype: 'json',
                    colModel: [
                        { label: '编号', name: 'id', key:true, width: 75 },
                        { label: '用户名', name: 'username',  width: 150 },
                        { label: '真实姓名', name: 'realname', width: 150 },
                        { label: '创建人', name: 'createby', width: 150 },
                        { label: '创建时间', name: 'createtime', width: 150, formatter:'date',formatoptions: {srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'} }
                    ],
                    shrinkToFit: false,
                    autowidth: true,
                    height: 250,
                    rowNum: 10,
                    viewrecords: true,
                    gridview: true,
                    pager: '#userGridPager'
                });
            }
        }
    </script>
</body>
</html>