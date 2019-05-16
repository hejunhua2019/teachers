//package cn.com.yajiaotong.wface.web.security;
//
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.lang.time.DateFormatUtils;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import cn.com.yajiaotong.wface.entity.User;
//import cn.com.yajiaotong.wface.exception.IncorrectCaptchaException;
//import cn.com.yajiaotong.wface.service.PermissionService;
//import cn.com.yajiaotong.wface.service.UserService;
//import cn.com.yajiaotong.wface.util.C;
//import cn.com.yajiaotong.wface.util.U;
//
//
///**
// */
//public class WebCaptchaUserAuthorizingRealm extends AuthorizingRealm {
//
//	private static final Logger logger = LoggerFactory
//			.getLogger(WebCaptchaUserAuthorizingRealm.class);
//	
//   
//
//
//    /**
//     * 进行认证，获取认证信息
//     *
//     * @param token the token
//     * @return the authentication info
//     */
//    protected AuthenticationInfo doGetAuthenticationInfo(
//            AuthenticationToken token) {
//    	CaptchaAuthenticationToken localAuthenticationToken = (CaptchaAuthenticationToken) token;
//        String username = localAuthenticationToken.getUsername();
//        String password = new String(localAuthenticationToken.getPassword());
//        boolean rememberMe = localAuthenticationToken.isRememberMe();
////        if (!validateCaptcha(captcha)) {
////            throw new IncorrectCaptchaException("captcha");
////        }
//        if ((username != null) && (password != null)) {
//            User user = userService.findByLoginName(username);
//            if (user == null) {
//                throw new UnknownAccountException();
//            }
//            if (!DigestUtils.md5Hex(password).equals(user.getLoginPassword())) { // 验证密码,5次锁死
//                throw new IncorrectCredentialsException("password");
//            }else{
//            	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//                if (attr == null) {
//                    throw new RuntimeException("request attr is null");
//                }
//                HttpSession session = attr.getRequest().getSession(false);
//                if (session == null) {
//                	throw new RuntimeException("request session is null");
//                }
//                session.setAttribute(C.UID, user.getId());
//                session.setAttribute(C.DEPTID, user.getDpId());
//            	session.setAttribute(C.LOGINNAME, user.getLoginName());
//        		session.setAttribute(C.UNAME, user.getUserName());
//        		//更新用户的最后登陆时间
//        		Date d=new Date();
//            	user.setLastLoginDate(d);
//            	this.userService.updateLastLoginDate(user);
//            	session.setAttribute(C.LASTLOGINDATE, DateFormatUtils.format(d, "yyyyMMdd HH:mm:ss"));
//            	session.setAttribute(C.USERCREATEDATE, DateFormatUtils.format(user.getCreateDate(), "yyyyMMdd HH:mm:ss"));
//            }
//            return new SimpleAuthenticationInfo(new Principal(user.getId(),username), password, getName());
//        }
//        throw new UnknownAccountException();
//    }   
//
//    /**
//     * 进行授权，获取授权信息
//     *
//     * @param principals the principals
//     * @return the authorization info
//     */
//    protected AuthorizationInfo doGetAuthorizationInfo(
//            PrincipalCollection principals) {
//    	logger.info("==========||||||||||========invoke doGetAuthorizationInfo==============||||||||||==============");
////        Principal principal = (Principal) principals.fromRealm(getName())
////                .iterator().next();
////        if (principal != null) {
////            List<String> authorities = subjectPermissionProvider.findPermissionsId(principal
////                    .getId());
////            if (authorities != null) {
////                SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
////                simpleAuthorizationInfo.addStringPermissions(authorities);
//    			  //TODO: 向simpleAuthorizationInfo实例添加授权信息(角色、权限等)
////                return simpleAuthorizationInfo;
////            }
////        }
//        return null;
//    }
//    
////    private boolean validateCaptcha(String captcha) {
////        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
////        if (attr == null) {
////            return false;
////        }
////        HttpSession session = attr.getRequest().getSession(false);
////        if (session == null) {
////            return false;
////        }
////        String rcaptcha = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
////        if (rcaptcha == null) {
////            return false;
////        }
////        if (StringUtils.equals(rcaptcha, captcha)) {
////            return true;
////        }
////        return false;
////    }
//    
//    public static void main(String[] args){
//    	System.out.println(DigestUtils.md5Hex("1234567890"));
//    }
//}
