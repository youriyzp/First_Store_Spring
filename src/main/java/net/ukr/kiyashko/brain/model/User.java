package net.ukr.kiyashko.brain.model;

import net.ukr.kiyashko.brain.model.enums.RoleEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity // аннотация помечающая класс как персистентную сущность
@Table(name = "users", schema = "Store") // укзание что данный класс соответствует таблице в БД
public class User {

    @Id // указание что это поле являеться ключем
    // Описание последовательности для генерации ID
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Store.users_id_seq")
    @SequenceGenerator(name = "Store.users_id_seq", sequenceName = "Store.users_id_seq", allocationSize = 1)
    @Column // аннотация помечающая поле как колонку в таблице БД, название должно соответствовать
    private Long id;

    @Column(nullable = false) // установка запрета на сохранение null значений
    private String email;

    @Column
    private String password;

    // Можно указать другое название, если явно указать имя колонки в параметре name
    // Или можно назвать переменную, заменив разделители на camelCase ( createAt )
    @Column(name = "created_at")
    private Date creationDate;

    @Column
    private String address;

    @Column(name = "user_name", nullable = false)
    private String user_name;

    @Column(name = "user_first_name")
    private String user_first_name;

    @Column(name = "telephon")
    private int telephon;

    @Column(name = "password_hash")
    private String password_hash;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    /*@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> order;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
