package lispanalysis.tokenizer;

import java.util.Iterator;
import java.util.Arrays;

public class Tokenizer {
    /**
     * Tokenizes the input string by adding spaces around parentheses
     * and splitting the string by whitespace.
     *
     * @param input the input string to tokenize
     * @return a list of tokens
     */
    public Iterator<String> tokenize(String input) {
        input = input.replaceAll("[()]", " $0 ");
        //[()] character class that matches either ( or ).
        //$0 refers to the entire match found by the regular expression.
        
        return Arrays.asList(input.trim().split("\\s+")).iterator();
        // s+ regex for one or more whitespace characters
    }
}