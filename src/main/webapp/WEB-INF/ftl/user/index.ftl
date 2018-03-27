<#import "/common/common.macro.ftl" as common>
<!DOCTYPE html>
<html>
<head>
    <@common.commonHead/>
    <title>首页</title>
    <@common.commonStyle/>
    <link type="text/css" rel="stylesheet" href="${request.contextPath}/assets/css/css.css"/>
</head>
<body>
<div class="page-wrapper">
    <header class="page-header">
        <h2 class="title">系统-用户管理</h2>
        <div class="actions">
            <span class="record">共 28 条记录</span>
            <button class="btn btn-primary btn-sm"><i class="fa fa-edit"></i> 刷新</button>
            <button class="btn btn-primary btn-sm"><i class="fa fa-edit"></i> 添加</button>
            <button class="btn btn-primary btn-sm"><i class="fa fa-edit"></i> 添加</button>
        </div>
    </header>
    <div class="page-content">
        <div class="searchbar form-inline">
            <div class="form-group">
                <label>类别名称：</label>
                <input type="text" class="form-control form-control-sm"/>
            </div>
            <div class="form-group">
                <label>类别名称：</label>
                <input type="text" class="form-control form-control-sm"/>
            </div>
            <div class="btn-group">
                <button type="button" class="btn btn-primary btn-sm">查询</button>
                <button type="button" class="btn btn-primary btn-sm">重置</button>
            </div>
        </div>
        <div class="grid">
            <table id="jqGrid"></table>
            <div id="jqGridPager"></div>
        </div>
    </div>
</div>
    <@common.commonScript/>
<script type="text/javascript">
    $(function () {
        user.init();
    })
    var user = {
        init: function () {
            user.grid();
        },
        grid: function () {
            $('#jqGrid').jqGrid({
                url: '${request.contextPath}/user/list',
                datatype: 'json',
                colModel: [
                    {label: '编号', name: 'id', key: true, width: 75},
                    {label: '用户名', name: 'username', width: 150},
                    {label: '真实姓名', name: 'realname', width: 150},
                    {label: '创建人', name: 'createby', width: 150},
                    {
                        label: '创建时间',
                        name: 'createtime',
                        width: 150,
                        formatter: 'date',
                        formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}
                    }
                ],
                shrinkToFit: false,
                autowidth: true,
                height: $(window).height() - 177,
                rowNum: 10,
                viewrecords: true,
                gridview: true,
                pager: '#jqGridPager'
            });
        }
    }
</script>
</body>
</html>