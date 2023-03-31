package injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

//xml에서 설정해야함
public class CollectionBean {

	/*private List<String> addressList;

	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}*/
	
	/*
	private Set<String>addressList;

	public Set<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<String> addressList) {
		this.addressList = addressList;
	}
*/
	
	//MAP일때
	/*
	private Map<String,String>addressList;

	public Map<String, String> getAddressList() {
		return addressList;
	}

	public void setAddressList(Map<String, String> addressList) {
		this.addressList = addressList;
	}
*/
	
	
	private Properties addressList;

	public Properties getAddressList() {
		return addressList;
	}

	public void setAddressList(Properties addressList) {
		this.addressList = addressList;
	}



	
	
}
