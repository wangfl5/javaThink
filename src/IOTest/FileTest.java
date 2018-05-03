package IOTest;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("./src/QuartzTest");
		String[] a;
		if(0==args.length){
			a=file.list();
		}
		else 
			a=file.list(new DirFileter(args[0]));
		Arrays.sort(a,String.CASE_INSENSITIVE_ORDER);
		for(String temp:a){
			System.out.println(temp);
		}
		
		
		//System.out.println(Pattern.compile("([a-z]|[A-Z])*.java").matcher("aFaa.java").matches());
	}

}
