package IOTest;

import java.io.File;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String regex = "^A([a-z]|[A-Z])*.java";
		String path = "./src/luceneTest";
		String path2 = ".";
		SortDirList list = new SortDirList(path);
		String[] names = list.list();
		String[] names2 = list.list(regex);
//		for(String nameTemp:names){
//			System.out.println(nameTemp);
//		}
//		System.out.println("------------------");
//		for(String nameTemp:names2){
//			System.out.println(nameTemp);
//		}
		File file = new File(path2);
		Dir dir = new Dir();
		dir = dir.recurseDir(file, regex);
		System.out.println(dir.toString());
	}

}
