# keyvaluestore
Local file based key value data store

## Getting Started
### Prerequisites
- Java JDK (preferably jdk1.8.0_211 or higher) with environment variables set
- An IDE that supports maven such as IntelliJ or Eclipse (along with JUnit and JaCoCo if you are going to run unit tests)
- Apache Maven (this is only if you want to build/run tests from command line) with environment variables set
### Installation
Clone this repository to any desired location on your system:
``` 
git clone https://github.com/rohithjayaraman/keyvaluestore.git 
```
or download as a zip file and extract
### Usage
#### Importing as Maven project into an IDE
Choose to import a project from existing resources in your IDE and when prompted, select the keyvaluestorage folder that was cloned/downloaded. This will create a maven project with this repo

#### Importing as external JAR/library file
To use only the external JAR/library file in your program simply add the JAR to your build dependency in your IDE. Once this is done, import the classes into your program by using an import statement
```java
import kvstore.*;
```
#### Creating an object
Creating an object of class KeyValueStore will automatically create a file (whose name is of the format **processid@devicename-keystore** which ensures that only one process can modify a particular file).
To create the file in the current directory, create an object using the following command:
```java
KeyValueStore kvs = new KeyValueStore();
```
To create the file in a location of your choice, create the object while passing the location as an argument. For example, to create the file in local disk C on windows:
```java
KeyValueStore kvs = new KeyValueStore("C:/");
```
Please make sure you give a valid directory. Also, if you are using linux or MacOS then **do not use ~/ to specify the directory**. Mention the full directory instead.
#### Creating/Adding a key value pair
To add a key value pair, use the create function of the KeyValueStore object that was created in the step above. The key must be a string that is alphanumeric whose length is less than or equal to 32 characters. The key cannot be empty. The value must be a json object whose size is less than 16 kb. The create function returns the key of the key-value pair if creation was done successfully. To create a key-value pair:
```java
String key = "abcdefgh123456abcxysutersjsd3212";
String jsonValue = "{\"name\":\"Pikachu\", \"type\":\"Electric\"}";
String result;
JSONObject json = new JSONObject(jsonValue);
result = kvs.create(key, value);
```
Additionally, you may also specify a Time To Live (TTL) parameter (in seconds) which defines how long the data will be available. As soon as the TTL has elapsed, the data will be deleted. By default, there is no TTL. To specify time to live while creating key-value pair, simply call the create function as: 
```java
String key = "abcdefgh123456abcxysutersjsd3212";
String jsonValue = "{\"name\":\"Pikachu\", \"type\":\"Electric\"}";
String result;
JSONObject json = new JSONObject(jsonValue);
result = kvs.create(key, value, 3);
```
Whenever using the create method in a function, the following exceptions must be handled: FileNotFoundException, ExceededSizeLimitException, NonUniqueKeyException
#### Reading a value
To read a value from the file, call the read function while passing the key as the argument. The function returns a json value if key was found. Any function that uses the read method must handle EmptyFileException, MissingKeyException, FileNotFoundException.
```java
String key = "abcdefgh123456abcxysutersjsd3212";
JSONObject json = new JSONObject();
json = kvs.read(key);
```
#### Deleting a value
To delete a value from the file, simply call the delete function and pass key as parameter. The function returns true if the key was found and deleted. Any function that uses the delete method must handle EmptyFileException, MissingKeyException, FileNotFoundException
```java
String key = "abcdefgh123456abcxysutersjsd3212";
Boolean deletion;
deletion = kvs.delete(key);
```
#### Erasing the entire keystore file
There is an option to erase the entire key store file. It is a function that returns true if the file was deleted. The command is:
```java
Boolean deletion;
deletion = kvs.apocalypseNow();
```
## Unit Tests
### Running the tests
#### Running via IDE
To run the unit tests via IDE, simply select Run Tests with Coverage on your IDE. There are 15 tests totally which test the code.
#### Running from command line
There is an option to run the tests via command line Interface. Ensure that you have jdk and maven installed with the required environment variables set. 
##### On Windows
Go to the keyvaluestore folder that was cloned. Perform a Shift+Right click and select open powershell window here.
It should prompt typing with the location showing as inside keyvaluestore. Now once the powershell is loaded, type the command:
```
mvn clean test
```
##### On Linux, MacOS and other operating systems
Open terminal and navigate to the inside of the keyvaluestore folder that was downloaded. Now type the command:
```
mvn clean test
```
This should build the project and run all 15 unit tests. Once testing is done, you will get a message saying Build Successful.
### Code Coverage
The code coverage for the unit tests can be obtained if the tests are run in an IDE with an inbuilt Code Coverage like JaCoCo. 
Code Coverage is not a dependency for this maven project and hence cannot be obtained if the tests are being run from command line. 

Below is a screenshot of the code coverage when the tests were run on IntelliJ using inbuilt JaCoCo for code coverage

![Alt text](codeCoverage.png?raw=true "Code Coverage")
