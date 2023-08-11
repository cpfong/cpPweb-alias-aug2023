#!/usr/local/bin/python

# ref
#https://api.tej.com.tw/document_python.html
#try secret code apply from https://api.tej.com.tw/trial.html

import tejapi

tejapi.ApiConfig.api_key = "FAKE-fake-do-NOT-useME"
tejapi.ApiConfig.ignoretz = True
info = tejapi.ApiConfig.info()

print(info)
