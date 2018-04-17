package CollectionTset;
class Tuple1<A,B>{
	public final A a;
	public final B b;
	public Tuple1(A first,B second){
		a = first;
		b = second;
	}
}
class Tuple2<A,B,C> extends Tuple1<A,B>{
	public final C c;
	public Tuple2(A first,B second,C third){
		super(first,second);
		c = third;
	}
}
public class TupleTest {
	public static void main(String[] args) {
		;
		System.out.println("a:"+getTuple1().a+" b:"+getTuple1().b);
	}
	public static Tuple1 getTuple1(){
		return new Tuple1<String, Integer>("123", 123);
	}
}
