
package javabrains;

import java.util.Locale;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	
	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		Triangle triangle = (Triangle) context.getBean("triangle1");
		triangle.draw();
		
		Circle circle = (Circle) context.getBean("circle");
		circle.draw();
		
		Shape shape = (Shape) context.getBean("circle");
		shape.draw();
		//System.out.println(context.getMessage("greeting", null, "Defaul Greeting", null));
	}
}
