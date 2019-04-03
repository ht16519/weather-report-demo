package com.example.demo.common.web.error;

/**
 * @author deng.wenqin
 * @Name EmBusinessError
 * @Description 业务错误枚举
 * @Date 2018-03-21
 */
public enum EmError implements CommomError {
    //基本类型
    SUCCESS(0, "操作成功"),
    FAIL(-1, "操作失败"),
    //1000开头为通用错误类型
    UNKNOWN_ERROR(10001, "未知错误"),
    PARAMETER_VERIFICATION_ERROR(10002, "参数不合法"),
    //2000开头为天气信息相关错误
    GET_WEATHER_INFO_ERROR(20001, "天气数据获取异常"),
    USER_DATA_ERROR(20002, "用户数据错误"),
    USER_PASSWORD_ERROR(20004, "密码错误"),
    USER_SESSION_NOT_EXITS(20003, "用户未登录或登录已超时"),
    //3000开头为文件相关错误
    FILE_WRITE_ERROR(30001, "文件写入失败"),
    FILE_IS_NOT_PICTURE(30003, "不支持的文件类型"),
    MAX_UPLOAD_SIZE_EXCEEDED(30002, "文件不能超过1MB"),;

    private int code;
    private String msg;


    private EmError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getErrCode() {
        return this.code;
    }

    @Override
    public String getErrMsg() {
        return this.msg;
    }

    @Override
    public CommomError setErrMsg(String msg) {
        this.msg = msg;
        return this;
    }

}
