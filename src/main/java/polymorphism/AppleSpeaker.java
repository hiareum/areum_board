package polymorphism;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "appl")

public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
		System.out.println("애플스피커 만들어짐");
	}
	
	public void volumeUp(){
		System.out.println("애플 스피커 소리올림");
	}
	
	public void volumeDown(){
		System.out.println("애플 스피커 소리내림");
	}
}
