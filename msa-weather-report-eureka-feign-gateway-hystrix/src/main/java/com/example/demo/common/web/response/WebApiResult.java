package com.example.demo.common.web.response;

import java.util.HashMap;
import java.util.List;

/**
 * @Name WebApiResult
 * @Description ajax请求返回结果对象
 * @Date 2019年1月22日
 * @Author wen
 */
public class WebApiResult extends HashMap<String, Object> {

	public static final String HTTP_CODE_KEY = "code";
	public static final String HTTP_MSG_KEY = "msg";
	public static final String HTTP_DATA_KEY = "data";
	public static final String HTTP_COUNT_KEY = "count";
	
	public static final int HTTP_SUCCESS_CODE = 0;
	public static final int HTTP_FAIL_CODE = -1;
	public static final String HTTP_SUCCESS_MSG = "操作成功！";
	public static final String HTTP_FAIL_MSG = "操作失败！";
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static <T> WebApiResult data(Integer count, List<T> data) {
		WebApiResult r = new WebApiResult();
		r.put(HTTP_CODE_KEY, HTTP_SUCCESS_CODE);
		r.put(HTTP_COUNT_KEY, count);
		r.put(HTTP_DATA_KEY, data);
		return r;
	}

	public static WebApiResult success() {
		WebApiResult r = new WebApiResult();
		r.put(HTTP_CODE_KEY, HTTP_SUCCESS_CODE);
		r.put(HTTP_MSG_KEY, HTTP_SUCCESS_MSG);
		return r;
	}

	public static WebApiResult success(String message) {
		WebApiResult r = new WebApiResult();
		r.put(HTTP_CODE_KEY, HTTP_SUCCESS_CODE);
		r.put(HTTP_MSG_KEY, message);
		return r;
	}

	public static WebApiResult success(int code, String message) {
		WebApiResult r = new WebApiResult();
		r.put(HTTP_CODE_KEY, code);
		r.put(HTTP_MSG_KEY, message);
		return r;
	}

	public static WebApiResult fail() {
		WebApiResult r = new WebApiResult();
		r.put(HTTP_CODE_KEY, HTTP_FAIL_CODE);
		r.put(HTTP_MSG_KEY, HTTP_FAIL_MSG);
		return r;
	}

	public static WebApiResult fail(String message) {
		WebApiResult r = new WebApiResult();
		r.put(HTTP_CODE_KEY, HTTP_FAIL_CODE);
		r.put(HTTP_MSG_KEY, message);
		return r;
	}

	public static WebApiResult fail(int code, String message) {
		WebApiResult r = new WebApiResult();
		r.put(HTTP_CODE_KEY, code);
		r.put(HTTP_MSG_KEY, message);
		return r;
	}

	public WebApiResult add(Object value) {
		return add(HTTP_DATA_KEY, value);
	}

	public WebApiResult add(String key, Object value) {
		this.put(key, value);
		return this;
	}

}