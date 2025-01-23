package com.CryptoPage.CryptoPage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "USERS")
public class Users {

    @Id
    @Column(name = "ID")
    private int userID;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "USERPASSWORD")
    private String userPassword;

}
