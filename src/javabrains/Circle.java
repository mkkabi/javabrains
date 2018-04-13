package javabrains;

import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class Circle implements Shape{

	private Point center;
	@Autowired
	private MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
		
	@Override
	public void draw() {
		System.out.println("Drawing circle");
		System.out.println("Circle poing is X: " + center.getX() + " Y: "+ center.getY());
		System.out.println(this.messageSource.getMessage("greeting", null, "Defaul Greeting", null));
	}

	public Point getCenter() {
		return center;
	}
	// it is possible to autowire spring rewources with annotation instead of xml
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}
	@PostConstruct
	public void initializeCircle(){
		System.out.println("Init of Circle");
	}
	@PreDestroy
	public void destroyCircle(){
		System.out.println("destroy of Circle");
	}
}