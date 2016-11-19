package edu.tsinghua.gaoyong.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现二分查找的算法
 * @author gaoyong
 *
 */
public class BinarySearch {
	
	/**
	 * 提供二分查找的算法实现
	 * @param list  输入的有序值
	 * @param value 待查找值
	 * @return 待查找值在list的index值
	 */
	public static final int binarySearch(List<Integer> list, int value ){
		if (list == null || list.size() ==0){
			return -1;
		}
		
		int min = 0;
		int max = list.size() -1 ;
		int k = 0;
		while(min <= max){
			k = (min + max)/2;
			if(list.get(k) == value){
				return k;
			}
			
			if(list.get(k) < value){
				min = k+1;
			}
			
			if(list.get(k) > value){
				max = k-1;
			}
			
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(4);
		list.add(6);
		list.add(8);
		list.add(33);
		list.add(66);
		list.add(88);
		list.add(89);
		list.add(100);
		list.add(150);
		list.add(250);
		
		int value = 3;
		int result = binarySearch(list,value);
		System.out.println("binarySearch result:" + result);
		if (result != -1){
			System.out.println("" + list.get(result) + "==" + value);
		}else{
			System.out.println("no result found ,please check the value");
		}
		
		
	}

}
