# Rogers_Marianne_Assign7.py
#
# Create a python client application that can take in form data
# and send it to a server side program (PHP, JSP, ASP, ASP.NET,
# Cold Fusion) using JSON or XML.  Your client should ask for 
# several fields and send the group on data in one request


import sys,urllib, urllib2, json
data = ''

if (len(sys.argv) > 1): url = sys.argv[1]
if (len(sys.argv) > 2):
	formArgs = (sys.argv[2]).split(';')
	formData = json.dumps(dict([(('form%d' %formArgs.index(formArg)), formArg) for formArg in formArgs]))

req = urllib2.Request(url, formData)
page = urllib2.urlopen(req)
print page.read()

