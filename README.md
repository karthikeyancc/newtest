#File System REST Application

#Design
This Web application embraces REST interface
This uses Spring boot to provide web layer
This has a controller layer where the REST request from browser is received and response is delevered using JSON
This application uses a service layer which talks to local file system to get the information of any given file / directory

#Assumptions
This web application runs in the port 8080
This handles only regular files/directories.
This does not deal with character/block system files, does not follow through linked files.
This provides response only in JSON format
This uses "/fs" as the REST endpoint
This endpoint take name as a query parameter
If this parameter is not provided, text/plain response of "Invalid request" is sent out
If the file name mentioned using parameter is not available in the file system, then text/plain response of "Invalid Request" is sent out
This can handle both absolute path and relative paths
Relative path should be with respect to the directory from where this spring boot application is run.

#Deployment
Application can be started using "./mvnw spring-boot:run" from the project directory

