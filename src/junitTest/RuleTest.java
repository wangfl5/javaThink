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
	 * TemporaryFolder Rule            ʹ�����Rule���Դ���һЩ��ʱĿ¼�����ļ�����һ�����Է�������֮��ϵͳ���Զ�������ǡ�
	 * ExternalResource Rule           ExternalResource ��TemporaryFolder�ĸ��࣬��Ҫ�����ڲ���֮ǰ������Դ�����ڲ�����ɺ����١�
	 * ErrorCollector Rule             ErrorCollector���������ռ�������󣬲��ڲ���ִ�����һ�ι���ʾ����
	 * Verifier Rule                   Verifier��ErrorCollector�ĸ��࣬�����ڲ���ִ�����֮����һЩУ�飬����֤���Խ���ǲ�����ȷ
	 * TestWatcher Rule                TestWatcher ��������������㣬�ֱ��ǲ��Գɹ�������ʧ�ܣ����Կ�ʼ��������ɣ���������������������ÿ��������ִ���Զ�����߼���
	 * TestName Rule                   TestName���������ڲ����л�ȡĿǰ���Է��������֡�
	 * Timeout��ExpectedException Rule  �ֱ����ڳ�ʱ�������쳣����
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
