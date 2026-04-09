@echo off
cd /d C:\Users\kariu\IdeaProjects\Inventory-service
echo Starting Inventory Service...
echo.
java -jar target/Inventory-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=default
pause
