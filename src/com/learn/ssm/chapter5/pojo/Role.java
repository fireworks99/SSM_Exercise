package com.learn.ssm.chapter5.pojo;

public class Role {
    private Long id;
    private String roleName;
    private String note;

    //如果你没有写任何构造函数，Java 会自动生成一个无参构造函数。
    //public Role(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", roleName=" + roleName + ", note=" + note + '}';
    }
}
