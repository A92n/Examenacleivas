/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wssoftware.appacleivas.controllers;



import com.wssoftware.appacleivas.models.Person;
import com.wssoftware.appacleivas.views.ContactFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Amy Leiva
 */
public class PersonController extends KeyAdapter implements ActionListener{
ContactFrame personFrame;

JFileChooser d;
Person person;



    public PersonController(ContactFrame f) {
        super();
        personFrame=f;
        d=new JFileChooser();
        person=new Person();
       
    }

    

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person b) {
       person = b;
    }
  public void setPerson(String filePath) {
      File f = new File(filePath);
    readPerson(f);
    }
  
@Override
  public void actionPerformed(ActionEvent e){
 
     
switch(e.getActionCommand()){
        case "save":
            save();
            break;
        case "select":
            select();

            break;
        case"clear":
            personFrame.clear();
            break;


    }

  
  } 
  
 
    private void save() {
        d.showSaveDialog(personFrame);
        if(d.getSelectedFile() !=null){
       person = personFrame.getPersonData();
       writePerson(d.getSelectedFile(),personFrame.getPersonData());
      }
    }

 
       
    private void select() {
        d.showOpenDialog(personFrame);
             person =readPerson(d.getSelectedFile());
              personFrame.setPersonData(person);
    }
  
  
  
             
private void writePerson(File file,Person person){
            
    try {
       ObjectOutputStream w = new ObjectOutputStream(new FileOutputStream(file));
    w.writeObject(person);
     w.flush();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
    }

        
    catch (IOException ex) {
        Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
    }

       
}


private Person readPerson(File file){
           person=null;


    try {
       ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
  person = (Person) ois.readObject();
    } catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(personFrame, e.getMessage(),personFrame.getTitle(),JOptionPane.WARNING_MESSAGE);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }


return person;
}
 





   
    
    
@Override
 public void keyTyped(KeyEvent event) {
     JTextField input =(JTextField)event.getSource();
       
        switch (input.getName()) {
             case "Name":
                char e=event.getKeyChar();
                if (Character.isDigit(e)) {
                    event.consume();
                }
                break;
             case "lastName":
                char a=event.getKeyChar();
                if (Character.isDigit(a)) {
                    event.consume();
                }
                break;
                
            case "numero":
                char c= event.getKeyChar();
        if(Character.isLetter(c)){
                event.consume();
        }
             
                    break;
           
        }
    }
  

  
  
}
