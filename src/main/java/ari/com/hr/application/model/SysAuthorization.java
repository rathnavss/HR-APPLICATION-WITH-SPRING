/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.com.hr.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ari-prasetiyo
 */
@Entity
@Table(name = "sys_authorization")
public class SysAuthorization extends ModelSerializable {

    @Column(name = "pattern_dispatcher_url", length = 100, nullable = true)
    private String patternDispatcherUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private SysRoles sysRoles;

    @Column(name = "name_menu")
    private String nameMenu;

    private boolean isUpdate;

    private boolean isDelete;

    private boolean isInsert;

    private boolean isRead;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = true)
    private SysAuthorization parent;

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public boolean isIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(boolean isUpdate) {
        this.isUpdate = isUpdate;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public boolean isIsInsert() {
        return isInsert;
    }

    public void setIsInsert(boolean isInsert) {
        this.isInsert = isInsert;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public SysAuthorization getParent() {
        return parent;
    }

    public void setParent(SysAuthorization parent) {
        this.parent = parent;
    }

    public SysRoles getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(SysRoles sysRoles) {
        this.sysRoles = sysRoles;
    }

    public void setSysRoles(long id) {
        SysRoles byId = new SysRoles();
        byId.setId(id);
        this.sysRoles = byId;
    }

    public String getPatternDispatcherUrl() {
        return patternDispatcherUrl;
    }

    public void setPatternDispatcherUrl(String patternDispatcherUrl) {
        this.patternDispatcherUrl = patternDispatcherUrl;
    }

}
