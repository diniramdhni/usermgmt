package com.usermgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "mst_branch")
public class MstBranch {
    @Id
    @Column(name = "branch_id")
    private String id;
    @Column(name = "branch_name")
    private String name;
    @Column(name = "branch_type")
    private String type;
    @Column(name = "branch_address")
    private String address;
    @Column(name = "flag_active")
    private boolean flag_active;
    @Column(name = "created_date")
    private LocalDateTime created_date;
    @Column(name = "created_by")
    private String created_by;
    @Column(name = "updated_date")
    private LocalDateTime update_date;
    @Column(name = "updated_by")
    private String update_by;

    public MstBranch(){}


    public MstBranch(String id, String name, String type, String address, boolean flag_active, LocalDateTime created_date, String created_by, LocalDateTime updated_date, String update_by) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.address = address;
        this.flag_active = flag_active;
        this.created_date = created_date;
        this.created_by = created_by;
        this.update_date = updated_date;
        this.update_by = update_by;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFlag_active() {
        return flag_active;
    }

    public void setFlag_active(boolean flag_active) {
        this.flag_active = flag_active;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDateTime update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "Mst_Branch{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", flag_active=" + flag_active +
                ", created_date=" + created_date +
                ", created_by='" + created_by + '\'' +
                ", update_date=" + update_date +
                ", update_by='" + update_by + '\'' +
                '}';
    }
}
