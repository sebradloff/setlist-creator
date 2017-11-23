package io.sebradloff.setlistcreator;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "visitors")
public class ArtistController {
    private static final List<String> VISITORS = new ArrayList<>();

    @RequestMapping(path = "", method = POST)
    public ResponseEntity<?> writeDownVisitor(final @RequestBody Map<String, Object> input) {
        if (input.containsKey("name") && input.get("name") != null) {
            VISITORS.add(input.get("name").toString());
            return ok(VISITORS);
        }
        else
            return badRequest().body("'name' is required.");
    }
}
