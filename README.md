# tpcc-soccer-manager-service
Spring Boot backend service

## Start Spring Boot Application
```dtd
//setup
sudo apt-get update
sudo apt-get install openjdk-11-jdk
git clone https://github.com/johnb9682/tpcc-soccer-manager-service.git

//update
cd tpcc-soccer-manager-service
git pull origin

//run
./gradlew bootRun
./gradlew --daemon bootRun
ssh ubuntu@13.250.52.217  -i trip-planner-key-pair.pem
ps -ef | grep gradle
nohup ./gradlew bootRun >Output.log 2>&1 &
kill -9 "数字"
```

## API Docs
http://localhost:8081/swagger-ui.html  

## Frequently Used Git Commands
Action | Git Command
--- | --- | 
check status| `git status`.  
add| `git add <filename>`, `git add -A`.  
commit| `git commit -m “add message here to describe this commit”`.  
pull| `git pull`.  
push (for an existing branch in remote)|  `git push`.  
push (for a new branch)| `git push -u origin <branch name>`.  
list local branches| `git branch`.  
checkout a branch| `git checkout xxx_branch`.  
merge a branch to another| `git merge xxx_branch`.  
delete a local branch| `git branch -d xxx_branch`.  
create a new branch (shortcut)| `git checkout -b new_branch_name`.  

## File Sturcture:
* `config` (NOT ADVISED TO CHANGE): API doc configs.
*  `controller`: API Interface definitions.
*  `dao`: Connection to the database.  
*  `dto`: Parameter definitions for `request` and `response`.  
*  `entity`: Entity definitions corresponding to the database tables.  
*  `service`: Business logics for APIs.  
*  `Application`(NOT ADVISED TO CHANGE): Main driver of the application.  
