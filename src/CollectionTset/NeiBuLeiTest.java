package CollectionTset;

public class NeiBuLeiTest {
	private String name;
	public class Test2 {//��Ա�ڲ���
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
		test.name="����1";
		NeiBuLeiTest.Test2 test2 = test.new Test2();
		System.out.println(test2.getnames());
		test.flys(new Brid(){//�����ڲ���
			public String name(){
				return "����";
			}
			public String fly(){
				return "��1����";
			}
		}
		);
	}
	
}

interface Brid {
	public String name();
	public String fly();
}
