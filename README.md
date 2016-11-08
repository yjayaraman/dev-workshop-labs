# dev-workshop-labs
Content for running the labs portion of Cloud Native Dev Workshop.

## Getting the workshop content

1. Git clone the repository. If you don't have GitHub account, you can download it from https://github.com/yjayaraman-pivotal/dev-workshop-labs/archive/master.zip

    $ git clone https://github.com/yjayaraman-pivotal/dev-workshop-labs.git

2. Each lab has a `final` folder and an `initial` folder. You can start with the `initial` folder of lab and complete the lab with that, or the you may choose to skip a lab and just run it from the `final` folder. 
    
3. `pre-built` consists of jars that are already pre-built. 
  + **If you want to avoid building app with Maven, use this for situations where the participant does not have Maven installed or in a restricted env where the dependecies cannot be downloaded, you can use the pre-built wars/jars directly from pre-built folder in the repository**

  + Otherwise you need an installation of [Maven](https://maven.apache.org/) to build and run the labs
