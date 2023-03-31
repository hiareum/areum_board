package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "stv")
public class SamsungTV implements TV{
	

		//@Autowired  //컨테이너가 SonySpeaker객체를 speaker변수에 자동 할당, @Autowired 를 사용해야 TV에서 Speaker를 사용 할 수 있음
		@Autowired 
		@Qualifier(value = "appl")  //Speaker을 상속받은 클래스가 2개(sony,appl)가 있으므로 그 중 appl을 사용한다는 의미로 작성
		private Speaker speaker;
		private int price;  
	
	
	/*
	@Resource(name="sony")//컨테이너가 소티 스피커 객체를 스피커변수에 자동으로 할당,@Autowired는 변수의 타입을 기준으로 객체를 검색하여 의존성 처리하지만 ,  대신에 @Resource는 객체의 이름을 이용하여 의존성 주입처리
	private Speaker speaker;
	private int price;
	*/

	
	//applicationContext.xml설정파일에 작성 init-method="initMethod"
	public SamsungTV() {
		System.out.println("삼성티비 1 객체 생성");
	}
	
	/*
	 //아래 방식은 생성자를 이용한 의존성 처리(setter메서드가 제공되지 않는 클래스에 대해서만 생성자 인젝션 사용)
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
	
	*/
	
	//아래 방식은 setter인젝션
	
	public void powerOn(){
		System.out.println("s-TV켬" + " 가격은 "+price+"원");
	}
	
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("setPrice() 호출");
		this.price = price;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void volumeUp(){
		//speaker=new SonySpeaker();
		speaker.volumeUp();
		//System.out.println("소리올림");
	}
	
	public void volumeDown(){
	//	speaker=new SonySpeaker();
		speaker.volumeDown();
		//System.out.println("소리내림");
	}
	
	public void powerOff(){
		System.out.println("s-TV끔");
	}
	
	//applicationContext.xml설정파일에 작성 destroy-method="destoryMethod"
	public void destoryMethod(){
		System.out.println("객체 삭제 전에 처리할 로짓");
	}
}
