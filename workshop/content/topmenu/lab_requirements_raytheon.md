+++
categories = ["general"]
date = "2016-05-06T07:14:45-04:00"
tags = ["document"]
title = "Lab Requirements"

+++

## Pre-Requisites 

1. Appropriate permissions to install software on your laptop. 

2. Internet Access. Internet access is required to take this course.  

3. Java Developers
  1. Installation of [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). Open a terminal/command window and type `java -version`

  2. Install a Java IDE  -  Install [STS](https://spring.io/tools) `(recommended)`.  You can also use IntelliJ IDEA or Eclipse

  3. You need an installation of [Maven](https://maven.apache.org/)

4. `Optional (but recommended)` For the labs, we are using [Git](https://www.git-scm.com). If you do not have git, please install it and get familiar with it [Git Lessons]( https://try.github.io/levels/1/challenges/1 ). 

4. `Optional (but recommended)` [Github account](https://github.com/) 

5. For the labs, you will need to have the materials cloned and track the `master`. This can be accomplished as follows. From the command line:  

```
    cd <your preferred directory>
    git clone https://github.com/yjayaraman-pivotal/dev-workshop-labs.git
```
> If you don't have GitHub account, you can download it from https://github.com/yjayaraman-pivotal/dev-workshop-labs/archive/master.zip.
> Some of the labs have a `final` folder and an `initial` folder. You can start with the `initial` folder of lab and complete the lab with that, or the you may choose to skip a lab and just run it from the `final` folder. 

6. You will be pushing apps to Cloud Foundry. Students must be able to access the labs environment at https://apps.sys.mag.perfexel.com to perform practical work.  Outbound access to this site over TCP ports 80 (http), 443 (https), 
and 4443 (websockets) is required.   

7.  Check to see if you have a CLI already installed. Open a terminal/command window and type `cf --version`. If you see that you have an installed version of 6.x or greater, you can skip the next step.

8. `Need Admin Access on Windows` Go to https://console.run.pivotal.io/tools. Download and run the installer for your platform. Optionally you can download it from https://github.com/cloudfoundry/cli/releases 

9. Verify your install by opening a terminal/command window and typing `cf --version`. You now have a Cloud Foundry client that can communicate with any Cloud Foundry installation.

