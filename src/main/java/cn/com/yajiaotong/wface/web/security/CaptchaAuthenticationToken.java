package cn.com.yajiaotong.wface.web.security;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 用户认证身份的token.
 */
public class CaptchaAuthenticationToken extends UsernamePasswordToken {

    private static final long serialVersionUID = 5898441540965086534L;
    private String captchaId;
    private String captcha;
    private boolean rememberMe;

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    /**
     * 激活码
     */
    private String activationCode;

    public CaptchaAuthenticationToken(String username, String password,
                                      String captchaId, String captcha, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
        this.captchaId = captchaId;
        this.captcha = captcha;
        this.rememberMe=rememberMe;
    }

    public CaptchaAuthenticationToken(String username, String password,
                                      String captchaId, String captcha, boolean rememberMe, String host, String activationCode) {
        super(username, password, rememberMe, host);
        this.captchaId = captchaId;
        this.captcha = captcha;
        this.activationCode = activationCode;
        this.rememberMe=rememberMe;
    }


    public String getCaptchaId() {
        return captchaId;
    }

    public void setCaptchaId(String captchaId) {
        this.captchaId = captchaId;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
}
