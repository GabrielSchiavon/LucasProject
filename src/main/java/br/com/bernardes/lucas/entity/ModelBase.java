package br.com.bernardes.lucas.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ModelBase {

    @Id
    private String id;

    public ModelBase() {
        this.id = generateID();
    }

    private String generateID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
