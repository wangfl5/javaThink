package IOTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dir {
	private List<File> dir = new ArrayList<File>();
	private List<File> file = new ArrayList<File>();
	public void addAll(Dir other){
		dir.addAll(other.dir);
		file.addAll(other.file);
	}
	public Dir recurseDir(File startfile,String regex){
		Dir result = new Dir();
//		if(startfile.isDirectory()){
//			result.dir.add(startfile);
//		}
//		else
//			result.file.add(startfile);
		for(File filetemp:startfile.listFiles()){
			if(filetemp.isDirectory()){
				result.dir.add(filetemp);
				result.addAll(recurseDir(filetemp,regex));
			}
			else{
				result.file.add(filetemp);
			}
		}
		return result;
		
	}
	public String toString(){
		String result="";
		for(int i=0;i<dir.size();i++){
			result+="\n dir:"+dir.get(i).getName();
		}
		for(int i=0;i<file.size();i++){
			result+="\n file:"+file.get(i).getName();
		}
		return result;
	}
}
