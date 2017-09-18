/**
 * @Title: TreeHelper.java
 * @Package com.sloop.treeview.utils
 * @Description: TODO
 * Copyright: Copyright (c) 2015
 * @author sloop
 * @date 2015年2月21日 上午3:19:27
 * @version V1.0
 */

package com.android.core.widget.treeview.utils;

import com.android.core.R;
import com.android.core.utils.Utils;
import com.android.core.widget.treeview.utils.annotation.TreeNodeId;
import com.android.core.widget.treeview.utils.annotation.TreeNodeLabel;
import com.android.core.widget.treeview.utils.annotation.TreeNodePid;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 树形结构的帮助类 将元数据转换为节点
 *
 * @author sloop
 * @ClassName: TreeHelper
 * @Description:
 * @date 2015年2月21日 上午3:19:27
 */

public class TreeHelperOther {
    /**
     * 根据所有节点获取可见节点
     *
     * @param allNodes
     * @return
     */
    public static List<OtherNode> filterVisibleNode(List<OtherNode> allNodes) {
        List<OtherNode> visibleNodes = new ArrayList<OtherNode>();
        for (OtherNode node : allNodes) {
            // 如果为根节点，或者上层目录为展开状态
            if (node.isRoot() || node.isParentExpand()) {
                setNodeIcon(node);
                visibleNodes.add(node);
            }
        }
        return visibleNodes;
    }

    /**
     * 获取排序的所有节点
     *
     * @param datas
     * @param defaultExpandLevel
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static <T> List<OtherNode> getSortedNodes(List<T> datas,
                                                     int defaultExpandLevel, boolean isHide)
            throws IllegalAccessException, IllegalArgumentException {
        List<OtherNode> sortedNodes = new ArrayList<OtherNode>();
        // 将用户数据转化为List<Node>
        List<OtherNode> nodes = convertData2Nodes(datas, isHide);
        // 拿到根节点
        List<OtherNode> rootNodes = getRootNodes(nodes);
        // 排序以及设置Node间关系
        for (OtherNode node : rootNodes) {
            addNode(sortedNodes, node, defaultExpandLevel, 1);
        }
        return sortedNodes;
    }

    /**
     * 把一个节点上的所有的内容都挂上去
     */
    private static void addNode(List<OtherNode> nodes, OtherNode node,
                                int defaultExpandLeval, int currentLevel) {

        nodes.add(node);
        if (defaultExpandLeval >= currentLevel) {
            node.setExpand(true);
        }

        if (node.isLeaf())
            return;
        for (int i = 0; i < node.getChildrenNodes().size(); i++) {
            addNode(nodes, node.getChildrenNodes().get(i), defaultExpandLeval,
                    currentLevel + 1);
        }
    }

    /**
     * 获取所有的根节点
     *
     * @param nodes
     * @return
     */
    public static List<OtherNode> getRootNodes(List<OtherNode> nodes) {
        List<OtherNode> rootNodes = new ArrayList<OtherNode>();
        for (OtherNode node : nodes) {
            if (node.isRoot()) {
                rootNodes.add(node);
            }
        }

        return rootNodes;
    }

    /**
     * 将泛型datas转换为node
     *
     * @param datas
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static <T> List<OtherNode> convertData2Nodes(List<T> datas, boolean isHide)
            throws IllegalAccessException, IllegalArgumentException {
        List<OtherNode> nodes = new ArrayList<OtherNode>();
        OtherNode node = null;
        for (T t : datas) {        //循环遍历所有数据
            String id = "-1";
            String pId = "-1";
            String label = null;

            Class clazz = t.getClass();    //使用反射+注解获取属性和方法

            //遍历所有字段(属性)并根据注解判断方法
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.getAnnotation(TreeNodeId.class) != null) {
                    //扩展-通过用户指定类型来强制转换到该类型
            /*		TreeNodeId annotation = field.getAnnotation(TreeNodeId.class);
                    Class type = annotation.type();
					if (type==String.class) {
						//强转为String
					}else if (type == Integer.class) {
						//强转为int
					}*/

