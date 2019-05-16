/**
 * 
 */
$(function(){
	$(".m_fixed_ul li").each(function(index,element){
		if($(element).hasClass('current_url')){
			$(element).parent().show();
			$(element).parent().prev().find('a').addClass('m_fixed-on');
		}
	});
	$('.nav_tiele').find(' h2:last').css({'border-bottom':'none 0'});
	//左侧功能模块菜单
	$(".m_fixed").click(function(){
		var $this = $(this);
		if(!$this.hasClass("m_fixed-on")){
			$(".m_fixed_ul").slideUp(600);
			$(".m_fixed").removeClass("m_fixed-on");
			if(0 != $this.parent().next(".m_fixed_ul").length){
				$this.parent().next(".m_fixed_ul").slideDown(600);
			}
			$this.addClass("m_fixed-on");
		}else{
			$this.removeClass("m_fixed-on");
			$this.parent().next(".m_fixed_ul").slideUp(600);
		}
	});
});

var curMenu = null, zTree_Menu = null;
var setting = {
	treeId : 'treeMenu',
	view: {
		showLine: false,
		selectedMulti: false,
		dblClickExpand: false
	},
	data: {
		simpleData: {
			enable: true,
			idKey : 'id'
		}
	},
	callback: {
		//onNodeCreated: this.onNodeCreated,
		beforeClick: this.beforeClick/* ,
		onClick : this.onClick */
	}
};

function beforeClick(treeId, node) {
	//debugger;
	if (node.isParent) {
		//alert('parent');
		if (node.open) {
			zTree_Menu.expandNode(node,false);
		} else {
			zTree_Menu.expandNode(node,true);
		}
		//return false;
	}
	//alert('click'+node.tId);
	return false; //!node.isParent;
}
$(document).ready(function(){
	$("#mainFrame").panel('setTitle',curMenu);
//	$.ajax({
//		  type: "POST",
//		  url: "index/menuAjax",
//		  dataType: "json",
//		  success : function(data,status){
//			  //alert('status'+status);
//			  $.fn.zTree.init($("#treeMenu"), setting, data);
//			  	alert(current_menu_id);
//				zTree_Menu = $.fn.zTree.getZTreeObj("treeMenu");
//				zTree_Menu.expandAll(true);
//				//alert('treeid:'+zTree_Menu.setting.treeId);
//				var node = zTree_Menu.getNodeByParam('id',mid);
//				alert(node);
//				if(node != null){
//					//alert(node.name);
//					zTree_Menu.selectNode(node,false);
//					//alert('done');
//					$("#mainFrame").panel('setTitle',node.name);
//				}
//		  }
//		});	
});


//将form中的值转换为键值对。
function getFormJson(frm) {
    var o = {};
    var a = $(frm).serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });

    return o;
}

function showMessage(title,message,timeout){
	if(!timeout){
		timeout=2000;
	}
	$.messager.show({ // show error message
		title: title,
		msg: message,
		timeout:timeout,
		style:{
			right:'',
			top:document.body.scrollTop+document.documentElement.scrollTop,
			bottom:''
		}
	});
}

