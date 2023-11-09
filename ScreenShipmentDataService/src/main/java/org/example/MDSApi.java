package org.example;

import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class MDSApi {
    private final WebClient webClient;

    MDSApi(WebClient webClient){
        this.webClient = webClient;
    }

    public String fetchDimensions() {

        return webClient.get()
                .uri("http://localhost:8082/dimensions")
                .attributes(
                        ServerOAuth2AuthorizedClientExchangeFilterFunction
                                .clientRegistrationId("mds-client-model"))
                .retrieve()
                .bodyToMono(String.class)
                .map(string
                        -> "Retrieved using Client Credentials Grant Type: " + string)
                .block();
    }
}
