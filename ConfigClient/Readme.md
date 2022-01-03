
# Spring Cloud Config Client


## Enabling Client to Access Server
The following properties allow client to get access to cloud config server.

	spring.config.import=optional:configserver:http://localhost:8888
	spring.application.name=myproperties

Your application name in this file should match the properties file name in Git Hub. The Config SERVER will grab the properties file matching your app name.

## Loading the properties in Client

	@Value 
allows the properties to be injected at initialization through Application Context.
Once the properties are loaded they reside (Injected) in the Context. _Special Case below_ 


#### Scenario 1: Startup
On Startup, the client contacted the server and downloaded the properties. Now even if the server restarts or shuts down , the client retains the properties already injected by way of @Value. 

On a Client Restart though, it will go and fetch those properties again from server (if a newer version is available, now that'll be injected)


##### If the server is down on client setup, client will not come up as well


#### Scenario 2: Refreshing Property Values without restarting Client.
	@RefreshScope 
This annotation above a configuration, helps to re inject values (the ctual scope is bigger as it actually re-initializes all beans in an configuration) without a restart. However, for this to work one has to provide a way in like

> Add Actuator to your configuration and then on sending a POST to /actuator/refresh, this will refresh all beans (or get new values from server)


	curl -X POST http://localhost:8080/actuator/refresh

In my experiments, I saw that it somehow made the Server too to get new configs from Github by asking for new configurations.
