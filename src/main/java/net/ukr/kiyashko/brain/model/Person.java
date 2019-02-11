package net.ukr.kiyashko.brain.model;

import net.ukr.kiyashko.brain.model.enums.RoleEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

   // private OrderEntity order;

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String user_name;

    @Column(name = "user_first_name")
    private String user_first_name;

    @Column(name = "telephon")
    private int telephon;

    @Column(name = "email")
    private String email;

    @Column(name = "last_login")
    private Date last_login;

    @Column(name = "adress_sity")
    private String adress_sity;

    @Column(name = "login")
    private String login;

    @Column(name = "password_hash")
    private String password_hash;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> order;


    public Person(long id, String user_name, String user_first_name, int telephon, String email, Date last_login, String adress_sity,  String login, String password_hash,RoleEnum role) {
        this.id = id;
        this.user_name = user_name;
        this.user_first_name = user_first_name;
        this.telephon = telephon;
        this.email = email;
        this.last_login = last_login;
        this.adress_sity = adress_sity;
        this.login = login;
        this.password_hash = password_hash;
        this.role = role;
    }
    public Person(){
            }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public int getTelephon() {
        return telephon;
    }

    public void setTelephon(int telephon) {
        this.telephon = telephon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getAdress_sity() {
        return adress_sity;
    }

    public void setAdress_sity(String adress_sity) {
        this.adress_sity = adress_sity;
    }

        public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
    public RoleEnum getRole() {
        return role;
    }

}
