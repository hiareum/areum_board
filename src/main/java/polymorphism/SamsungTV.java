package polymorphism;

public class SamsungTV implements TV{
	
	//private SonySpeaker speaker;
	private Speaker speaker;
private int price;
	//applicationContext.xml설정파일에 작성 init-method="initMethod"

	
	public SamsungTV() {
		System.out.println("삼성티비 1 객체 생성");
	}
	
	//SonySpeaker speaker를 매개변수로 넣어서 사용 그래서 실행결과 먼저SonySpeaker가 생성
	public SamsungTV(SonySpeaker speaker,int price) {
		System.out.println("삼성티비 2 객체 생성");
		this.speaker=speaker;
		this.price=price;
	}
	
	public SamsungTV(Speaker speaker,int price) {
		System.out.println("삼성티비 3 객체 생성");
		this.speaker=speaker;
		this.price=price;
	}
	
	
	public void powerOn(){
		System.out.println("s-TV켬" + " 가격은 "+price+"원");
	}
	
	
	public void volumeUp(){
		//speaker=new SonySpeaker();
		speaker.volumeUp();
		
	}
	
	public void volumeDown(){
		//speaker=new SonySpeaker();
		speaker.volumeDown();
	
	}
	
	public void powerOff(){
		System.out.println("s-TV끔");
	}
	
	//applicationContext.xml설정파일에 작성 destroy-method="destoryMethod"
	public void destoryMethod(){
		System.out.println("객체 삭제 전에 처리할 로짓");
	}
}
