+++
categories = ["general"]
date = "2016-05-06T07:14:45-04:00"
tags = ["document"]
title = "Lab Requirements"

+++

## Pre-Requisites 

1. Appropriate permissions to install software on your laptop. 

2. Internet Access. Internet access is required to take this course.  Students must be able to access
the labs environment at https://apps.run.haas-80.pez.pivotal.io to perform practical work.  Outbound access to this site over TCP ports 80 (http), 443 (https), 
and 4443 (websockets) is required.

3. Installation of [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

3. For the labs, we are using [Git](https://www.git-scm.com). If you do not have git, please install it and get familiar with it [Git Lessons]( https://try.github.io/levels/1/challenges/1 ). 

4. [Github account](https://github.com/) 

5. For the labs, you will need to have the materials cloned and track the `master`. This can be accomplished as follows:

    $ git clone https://github.com/yjayaraman-pivotal/dev-workshop-labs.git. If you don't have GitHub account, you can download it from https://github.com/yjayaraman-pivotal/dev-workshop-labs/archive/master.zip

    Each lab has a `final` folder and an `initial` folder. You can start with the `initial` folder of lab and complete the lab with that, or the you may choose to skip a lab and just run it from the `final` folder. 

  + **If you want to avoid building app with Maven, you can use the pre-built wars/jars directly from pre-built folder in the repository**

  + Otherwise you need an installation of [Maven](https://maven.apache.org/)

6. You will be pushing apps to Cloud Foundry. 

+ Check to see if you have a CLI already installed. Open a terminal/command window and type `cf --version`. If you see that you have an installed version of 6.x or greater, you can skip the install.

+ Otherwise, go to https://console.run.pivotal.io/tools. Download and run the installer for your platform. Optionally you can download it from https://github.com/cloudfoundry/cli/releases 

+ Verify your install by opening a terminal/command window and typing `cf --version`. You now have a Cloud Foundry client that can communicate with any Cloud Foundry installation.



## Optional (but recommended)

1. [STS](https://spring.io/tools)  

2. [JSON Formatter](https://chrome.google.com/webstore/detail/json-formatter/bcjindcccaagfpapjjmafapmmgkkhgoa?hl=en)



