package injection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanTest {

	public static void main(String[] args) {
	
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBean bean=(CollectionBean) factory.getBean("collectionBean");
		//List<String> addressList=bean.getAddressList();
	//	Set<String> addressList=bean.getAddressList();
//		for(String address:addressList) {
//			System.out.println(address);
//		}
		
		//Map으로 사용 할 때
	/*	
		Map<String,String> addressList=bean.getAddressList();
		Set<String> keys=addressList.keySet();
		
		for(String key:keys) {
			System.out.println(key);
			System.out.println(addressList.get(key));
		}
		
		*/
		
		//Properties사용할 때
		Properties addressList=bean.getAddressList();
		Set<String> keys=addressList.stringPropertyNames();
		
		for(String key:keys) {
			System.out.println(key);
			System.out.println(addressList.get(key));
		}
		
		
		
	}

}
