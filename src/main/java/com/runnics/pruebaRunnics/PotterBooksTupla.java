package com.runnics.pruebaRunnics;

/**
 *  Sequence of 5 elements. first value index is 0.
 *  On this kata, each index represents a different Potter book, and the values associated with each index represents
 *  the number of books of that type. (e.g. tupla.getValue(4)=3 means there is 3 books of the fifth Potter's title)
 * <p />
 * Although using Guava's ImmutableList should improve efficiency, this implementation makes the problem simpler.
 *
 * @author adelrioj.
 */
public class PotterBooksTupla {

    private Integer[] values = {0,0,0,0,0};

    public PotterBooksTupla(Integer... values){
        if (values.length == 5){
            this.values = values;
        }
    }

    public boolean isComposedOfZeroAndOneValues(){
        for (Integer value : values) {
            if (value > 1) return false;
        }
        return true;
    }

    public Integer getValue(int index){
        return values[index];
    }

    public Integer getCountOfNonZeroValues(){
        Integer count = 0;
        for (Integer value : values) {
            if (value > 0) count++;
        }
        return count;
    }

    public Integer getValuesCount(){
        Integer count = 0;
        for (Integer value : values) {
            count += value;
        }
        return count;
    }

    public void updateByIndex(int index, int value){
        values[index] = value;
    }

    /**
     * Substracts tupla to this, by index.
     * @param tupla subtrahend of the operation
     * @return for each index n, return this[n] - tupla[n]
     */
    public PotterBooksTupla substract(PotterBooksTupla tupla){
        for (int i = 0; i < values.length; i++) {
            values[i] -= tupla.getValue(i);
        }
        return this;
    }

    public boolean isSubstractAllowed(PotterBooksTupla tupla){
        for (int i = 0; i < values.length; i++) {
                if (values[i] - tupla.getValue(i) < 0){
                    return false;
                }
        }
        return true;
    }

    @Override
    public PotterBooksTupla clone() {
        return new PotterBooksTupla(values.clone());
    }
}
