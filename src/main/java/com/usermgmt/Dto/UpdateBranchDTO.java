package com.usermgmt.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateBranchDTO {

    @NotBlank(message="Id is required.")
    private String id;

    @NotBlank(message="Branch Name is required.")
    private String name;

    @NotBlank(message="Branch Type is required.")
    private String type;

    @NotBlank(message="Branch Address is required.")
    private String address;

    @NotNull(message="Flag active is required.")
    private boolean flag_active;


    @NotBlank(message="Updated By is required.")
    private String update_by;

    public UpdateBranchDTO() {
    }

    public UpdateBranchDTO(String id, String name, String type, String address, boolean flag_active, String update_by) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.address = address;
        this.flag_active = flag_active;
        this.update_by = update_by;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFlag_active() {
        return flag_active;
    }

    public void setFlag_active(boolean flag_active) {
        this.flag_active = flag_active;
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

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    @Override
    public String toString() {
        return "UpdateBranchDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", flag_active=" + flag_active +
                ", update_by='" + update_by + '\'' +
                '}';
    }
}
