package ru.artyomkomarov;

import java.io.File;

public class MainApp {
	static long ans = 0;
	public static void calculSize(String path) {
		File f = new File(path);
		File[] files = f.listFiles();
		for(int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()) {
				calculSize(files[i].getPath());
			} else { 
				ans += files[i].length();
			}
		}
	}
    public static void main(String[] args) {
    	/*args = new String[2];
    	args[0] = "C:\\Users\\1\\Desktop\\AlReader2.win32.ru";
    	args[1] = "false";*/
    	String name = "";
    	String mark = "false";
    	for(int i = 0; i < args.length - 1; i++) {
    		if(i == 0)name = args[i];
    		else name = name + " " + args[i]; 
    	}
    	mark = args[args.length - 1];
    	if(mark.equals("true")) {
    		ThreadClass th = new ThreadClass(args[0]);
    		Thread newTh = new Thread(th);
    		newTh.start();
    		try {
    			newTh.join();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		System.out.println(th.res);
    	} else {
    		calculSize(name);
    		System.out.println(ans);
    	}
    }
}
