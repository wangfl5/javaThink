package junitTest;
import java.io.File;
import java.io.IOException;

import org.junit.*;
import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.*;
import org.junit.runner.Description;
public class RuleTest {
	File files;
	/**
	 * TemporaryFolder Rule            使用这个Rule可以创建一些临时目录或者文件，在一个测试方法结束之后，系统会自动清空他们。
	 * ExternalResource Rule           ExternalResource 是TemporaryFolder的父类，主要用于在测试之前创建资源，并在测试完成后销毁。
	 * ErrorCollector Rule             ErrorCollector允许我们收集多个错误，并在测试执行完后一次过显示出来
	 * Verifier Rule                   Verifier是ErrorCollector的父类，可以在测试执行完成之后做一些校验，以验证测试结果是不是正确
	 * TestWatcher Rule                TestWatcher 定义了五个触发点，分别是测试成功，测试失败，测试开始，测试完成，测试跳过，能让我们在每个触发点执行自定义的逻辑。
	 * TestName Rule                   TestName能让我们在测试中获取目前测试方法的名字。
	 * Timeout与ExpectedException Rule  分别用于超时测试与异常测试
	 */
//	@Rule
//	public TemporaryFolder tf = new TemporaryFolder();
//	@Test
//	public void tfTest() throws IOException{
//		File f = tf.newFile("aaa.txt");
//		System.out.println(f.getPath());
//	}
//	@Rule
//	public ExternalResource er = new ExternalResource() {
//		protected void before(){
//			try {
//				files = File.createTempFile("bbb", ".doc");
//				System.out.println("--------------");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	};
//	@Test
//	public void erTest(){
//		System.out.println(files.getPath());
//	}
	
//	@Rule
//	public ErrorCollector ec = new ErrorCollector();
//	@Test
//	public void ecTest(){
//		ec.addError(new Throwable("1232"));
//		ec.addError(new Exception("exception"));
//	}
	
	@Rule
	public TestWatchman tw = new TestWatchman(){
		 	protected void succeeded(Description description) {  
		        System.out.println(description.getDisplayName() + " Succeed");  
		    }  
		  
		    protected void failed(Throwable e, Description description) {  
		        System.out.println(description.getDisplayName() + " Fail");  
		    }  
		  
		    protected void skipped(AssumptionViolatedException e, Description description) {  
		        System.out.println(description.getDisplayName() + " Skipped");  
		    }  
		  
		    protected void starting(Description description) {  
		        System.out.println(description.getDisplayName() + " Started");  
		    }  
		  
		    protected void finished(Description description) {  
		        System.out.println(description.getDisplayName() + " finished");  
		    }  
	};
	@Test
	public void twTest(){
		System.out.println("Test");
	}
	
}
