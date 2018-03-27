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
                <label>用户名：</label>
                <input type="text" id="username" class="form-control form-control-sm"/>
            </div>
            <div class="btn-group">
                <button type="button" class="btn btn-primary btn-sm" id="btn-search">查询</button>
                <button type="button" class="btn btn-primary btn-sm" id="btn-reset">重置</button>
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
        grid: null,
        init: function () {
            user.bindEvent();
            user.loadGrid();
            $(window).resize(function () {
                user.grid.setGridWidth(user.grid.closest('.grid').width());
                user.grid.setGridHeight($(window).height() - 179);
            })
        },
        loadGrid: function () {
            if (user.grid) {
                user.grid.jqGrid('setGridParam', {
                    postData: user.getPostData(),
                    page: 1
                }).trigger('reloadGrid');
            } else {
                user.grid = $('#jqGrid').jqGrid({
                    url: '${request.contextPath}/user/list',
                    datatype: 'json',
                    colModel: [
                        {label: '编号', hidden: true, name: 'id', key: true, width: 70},
                        {label: '用户名', name: 'username', width: 100},
                        {label: '真实姓名', name: 'realname', width: 100, align: 'center'},
                        {label: '性别', name: 'sex', width: 70},
                        {
                            label: '出生日期',
                            name: 'birthday',
                            width: 100,
                            formatter: 'date',
                            formatoptions: {srcformat: 'Y-m-d', newformat: 'Y-m-d'}
                        },
                        {label: '住址', name: 'address', width: 200},
                        {label: '创建人', name: 'createBy', width: 100},
                        {
                            label: '创建时间',
                            name: 'createTime',
                            width: 130,
                            formatter: 'date',
                            formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}
                        }
                    ],
                    postData: user.getPostData(),
                    rownumbers: true,
                    pager: "#jqGridPager",
                    rowNum: 20,
                    rowList: [20, 30, 50, 100],
                    shrinkToFit: false,
                    autowidth: true,
                    height: $(window).height() - 179,
                    viewrecords: true,
                    gridview: true
                });
            }
        },
        getPostData: function () {
            return {
                username: $.trim($('#username').val())
            }
        },
        bindEvent: function () {
            $('#btn-search').click(function () {
                user.loadGrid();
            });
            $('#btn-reset').click(function () {
                $('#username').val('');
                user.loadGrid();
            })
        }
    }
</script>
</body>
</html>