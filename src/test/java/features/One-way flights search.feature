@flightsearch 
Feature: One-way flight search 
Scenario Outline: To verify the page results are ordered in decreasing order of cost. 

	Given user is on GoIbibo homepage 
	When user selects source as "<sourcePoint>" 
	And user selects destination as "<destinationPoint>" 
	And user selects valid depart date 
	And user clicks on flight search button 
	And user clicks on price arrow button 
	Then user is able to see the cost of flight search results should be in decreasing order 
		
	Examples: 
		| sourcePoint| destinationPoint   |
		| Bangalore  | Mumbai             |
		| Bangalore  | Delhi              |
		
