package cn.com.yajiaotong.wface.web.common;


import java.util.Set;

import com.alibaba.druid.wall.Violation;

/**
 * 默认的页面请求返回的model对象.用来包裹controller的页面输出
 */
public class RespBody {

    //默认的成功消息 
    public static final String MESSAGE_OK = "success"; 
    //默认的错误 
    public static final String STATUS_INTERNAL_ERROR = "500"; 
    //默认的成功
    public static final Integer STATUS_INTERNAL_SUCCESS = 200; 
    /**
     * The constant MESSAGE_INTERNAL_ERROR.
     * 默认的错误消息  数据验证失败
     */
    public static final String MESSAGE_VIOLATION_ERROR = "incorrect input";

    /**
     * The constant STATUS_INTERNAL_ERROR.
     * 默认的错误   数据验证失败
     */
    public static final String STATUS_VIOLATION_ERROR = "400";


    /**
     * The constant MESSAGE_INTERNAL_ERROR.
     * 默认的错误消息
     */
    public static final String MESSAGE_INTERNAL_ERROR = "internal error";

    /**
     * The Message.  提示消息
     */
    private String message = null;  
    
    private Integer code = STATUS_INTERNAL_SUCCESS; 

    /**
     * 结果对象,结果为单个对象,或者列表的情况
     */
    private Object result = null; 
    /**
     * The Violations. 数据校验错误
     */
    private Set<Violation> violations;

    /**
     * The Success. 判断成功或者失败的条件
     */
    private Boolean success = null;   

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
    

    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	/**
     * 默认的成功消息
     */
    public RespBody() {
        this.success = Boolean.TRUE; 
        this.message = MESSAGE_OK;
        this.code = RespBody.STATUS_INTERNAL_SUCCESS;
    }
    
    public RespBody(Boolean success, String message, Object result,Integer code) {
        this.success = success;
        this.message = message; 
        this.result=result;
        this.code=code;
    }

    /**
     * Instantiates a new Response.
     *
     * @param message the message 消息
     * @param result  the object  结果对象
     */
    public RespBody(Boolean success, String message, Object result) {
        this.success = success;
        this.message = message;   
        this.result = result;
    } 
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }  

    public Set<Violation> getViolations() {
        return violations;
    }

    public void setViolations(Set<Violation> violations) {
        this.violations = violations;
    } 

}
