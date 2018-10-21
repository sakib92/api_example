"PROBLEM"
Take a look at the OpenWeather API ( http://openweathermap.org/api ) specifically the
endpoint described in ( http://openweathermap.org/current#name ). Write a script that
takes a city name as user input and display maximum and minimum temperatures from
the result.


"SOLUTION"
Create a client that makes requests to the weather API. Create a test that utilizes this client 


"HOW TO SETUP PROJECT"
- It's a maven project. Use your favorite IDE and import as existing maven project.
- Update all the maven dependencies if it isn't done automatically 


"HOW TO RUN"
- I'm using JUNIT4 as the test runner. Right click on the CityNameMinMaxTest.java and run as JUnit Test. Your IDE probably has JUNIT4 capabilities installed already.
If not, then the other option is to use the maven command - mvn test. 


"MORE INFO AND OTHER THINGS I'D DO IF I HAD MORE TIME"
For the API client, I implemented it using REST-ASSURED. It's a very popular Java library that provides a domain-specific language (DSL) for writing powerful, maintainable tests for RESTful APIs. I use it for my service tests at FINRA. 

I used the REST-ASSURED Specification class to hold the appid value and the base url. To make API calls, I had to sign up for the weather website and get an appid. This appid is passed along with every call. There may be limits on the number of requests you can make since it's a free account. 
The appID is harcoded into my Spec class right now. If I had more time, I would see if I can get it back from the weather server with my login/password credentials. 

I used JUNIT4 Paramaterized tests. If you want to add another city to test, just add the city name to the paramaterized test method. 

I used an interface for the the weather API calls. So you can swap out the implementation if you don't want to use REST-ASSURED. 
Problem is I have a concrete implementation of the client in my test class. If I had more time I'd use Spring to inject the concrete implementation to make it more reusable

If I had more time, I would create a POJO object for the JSON response. This way, I would deal with objects instead of JSON string responses and JsonPath expression which can get messy. However, this may be overkill depending on how often you will be using the POJO for your other tests.  

If I had more time, I would use JUNIT5 but I was having trouble getting the JUNIT5 plugin installed on my Eclipse IDE. Probably should have used Intelliji. JUNIT5 provides more detailed reports..  


