## hello.py
from mod_python import apache

def index(req):
    req.content_type = 'text/plain'
    req.write('Hello world from mod_python\n')
#    return apache.OK
