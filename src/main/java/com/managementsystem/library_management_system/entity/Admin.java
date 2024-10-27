package com.managementsystem.library_management_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id", length = 11)
    private int adminid;

    @Column(name = "name", length = 50)
    private String name;


    public Admin(int adminid, String name) {
        this.adminid = adminid;
        this.name = name;
    }

    public Admin(String name) {
        this.name = name;
    }

    public Admin() {}

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminid=" + adminid +
                ", name='" + name + '\'' +
                '}';
    }
}
