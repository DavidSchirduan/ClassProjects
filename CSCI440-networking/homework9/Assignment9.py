#David Schirduan 12-8-11 Assignment 9.py
#connect to stono and print out the file structure
import paramiko
class AllowAnythingPolicy(paramiko.MissingHostKeyPolicy):
    def missing_host_key(self, client, hostname, key):
        return

if (len(sys.argv) > 1):
        Args = (sys.argv[1]).split(';') # create a list of the things passed in through the command line
        uname = Args[0]
        pwrd = Args[1]

client = paramiko.SSHClient()
client.set_missing_host_key_policy(AllowAnythingPolicy())
client.connect('stono.cs.cofc.edu', username=uname, password=pwrd)
for command in 'echo "Hello, world!"', 'uname', 'uptime', 'ls -R': #command to list all directories
    stdin, stdout, stderr = client.exec_command(command)
    stdin.close()
    print repr(stdout.read())
    stdout.close()
    stderr.close()
client.close()
