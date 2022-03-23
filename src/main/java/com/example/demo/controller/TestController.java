package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.dto.TestRequestBodyDTO;
import com.example.demo.dto.TestResponseDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("/testGetMapping")
    public String testController() {
        return "First GET Method! Hello World!";
    }

    @GetMapping("/{id}")        // path variable (매개변수) 필요함을 의미
    public String testControllerWithPathVariable(@PathVariable(required = false) int id) {
        return "Get Method with Path Variable! " + id;
    }

    @GetMapping("/testRequestParam")
    public String testControllerWithRequestParam(@RequestParam(required = false) int id) {
        return "Get Method with Path Variable (another way)! " + id;
    }

    @GetMapping("/testRequestBody")
    public String testControllerWithRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return "Get Method with Request Body DTO! ID is: " +
                testRequestBodyDTO.getId() + " and the Message is: " + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")
    public TestResponseDTO<String> testControllerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("My first GET Method that returns a response body DTO!");
        TestResponseDTO<String> response = TestResponseDTO.<String>builder().data(list).build();

        return response;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerWithResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("My first GET Method using Response Entity. You may get 400 http status!");
        TestResponseDTO<String> response = TestResponseDTO.<String>builder().data(list).build();

        return ResponseEntity.badRequest().body(response);
    }
}