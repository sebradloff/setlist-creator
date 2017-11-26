package io.sebradloff.setlistcreator.controllers;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping(path = "artists")
public class ArtistsController {
    private static final List<String> VISITORS = new ArrayList<>();

    private enum ValidVersion {
       v1
    }

    @RequestMapping(path = "", method = POST)
    public ResponseEntity<?> sayHello(@RequestHeader("X-API-Version") final ValidVersion version, final @RequestBody Map<String, String> input) {
        if (input.containsKey("artist") && input.get("artist") != null) {
            String inputArtistName = input.get("artist").toString();
            JsonObject responseObject = new JsonObject();
            responseObject.addProperty("artist", inputArtistName);
            return ok(responseObject);
        } else {
            return badRequest().body("'artist' is required.");
        }
    }
}
