package com.bucur.queries.native_sql;

import javax.persistence.*;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "findTradersByNameNativeSQL",
                query = "SELECT * FROM trader t where t.name = :name",
                resultClass = Trader.class)})
@Entity(name = "Trader")
@Table(name = "trader")
public class Trader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Trader() {
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

    @Override
    public String toString() {
        return "Trader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
