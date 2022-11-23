package com.example.projecttwo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final WebClient webClient;

    public EmployeeService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
        //https://jsonplaceholder.typicode.com
    }




         public List<Employee> findall() {
             return this.webClient
                     .get()
                     .uri("/get")
                     .retrieve()
                     .bodyToMono(new ParameterizedTypeReference<List<Employee>>() {})
                     .block();
         }
         public List<Example> findLaptops(){

             return this.webClient
                     .get()
                     .uri("/users")
                     .retrieve()
                     .bodyToMono(new ParameterizedTypeReference<List<Example>>() {})
                     .block();

         }

         public Employee saveEmployee(Employee employee){
             return employee = webClient
                     .post()
                     .uri("/add")
                     .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                     .body(Mono.just(employee), Employee.class)
                     .retrieve()
                     .bodyToMono(Employee.class)
                     .block();
         }
}
