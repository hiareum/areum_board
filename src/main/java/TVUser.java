import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	//factory패턴
	public static void main(String[] args) {
	//TV stv=new LgTV();
		//BeanFactory factory=new BeanFactory();
		//스프링에서는 BeanFactory와 이를 상속한 ApplicationContext두가지 유형의 컨테이너 제공
		//ApplicationContext가 즉시 로딩 외에 다양한 기능을 지원하므로 이것을 사용하는 것이 좋다
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		//구동된 컨테이너로부터 삼성tv 객체를 얻어냄
//		TV stv=(TV) factory.getBean("tv");
		
		////applicationContext.xml설정파일에 작성 scope="singleton"실행결과 하나만 출력됨
		//applicationContext.xml설정파일에 작성 scope="prototype"실행결과 모두 출력됨
		TV stv1=(TV) factory.getBean("tv");
		TV stv2=(TV) factory.getBean("tv");
		TV stv3=(TV) factory.getBean("tv");
		TV stv4=(TV) factory.getBean("tv");
		
	/*	
		System.out.println(stv);
	stv.powerOn();
	stv.volumeUp();
	stv.volumeDown();
	stv.powerOff();
	*/
	
	//스프링 컨테이너 종료
	factory.close();
	}

	
}
