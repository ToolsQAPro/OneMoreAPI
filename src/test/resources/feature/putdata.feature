Feature: Test Put
Scenario: Testing application with put request
Given Body take from json
When I do put request with url
Then Get the response and verify details put