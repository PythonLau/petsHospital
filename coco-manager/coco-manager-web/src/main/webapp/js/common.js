Date.prototype.format = function(format){
    var o =  {
        "M+" : this.getMonth()+1, //month
        "d+" : this.getDate(), //day
        "h+" : this.getHours(), //hour
        "m+" : this.getMinutes(), //minute
        "s+" : this.getSeconds(), //second
        "q+" : Math.floor((this.getMonth()+3)/3), //quarter
        "S" : this.getMilliseconds() //millisecond
    };
    if(/(y+)/.test(format)){
        format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    for(var k in o)  {
        if(new RegExp("("+ k +")").test(format)){
            format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
        }
    }
    return format;
};

var TT = TAOTAO = {
    // 编辑器参数
    kingEditorParams : {
        //指定上传文件参数名称
        filePostName  : "uploadFile",
        //指定上传文件请求的url。
        uploadJson : '/pic/upload',
        //上传类型，分别为image、flash、media、file
        dir : "image"
    },
    // 格式化时间
    formatDateTime : function(val,row){
        var now = new Date(val);
        return now.format("yyyy-MM-dd hh:mm:ss");
    },

    // 格式化价格
    formatPrice : function(val,row){
        return (val/1000).toFixed(2);
    },
    // 格式化商品的状态
    formatItemStatus : function formatStatus(val,row){
        if (val == 1){
            return '正常(1)';
        } else if(val == 2){
            return '<span style="color:red;">下架(0)</span>';
        } else {
            return '未知';
        }
    },

    formatEmployeeStatus : function formatStatus(val,row){
        if (val == 1){
            return '在职(1)';
        } else if(val == 0){
            return '<span style="color:red;">离职(0)</span>';
        } else {
            return '未知';
        }
    },

    formatmedialStatus : function formatmedialStatus(val,row) {
        if(val == 0){
            return '无效挂号(0)';
        }else if(val == 1){
            return '挂号中(1)';
        }else if(val == 2){
            return '医生已处理(2)';
        }else if(val == 3){
            return '正常结束(3)';
        }
    },

    formatAccountStatus : function formatAccountStatus(val,row) {
        if(val == 0){
            return '已注销(0)';
        }else if(val == 1){
            return '普通用户(1)';
        }else if(val == 2){
            return '会员(2)';
        }
    },
    // 格式化连接
    formatUrl : function(val,row){
        if(val){
            return "<a href='"+val+"' target='_blank'>查看</a>";
        }
        return "";
    },

    init : function(data){
        //新增物品界面初始化图片上传组件
        this.initAddPicUpload(data)
        // 新增物品界面初始化选择类目组件
        this.initAddItemCat(data);
        // 编辑物品界面初始化上传图片组件
        this.initPicUpload(data);
        // 编辑物品界面初始化选择类目组件
        this.initItemCat(data);
        //新增员工界面初始化图片上传组件
        this.initAddEmployeeCat(data);
        //新增员工界面初始化照片上传组件
        this.initAddEmployeePicUpload(data);
        //编辑员工界面初始化类目选择组件
        this.initEditEmployeeCat(data);
        //挂号界面初始化类目上传组件
        this.initMedicalEmployeeCat(data);
    },

    // 编辑物品界面初始化图片上传组件
    initPicUpload : function(data){
        $(".picFileUpload").each(function(i,e){
            var _ele = $(e);
            _ele.siblings("div.pics").remove();
            _ele.after('\
    			<div class="pics">\
        			<ul></ul>\
        		</div>');
            // 回显图片
            if(data && data.pics){
                var imgs = data.pics.split(",");
                for(var i in imgs){
                    if($.trim(imgs[i]).length > 0){
                        _ele.siblings(".pics").find("ul").append("<li><a href='"+imgs[i]+"' target='_blank'><img src='"+imgs[i]+"' width='80' height='50' /></a></li>");
                    }
                }
            }
            //给“上传图片按钮”绑定click事件
            $(e).click(function(){
                var form = $(this).parentsUntil("form").parent("form");
                //打开图片上传窗口
                KindEditor.editor(TT.kingEditorParams).loadPlugin('multiimage',function(){
                    var editor = this;
                    editor.plugin.multiImageDialog({
                        clickFn : function(urlList) {
                            var imgArray = [];
                            KindEditor.each(urlList, function(i, data) {
                                imgArray.push(data.url);
                                form.find(".pics ul").append("<li><a href='"+data.url+"' target='_blank'><img src='"+data.url+"' width='80' height='50' /></a></li>");
                            });
                            form.find("[name=image]").val(imgArray.join(","));
                            editor.hideDialog();
                        }
                    });
                });
            });
        });
    },


    // 新增物品界面初始化图片上传组件
    initAddPicUpload : function(data){
        $(".addItemPicFileUpload").each(function(i,e){
            var _ele = $(e);
            _ele.siblings("div.pics").remove();
            _ele.after('\
    			<div class="pics">\
        			<ul></ul>\
        		</div>');
            // 回显图片
            if(data && data.pics){
                var imgs = data.pics.split(",");
                for(var i in imgs){
                    if($.trim(imgs[i]).length > 0){
                        _ele.siblings(".pics").find("ul").append("<li><a href='"+imgs[i]+"' target='_blank'><img src='"+imgs[i]+"' width='80' height='50' /></a></li>");
                    }
                }
            }
            //给“上传图片按钮”绑定click事件
            $(e).click(function(){
                var form = $(this).parentsUntil("form").parent("form");
                //打开图片上传窗口
                KindEditor.editor(TT.kingEditorParams).loadPlugin('multiimage',function(){
                    var editor = this;
                    editor.plugin.multiImageDialog({
                        clickFn : function(urlList) {
                            var imgArray = [];
                            KindEditor.each(urlList, function(i, data) {
                                imgArray.push(data.url);
                                form.find(".pics ul").append("<li><a href='"+data.url+"' target='_blank'><img src='"+data.url+"' width='80' height='50' /></a></li>");
                            });
                            form.find("[name=image]").val(imgArray.join(","));
                            editor.hideDialog();
                        }
                    });
                });
            });
        });
    },


    // 新增物品界面初始化图片上传组件
    initAddEmployeePicUpload : function(data){
        $(".addEmployeePicFileUpload").each(function(i,e){
            var _ele = $(e);
            _ele.siblings("div.pics").remove();
            _ele.after('\
    			<div class="pics">\
        			<ul></ul>\
        		</div>');
            // 回显图片
            if(data && data.pics){
                var imgs = data.pics.split(",");
                for(var i in imgs){
                    if($.trim(imgs[i]).length > 0){
                        _ele.siblings(".pics").find("ul").append("<li><a href='"+imgs[i]+"' target='_blank'><img src='"+imgs[i]+"' width='80' height='50' /></a></li>");
                    }
                }
            }
            //给“上传图片按钮”绑定click事件
            $(e).click(function(){
                var form = $(this).parentsUntil("form").parent("form");
                //打开图片上传窗口
                KindEditor.editor(TT.kingEditorParams).loadPlugin('multiimage',function(){
                    var editor = this;
                    editor.plugin.multiImageDialog({
                        clickFn : function(urlList) {
                            var imgArray = [];
                            KindEditor.each(urlList, function(i, data) {
                                imgArray.push(data.url);
                                form.find(".pics ul").append("<li><a href='"+data.url+"' target='_blank'><img src='"+data.url+"' width='80' height='50' /></a></li>");
                            });
                            form.find("[name=image]").val(imgArray.join(","));
                            editor.hideDialog();
                        }
                    });
                });
            });
        });
    },


    // 编辑物品界面初始化选择类目组件
    initItemCat : function(data){
        //alert("初始化编辑物品类目控件")
        $(".selectItemCat").each(function(i,e){
            var _ele = $(e);
            if(data && data.cid){
                //alert("编辑物品有cid:")
                //alert(data.cid)
                _ele.after("<span style='margin-left:10px;'>"+data.cid+"</span>");
            }else{
                //alert("编辑物品没有cid:")
                _ele.after("<span style='margin-left:10px;'></span>");
            }
            _ele.unbind('click').click(function(){
                //alert("点击了编辑物品类目按钮")
                $("<div>").css({padding:"5px"}).html("<ul>")
                    .window({
                        width:'500',
                        height:"450",
                        modal:true,
                        closed:true,
                        iconCls:'icon-save',
                        title:'选择类目',
                        onOpen : function(){
                            var _win = this;
                            $("ul",_win).tree({
                                url:'/item/cat/list',
                                animate:true,
                                onClick : function(node){
                                    if($(this).tree("isLeaf",node.target)){
                                        alert(node.id)
                                        // 填写到cid中
                                        //alert("编辑后物品的cid是:")
                                        //alert(node.id)
                                        //alert("准备把编辑物品分类写入到表单中")
                                        _ele.parent().find("[name=cid]").val(node.id);
                                        _ele.next().text(node.text).attr("cid",node.id);
                                        $(_win).window('close');
                                        if(data && data.fun){
                                            data.fun.call(this,node);
                                        }
                                    }
                                }
                            });
                        },
                        onClose : function(){
                            $(this).window("destroy");
                        }
                    }).window('open');
            });
        });
    },

    // 新增物品界面初始化选择类目组件
    initAddItemCat : function(data){
        $(".addItemSelectItemCat").each(function(i,e){
            var _ele = $(e);
            if(data && data.cid){
                //alert("新增物品有cid")
                _ele.after("<span style='margin-left:10px;'>"+data.cid+"</span>");
            }else{
                //alert("新增物品没有cid")
                _ele.after("<span style='margin-left:10px;'></span>");
            }
            _ele.unbind('click').click(function(){
                //alert("点击了新增物品类目按钮")
                $("<div>").css({padding:"5px"}).html("<ul>")
                    .window({
                        width:'500',
                        height:"450",
                        modal:true,
                        closed:true,
                        iconCls:'icon-save',
                        title:'选择类目',
                        onOpen : function(){
                            var _win = this;
                            $("ul",_win).tree({
                                url:'/item/cat/list',
                                animate:true,
                                onClick : function(node){
                                    if($(this).tree("isLeaf",node.target)){
                                        // 填写到addItemCid中
                                        //alert("新增物品的cid是:")
                                        //alert(node.id)
                                        //alert("准备把新增物品分类写入到表单中")
                                        _ele.parent().find("[name=cid]").val(node.id);
                                        _ele.next().text(node.text).attr("cid",node.id);
                                        $(_win).window('close');
                                        if(data && data.fun){
                                            data.fun.call(this,node);
                                        }
                                    }
                                }
                            });
                        },
                        onClose : function(){
                            $(this).window("destroy");
                        }
                    }).window('open');
            });
        });
    },

    // 新增员工界面初始化选择类目组件
    initMedicalEmployeeCat : function(data){
        //alert("初始化新增物品类目控件")
        $(".registerMedicalSelectPositionCat").each(function(i,e){
            var _ele = $(e);
            if(data && data.cid){
                //alert("新增物品有cid")
                _ele.after("<span style='margin-left:10px;'>"+data.cid+"</span>");
            }else{
                //alert("新增物品没有cid")
                _ele.after("<span style='margin-left:10px;'></span>");
            }
            _ele.unbind('click').click(function(){
                //alert("点击了新增物品类目按钮")
                $("<div>").css({padding:"5px"}).html("<ul>")
                    .window({
                        width:'500',
                        height:"450",
                        modal:true,
                        closed:true,
                        iconCls:'icon-save',
                        title:'选择类目',
                        onOpen : function(){
                            var _win = this;
                            $("ul",_win).tree({
                                url:'/position/cat/medicalList',
                                animate:true,
                                onClick : function(node){
                                    if($(this).tree("isLeaf",node.target)){
                                        // 填写到addItemCid中
                                        //alert("新增物品的cid是:")
                                        //alert(node.id)
                                        //alert("准备把新增物品分类写入到表单中")
                                        _ele.parent().find("[name=cid]").val(node.id);
                                        _ele.next().text(node.text).attr("cid",node.id);
                                        $(_win).window('close');
                                        if(data && data.fun){
                                            data.fun.call(this,node);
                                        }
                                    }
                                }
                            });
                        },
                        onClose : function(){
                            $(this).window("destroy");
                        }
                    }).window('open');
            });
        });
    },


    // 新增员工界面初始化选择类目组件
    initAddEmployeeCat : function(data){
        //alert("初始化新增物品类目控件")
        $(".addEmployeeSelectPositionCat").each(function(i,e){
            var _ele = $(e);
            if(data && data.cid){
                //alert("新增物品有cid")
                _ele.after("<span style='margin-left:10px;'>"+data.cid+"</span>");
            }else{
                //alert("新增物品没有cid")
                _ele.after("<span style='margin-left:10px;'></span>");
            }
            _ele.unbind('click').click(function(){
                //alert("点击了新增物品类目按钮")
                $("<div>").css({padding:"5px"}).html("<ul>")
                    .window({
                        width:'500',
                        height:"450",
                        modal:true,
                        closed:true,
                        iconCls:'icon-save',
                        title:'选择类目',
                        onOpen : function(){
                            var _win = this;
                            $("ul",_win).tree({
                                url:'/position/cat/list',
                                animate:true,
                                onClick : function(node){
                                    if($(this).tree("isLeaf",node.target)){
                                        // 填写到addItemCid中
                                        //alert("新增物品的cid是:")
                                        //alert(node.id)
                                        //alert("准备把新增物品分类写入到表单中")
                                        _ele.parent().find("[name=cid]").val(node.id);
                                        _ele.next().text(node.text).attr("cid",node.id);
                                        $(_win).window('close');
                                        if(data && data.fun){
                                            data.fun.call(this,node);
                                        }
                                    }
                                }
                            });
                        },
                        onClose : function(){
                            $(this).window("destroy");
                        }
                    }).window('open');
            });
        });
    },


    // 新增员工界面初始化选择类目组件
    initEditEmployeeCat : function(data){
        //alert("初始化新增物品类目控件")
        $(".editEmployeeSelectPositionCat").each(function(i,e){
            var _ele = $(e);
            if(data && data.cid){
                //alert("新增物品有cid")
                _ele.after("<span style='margin-left:10px;'>"+data.cid+"</span>");
            }else{
                //alert("新增物品没有cid")
                _ele.after("<span style='margin-left:10px;'></span>");
            }
            _ele.unbind('click').click(function(){
                //alert("点击了新增物品类目按钮")
                $("<div>").css({padding:"5px"}).html("<ul>")
                    .window({
                        width:'500',
                        height:"450",
                        modal:true,
                        closed:true,
                        iconCls:'icon-save',
                        title:'选择类目',
                        onOpen : function(){
                            var _win = this;
                            $("ul",_win).tree({
                                url:'/position/cat/list',
                                animate:true,
                                onClick : function(node){
                                    if($(this).tree("isLeaf",node.target)){
                                        // 填写到addItemCid中
                                        //alert("新增物品的cid是:")
                                        //alert(node.id)
                                        //alert("准备把新增物品分类写入到表单中")
                                        _ele.parent().find("[name=cid]").val(node.id);
                                        _ele.next().text(node.text).attr("cid",node.id);
                                        $(_win).window('close');
                                        if(data && data.fun){
                                            data.fun.call(this,node);
                                        }
                                    }
                                }
                            });
                        },
                        onClose : function(){
                            $(this).window("destroy");
                        }
                    }).window('open');
            });
        });
    },



    createEditor : function(select){
        return KindEditor.create(select, TT.kingEditorParams);
    },

    /**
     * 创建一个窗口，关闭窗口后销毁该窗口对象。<br/>
     *
     * 默认：<br/>
     * width : 80% <br/>
     * height : 80% <br/>
     * title : (空字符串) <br/>
     *
     * 参数：<br/>
     * width : <br/>
     * height : <br/>
     * title : <br/>
     * url : 必填参数 <br/>
     * onLoad : function 加载完窗口内容后执行<br/>
     *
     *
     */
    createWindow : function(params){
        $("<div>").css({padding:"5px"}).window({
            width : params.width?params.width:"80%",
            height : params.height?params.height:"80%",
            modal:true,
            title : params.title?params.title:" ",
            href : params.url,
            onClose : function(){
                $(this).window("destroy");
            },
            onLoad : function(){
                if(params.onLoad){
                    params.onLoad.call(this);
                }
            }
        }).window("open");
    },

    closeCurrentWindow : function(){
        $(".panel-tool-close").click();
    },

    changeItemParam : function(node,formId){
        // $.getJSON("/item/param/query/itemcatid/" + node.id,function(data){
        //     if(data.status == 200 && data.data){
        //         $("#"+formId+" .params").show();
        //         var paramData = JSON.parse(data.data.paramData);
        //         var html = "<ul>";
        //         for(var i in paramData){
        //             var pd = paramData[i];
        //             html+="<li><table>";
        //             html+="<tr><td colspan=\"2\" class=\"group\">"+pd.group+"</td></tr>";
        //
        //             for(var j in pd.params){
        //                 var ps = pd.params[j];
        //                 html+="<tr><td class=\"param\"><span>"+ps+"</span>: </td><td><input autocomplete=\"off\" type=\"text\"/></td></tr>";
        //             }
        //
        //             html+="</li></table>";
        //         }
        //         html+= "</ul>";
        //         $("#"+formId+" .params td").eq(1).html(html);
        //     }else{
        //         $("#"+formId+" .params").hide();
        //         $("#"+formId+" .params td").eq(1).empty();
        //     }
        // });
    },
    getSelectionsIds : function (select){
        var list = $(select);
        var sels = list.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].id);
        }
        ids = ids.join(",");
        return ids;
    },

    /**
     * 初始化单图片上传组件 <br/>
     * 选择器为：.onePicUpload <br/>
     * 上传完成后会设置input内容以及在input后面追加<img>
     */
    initOnePicUpload : function(){
        $(".onePicUpload").click(function(){
            var _self = $(this);
            KindEditor.editor(TT.kingEditorParams).loadPlugin('image', function() {
                this.plugin.imageDialog({
                    showRemote : false,
                    clickFn : function(url, title, width, height, border, align) {
                        var input = _self.siblings("input");
                        input.parent().find("img").remove();
                        input.val(url);
                        input.after("<a href='"+url+"' target='_blank'><img src='"+url+"' width='80' height='50'/></a>");
                        this.hideDialog();
                    }
                });
            });
        });
    }
};
