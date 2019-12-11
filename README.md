# dataTranform
This is maven spring boot project .
1.0 package project with mvn package . if there are any import errors do maven update on whole project .
   please set skip tests on Run Configuration in eclipse as test package is not completed.
2.0 once the project compiles . you will find demo-0.0.1-SNAPSHOT.jar jar in target folder .  
3.0 start the spring boot app from eclipse using Run as spring boot app on com.example.rss.RssFeedApplication bootsrap class.
or     java -jar demo-0.0.1-SNAPSHOT.jar
4.0 to get json feed
    http://localhost:8080/trafficIncidentsJFeed
3.0 the app uses configurable property for xml feed source .
traffic.urlEndpoint=http://localhost:8080/getTrafficXml
server=8080
debug=true .
4.0 The xml feed given as source  is also available at http://localhost:8080/getTrafficXml


please note application is set as springboot application 
Some thoughts on making it prod app
1.0 I would generate schema and use it to validate incoming feed .
2.0 I would add validation to fields to enforce (required ,number ,string etc)
3.0 I would go with streaming API like stax if feed is larger .
4.0 I would run load test get performance benchmarks and make updates like implement 3.0 
5.0 I have imported the jakarata libraries for jsonb and jsonp in Pom file . these can be used as alternative if we want to get ride of jackson dependency . please disregard  sample code under jsonbservice using these libraries for marshalling and unmarshalling json .
5.0 I would add some test cases . I would also remove any unwanted libraries from pom file .
6.0 I would set debug to false . remove any system.out statements . turn off actuator endpoints for springboot app or change default port .
7.0 I would also add authentication layer using oauth2 using JWT via symetric secret key if required .
8.0 I would also refine error handling logic in try catch . Service should return custom error message and should not throw error to user and also returm proper HTTP status codes .
