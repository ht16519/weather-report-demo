/**
 * report页面下拉框事件
 * auther:waylau.com
 */
$(function(){
	$("#selectCityCode").change(function(){
		var cityCode = $("#selectCityCode").val();
		var url = '/report/code/'+ cityCode;
		window.location.href = url;
	})
});