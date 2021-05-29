/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wssoftware.appacleivas.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Amy Leiva
 */
public class Person implements Serializable{
private int personId;
private String Name;
private String lastName;
private Email []email;
private Address []direccion;
private  Phone []phones;

//private ArrayList<Telefono> tel;
//private String [] tipo;

//private String telefono;
//private String tipo;

    public Email[] getEmail() {
        return email;
    }

    public void setEmail(Email[] email) {
        this.email = email;
    }

    public Address[] getDireccion() {
        return direccion;
    }

    public void setDireccion(Address[] direccion) {
        this.direccion = direccion;
    }

    public Phone[] getPhones() {
        return phones;
    }

    public void setPhones(Phone[] phones) {
        this.phones = phones;
    }


  /*  public ArrayList<Telefono> getTel() {
        return tel;
    }

    public void setTel(ArrayList<Telefono> tel) {
        this.tel = tel;
    }*/

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   
  

    
}
