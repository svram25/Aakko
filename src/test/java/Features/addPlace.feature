Feature: Validation Place API

@AddPlace
#First Test Case is add
Scenario Outline: Verify Places is beign successfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "POST" http request
	Then the API call is success with status code 200
 	And "status" in response body is "OK"
 	And "scope" in response body is "APP"
 	And verify place_ID created maps to "<name>" using "getPlaceAPI"
 	
 Examples:
 			
 			|name|language|address|
 			|Siva|English |TKM    |
 #			|Ram |Tamil   |CPT    |
 
 @DeletePlace
 #Second Test Case is delete
 Scenario: To verify delete is working fine
 	Given DeletePlace Payload
 	When user calls "DeletePlaceAPI" with "POST" http request
 	Then the API call is success with status code 200
 	And "status" in response body is "OK"
 	