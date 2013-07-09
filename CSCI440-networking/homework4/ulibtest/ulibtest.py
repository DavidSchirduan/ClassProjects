import urllib2, cookielib
cj = cookielib.CookieJar()
opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cj))
opener.addheaders = [('Cookie', 'gogs=1')]
page = opener.open('http://aspeno.csatcofc.info/httptest.php?dogs=3&cats=0')
print page.read()
for cookie in cj:
        print cookie        