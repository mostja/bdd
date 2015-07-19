Meta: @ignore
Narrative:
As a user
I want to search for a specific phone
So that I make sure that that first available link will be the requested one

Scenario: Searching for an iPhone 6
Given the user is on the Sokol home page
When the user starts a search for <model> phone
Then <model> phone is the first one in results list

Examples:
|model|
|iPhone 6|
|Galaxy S6|
|HTC One M9|