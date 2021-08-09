package com.josthin.login;

public class Usuario {
    int Id;
    String Email, Password;

    public Usuario() {
    }

    public Usuario(String email, String password) {
        Email = email;
        Password = password;
    }

    public boolean isNull(){
        if(Email.equals("") && Password.equals("")){
            return false;
        } else {
            return true;
        }
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
