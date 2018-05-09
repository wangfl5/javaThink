package junitTest;
import org.junit.rules.*;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
public class MyRule implements MethodRule{
	int count;
	public MyRule(int num){
		this.count=num;
	}
	@Override
	public Statement apply(final Statement arg0, FrameworkMethod arg1, Object arg2) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				for(int i=0;i<count;i++){
					arg0.evaluate();
					System.out.println("test:"+i);
				}
			}
		};
	}

}
