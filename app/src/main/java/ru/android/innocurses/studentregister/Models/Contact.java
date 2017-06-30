package ru.android.innocurses.studentregister.Models;

import java.io.Serializable;

/**
 * Created by Alexey Balakin on 08.06.2017.
 */
public class Contact implements Serializable{
    private String value;
    private ContactType type;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public Contact(String value, ContactType type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public int hashCode() {
        return (21 + value.hashCode()*42) + (21 + type.hashCode()*42);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return  false;
        if (!(obj instanceof  Contact)) return false;
        if (this.value!= ((Contact) obj).getValue()) return false;
        if (this.type!= ((Contact) obj).getType()) return false;
        return true;
    }
}
