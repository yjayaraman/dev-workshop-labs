#!/bin/bash
set -ex

# vars to define
ZONE_ENDPOINT =  http://localhost:8080
#eg freddys-bbq.login.systemdomain.com
ZONEADMIN_CLIENT_ID = admin-portal
ZONEADMIN_CLIENT_SECRET = secret


uaac target $ZONE_ENDPOINT --skip-ssl-validation
uaac token client get $ZONEADMIN_CLIENT_ID -s $ZONEADMIN_CLIENT_SECRET
uaac user add frank --email frank@whitehouse.gov --given_name Frank --family_name Underwood -p password
uaac user add freddy --email freddy@freddysbbq.com --given_name Freddy --family_name Hayes -p password
uaac group add menu.read
uaac group add menu.write
uaac group add order.admin
uaac group add order.me
uaac member add menu.read frank
uaac member add menu.read freddy
uaac member add menu.write freddy
uaac member add order.admin freddy
uaac member add order.me frank
