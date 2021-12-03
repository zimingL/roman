This repository provide a simple REST API to convert between roman numerals and arabic numerals(the scope is between 1 and 4000). It is built on top of Spring Boot framework. And the test driven approach is used in the development.

###API
Under "/v1/convertion/romantoarabic", you are asked to provide a roman numeral(which should be a String), and then get a corresponding arabic numeral.

Under "/v1/convertion/arabictoroman", you are asked to provide an arabic numeral(which should be a Integer, between 1 and 4000), then get a corresponding roman numeral.