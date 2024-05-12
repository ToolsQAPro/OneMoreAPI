Feature: Test Get
Scenario: Hit the get request
Given I have the API endpoint
When  I send a GET request
Then the response status code should be