Feature: validating place API
@addplaceAPI
Scenario Outline: verification of addPlaceAPI with for successful place addition
Given user should have a addPlaceAPI details "<name>" "<language>" "<type>" "<shop>" <lat> <long> and key for authentication
When the "addPlaceAPI" request is sent through "POST" method
Then the response should give 200 response 
And read the placeid value
And Verify the "<name>" through "GET" method
Examples:
|name|language|type|shop|lat|long|
|ASDFGH|Portugal|Sports|Accessories|10.67778|67.78889|
#|RBNM|Japanse|Service Provider|Showroom|45.23566|67.34341|

@deleteplaceAPI
Scenario: verification of delete place API
Given user should have deleteplaceAPI request
When the "deletePlaceAPI" request is sent through "DELETE" method
Then the response should give 200 response

