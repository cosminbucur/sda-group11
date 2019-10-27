package com.bucur.queries.hql;

import java.util.List;

public class DemoHqlQuery {

    public static void main(String[] args) {
        // create 2 stocks
        Stock stock1 = new Stock();
        stock1.setName("stock1");
        stock1.setStockCode("S0223");
        Stock stock2 = new Stock();
        stock2.setName("stock2");
        stock1.setStockCode("S0445");

        // persist stocks
        StockDao dao = new StockDao();
        dao.create(stock1);
        dao.create(stock2);

        // find all using native query
        List<Stock> stocks = dao.findAllWithHqlQuery();
        System.out.println("--- all stocks: " + stocks);

        List filteredStocks = dao.findAllByStockCodeNamedQuery(stock1.getStockCode());
        System.out.println("--- filtered stocks: " + filteredStocks);
    }
}
