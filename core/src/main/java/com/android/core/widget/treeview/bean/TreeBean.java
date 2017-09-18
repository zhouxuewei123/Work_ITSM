package com.android.core.widget.treeview.bean;


import com.android.core.widget.treeview.utils.annotation.TreeNodeId;
import com.android.core.widget.treeview.utils.annotation.TreeNodeLabel;
import com.android.core.widget.treeview.utils.annotation.TreeNodePid;

/**
 * @author sloop
 * @ClassName: TreeBean
 * @Description:
 * @date 2015年2月21日 上午2:45:13
 */
public class TreeBean {

    /**
     * 当前id
     */
    @TreeNodeId
    private String id;
    /**
     * 父节点id
     */
    @TreeNodePid
    private String pId;
    /**
     * 标记名称
     */
    @TreeNodeLabel
    private String lable;

    public TreeBean() {
    }

    public TreeBean(String id, String pId, String lable) {
        this.id = id;
        this.pId = pId;
        this.lable = lable;
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

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }


}
