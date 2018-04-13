
package javabrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle  implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean{
	private Point pointA, pointB, pointC;
	private ApplicationContext context = null;
	private String beanName = null;
	
	{
		System.out.println("init block");
	}
	
	public Point getPointA() {
		return pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
				
	public void draw(){
		System.out.println("Drawing triangle");
		System.out.println("PintA: "+pointA);
		System.out.println("PintB: "+pointB);
		System.out.println("PintC: "+pointC);
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
	
	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println("Bean name is: " + beanName);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Bean method called for Triangle");
	}
	
	@Override
	public void destroy() throws Exception{
		System.out.println("DisposableBean destroy method called for Tiangle class" + beanName);
	}
	
}
