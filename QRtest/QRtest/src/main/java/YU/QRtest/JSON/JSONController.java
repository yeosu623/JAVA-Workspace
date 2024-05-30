package YU.QRtest.JSON;

import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JSONController {

    JsonObject json = new JsonObject();
    @GetMapping("/json")
    @ResponseBody
    public ResponseEntity<String> jsonGet() {

        System.out.println("GET : " + json.toString());
        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }

    @PostMapping("/json")
    public ResponseEntity<Void> jsonPost(@RequestBody Data data) {

        json.addProperty("data1", data.getData1());
        json.addProperty("data2", data.getData2());
        System.out.println("POST : " + data.toString());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
