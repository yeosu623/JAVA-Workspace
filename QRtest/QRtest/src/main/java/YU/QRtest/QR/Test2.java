package YU.QRtest.QR;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class Test2 {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "steave");
        map.put("age", 32);
        map.put("job", "baker");

        System.out.println(map);
        System.out.println(mapper.writeValueAsString(map));

        String jsn = mapper.writeValueAsString(map);

        HashMap<String, Object> map_result = mapper.readValue(jsn, new TypeReference<>() {});
        System.out.println(map_result);
        System.out.println(map_result.get("name").getClass().getName());
        System.out.println(map_result.get("job").getClass().getName());
        System.out.println(map_result.get("age").getClass().getName());
    }
}

// {age=32, name=steave, job=baker}
// {"age":"32","name":"steave","job":"baker"}