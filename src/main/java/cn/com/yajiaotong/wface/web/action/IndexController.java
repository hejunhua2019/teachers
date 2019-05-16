package cn.com.yajiaotong.wface.web.action;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import cn.emay.emas.entity.AirCustomer;
//import cn.emay.emas.service.AirCustomerService;

/**
 * 菜单暂时是写死的
 * @author meizhiwen
 *
 */
@Controller
@RequestMapping("index")
public class IndexController{
	
	
//	@Autowired
//	private AirCustomerService aircustomerService;
	
	@RequestMapping("welcome")
	public String index(){
//		AirCustomer aircustomer = new AirCustomer();
//		aircustomer.setDepcode("11111");
//		aircustomer.setMobile("13122224444");
//		aircustomer.setFlowno("111233456765433");
//		aircustomer.setDate("20150908");
//		aircustomerService.deleteAirCustomer(aircustomer);
		return "index/welcome";
	}
}
