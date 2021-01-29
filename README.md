# Artificial Intelligence Rest Services

A rest service that will provide value by computing, performing voice or facial recognition, responding to human prompts, and sense and monitor human activity.

*** Please note this project is currently in development**

### What You Need

About 15 minutes

A favorite text editor or IDE

JDK 1.8 or later

Gradle 4+ or Maven 3.2+

You can also import the code straight into your IDE: Spring Tool Suite (STS)

GIT

### Clone The Repository

``` git clone https://github.com/shakes082/artificialintelligencerestservices.git ```

``` cd artificialintelligencerestservices ```

### Run the Application

To run the application, run the following command in a terminal window (in the complete) directory:


```./gradlew bootRun```

If you use Maven, run the following command in a terminal window (in the complete) directory:


```./mvnw spring-boot:run```

### Access The Application
Open up your favourite browser and go to the following address:

Rest Endpoint API Docs:

http://127.0.0.1:8080/artificialintelligence/api-doc


## Server Configurations

### Ping

Rest Action: Get

Url: http://127.0.0.1:8080/artificialintelligence/serverconfiguration/ping

Expected USSDResponse:

```
{
  "alive" : true
}
```

## Vision

### Detect Faces In A Base64 Encode Image

Rest Action: Post

Url: http://127.0.0.1:8080/artificialintelligence/vision/detectFaces

Sample Request:
```
{
  uuid: "977f3840-61fe-11eb-ae93-0242ac130002",
  base64EncodedImage: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVQYV2NgYAAAAAMAAWgmWQ0AAAAASUVORK5CYII="
}

```

Sample Response:

```
{
  "detectedFaces" : false
}

```

### Detect And Trace Faces In A Base64 Encoded Image

Rest Action: Post

Url: http://127.0.0.1:8080/artificialintelligence/vision/detectAndTraceFaces

Sample Request:
```
{
  uuid: "977f3840-61fe-11eb-ae93-0242ac130002",
  base64EncodedImage: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVQYV2NgYAAAAAMAAWgmWQ0AAAAASUVORK5CYII="
}

```

Sample Response:

```
{
  base64EncodedImage: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVQYV2NgYAAAAAMAAWgmWQ0AAAAASUVORK5CYII="
}

```
