package org.example;

import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DOORApi {
    private final WebClient webClient;

    DOORApi(WebClient webClient){
        this.webClient = webClient;
    }

    public String fetchDoorsInformation() {

        return webClient.get()
                .uri("http://localhost:8083/doors")
                .attributes(
                        ServerOAuth2AuthorizedClientExchangeFilterFunction
                                .clientRegistrationId("door-client-model"))
                .retrieve()
                .bodyToMono(String.class)
                .map(string
                        -> "Retrieved using Client Credentials Grant Type: " + string)
                .block();
                //.subscribe(System.out::println);
    }
}
