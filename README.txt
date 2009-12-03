PastEasy is a simple collaborative debugging tool like well known http://pastebin.com or http://openpaste.org/

My goal is to build a simple java webapp easy to deploy without any specific configurations.
I’ve chosen to use a cache manager in order to store the code snippets. In my opinion a cache manager is the best candidate for this task, code snippet don’t need to persists for long time, no needs of specific database configuration, automatic cleanup and high performances.
PastEasy internally use Ehcache and perform more that 10 000 snippet posts per seconds on my laptop.

The api is not really RESTFul, waiting for spring 3.0

to run it:
    mvn jetty:run

to post a snippet:
    curl -d language=java -d "data=class Gava" -d "lineNumber=10" http://localhost:8080/add.do

it return an ID that is used to retrieve the code, in a browser:
    http://localhost:8080/show.do?id=ID