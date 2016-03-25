package edu.tsinghua.gaoyong.watcher;

public class Watcher implements java.util.Observer {
	public void update(java.util.Observable obj, Object arg) {
		System.out.print("Update() called, count is " + ((Integer) arg).intValue());
		int obsNum = obj.countObservers();
		System.out.println("\tobsNum="+obsNum);
	}
}
