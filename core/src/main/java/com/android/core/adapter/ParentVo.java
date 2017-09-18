package com.android.core.adapter;

import java.util.List;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/11/1 14:34
 */
public class ParentVo<E> {
	
	private List<E> children;

	public List<E> getChildren() {
		return children;
	}

	public void setChildren(List<E> child) {
		this.children = child;
	}
	
	public void addChildren(E e){
		children.add(e);
	}
	
	public void addChildren(List<E> childs){
		children.addAll(childs);
	}
	public void addChildren(int position,E e){
		children.add(position, e);
	}
	
	public void addChildren(int position,List<E> childs){
		children.addAll(position,childs);
	}
}
