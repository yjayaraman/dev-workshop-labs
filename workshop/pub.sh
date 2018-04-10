#!/bin/bash
rm -rf public/*
touch pub.sh
hugo
cd public
cf login -a https://api.run.pivotal.io -u yjayaraman@pivotal.io
cf push raytheon -m 128M
cf d raytheon2
cd ..
hugo server --watch
