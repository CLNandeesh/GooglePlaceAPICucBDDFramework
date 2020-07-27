Feature: Validate Google Place API functionality

@AddPlace
Scenario Outline: Validate Add Place functionality
Given Add Place Payload with "<name>"  "<language>" "<address>"
When User calls "AddPlaceAPI" api with "post" http request
Then api call got success with status code <200>
And "status" in response is "OK"
And "scope" in response is "APP"
And verify place_id created maps to "<name>" using "GetPlaceAPI"

Examples:
        |name|language|address|
        |appu|frenchy|brigade appartment|
       |shivu|spanish|global appartment|


@DeletePlace
Scenario: Validate Delete Place funcionslity
Given Delte Place payload  
When User calls "DeletePlaceAPI" api with "delete" http request
Then api call got success with status code <200>
And "status" in response is "OK"