package lispanalysis;

class AtomInterpreter {
    /**
     * Interprets the given parsed Token and returns it as an Integer, Double, or String.
     *
     * @param parsedparsedToken the parsed Token to be interpreted
     * @return the parsed Token as an Integer, Double, or String
     */
    public Object interpretAtom(String parsedToken) {
        try {
            //regular expressions (regex) that define patterns to match against parsedToken.
            if (parsedToken.matches("-?\\d+")) { 
                //optional minus sign followed by one or more digits.
                return Integer.parseInt(parsedToken);
            } else if (parsedToken.matches("-?\\d*\\.\\d+")) {
                //optional minus sign, followed by zero or more digits, 
                //followed by a decimal point, and ending with one or more digits.
                return Double.parseDouble(parsedToken);
            } else {
                return parsedToken;
            }
        } catch (NumberFormatException e) {
            return e.getMessage();
        }
        
    }
}
