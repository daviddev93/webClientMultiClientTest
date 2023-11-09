package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoorsController {

    @GetMapping("/doors")
    public String[] getDoorsInformation() {
        return new String[]{"Door 1", "Door 2", "Door 3"};
    }
}
