package com.ite.smvcDemo.common.page;

public class SystemContext {
	
	//ThreadLocal是Java中一种较为特殊的线程绑定机制，是每一个线程都可以独立地改变自己的副本，而不会和其它线程的副本冲突。
	private static ThreadLocal<Integer> offset = new ThreadLocal<Integer>();
	
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();

	public static Integer getOffset() {
		return offset.get();
	}

	public static void setOffset(Integer _offset) {
		offset.set(_offset);
	}
	
	public static void removeOffset() {
		offset.remove();;
	}

	public static Integer getPageSize() {
		return pageSize.get();
	}

	public static void setPageSize(Integer _pageSize) {
		pageSize.set(_pageSize);
	}
	
	public static void removePageSize() {
		pageSize.remove();
	}
	
	
}