                    field.setAccessible(true);    //设置访问权限 强制更改为可以访问
                    id = (String) field.get(t);
                }
                if (field.getAnnotation(TreeNodePid.class) != null) {
                    field.setAccessible(true);
                    pId = (String) field.get(t);
                    if (Utils.isEmpty(pId)) {
                        pId = "-1";
                    }
                }
                if (field.getAnnotation(TreeNodeLabel.class) != null) {
                    field.setAccessible(true);
                    label = (String) field.get(t);
                }
            }
            node = new OtherNode(id, pId, label);
            node.setHideChecked(isHide);
            nodes.add(node);
        }
        //为node设置关联关系
	/*	for (Node n : nodes){
			for (Node m : nodes) {
				if (m.getpId() == n.getId()) {			//m是n的子节点
					n.getChildren().add(m);
					m.setParent(n);
				}else if (m.getId() == n.getpId()) {	//m是n的父节点
					m.getChildren().add(n);
					n.setParent(m);
				}
			}
		}*/
        for (int i = 0; i < nodes.size(); i++) {
            OtherNode n = nodes.get(i);
            for (int j = i + 1; j < nodes.size(); j++) {
                OtherNode m = nodes.get(j);
                if (m.getpId().equals(n.getId())) {            //m是n的子节点
                    n.getChildrenNodes().add(m);
                    m.setParent(n);
                } else if (m.getId().equals(n.getpId())) {    //m是n的父节点
                    m.getChildrenNodes().add(n);
                    n.setParent(m);
                }
            }
        }

        for (OtherNode n : nodes) {
            setNodeIcon(n);
        }

        return nodes;
    }

    /**
     * 设置打开，关闭icon
     *
     * @param node
     */
    public static void setNodeIcon(OtherNode node) {
        if (node.getChildrenNodes().size() > 0 && node.isExpand()) {
            node.setIcon(R.drawable.item_open);
        } else if (node.getChildrenNodes().size() > 0 && !node.isExpand()) {
            node.setIcon(R.drawable.item_close);
        } else
            node.setIcon(-1);
    }

    public static void setNodeChecked(OtherNode node, boolean isChecked, boolean isClick) {
        // 自己设置是否选择
        node.setChecked(isChecked);
        /**
         * 非叶子节点,子节点处理
         */
        setChildrenNodeChecked(node, isChecked, isClick);
        /** 父节点处理 */
        setParentNodeChecked(node, isClick);

    }

    public static boolean isfirst = true;

    /**
     * 非叶子节点,子节点处理
     */
    private static void setChildrenNodeChecked(OtherNode node, boolean isChecked, boolean isClick) {
        node.setChecked(isChecked);
        if (!node.isLeaf() && isClick) {
            for (OtherNode n : node.getChildrenNodes()) {
                // 所有子节点设置是否选择
                setChildrenNodeChecked(n, isChecked, isClick);
            }
        }
    }

    /**
     * 设置父节点选择
     *
     * @param node
     */
    private static void setParentNodeChecked(OtherNode node, boolean isClick) {

        /** 非根节点 */
        if (!node.isRoot()&&!isClick) {
            OtherNode rootNode = node.getParent();
            boolean isAllChecked = false;
            int i = 0;
            for (OtherNode n : rootNode.getChildrenNodes()) {
                if (n.isChecked()) {
                    i++;
//                    isAllChecked = false;
//                    break;
                }
            }
            if (i == 0) {
                isAllChecked = false;
            } else {
                isAllChecked = true;
            }

            if (isAllChecked) {
                rootNode.setChecked(true);
            } else {
                rootNode.setChecked(false);
            }
            setParentNodeChecked(rootNode, isClick);
        }
    }
}
