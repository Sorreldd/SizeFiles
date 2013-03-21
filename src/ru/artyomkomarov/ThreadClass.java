package ru.artyomkomarov;

import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadClass implements Runnable{
	static AtomicLong res = new AtomicLong(0);
	String path;
	boolean flag = false;
	File root;
	File[] files;
	public ThreadClass(String path, boolean flag) {
		this.path = path;
		this.flag = flag;
		this.root = new File(this.path);
		files = root.listFiles();
	}
	@Override
	public void run() {
		Thread[] th;
		int countTh = 0, indx = 0;
		for(int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()) {
				countTh++;
			} else {
				res.getAndAdd(files[i].length());
			}
		}
		th = new Thread[countTh];
		for(int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()) {
				th[indx] = new Thread(new ThreadClass(files[i].getPath(), flag));
				th[indx].start();
				indx++;
			}
		}
		for(int i = 0; i < countTh; i++) {
			try {
				th[i].join();
			} catch (Exception e) {}			
		}
	}
}
