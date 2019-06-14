package com.mic.fleetmanagement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TourPackage implements Serializable {
    @Id
    private String code;

    @Column
    private String name;

    public TourPackage(String code, String name) {
        this.code = code;
        this.name = name;
    }

    protected TourPackage() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TourPackage{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        else
            return false;
    }
}
