package com.bucur.queries.hql;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "findStocksByStockCode",
                query = "FROM Stock s WHERE s.stockCode = :stockCode")
})
@Entity(name = "Stock")
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "stock_code")
    private String stockCode;

    public Stock() {
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

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stockCode='" + stockCode + '\'' +
                '}';
    }
}
