package com.app.entity;

import org.hibernate.Hibernate;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jadira.usertype.dateandtime.joda.PersistentDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Common ancestor for entities in system
 */
@TypeDefs({ @TypeDef(name = "jodaDateTime", typeClass = PersistentDateTime.class) })
@MappedSuperclass
public abstract class AbstractEntity {
    public static final String ID_PROPERTY = "id";

    /**
     * Unique identifier
     */
    private Long id;

    /**
     * Metod deleguje na potomky vraceni jejich idcka pro potreby metod equals, hashcode a toString
     * 
     * @return id
     */
    @Transient
    public Long getId() {
        return id;
    }

    /**
     * Metoda nastavuje id objektu.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Implmenentace hascode pracujicich na idckach. V pripade potreby lze prekryt klasickym zpusobem v potomku tridy AbstractEntity.
     * 
     * @return hash
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    /**
     * Implementace metody equals porovnavajici idcka . V pripade potreby lze prekryt klasickym zpusobem v potomku tridy AbstractEntity.
     * 
     * @param Object : porovnavany objekt
     * @return true nebo false podla toho ci plati rovnost
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!Hibernate.getClass(this).equals(Hibernate.getClass(obj))) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity)obj;
        if (getId() == null) {
            if (other.getId() != null) {
                return false;
            } else {
                return super.equals(obj);
            }
        } else if (!getId().equals(other.getId())) {
            return false;
        }

        return true;
    }
}
