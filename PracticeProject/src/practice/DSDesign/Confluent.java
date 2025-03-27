package practice.DSDesign;


/*
* register[{
*    funA:{["Boolean", "Integer"], isVariadic:false},
*    funB:{["Integer"], isVariadic:false},
*    funC:{["Integer"], isVariadic:true}

* })
*
* findMatches(["Boolean", "Integer"])            -> [funA]
* findMatches(["Integer"])                       -> [funB, funC]
* findMatches(["Integer", "Integer", "Integer"]) -> [funC]
*
* More Examples:
*
*    funD:{["String", "Integer", "Integer", "Integer"], isVariadic:true},
*    funE:{["String", "Integer", "Integer"], isVariadic:false}
*
* findMatches(["String", "Integer"])             -> []
* findMatches(["String", "Integer", "Integer"])  -> [funE]
* findMatches(["String", "Integer", "Integer", "Integer", "Integer"])  -> [funD]
*/

import java.util.*;

class Function {
    public final List<String> argumentTypes; // e.g. ["Integer", "String", "PersonClass"]
    public final String name;
    public final boolean isVariadic;

    Function(String name, List<String> argumentTypes, boolean isVariadic) {
        this.name = name;
        this.argumentTypes = argumentTypes;
        this.isVariadic = isVariadic;
    }

    public String toString() {
        return this.name;
    }
}

class FunctionLibrary {

    static Map<String, Function> variadicMap;
    static Map<String, Function> nonVariadicMap;


    public FunctionLibrary() {
        variadicMap = new HashMap<>();
        nonVariadicMap = new HashMap<>();
    }

    static void register(List<Function> functions) {
        // implement me

        for(Function func : functions) {

            List<String> args = func.argumentTypes;

            String key = String.join(",", args);

            boolean isVariadic = func.isVariadic;

            if(isVariadic) {
                variadicMap.put(key, func);
            } else {
                nonVariadicMap.put(key, func);
            }
        }
    }

    static List<Function> findMatches(List<String> argumentTypes) {
        // implement me

        List<Function> result = new ArrayList<Function>();

        String key = String.join(",", argumentTypes);

        if(nonVariadicMap.containsKey(key)) {
            result.add(nonVariadicMap.get(key));
        }

        StringBuilder sb = new StringBuilder(key);
        String[] arr = key.split(",");

        for(int i = argumentTypes.size() - 1 ; i >= 0 ; i--) {
            if(variadicMap.containsKey(sb.toString())) {
                result.add(variadicMap.get(sb.toString()));
            }
        }
        return result;
    }


    static class Solution {
        public static void main(String[] args) {

            FunctionLibrary lib = new FunctionLibrary();

            List<Function> al = new ArrayList<>();

            Function f1 = new Function("funA", Arrays.asList(new String[]{"Boolean", "Integer"}), false);
            Function f2 = new Function("funB", Arrays.asList(new String[]{"Integer"}), false);
            Function f3 = new Function("funC", Arrays.asList(new String[]{"Integer"}), true);

            al.add(f1);
            al.add(f2);
            al.add(f3);

            lib.register(al);

            List<Function> result = lib.findMatches(Arrays.asList(new String[]{"Boolean", "Integer"}));

            for(Function f : result)
                System.out.println(f.toString());

        }
    }
}