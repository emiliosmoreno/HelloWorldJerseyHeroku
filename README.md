HelloWorldJersey
=====================

Simple REST webapp from jersey documentation (enhanced to work on heroku with Jetty 8 - servlet 3)

Steps to publish on heroku (considering that you already have git installed and an heroku account created)


1. Clone this repository
2. Setup your SSL keys (fast track below )
     ssh-keygen -t rsa
     heroku login
     heroku keys:add    
3. Create the heroku app
     heroku create
4. Push the project to heroku
     git push heroku master
     "check the console for your webapp link"
5. Scale one web server
     heroku ps:scale web=1

Done.

Note:
Using the command below you can test your webapp localy.

java -jar server/jetty-runner.jar --port 8880  target/simple-service-webapp.war

Than access localhost:8880
