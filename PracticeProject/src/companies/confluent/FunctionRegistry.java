package companies.confluent;


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


public class FunctionRegistry {

    private final Map<String, FunctionInfo> registry = new HashMap<>();

    /**
     * Registers multiple functions in the registry.
     *
     * Example input:
     * Map.of(
     *     "funA", new FunctionInfo(List.of("Boolean", "Integer"), false),
     *     "funB", new FunctionInfo(List.of("Integer"), false),
     *     "funC", new FunctionInfo(List.of("Integer"), true)
     * );
     */
    private void register(Map<String, FunctionInfo> functions) {
        registry.putAll(functions);
    }

    /**
     * Finds all function names whose signatures match the given argument types.
     * Handles both fixed-argument and variadic functions.
     */
    public List<String> findMatches(List<String> argTypes) {

        List<String> matches = new ArrayList<>();

        for (Map.Entry<String, FunctionInfo> entry : registry.entrySet()) {

            String functionName = entry.getKey();
            FunctionInfo info = entry.getValue();

            if (matchesFixed(info, argTypes) || matchesVariadic(info, argTypes)) {
                matches.add(functionName);
            }
        }

        return matches;
    }

    // Checks for exact match (non-variadic functions)
    private boolean matchesFixed(FunctionInfo info, List<String> args) {

        if (info.isVariadic)
            return false;

        return info.argTypes.equals(args);
    }

    // Checks for variadic match
    private boolean matchesVariadic(FunctionInfo info, List<String> args) {

        if (!info.isVariadic)
            return false;

        int fixedCount = info.argTypes.size();

        if (fixedCount == 0)
            return false; // must have at least one type to vary

        // The variadic type is the last one in the list
        String variadicType = info.argTypes.get(fixedCount - 1);

        // Must have at least (fixedCount - 1) arguments
        if (args.size() < fixedCount)
            return false;

        // Check all fixed arguments first
        for (int i = 0; i < fixedCount - 1; i++) {
            if (!info.argTypes.get(i).equals(args.get(i))) {
                return false;
            }
        }

        // Remaining args must all match variadic type
        for (int i = fixedCount - 1; i < args.size(); i++) {
            if (!args.get(i).equals(variadicType)) {
                return false;
            }
        }
        return true;
    }

    // A helper class to store function info
    static class FunctionInfo {
        List<String> argTypes;
        boolean isVariadic;

        FunctionInfo(List<String> argTypes, boolean isVariadic) {
            this.argTypes = argTypes;
            this.isVariadic = isVariadic;
        }
    }

    // Example main method to test
    public static void main(String[] args) {
        FunctionRegistry registry = new FunctionRegistry();

        Map<String, FunctionInfo> funcs = new HashMap<>();
        funcs.put("funA", new FunctionInfo(List.of("Boolean", "Integer"), false));
        funcs.put("funB", new FunctionInfo(List.of("Integer"), false));
        funcs.put("funC", new FunctionInfo(List.of("Integer"), true));
        funcs.put("funD", new FunctionInfo(List.of("String", "Integer", "Integer", "Integer"), true));
        funcs.put("funE", new FunctionInfo(List.of("String", "Integer", "Integer"), false));

        registry.register(funcs);

        System.out.println(registry.findMatches(List.of("Boolean", "Integer")));            // [funA]
        System.out.println(registry.findMatches(List.of("Integer")));                       // [funB, funC]
        System.out.println(registry.findMatches(List.of("Integer", "Integer", "Integer"))); // [funC]
        System.out.println(registry.findMatches(List.of("String", "Integer")));             // []
        System.out.println(registry.findMatches(List.of("String", "Integer", "Integer")));  // [funE]
        System.out.println(registry.findMatches(List.of("String", "Integer", "Integer", "Integer", "Integer"))); // [funD]
    }
}
