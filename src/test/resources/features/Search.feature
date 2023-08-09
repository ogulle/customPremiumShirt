@etsyAll
Feature: Etsy search feature
  Agile story: When user is creating a design, user needs to edit some feature

  Background: User is on the Custom Premium Shirt home page
    Given User is on the CPS home page


  Scenario: Title verification
    Then User should see title is as expected

    #expected : Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone


  @CPS_Ship
  Scenario Outline: Start Designing Order Verification - Ship
    When User starts by clicking start designing
    And User selects "<size>","<color>","<quantity>" of the tShirt
    And User adds "<design>"
    And User verifies order details on cart "<state>", "<zipcode>"
    And User fills out shipping information for shipping "<email>","<FirstName>","<LastName>","<address>","<city>","<stateCode>","<zipcode>"
    Then User verify all order details for shipping "<size>","<color>"
    Examples: User needs to see followed information on payment page
      | size | color | quantity | design | email               | FirstName | LastName | address           | city    | state | stateCode | zipcode|
      | XL   | Black | 1        | osman  | alexgulle@gmail.com | Osman     | Gulle    | 435 Rocky Briar Ct| Richmond| Texas | TX        | 77406  |

  @CPS_PickUp
  Scenario Outline: Start Designing Order Verification - Pickup
    When User starts by clicking start designing
    And User selects "<size>","<color>","<quantity>" of the tShirt
    And User adds "<design>"
    And User verifies order details on cart "<state>", "<zipcode>"
    And User fills out shipping information for pickup "<email>"
    Then User verify all order details for pickup "<size>","<color>"
    Examples: User needs to see followed information on payment page
      | size | color | quantity | design | email               | state | zipcode|
      | M    | Black | 1        | osman  | alexgulle@gmail.com | Texas | 77406  |

    @MultipleOrder
    Scenario Outline: Start Designing Order Verification - Pickup
      When User starts by clicking start designing
      And User selects "<size>","<color>","<quantity>" of the tShirt
      And User adds "<design>"
      And User verifies order details on cart "<state>", "<zipcode>"
      And User fills out shipping information for pickup "<email>"
      Then User verify all order details for pickup "<size>","<color>"
      Examples: User needs to see followed information on payment page
        | size | color | quantity | design | email               | state | zipcode|
        | M    | Black | 1        | osman  | alexgulle@gmail.com | Texas | 77406  |



