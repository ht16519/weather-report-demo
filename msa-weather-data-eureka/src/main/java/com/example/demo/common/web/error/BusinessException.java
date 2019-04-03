package com.example.demo.common.web.error;

/**
 * @Name BusinessException
 * @Description 业务异常类
 * @Date 2018-03-21 
 * @author deng.wenqin
 */
public class BusinessException extends Exception implements CommomError {

	private static final long serialVersionUID = 1L;
	
	private CommomError commomError;
	
	/**
	 * 直接接收 EmBusinessError的传参用于构造业务异常
	 * @param commomError
	 */
	public BusinessException(CommomError commomError) {
		super();
		this.commomError = commomError;
	}
	
	/**
	 * 接收自定义errMsg的方法构造业务异常
	 * @param commomError
	 * @param errMsg
	 */
	public BusinessException(CommomError commomError, String errMsg) {
		super();
		this.commomError = commomError;
		this.commomError.setErrMsg(errMsg);
	}

	@Override
	public int getErrCode() {
		return this.commomError.getErrCode();
	}

	@Override
	public String getErrMsg() {
		return this.commomError.getErrMsg();
	}

	@Override
	public CommomError setErrMsg(String errMsg) {
		this.commomError.setErrMsg(errMsg);
		return this;
	}

}
