package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final DOORApi doorApi;
    private final MDSApi mdsApi;

    ClientController(MDSApi mdsApi, DOORApi doorApi){
        this.mdsApi = mdsApi;
        this.doorApi = doorApi;
    }

    @GetMapping("/client/dimensions")
    public String getDimensions(){
        return mdsApi.fetchDimensions();
    }

    @GetMapping("/client/doors")
    public String getDoors(){
       return doorApi.fetchDoorsInformation();
    }
}
