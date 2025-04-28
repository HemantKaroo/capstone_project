package com.elasticpath.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    //private RestTemplate restTemplate;

    private static final String EXTERNAL_API_URL = "https://useast.api.elasticpath.com";
    private static final String BEARER_TOKEN = "98c4c2c77c510c47f4d24a1dff0ffe1f64a26652"; // you can also inject this via application.properties

    public String getExternalProducts() {
        /*HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(BEARER_TOKEN); // sets Authorization: Bearer your_token_here
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                EXTERNAL_API_URL,
                HttpMethod.GET,
                entity,
                String.class
        );
*/
        return null;//response.getBody();
    }

}
