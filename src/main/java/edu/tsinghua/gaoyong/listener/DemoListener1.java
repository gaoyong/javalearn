package edu.tsinghua.gaoyong.listener;

public class DemoListener1 implements DemoListener {     
    public void handleEvent(DemoEvent de) {     
           System.out.println("Inside listener1...");     
           de.say();//回调     
    }     
}  
