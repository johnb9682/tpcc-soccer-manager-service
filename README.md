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
`Documentation`: http://13.213.77.131:8081/swagger-ui.html

`Local testing`: http://localhost:8081/swagger-ui.html

`Config Reference`: https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api

## Frequently Used Git Commands
Action | Git Command
--- | --- | 
check status| `git status`.  
add| `git add <filename>`, `git add -A`.  
commit| `git commit -m “add message here to describe this commit”`.  
pull| `git pull`.  
push (for an existing branch in remote)|  `git push`.  
push (for a new branch)| `git push -u origin <branch name>`.  
stash local changes| `git stash`.  
apply back stashed changes|`git stash apply`.  
list local branches| `git branch`.  
checkout a branch| `git checkout <branch name>`.  
merge a branch to current branch| `git merge <branch name>`.  
delete a local branch| `git branch -d <branch name>`.  
create a new branch based on current branch (shortcut)| `git checkout -b <new branch name>`.  

## File Sturcture:
* `config` (**NOT ADVISED TO CHANGE**): API doc configs.
*  `controller`: API Interface definitions.
*  `dao`: Connection to the database.  
*  `dto`: Parameter definitions for `request` and `response`.  
*  `entity`: Entity definitions corresponding to the database tables.  
*  `service`: Business logics for APIs.  
*  `Application`(**NOT ADVISED TO CHANGE**): Main driver of the application.  
