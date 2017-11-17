package wanna;

import java.io.File;
import java.io.IOException;

public class DatabankOperate {
	static String rootdirs="C:/Todo";
	static String flcon="C:/Todo/nowthings.cfg";
	static File rootdir = new File(rootdirs);
	static File config=new File(flcon);
	public File destFile=new File("C:/Todo/nowthings.cfg");
	public static void checkSecuirty() throws IOException {
		if(!rootdir.exists())
			rootdir.mkdirs();
		if(!config.exists()) 
			config.createNewFile();
		System.out.println("Security inited successfully.");
	}
	public static void addANewLineOnTheConfig(String wanna) {
		//IO code write urself.
	}
	public static void removeALineOnTheConfig(int lineIndex) {
		//IO code write urself.
	}
	public static void changeALineOnTheConfig(int lineIndex,String wr1,String wr2) {
		//IO code write urself.
	}
	public static void main(String[] args) throws IOException {
		checkSecuirty();
	}

}
