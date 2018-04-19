package CollectionTset;

public class NeiBuLeiTest {
	private String name;
	public class Test2 {//成员内部类
		private String names;
		public String getnames(){
			names = name;
			return names;
		}
	}
	public void flys(Brid brid){
		System.out.println(brid.name()+brid.fly());
	}
	public static void main(String[] args) {
		NeiBuLeiTest test = new NeiBuLeiTest();
		test.name="测试1";
		NeiBuLeiTest.Test2 test2 = test.new Test2();
		System.out.println(test2.getnames());
		test.flys(new Brid(){//匿名内部类
			public String name(){
				return "大雁";
			}
			public String fly(){
				return "飞1万里";
			}
		}
		);
	}
	
}

interface Brid {
	public String name();
	public String fly();
}
