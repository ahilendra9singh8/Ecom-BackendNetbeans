/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apogee.EntityModel;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author lENOVO
 */
@Entity
@Table(name = "user_info")
@Getter
@Setter
//@AllArgsConstructor
//@FieldNameConstants
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;

    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)  
    public String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;
    private String about;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false, length = 10)
    private String phone;
    @Column(name = "CreaeAt")
    private Date date;
    private boolean active;
    @OneToOne(mappedBy = "user")
    private Cart cart;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Roles> role = new HashSet<>();

    //jab role ki jarurat padegi is ko call krke roll le lege
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> collect = this.role.stream().map((r) -> new SimpleGrantedAuthority(r.getRoleName())).collect(Collectors.toList());
        return collect;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//    public User() {
//        super();
//    }
//
//    public User(int userId, String name, String email, String password, String address, String about, String gender, String phone, Date date) {
//        super();
//        this.userId = userId;
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.address = address;
//        this.about = about;
//        this.gender = gender;
//        this.phone = phone;
//        this.date = date;
//    }
//
//    /**
//     * @return the userId
//     */
//    public int getUserId() {
//        return userId;
//    }
//
//    /**
//     * @param userId the userId to set
//     */
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    /**
//     * @return the name
//     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * @param name the name to set
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    /**
//     * @return the email
//     */
//    public String getEmail() {
//        return email;
//    }
//
//    /**
//     * @param email the email to set
//     */
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    /**
//     * @return the password
//     */
//    public String getPassword() {
//        return password;
//    }
//
//    /**
//     * @param password the password to set
//     */
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    /**
//     * @return the address
//     */
//    public String getAddress() {
//        return address;
//    }
//
//    /**
//     * @param address the address to set
//     */
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    /**
//     * @return the about
//     */
//    public String getAbout() {
//        return about;
//    }
//
//    /**
//     * @param about the about to set
//     */
//    public void setAbout(String about) {
//        this.about = about;
//    }
//
//    /**
//     * @return the gender
//     */
//    public String getGender() {
//        return gender;
//    }
//
//    /**
//     * @param gender the gender to set
//     */
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    /**
//     * @return the phone
//     */
//    public String getPhone() {
//        return phone;
//    }
//
//    /**
//     * @param phone the phone to set
//     */
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    /**
//     * @return the date
//     */
//    public Date getDate() {
//        return date;
//    }
//
//    /**
//     * @param date the date to set
//     */
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    /**
//     * @return the active
//     */
//    public String getActive() {
//        return active;
//    }
//
//    /**
//     * @param active the active to set
//     */
//    public void setActive(String active) {
//        this.active = active;
//    }
}
