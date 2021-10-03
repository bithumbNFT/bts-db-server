package com.bts.db.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Getter @Setter
@NoArgsConstructor
@DynamicInsert
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "social")
    private String social;

    @Column(nullable = true)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "coin_wallet",nullable = true)
    private String coinWallet;

//    @OneToMany(mappedBy = "owner")
//    private List<NFT> NFT = new ArrayList<>();
    @OneToMany(mappedBy = "userId")
    @Cascade(value = { CascadeType.ALL })
    @JsonIgnore
    private List<NFT> NFT = new ArrayList<NFT>();


    @Builder
    public User(String name, String social, String email, String picture, Role role) {
        this.name = name;
        this.social = social;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture, String social) {
        this.name = name;
        this.picture = picture;
        this.social = social;

        return this;
    }
    public User updatewallet(String coinWallet){
        this.coinWallet = coinWallet;
        return this;
    }

}
