#!/bin/bash
touch pub2.sh
hugo
cd public
cf login -a https://api.run.pivotal.io -u yjayaraman@pivotal.io
cf push raytheon2 -n raytheon -m 128M
cf d raytheon
cd ..
hugo server --watch
