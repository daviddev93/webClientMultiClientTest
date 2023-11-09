package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DimensionsController {

    @GetMapping("/dimensions")
    public String[] getDimensions() {
        return new String[]{"Dimension 1", "Dimension 2", "Dimension 3"};
    }

}
