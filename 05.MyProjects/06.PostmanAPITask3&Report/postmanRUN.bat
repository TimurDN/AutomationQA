@echo off

cd "Postman REST API Testing&Newman Report"       <----- NAME OF THE FOLDER

newman run "APITests.postman_collection.json" -e "ZettaEnvironment.postman_environment.json" --reporters cli,htmlextra

echo Postman collection execution completed.