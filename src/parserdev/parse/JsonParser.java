package parserdev.parse;

import parserdev.model.JsonObject;

import java.util.ArrayList;

public class JsonParser {

    // Fixme: Assumption we have Lexer , Don't forget to implement one later;

    final ArrayList<String> tokens;
    int idx = 0;
    String currentToken;

    String key = "";
    Object value;
    public JsonParser() {
        tokens = new ArrayList<>();
        /*
            {
                age: 10
            }
         */
        tokens.add("{");
        tokens.add("age");
        tokens.add(":");
        tokens.add("10");
        tokens.add("}");
        advance();
    }

    // Todo: rename it
    boolean check(String token) {
        return token.equals(currentToken);
    }

    // it is optional token advancement;  var x : int = 10;  var y = 10;
    boolean consumeIf(String token) {
        if (check(token)) {
            key = currentToken;  // bad design
            advance();
            return true;
        }
        return false;
    }

    // Eat otherwise parser error;
    boolean eat(String token) {
        if (check(token)) {
            advance();
            return true;
        } else {
            // TODO: 7/13/21 Throw parser error;
            System.err.println("Expected: " + token + " but Got " + currentToken);
        }
        return false;
    }

    boolean advance() {
        /*lexer.nextToken()*/
        if (idx < tokens.size()) {
            currentToken = tokens.get(idx++);
            return true;
        }
        return false;
    }

    public void parseJson() {

        if (consumeIf("{")) {
            System.out.println(parseObject());
            eat("}");   // closing object;
        }

        // we shoud never reach here;
    }


    private Object parseObject() {
        if (consumeIf("age")) {
            var jsonObject = new JsonObject();
            var jsonKey  = key;
            eat(":");
            switch (currentToken) {
                case "{" -> {
                    // parse object recursively
                }
                case "10" -> {
                    value = currentToken;
                    jsonObject.put(key, value);
                    value = jsonObject;
                    advance();
                    return jsonObject;
                }
            }
        }
        return null;
    }
    private void parseArray() {
        // TODO: 7/13/21

    }


    public static void main(String[] args) {
        var jParser = new JsonParser();
        jParser.parseJson();

//        var prsObjectJson = jParser.parseJson();
    }
}