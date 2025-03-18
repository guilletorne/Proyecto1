class AtomParser {
    public Object parseAtom(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e1) {
            try {
                return Double.parseDouble(token);
            } catch (NumberFormatException e2) {
                return token;
            }
        }
    }
}
