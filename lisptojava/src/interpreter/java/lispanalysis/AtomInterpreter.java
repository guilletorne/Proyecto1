package lispanalysis;

class AtomInterpreter {
    /**
     * Parses the given token and returns it as an Integer, Double, or String.
     *
     * @param token the token to be parsed
     * @return the parsed token as an Integer, Double, or String
     */
    public Object parseAtom(String token) {
        try {
            //regular expressions (regex) that define patterns to match against token.
            if (token.matches("-?\\d+")) { 
                //optional minus sign followed by one or more digits.
                return Integer.parseInt(token);
            } else if (token.matches("-?\\d*\\.\\d+")) {
                //optional minus sign, followed by zero or more digits, 
                //followed by a decimal point, and ending with one or more digits.
                return Double.parseDouble(token);
            } else {
                return token;
            }
        } catch (NumberFormatException e) {
            return e.getMessage();
        }
        
    }
}
