/**
 * @Title: Node.java
 * @Package com.sloop.treeview.utils
 * @Description:
 * Copyright: Copyright (c) 2015
 * 
 * @author sloop
 * @date 2015年2月21日 上午3:40:42
 * @version V1.0
 */

package com.android.core.widget.treeview.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形结构的节点
 * 
 * @ClassName: Node
 * @author sloop
 * @date 2015年2月21日 上午3:42:26
 */

public class OtherNode {

	/**
	 * 节点id
	 */
	private String id;
	/**
	 * 父节点id
	 */
	private String pId;
	/**
	 * 是否展开
	 */
	private boolean isExpand = false;
	private boolean isChecked = false;//是否选中
	private boolean isHideChecked = true;//CheckBox是否隐藏
	/**
	 * 节点名字
	 */
	private String name;
	/**
	 * 节点级别
	 */
	private int level;
	/**
	 * 节点展示图标
	 */
	private int icon;
	/**
	 * 节点所含的子节点
	 */
	private List<OtherNode> childrenNodes = new ArrayList<OtherNode>();
	/**
	 * 节点的父节点
	 */
	private OtherNode parent;

	public OtherNode() {
	}

	public OtherNode(String id, String pId, String name) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public boolean isExpand() {
		return isExpand;
	}

	/**
	 * 当父节点收起，其子节点也收起
	 * @param isExpand
	 */
	public void setExpand(boolean isExpand) {
		this.isExpand = isExpand;
		if (!isExpand) {

			for (OtherNode node : childrenNodes) {
				node.setExpand(isExpand);
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return parent == null ? 0 : parent.getLevel() + 1;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public List<OtherNode> getChildrenNodes() {
		return childrenNodes;
	}

	public void setChildrenNodes(List<OtherNode> childrenNodes) {
		this.childrenNodes = childrenNodes;
	}

	public OtherNode getParent() {
		return parent;
	}

	public void setParent(OtherNode parent) {
		this.parent = parent;
	}

	/**
	 * 判断是否是根节点
	 *
	 * @return
	 */
	public boolean isRoot() {
		return parent == null;
	}

	/**
	 * 判断是否是叶子节点
	 *
	 * @return
	 */
	public boolean isLeaf() {
		return childrenNodes.size() == 0;
	}


	/**
	 * 判断父节点是否展开
	 *
	 * @return
	 */
	public boolean isParentExpand()
	{
		if (parent == null)
			return false;
		return parent.isExpand();
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public boolean isHideChecked() {
		return isHideChecked;
	}

	public void setHideChecked(boolean isHideChecked) {
		this.isHideChecked = isHideChecked;
	}
}
