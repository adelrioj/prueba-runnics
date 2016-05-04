package com.runnics.pruebaRunnics;

import lombok.Getter;
import java.util.List;
import static com.google.common.collect.Lists.newArrayList;

/**
 * Generates full set of Pattern tuplas. A pattern tupla is a PotterBooksTupla in wich each element of the tupla is 0 or 1,
 * so a complete set is all combinations: (1,0,0,0,0),(0,1,0,0,0) ... (1,1,1,1,1).
 * <p />
 * There is 2^5=32 possible combinations, but (0,0,0,0,0) is discarded.
 *
 * @see com.runnics.pruebaRunnics.PotterBooksTupla
 * @author adelrioj.
 */
public class PatternTuplaGenerator {

    /**
     * 2^5 possible combinations.
     */
    public static final Integer NUMBER_OF_COMBINATIONS = 32;
    public static final Integer NUMBER_OF_DIFFERENT_BOOKS = 5;

    @Getter
    private final List<PotterBooksTupla> PatternTuplas = newArrayList();

    public PatternTuplaGenerator() {
        for (int i=1; i<NUMBER_OF_COMBINATIONS; i++) {
            PatternTuplas.add(generatePatternTupla(i));
        }
    }

    private PotterBooksTupla generatePatternTupla(Integer counter){
        PotterBooksTupla patternTupla = new PotterBooksTupla();
        for (int j=0; j<NUMBER_OF_DIFFERENT_BOOKS; j++) {
            if ((counter & 1) == 1) {
                patternTupla.updateByIndex(j, 1);
            }
            counter >>= 1;
        }
        return patternTupla;
    }
}


