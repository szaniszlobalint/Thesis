package com.redmine.application.myapp.entities;

public class RedProjectOriginal {

    private long id;
    private String name;
    private String identifier;
    private String description;
    private long status;
    private boolean is_public;
    private boolean inherit_members;
    private String[] custom_fields;
    private String created_on;
    private String updated_on;

    protected RedProjectOriginal() {
    }

    public RedProjectOriginal(long id, String name, String identifier, String description,
                              long status, boolean is_public, boolean inherit_members, String[] custom_fields, String created_on, String updated_on) {
        this.id = id;
        this.name = name;
        this.identifier = identifier;
        this.description = description;
        this.status = status;
        this.is_public = is_public;
        this.inherit_members = inherit_members;
        this.custom_fields = custom_fields;
        this.created_on = created_on;
        this.updated_on = updated_on;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public boolean isIs_public() {
        return is_public;
    }

    public void setIs_public(boolean is_public) {
        this.is_public = is_public;
    }

    public boolean isInherit_members() {
        return inherit_members;
    }

    public void setInherit_members(boolean inherit_members) {
        this.inherit_members = inherit_members;
    }

    public String[] getCustom_fields() {
        return custom_fields;
    }

    public void setCustom_fields(String[] custom_fields) {
        this.custom_fields = custom_fields;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(String updated_on) {
        this.updated_on = updated_on;
    }
}
