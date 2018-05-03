package IOTest;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileTest2 {
	public static FilenameFilter filter(final String regex){
		return new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return Pattern.compile(regex).matcher(name).matches();
			}
		};
	}
	public static void main(String[] args) {
		File files = new File(".");
		String[] temp;
		if(args.length==0)
			temp=files.list();
		else
			temp=files.list(filter(args[0]));
		Arrays.sort(temp,String.CASE_INSENSITIVE_ORDER);
		for(String name:temp){
			System.out.println(name);
		}
	}
}
