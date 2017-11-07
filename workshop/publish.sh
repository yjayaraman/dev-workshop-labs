#!/bin/bash
hugo
cd public
pws
cf push raytheon -m 128M
cd ..
hugo server --watch
