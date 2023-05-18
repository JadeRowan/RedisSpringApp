# RedisSpringApp

The simple microservice app which consist of four microservices

"Cache Microservice" is collecting complicted object by requesting data from other three microservices. 
Once object was formed it will be cached for five minutes, and each next similiar request will get cached object.
If some object data will be changed cache will be invalidated

Each of three other microservices are using different data base (Mongo, MySql, Postgres) so data can't be collected using simple joins. 
This solution simuletes real sutuation when some complicated object creation can be simplified using cache
