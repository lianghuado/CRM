!function($) {
	$.extend({
		f1 : function() {
			alert("我是类中的f1");
		},

		f2 : function() {
			alert("我是类中的f2");
		}
	});
	$.fn.extend({
		f1 : function() {
			alert("我是对象里的f1");
		},

		f2 : function() {
			alert("我是对象里的f2");
		}
	});
}(jQuery)