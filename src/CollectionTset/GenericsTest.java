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
		//初始化之后就再不能指定其他类型了
		//gTest.set("123"); 报错：类型 GenericsTest<AutoClass> 中的方法 set（AutoClass）对于参数（String）不适用
		//gTest.set(123);
	}

}
