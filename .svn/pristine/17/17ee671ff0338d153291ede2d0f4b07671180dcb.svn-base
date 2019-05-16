package cn.com.yajiaotong.wface.interceptor;

/**
 * Created by HL.W on 2014/9/26.
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * 防御 XSS 和 SQL 注入攻击
 *
 * @author Xiexuan
 * @since 2013-8-27
 */
public class XssFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
	System.out.println("init...");
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request), response);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    private static class XssHttpServletRequestWrapper extends
            HttpServletRequestWrapper {

        public XssHttpServletRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        public String[] getParameterValues(String parameter) {
            String[] values = super.getParameterValues(parameter);
            if (values == null) {
                return null;
            }
            int count = values.length;
            String[] encodedValues = new String[count];
            for (int i = 0; i < count; i++) {
                encodedValues[i] = cleanXSS(values[i]);
            }
            return encodedValues;
        }

        public String getParameter(String parameter) {
            String value = super.getParameter(parameter);
            if (value == null) {
                return null;
            }
            return cleanXSS(value);
        }

        public String getHeader(String name) {
            String value = super.getHeader(name);
            if (value == null)
                return null;
            return cleanXSS(value);
        }

        private String cleanXSS(String value) {
            // You'll need to remove the spaces from the html entities below
            value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
            value = value.replaceAll("\\(", "& #40;").replaceAll("\\)",
                    "& #41;");
            value = value.replaceAll("'", "& #39;");
            value = value.replaceAll("eval\\((.*)\\)", "");
            value = value.replaceAll(
                    "[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
            value = value.replaceAll("script", "");
            value = value.replaceAll("\"", "");
            return value;
        }

    }

}
