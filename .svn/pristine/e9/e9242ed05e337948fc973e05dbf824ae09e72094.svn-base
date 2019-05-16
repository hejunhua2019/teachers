package cn.com.yajiaotong.wface.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import cn.emay.sms.model.UserInfoEntity;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//import cn.emay.sms.controller.DataSourceController;
//import cn.emay.sms.util.Constants;

public class MyHandlerInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = Logger.getLogger(MyHandlerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String url = request.getRequestURI();


		logger.info("请求URL："+url);

		if(url.endsWith("login"))  {

            return true;
        }
//        UserInfoEntity user = (UserInfoEntity)request.getSession().getAttribute("curruser");
//        logger.info("操作用户："+user.getUsername());
//		if(null!=user){
//            return true;
//        }
		//response.sendRedirect(request.getContextPath() + "/index.jsp");
//		return false;
		return true;
	}
	
}
