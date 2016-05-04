package com.runnics.pruebaRunnics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Represents a set of tuplas that have the same amount of books than the original book basket.
 * e.g. (2,0,0,0,0) -> (1,0,0,0,0),(1,0,0,0,0).
 *
 * @author adelrioj
 */
public class BookBasketSubSet {

    private List<PotterBooksTupla> bookBasketSubSet = new ArrayList<>();
    private BigDecimal price = null;

    public BookBasketSubSet(PotterBooksTupla subSet1, PotterBooksTupla subSet2){
        this.bookBasketSubSet = newArrayList();
        bookBasketSubSet.add(subSet1);
        bookBasketSubSet.add(subSet2);
    }

    public BigDecimal getPrice(){
        if (this.price == null){
            price = new BigDecimal("0");
            for (PotterBooksTupla tupla : bookBasketSubSet) {
                price = price.add(KataPotter.calculatePrice(tupla));
            }
        }
        return this.price;
    }
}
