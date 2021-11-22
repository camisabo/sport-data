from io import StringIO
from os import urandom
import string
import random

N = 100
n = 10000
f = open("analisis.txt", "a")
for i in range (n):
    f.write(''.join(random.SystemRandom().choice(string.ascii_uppercase + string.digits) for _ in range(N)))

f.close()
