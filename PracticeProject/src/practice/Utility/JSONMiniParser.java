package practice.Utility;

import java.util.*;
import java.math.BigInteger;

public class JSONMiniParser {

    private final String s;
    private int i = 0;

    private JSONMiniParser(String s) {
        this.s = s;
    }

    public static Object parse(String json) {

        JSONMiniParser p = new JSONMiniParser(json);
        Object val = p.parseValue();
        p.skipWs();

        if (p.i != p.s.length()) {
            throw new IllegalArgumentException("Trailing characters at: " + p.i);
        }
        return val;
    }

    private Object parseValue() {
        skipWs();
        if (i >= s.length()) throw new IllegalArgumentException("Unexpected end");
        char c = s.charAt(i);
        return switch (c) {
            case '{' -> parseObject();
            case '[' -> parseArray();
            case '"' -> parseString();
            case 't' -> parseTrue();
            case 'f' -> parseFalse();
            case 'n' -> parseNull();
            default -> parseNumber(); // -, 0-9 expected for numbers
        };
    }

    private Map<String, Object> parseObject() {
        expect('{');
        skipWs();
        Map<String, Object> obj = new LinkedHashMap<>();
        if (peek('}')) {
            i++;
            return obj;
        } // empty object
        while (true) {
            skipWs();
            String key = parseString(); // JSON keys are strings
            skipWs();
            expect(':');
            Object value = parseValue();
            obj.put(key, value);
            skipWs();
            if (peek('}')) {
                i++;
                break;
            }
            expect(',');
        }
        return obj;
    }

    private List<Object> parseArray() {
        expect('[');
        skipWs();
        List<Object> arr = new ArrayList<>();
        if (peek(']')) {
            i++;
            return arr;
        } // empty array
        while (true) {
            Object value = parseValue();
            arr.add(value);
            skipWs();
            if (peek(']')) {
                i++;
                break;
            }
            expect(',');
        }
        return arr;
    }

    private String parseString() {
        expect('"');
        int start = i;
        // Assumption: no escape sequences in input
        while (i < s.length() && s.charAt(i) != '"') i++;
        if (i >= s.length()) throw new IllegalArgumentException("Unterminated string");
        String out = s.substring(start, i);
        i++; // skip closing "
        return out;
    }

    private Object parseNumber() {
        int start = i;
        // sign
        if (s.charAt(i) == '-') i++;
        // int part
        if (i < s.length() && s.charAt(i) == '0') {
            i++; // leading zero alone
        } else {
            while (i < s.length() && Character.isDigit(s.charAt(i))) i++;
        }
        // frac
        boolean isFloat = false;
        if (i < s.length() && s.charAt(i) == '.') {
            isFloat = true;
            i++;
            if (i >= s.length() || !Character.isDigit(s.charAt(i)))
                throw new IllegalArgumentException("Invalid number fraction");
            while (i < s.length() && Character.isDigit(s.charAt(i))) i++;
        }
        // exp
        if (i < s.length() && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            isFloat = true;
            i++;
            if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            if (i >= s.length() || !Character.isDigit(s.charAt(i)))
                throw new IllegalArgumentException("Invalid number exponent");
            while (i < s.length() && Character.isDigit(s.charAt(i))) i++;
        }
        String num = s.substring(start, i);
        if (isFloat) {
            return Double.valueOf(num);
        } else {
            // try to fit in Long, otherwise BigInteger
            try {
                return Long.valueOf(num);
            } catch (NumberFormatException e) {
                return new BigInteger(num);
            }
        }
    }

    private Boolean parseTrue() {
        expect('t');
        expect('r');
        expect('u');
        expect('e');
        return Boolean.TRUE;
    }

    private Boolean parseFalse() {
        expect('f');
        expect('a');
        expect('l');
        expect('s');
        expect('e');
        return Boolean.FALSE;
    }

    private Object parseNull() {
        expect('n');
        expect('u');
        expect('l');
        expect('l');
        return null;
    }

    private void skipWs() {
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ' || c == '\n' || c == '\r' || c == '\t') i++;
            else break;
        }
    }

    private boolean peek(char c) {
        return i < s.length() && s.charAt(i) == c;
    }

    private void expect(char c) {
        if (i >= s.length() || s.charAt(i) != c) {
            throw new IllegalArgumentException("Expected '" + c + "' at " + i);
        }
        i++;
    }

    // --- quick demo ---
    public static void main(String[] args) {
        System.out.println(parse("{\"a\":2,\"b\":[1,2,3]}"));   // {a=2, b=[1, 2, 3]}
        System.out.println(parse("true"));                      // true
        System.out.println(parse("[1,5,\"false\",{\"a\":2}]")); // [1, 5, false, {a=2}]
    }
}
