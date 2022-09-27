package com.usermgmt.Dto;

import javax.persistence.Column;

public class Mst_BranchInsertDTO {
    private String id;
    private String name;
    private String type;
    private String address;
    private boolean flag_active;
    private String created_by;
    private String update_by;

    public Mst_BranchInsertDTO(){}

    public Mst_BranchInsertDTO(String id, String name, String type, String address, boolean flag_active, String created_by, String update_by) {
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
}
