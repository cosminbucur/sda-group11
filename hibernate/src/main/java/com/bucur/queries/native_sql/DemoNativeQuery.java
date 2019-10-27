package com.bucur.queries.native_sql;

import java.util.List;

public class DemoNativeQuery {

    public static void main(String[] args) {
        // create 2 traders
        Trader trader1 = new Trader();
        trader1.setName("smith");
        Trader trader2 = new Trader();
        trader2.setName("baker");

        // persist traders
        TraderDao dao = new TraderDao();
        dao.create(trader1);
        dao.create(trader2);

        // find all using native query
        List traders = dao.findAllWithNativeQuery();
        System.out.println("--- all traders: " + traders);

        List filteredTraders = dao.findAllByNameNamedNativeQuery(trader1.getName());
        System.out.println("--- filtered traders: " + filteredTraders);
    }
}
