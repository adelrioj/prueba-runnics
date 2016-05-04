package com.runnics.pruebaRunnics;

import static com.google.common.collect.Lists.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Kata potter implementation.
 *
 * @author adelrioj
 */
public class KataPotter {

    public static final BigDecimal BOOK_BASE_PRICE = new BigDecimal("8");

    public static final  BigDecimal[] DISCOUNT_FACTOR = new BigDecimal[] {
            BigDecimal.ONE,
            BigDecimal.ONE,
            new BigDecimal("0.95"),
            new BigDecimal("0.9"),
            new BigDecimal("0.8"),
            new BigDecimal("0.75")
    };

    private static List<PotterBooksTupla> patternTuplas = new PatternTuplaGenerator().getPatternTuplas();

    public static BigDecimal getPrice(Integer... books){
        PotterBooksTupla bookBasket = PotterBooksTuplaConverter.toPotterBooksTupla(books);
        return calculatePrice(bookBasket);
    }

    public static BigDecimal calculatePrice(PotterBooksTupla bookBasket){
        if (bookBasket.isComposedOfZeroAndOneValues()){
            return getPriceForBookBasketComposedOfZeroOrOneOfEachBook(bookBasket);
        }
        else{
            List<BookBasketSubSet> bookBasketSubSets = calculateBookBasketSubSets(bookBasket);
            BookBasketSubSet minimumPricedBasket = bookBasketSubSets.get(0);
            for (int i = 1; i < bookBasketSubSets.size(); i++) {
                if (bookBasketSubSets.get(i).getPrice().compareTo(minimumPricedBasket.getPrice()) < 0){
                    minimumPricedBasket = bookBasketSubSets.get(i);
                }
            }
            return minimumPricedBasket.getPrice();
        }
    }

    private static List<BookBasketSubSet> calculateBookBasketSubSets(PotterBooksTupla bookBasket){
        List<BookBasketSubSet> bookBasketSubSets = newArrayList();
        for (PotterBooksTupla patternTupla : patternTuplas) {
            if (bookBasket.isSubstractAllowed(patternTupla)){
                PotterBooksTupla remainingBasket = bookBasket.clone().substract(patternTupla);
                BookBasketSubSet basketSubSet = new BookBasketSubSet(patternTupla, remainingBasket);
                bookBasketSubSets.add(basketSubSet);
            }
        }
        return bookBasketSubSets;
    }

    private static BigDecimal getPriceForBookBasketComposedOfZeroOrOneOfEachBook(PotterBooksTupla bookBasket){
        BigDecimal booksInBasket = new BigDecimal(bookBasket.getValuesCount());
        BigDecimal discountFactor = DISCOUNT_FACTOR[bookBasket.getCountOfNonZeroValues()];
        return BOOK_BASE_PRICE.multiply(booksInBasket).multiply(discountFactor);
    }
}