var app = new Vue({
    el:"#vue",

    created:function () {
        loadData(1,2);
    },

    methods:{

    },
    data:{
        pageInfoList:{},
        pageInfo:{}
    }
});

function loadData(pageNum,pageSize) {
    $.post("http://localhost:8888/ssm-06/getPageA.action?",{"startPage":pageNum,"pageSize":pageSize},
        function (data) {
            if(data.flag == 0) {
                console.log(data.data.list);
                app.pageInfoList = data.data.list;
                app.pageInfo = data.data;
            } else {
                alert("加载错误");
            }
        });
}