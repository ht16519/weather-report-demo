package com.example.demo.common.web.handle;

import com.example.demo.common.web.error.BusinessException;
import com.example.demo.common.web.error.EmError;
import com.example.demo.common.web.response.WebApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


/**
 * @Name CommonExceptionHandler
 * @Description 全局异常处理类
 * @Date 2019年3月24日
 * @Author wen
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {
	
	/**
	 * 定义exceptionhandler解决未被controller层吸收的exception
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object handlerException(HttpServletRequest request, Exception ex) {
		log.error("请求异常： params:{}, url:{}",request.getParameterMap().toString(), request.getRequestURI(), ex);
		if(ex instanceof BusinessException) {
			BusinessException businessException = (BusinessException)ex;
			return WebApiResult.fail(businessException.getErrCode(), businessException.getErrMsg());
		}else {
			return WebApiResult.fail(EmError.UNKNOWN_ERROR.getErrCode(), EmError.UNKNOWN_ERROR.getErrMsg());
		}
	}

}
