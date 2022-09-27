package com.usermgmt.Dto;

public class UpdateBranchDTO {

    private String name;
    private String type;
    private String address;
    private String created_by;
    private String update_by;

    public UpdateBranchDTO() {
    }

    public UpdateBranchDTO(String name, String type, String address, String created_by, String update_by) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.created_by = created_by;
        this.update_by = update_by;
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
        return "UpdateBranchDTO{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", created_by='" + created_by + '\'' +
                ", update_by='" + update_by + '\'' +
                '}';
    }
}
