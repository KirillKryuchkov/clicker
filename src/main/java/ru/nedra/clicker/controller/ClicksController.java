package ru.nedra.clicker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nedra.clicker.service.ClicksService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ClicksController {

    private final ClicksService service;

    public ClicksController(ClicksService service) {
        this.service = service;
    }

    @RequestMapping(method = GET, path = "/rest/clicks", produces = "text/plain")
    public ResponseEntity<String> getClickCount() {
        return ResponseEntity.ok(String.valueOf(service.getActualClicksCount()));
    }

    @RequestMapping(method = POST, path = "/rest/click", produces = "text/plain")
    public ResponseEntity<String> postClick() {
        return ResponseEntity.ok(String.valueOf(service.submitClick()));
    }

    @RequestMapping(method = DELETE, path =  "/rest/clicks")
    public ResponseEntity<String> resetClicks(){
        return ResponseEntity.ok(String.valueOf(service.resetClicks()));
    }
}
