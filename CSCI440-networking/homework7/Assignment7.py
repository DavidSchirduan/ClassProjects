#David Schirduan 12-7-11 Networking Assignment 7

import sys,urllib, urllib2, json
#going to save data in a single variable
data = ''

if (len(sys.argv) > 1): url = sys.argv[1] #first pass in the url to pass data to
if (len(sys.argv) > 2):
	formArgs = (sys.argv[2]).split(';') # create a list of the things passed in through the command line
	formData = json.dumps(dict([(('form%d' %formArgs.index(formArg)), formArg) for formArg in formArgs]))

req = urllib2.Request(url, formData)
page = urllib2.urlopen(req)
print page.read()

