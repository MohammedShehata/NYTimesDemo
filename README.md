# NY Times Demo

Simple Android application demo using view API of NY Times.

## Getting Started


### Prerequisites

Android studio.

### Installing

- Open app by android studio
- Select **devDebug** from build variants
- Clean and run the app by your device or your device

## How do I run test units?
- Select **devDebug** from build variants
- Open ArticlesPeriodUnitTest
- Click on the run icon beside the class or the upper play icon in the title bar

## How do I run UI test units?
- Select **mocDevDebug** from build variants
- Open ArticlesUnitTest
- Click on the run icon beside the class or the upper play icon in the title bar

## How do I generate coverage reports?
- You can simply open the gradle side menu
- Navigate to tasks/verfication 
- Double click on createMockDevDebugCoverageReport
- You will find the report after few seconds in /app/build/reports/androidTests/connected/flavors/mockDevDebugAndroidTest
- open **index file**

OR Simply:
- You can type thise command in the terminal where the project file is the parent folder
```
 ./gradlew createMockDevDebugCoverageReport
```
## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* Kotlin
* MVVM architecture using Livedata and Viewmodels
* [NY times APIS](https://developer.nytimes.com/get-started) - [Show API](https://developer.nytimes.com/docs/most-popular-product/1/routes/viewed/%7Bperiod%7D.json/get)
* Espresso and mockWebServer for UI tests
* Junit for unit tests

## Authors

* **Mohammed Shehata**

See also the list of [contributors](https://github.com/MohammedShehata/NYTimesDemo/contributors) who participated in this project.
