class Tokenizer {
    public List<String> tokenize(String input) {
        input = input.replace("(", " ( ").replace(")", " ) ");
        return new ArrayList<>(Arrays.asList(input.trim().split("\\s+")));
    }
}