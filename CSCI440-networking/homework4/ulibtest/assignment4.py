David Schirduan                          10-6-11
Assignment 4

import urllib2, cookielib, urllib
##commands must have URL first, Form info next, and cookies last.
URL = sys.argv[1:]
forminfo = sys.argv[2:]
cookieinput = sys.argv[3:]
##default settings that work.
cj = cookielib.CookieJar()
opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cj))
opener.addheaders = [(cookieinput, 'gogs=1')]
page = opener.open(url
##page = opener.open('http://aspeno.csatcofc.info/httptest.php?dogs=3&cats=0')
print page.read()
for cookie in cj:
        print cookie

form = urllib.urlencode({'inputstring': form})
##default settings that work.
##form = urllib.urlencode({'inputstring': 'Atlanta, GA'})
response = opener.open(URL, form)



print response ##is this supposed to be something readable? because mine is just gibberish.
        
