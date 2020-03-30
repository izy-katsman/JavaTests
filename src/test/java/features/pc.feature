Feature: Test Login
  Scenario Outline: Login vk
    Given launch firefox  and navigate to the vk
    When I try to login <login> with Password <password>
    Then I should see that I logged in
    Examples:
    |login | password |
    |"89110918216"|"Vfrcbvjd11121973-"|



