
public class SamsungTV implements TV{

	//applicationContext.xml설정파일에 작성 init-method="initMethod"
	public void initMethod(){
		System.out.println("삼성티비 객체 생성");
	}
	
//	public SamsungTV() {
//		System.out.println("삼성티비 객체 생성");
//	}
	public void powerOn(){
		System.out.println("s-TV켬");
	}
	
	public void powerOff(){
		System.out.println("s-TV끔");
	}
	
	public void volumeUp(){
		System.out.println("s-TV소리 올림");
	}
	
	public void volumeDown(){
		System.out.println("s-TV소리 내림");
	}
	
	//applicationContext.xml설정파일에 작성 destroy-method="destoryMethod"
	public void destoryMethod(){
		System.out.println("객체 삭제 전에 처리할 로짓");
	}
}
