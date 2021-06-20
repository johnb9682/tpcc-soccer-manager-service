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

## Frequently Used Git Commands
add: `git add <filename>`, `git add -A`
commit: `git commit -m “add message here to describe this commit”`
pull: `git pull`
push: existing in remote: `git push`; new branch: `git push -u origin <branch name>`
