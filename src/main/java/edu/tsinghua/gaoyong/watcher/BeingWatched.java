package edu.tsinghua.gaoyong.watcher;

public class BeingWatched extends java.util.Observable {     
	public String hello = "hello";
	
    void counter(int period) {     
        for(; period>=0; period-- ) {     
                setChanged();     
                notifyObservers(new Integer(period));     
                try {     
                        Thread.sleep(100);     
                } catch( InterruptedException e) {     
                  System.out.println("Sleep interrupeted" );     
                }     
        }     
}     
}
