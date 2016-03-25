package edu.tsinghua.gaoyong.watcher;

public class Watcher2 implements java.util.Observer {
	public void update(java.util.Observable obj, Object arg) {
		System.out.println("更新接口被调用, count is " + ((Integer) arg).intValue());
	}
}
