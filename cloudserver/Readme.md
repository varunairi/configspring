
# Spring Cloud Config Server

This is a server project that serves property values from Git Hub project


#### To Enable Config Server


1.  Add an Annotation called 

	@EnableConfigServer

2.  Add a path to properties file

	spring.cloud.config.server.git.uri=https://github.com/varunairi/propertystore.git

	spring.cloud.config.server.git.timeout=4

_See the path to GIT File is to the repository _ 


> On Server Startup, the Server CLONES the repository locally and then loads property files.


##### Property Change on Github

If you change properties on github, it will not reflect on the server, until the client makes a new request to Server
_However, you can configure webhook to reload the server from GitHub_ 