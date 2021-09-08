package practice.Testing;

import org.json.JSONObject;

public class LongTest {

    public static void main(String[] args) {

        Long latency = null;

        JSONObject jsonObject = new JSONObject("{\"latency\" : 300}");

        if(jsonObject.has("latency")) {
            latency = Long.parseLong(String.valueOf(jsonObject.get("latency")));
//            latency = (long) jsonObject.get("latency");
        }
        System.out.println(latency);
    }
}
