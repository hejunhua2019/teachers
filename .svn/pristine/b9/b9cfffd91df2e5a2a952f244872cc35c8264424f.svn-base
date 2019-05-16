package cn.com.yajiaotong.wface.web.common;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;


/**
 * Created by
 * User: djyin
 * Time: 1:48 PM
 */
@SuppressWarnings("unchecked")
@Component("respBodyBuilder")
public class RespBodyBuilder {

    private static final Logger logger = LoggerFactory.getLogger(RespBodyBuilder.class);


    public RespBody toSuccess() {
        RespBody reps = new RespBody(Boolean.TRUE, RespBody.MESSAGE_OK, null);
        return reps;
    }


    /**
     *
     * @return the request result
     */
    public RespBody toSuccess(Object result) {
        RespBody reps = new RespBody(Boolean.TRUE, RespBody.MESSAGE_OK, result);
        return reps;
    }


    /**
     */
    public RespBody toSuccess(String message, Object result) {
        RespBody reps = new RespBody(Boolean.TRUE, message == null ? RespBody.MESSAGE_OK : message, result);
        return reps;
    }

    public RespBody toError() {
        RespBody reps = new RespBody(Boolean.FALSE, RespBody.MESSAGE_INTERNAL_ERROR, null);
        return reps;
    }


    /**
     *
     * @return the request result
     */
    public RespBody toError(Object result) {
        RespBody reps = new RespBody(Boolean.FALSE, RespBody.MESSAGE_INTERNAL_ERROR, result);
        return reps;
    }


    /**
     *
     */
    public RespBody toError(String message, Object result) {
        RespBody reps = new RespBody(Boolean.FALSE, message == null ? RespBody.MESSAGE_INTERNAL_ERROR : message, result);
        return reps;
    }

}
