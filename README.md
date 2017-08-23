# ING ATMs test

### How to run
#### Setup Database
Before deployment setup database on your mysql server.

Run the schema.sql file, This script file contain database creation script and required oauth table creation script.

Run the testdata.sql file, This script file contain required test data for oauth.

#### Deployment
Build and deploy the project on tomcat server.

#### Call Rest endpoint
After artifact is deployed successfully, call oauth endpoint <b>oauth/token</b> by passing valid credentials, grant type and authorization header, this call will return the oauth token for accessing other resource APIs.
As we will need to authorize our requests to the resource using our access token, we will append a simple authorization header with access token:

<b>Note: Currently spring oauth will work only with rest calls.</b>






