package IOTest;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;
/**
 * 文件排序筛选工具类
 * @author Administrator
 *
 */
public class SortDirList {
	private File file;
	private String[] names;
	public SortDirList (String path){
		file = new File(path);
	}
	public String[] list(){
		names = file.list();
		Arrays.sort(names,String.CASE_INSENSITIVE_ORDER);
		return names;
	}
	public String[] list(final String regex){
		names = file.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return Pattern.compile(regex).matcher(name).matches();
			}
		});
		Arrays.sort(names,String.CASE_INSENSITIVE_ORDER);
		return names;
	}
}
