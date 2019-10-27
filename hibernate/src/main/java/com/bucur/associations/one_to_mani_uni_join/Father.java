package com.bucur.associations.one_to_mani_uni_join;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Father")
@Table(name = "father")
public class Father {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "father_id")
    private List<Son> sons = new ArrayList<>();

    public Father() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Son> getSons() {
        return sons;
    }

    public void setSons(List<Son> sons) {
        this.sons = sons;
    }
}
