package com.example.Thesis.Models;

public interface EmailSender {
    //this interface is implemented to use this method in different forms
    void send(String to, String email);
}
