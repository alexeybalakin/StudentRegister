package ru.android.innocurses.studentregister.Models;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexey Balakin on 08.06.2017.
 */


public class Student implements Serializable {

    private Date dateOfBirth;
    private  Long id;
    private Long groupId;
    private String firstName;
    private String surname;
    private String secondName;
    private List<Contact> contacts;


    public Student() {

    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }


    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Student(Date dateOfBirth, Long groupId, String firstName, String surname, String secondName) {
        this.dateOfBirth = dateOfBirth;
        this.groupId = groupId;
        this.firstName = firstName;
        this.surname = surname;
        this.secondName = secondName;
        this.id = System.nanoTime();
        this.contacts = new ArrayList<>();
    }
    public Student(Date dateOfBirth, Long groupId, String firstName, String surname, String secondName, List<Contact> contacts) {
        this.dateOfBirth = dateOfBirth;
        this.groupId = groupId;
        this.firstName = firstName;
        this.surname = surname;
        this.secondName = secondName;
        this.id = System.nanoTime();
        this.contacts = contacts;
    }

    @Override
    public int hashCode() {
        return (int) (21+id*42);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return  false;
        if (!(obj instanceof Student)) return false;
        if(!this.id.equals(((Student)obj).getId())) return false;
        return true;
    }

    @Override
    public String toString() {
        return  secondName+ " "+firstName+" "+surname;
    }
}
