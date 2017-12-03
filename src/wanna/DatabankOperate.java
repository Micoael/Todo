package wanna;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

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
	public static void addANewLineOnTheConfig(String wanna) throws IOException {
		FileWriter fw = new FileWriter(config);
		BufferedWriter bw = new BufferedWriter(fw);
		Reader fr= new FileReader(config);
		BufferedReader br = new BufferedReader(fr);
		String inside="1";
		System.out.println(inside);
		while((inside=br.readLine()) != null){
			System.out.println(inside);
		}
		if(inside.equals(null)){
			bw.write(wanna);
			bw.newLine();
			System.out.println("Done.You wrote ''"+wanna+"''");
			bw.close();
		}else{
			bw.write(inside);
			bw.newLine();
			bw.write(wanna);
			bw.newLine();
			System.out.println("Done.You wrote ''"+wanna+"''");
			bw.close();
		}
	}
	public static void removeALineOnTheConfig(int lineIndex) {
		//IO code write urself.
	}
	public static void changeALineOnTheConfig(int lineIndex,String wr1,String wr2) {
		//IO code write urself.
	}
	public static void main(String[] args) throws IOException {
		checkSecuirty();
		addANewLineOnTheConfig("Go die2");
	}

}