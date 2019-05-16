package cn.com.yajiaotong.wface.web.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextListener implements ApplicationContextAware, BeanName {

    private static ApplicationContext context;
    
    @Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
    	context = applicationContext;
	}
    public static ApplicationContext getApplicationContext() {
        return context;
    }
	
    
}