package CollectionTset;
class AutoClass {}
public class GenericsTest<T> {
	private T a;
	public GenericsTest(T a){
		this.a = a;
	}
	public void set(T a){
		this.a = a;
	}
	public T get(){
		return a;
	}
	public static void main(String[] args) {
		GenericsTest<AutoClass> gTest = new GenericsTest<AutoClass>(new AutoClass());
		AutoClass aClass = gTest.get();
		//��ʼ��֮����ٲ���ָ������������
		//gTest.set("123"); �������� GenericsTest<AutoClass> �еķ��� set��AutoClass�����ڲ�����String��������
		//gTest.set(123);
	}

}
