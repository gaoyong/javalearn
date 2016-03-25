package edu.tsinghua.gaoyong.watcher;

public class ObserverDemo {     
    public static void main(String[] args) {     
        BeingWatched beingWatched = new BeingWatched();//受查者     
        Watcher watcher1 = new Watcher();//观察者
        Watcher2 watcher2 = new Watcher2();//观察者
        beingWatched.addObserver(watcher1);   
        beingWatched.addObserver(watcher2);     
        
        beingWatched.counter(10);     
    }     
} 
