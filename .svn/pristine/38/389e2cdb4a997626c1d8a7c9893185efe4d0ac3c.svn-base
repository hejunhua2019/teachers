package cn.com.yajiaotong.wface.web.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidAccessAuthorizationFilter extends AuthorizationFilter {

	private static final Logger logger = LoggerFactory.getLogger(InvalidAccessAuthorizationFilter.class);
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		logger.info("===========invoke InvalidAccessAuthorizationFilter=================");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		String referer=req.getHeader("Referer");
//		if(StringUtils.isBlank(referer)){
//			logger.error("##########referer is null##################");
//			return false;
//		}
		return true;
	}
}
