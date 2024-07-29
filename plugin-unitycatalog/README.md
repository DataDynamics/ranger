# Install Plugin Unity Catalog

```shell
cd ${PROJECT_ROOT}/plugin-unitycatalog/src/main/resources/service-defs
curl -v -X POST -u 'admin:rangerR0cks!' \
 -H 'Accept: application/json' \
 -H 'Content-Type: application/json' \
 http://localhost:6080/service/plugins/definitions \
 --data @ranger-servicedef-unitycatalog.json | jq .
```

```text
m2:~/projects/dd_ranger/plugin-unitycatalog/src/main/resources/service-defs % curl -v -X POST -u 'admin:rangerR0cks!' \
> -H 'Accept: application/json' \
> -H 'Content-Type: application/json' \
> http://localhost:6080/service/plugins/definitions \
> --data @ranger-servicedef-unitycatalog.json | jq .
Note: Unnecessary use of -X or --request, POST is already inferred.
* Host localhost:6080 was resolved.
* IPv6: ::1
* IPv4: 127.0.0.1
*   Trying [::1]:6080...
* Connected to localhost (::1) port 6080
* Server auth using Basic with user 'admin'
> POST /service/plugins/definitions HTTP/1.1
> Host: localhost:6080
> Authorization: Basic YWRtaW46cmFuZ2VyUjBja3Mh
> User-Agent: curl/8.6.0
> Accept: application/json
> Content-Type: application/json
> Content-Length: 2950
> 
< HTTP/1.1 200 OK
< Set-Cookie: RANGERADMINSESSIONID=990A4AB71F7C952177C884A7A563A0B4; Path=/; HttpOnly
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< X-Frame-Options: DENY
< X-XSS-Protection: 1; mode=block
< Strict-Transport-Security: max-age=31536000; includeSubDomains; preload
< Content-Security-Policy: default-src 'none'; script-src 'self' 'unsafe-inline' 'unsafe-eval'; connect-src 'self'; img-src 'self'; style-src 'self' 'unsafe-inline';font-src 'self'
< X-Permitted-Cross-Domain-Policies: none
< X-Content-Type-Options: nosniff
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Mon, 29 Jul 2024 07:08:09 GMT
< Server: Apache Ranger
< 
* Leftovers after chunking: 12 bytes
* Connection #0 to host localhost left intact
{
  "id": 206,
  "guid": "324e7dcf-42f9-47f6-a510-6cd7d51aa323",
  "isEnabled": true,
  "createdBy": "Admin",
  "updatedBy": "Admin",
  "createTime": 1722236889158,
  "updateTime": 1722236889160,
  "version": 1,
  "name": "unitycatalog",
  "displayName": "Unity Catalog",
  "implClass": "org.apache.ranger.services.uc.RangerServiceUC",
  "label": "UnityCatalog",
  "description": "OSS Unity Catalog",
  "options": {
    "enableDenyAndExceptionsInPolicies": "true"
  },
  "configs": [
    {
      "itemId": 1,
      "name": "username",
      "type": "string",
      "mandatory": true,
      "label": "Username"
    },
    {
      "itemId": 2,
      "name": "password",
      "type": "password",
      "mandatory": true,
      "label": "Password"
    },
    {
      "itemId": 3,
      "name": "uc.url",
      "type": "string",
      "mandatory": true,
      "defaultValue": "http://localhost:8080",
      "validationRegEx": "^https?://\\S+$",
      "validationMessage": "Must starts with http[s]://",
      "label": "Unity Catalog URL"
    }
  ],
  "resources": [
    {
      "itemId": 1,
      "name": "catalog",
      "type": "string",
      "level": 10,
      "mandatory": true,
      "lookupSupported": true,
      "recursiveSupported": false,
      "excludesSupported": false,
      "matcher": "org.apache.ranger.plugin.resourcematcher.RangerDefaultResourceMatcher",
      "matcherOptions": {
        "wildCard": "true",
        "ignoreCase": "false"
      },
      "label": "Catalog",
      "description": "Catalog",
      "isValidLeaf": false
    },
    {
      "itemId": 2,
      "name": "schema",
      "type": "string",
      "level": 20,
      "parent": "catalog",
      "mandatory": true,
      "lookupSupported": true,
      "recursiveSupported": false,
      "excludesSupported": false,
      "matcher": "org.apache.ranger.plugin.resourcematcher.RangerDefaultResourceMatcher",
      "matcherOptions": {
        "wildCard": "true",
        "ignoreCase": "false"
      },
      "label": "Schema",
      "description": "Schema",
      "isValidLeaf": false
    },
    {
      "itemId": 3,
      "name": "table",
      "type": "string",
      "level": 30,
      "parent": "schema",
      "mandatory": true,
      "lookupSupported": true,
      "recursiveSupported": false,
      "excludesSupported": false,
      "matcher": "org.apache.ranger.plugin.resourcematcher.RangerDefaultResourceMatcher",
      "matcherOptions": {
        "wildCard": "true",
        "ignoreCase": "false"
      },
      "label": "Table",
      "description": "Table",
      "isValidLeaf": true
    }
  ],
  "accessTypes": [
    {
      "itemId": 1,
      "name": "select",
      "label": "Select"
    },
    {
      "itemId": 2,
      "name": "update",
      "label": "Update"
    },
    {
      "itemId": 3,
      "name": "create",
      "label": "Create"
    },
    {
      "itemId": 4,
      "name": "drop",
      "label": "Drop"
    },
    {
      "itemId": 5,
      "name": "alter",
      "label": "Alter"
    },
    {
      "itemId": 6,
      "name": "all",
      "label": "All",
      "impliedGrants": [
        "select",
        "update",
        "create",
        "drop",
        "alter"
      ]
    }
  ],
  "policyConditions": [
    {
      "itemId": 1,
      "name": "_expression",
      "evaluator": "org.apache.ranger.plugin.conditionevaluator.RangerScriptConditionEvaluator",
      "evaluatorOptions": {
        "ui.isMultiline": "true"
      },
      "uiHint": "{ \"isMultiline\":true }",
      "label": "Enter boolean expression",
      "description": "Boolean expression"
    }
  ],
  "dataMaskDef": {},
  "rowFilterDef": {}
}
```

Ranger Admin Web UI 의 log 경로는 `/var/log/ranger/ranger-admin-ranger.example.com-.log`
