package org.example.courseenrollmentwebsite.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ApiService {

    public String getStuIdByName(String apiurl){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiurl))
                .build();
        try {
            // Send the request and receive the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check the status code and handle the response
            if (response.statusCode() == 200) {
                String responseBody = response.body();
                return responseBody;
            } else {
                return "Error: " + response.statusCode();
            }
        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }
    }

}

