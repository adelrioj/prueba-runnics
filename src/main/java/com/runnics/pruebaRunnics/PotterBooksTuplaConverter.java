package com.runnics.pruebaRunnics;

/**
 * Converter for PotterBooksTupla class
 *
 * @see com.runnics.pruebaRunnics.PotterBooksTupla
 * @author adelrioj.
 */
public class PotterBooksTuplaConverter {

    public static PotterBooksTupla toPotterBooksTupla (Integer... books){
        Integer[] tupla = {0,0,0,0,0};
        for (Integer book : books) {
            tupla[book]+=1;
        }
        return new PotterBooksTupla(tupla);
    }
}
