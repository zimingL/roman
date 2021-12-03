### Intro
This repository provide a simple REST API to convert between roman numerals and arabic numerals(the scope is between 1 and 4000). It is built on top of Spring Boot framework. And the test driven approach is used in the development.

### API
You can send a POST request to "/v1/convertion/romantoarabic" with key-value pair (String key, String romanNumeral), in which key is "romanN". For example: "http://localhost:8080/v1/convertion/romantoarabic?romanN=IX" 

You can send a POST request to "/v1/convertion/arabictoroman" with key-value pair (String key, Integer arabicNumeral), in which key is "arabicN". For example: "http://localhost:8080/v1/convertion/arabictoroman?arabicN=4"