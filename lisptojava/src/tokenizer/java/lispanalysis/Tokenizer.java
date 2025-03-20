package lispanalysis;

import java.util.Iterator;

class Tokenizer {
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
        return input.trim().split("\\s+");
        // s+ regex for one or more whitespace characters
    }
}