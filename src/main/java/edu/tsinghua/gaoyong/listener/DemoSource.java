package edu.tsinghua.gaoyong.listener;

import java.util.ArrayList;
import java.util.List;

public class DemoSource {     
    private List<DemoListener> listenerList = new ArrayList<DemoListener>();//监听自己的监听器队列  
    
    public DemoSource(){}     
    
    public void addDemoListener(DemoListener dl) {     
    	listenerList.add(dl); 
    }     
    
    public void notifyDemoEvent() {//通知所有的监听器     
           
           for(DemoListener dl:listenerList) {     
                 dl.handleEvent(new DemoEvent(this));     
           }     
    }     
}    
