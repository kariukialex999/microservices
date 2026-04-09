@echo off
cd /d C:\Users\kariu\IdeaProjects\Inventory-service
echo Starting Inventory Service...
echo.
echo Access Swagger UI at: http://localhost:8081/swagger-ui.html
echo Access API Docs at: http://localhost:8081/api-docs
echo.
java -jar target/Inventory-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=default
pause
