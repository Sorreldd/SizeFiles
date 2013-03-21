package ru.artyomkomarov;

public class MainApp {
	long ans = 0;
    public static void main(String[] args) {
    	args = new String[1];
    	args[0] = "C:\\Users\\1\\Desktop\\Фотографии";
        ThreadClass th = new ThreadClass(args[0], true);
        Thread newTh = new Thread(th);
        newTh.start();
        try {
        	newTh.join();
        } catch (Exception e) {
			System.out.println("BAD");
		}
        System.out.println(th.res);
    }


}
