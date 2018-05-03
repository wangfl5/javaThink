package IOTest;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirFileter implements FilenameFilter{
	private Pattern pattern;
	public DirFileter(String regex){
		pattern=Pattern.compile(regex);
	}
	
	public boolean accept(File file, String name) {
		return pattern.matcher(name).matches();
	}

}
