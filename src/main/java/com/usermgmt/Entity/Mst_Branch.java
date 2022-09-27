package com.usermgmt.Entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_branch")
public class Mst_Branch {
    @Id
    @Column(name = "branch_id")
    private String id;
    @Column(name = "branch_name")
    private String name;
    @Column(name = "branch_type")
    private String type;
    @Column(name = "branch_address")
    private String address;
    @Type(type = "org.hibernate.type.BooleanType")
    @Column(name = "flag_active")
    private short flag_active;
    @Column(name = "created_by")
    private String created_by;
    @Column(name = "update_by")
    private String update_by;

    Mst_Branch(){}

    public Mst_Branch(String id, String name, String type, String address, short flag_active, String created_by, String update_by) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.address = address;
        this.flag_active = flag_active;
        this.created_by = created_by;
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

    public short isFlag_active() {
        return flag_active;
    }

    public void setFlag_active(short flag_active) {
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

    @Override
    public String toString() {
        return "Mst_Branch{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", flag_active=" + flag_active +
                ", created_by='" + created_by + '\'' +
                ", update_by='" + update_by + '\'' +
                '}';
    }
}