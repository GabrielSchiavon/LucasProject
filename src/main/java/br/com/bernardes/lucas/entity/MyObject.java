package br.com.bernardes.lucas.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "my_object")
@Table(name = "my_object")
public class MyObject extends ModelBase{

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "description")
    private String description;

    public MyObject() {
        super();
    }

    public MyObject(String name, Date date, String description) {
        super();
        this.name = name;
        this.date = date;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
