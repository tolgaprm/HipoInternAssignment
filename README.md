
# Hipo Intern Assignment

# Screenshots

<div>
<img src="/screenshots/screenshot_1.png" width="180" height="360" float:left>
<img src="/screenshots/screenshot_2.png" width="180" height="360" float:left>
<img src="/screenshots/screenshot_3.png" width="180" height="360" float:left>
</div>

# Approach

In this project, I used the MVVM design pattern, Jetpack Compose and Clean Architecture.

The data layer has models that represent the data which is get from the api and an interface that represents the api endpoints. Also I used repository pattern to separated data access logic from the business logic.

The presentation layer has classes related to view. The most reason of the using ViewModel is to prevent to lose the data that saved when configuration changes. And it make operations on the data according to the incoming events and preparing the data to be shown on the view side.