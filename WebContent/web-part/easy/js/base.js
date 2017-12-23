//js部分封装
String.prototype.replaceAll = function(oldStr, newStr) {
	return this.replace(new RegExp(oldStr, "gm"), newStr);
};

// jquery部分封装
(function($) {
	$.extend({
		// 设置按钮禁用启用
		setBtnNY : function(jqobj) {
			$(jqobj).attr("disabled", "disabled");
			setTimeout(function() {
				$(jqobj).removeAttr("disabled");
			}, 5000);
		},
		// 判断data是否为json
		isJson : function(data) {
			return data.match("^\{(.+:.+,*){1,}\}$");
		},
		// 提取中文英文数字
		strip : function(s) {
			return s.match(/([\u4e00-\u9fa5\w]*)/ig).join("");
		},
		// 获取/设置HttpSession
		session : function(name, val) {
			// 获取
			if (arguments.length == 1) {
				var res = "";
				$.ajax({
					type : "POST",
					async : false,
					url : "demo/sessionget",
					data : {
						name : name
					},
					success : function(data) {
						res = data;
					}
				});
				return res;
			} // 设置
			else if (arguments.length == 2) {
				$.ajax({
					type : "POST",
					async : false,
					url : "demo/sessionset",
					data : {
						name : name,
						val : val
					},
					success : function(data) {
					}
				});
			}
		},
		// 获取指定表单所有项值
		getFormVals : function(fm) {
			var data = {};
			$(fm + " [name]").each(function(i, n) {
				var name = $(n).attr("name");
				data[name] = $.trim($(n).val());
			});
			return data;
		},
		// 根据json数据设置表单所有项值
		setFormVals : function(fm, data) {
			$(fm + " [name]").each(function(i, n) {
				var name = $(n).attr("name");
				$(n).val($.trim(data[name]));
			});
		},
		// 清空指定表单所有项值
		clearFormVals : function(fm) {
			$(fm + " [name]").each(function(i, n) {
				$(n).val("");
			});
		},
		// 获取dropdownlist-item
		getDropItem : function(valuefield, textfield, data) {
			var item = "<option value='" + data[valuefield] + "'>"
					+ data[textfield] + "</option>";
			return item;
		},
		// 渲染html模板
		render : function(tmpl, data) {
			var jqobj = $(tmpl);
			var items = jqobj.find("[field]");
			var items_e = jqobj.find("[idfield]");
			// 处理items
			$.each(items, function(i, n) {
				var field = $(n).attr("field");
				var formatter = $(n).attr("formatter");
				// 判断formatter
				if (!formatter) {
					$(n).html(data[field]);
				} else {
					var fmtFunc = new Function("val", "return " + formatter
							+ "(val)");
					$(n).html(fmtFunc(data[field]));
				}
			});
			// 处理items_e
			$.each(items_e, function(i, n) {
				var idfield = $(n).attr("idfield");
				$(n).attr("rowid", data[idfield]);
			});
			// 输出结果
			return jqobj[0].outerHTML;
		}
	//
	});
}(jQuery));