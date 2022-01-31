import string    
import random # define the random module  
S = 10  # number of characters in the string.  
# call random.choices() string module to find the string in Uppercase + numeric data.  

N = 10000000    
with open('src/analisis/10M.txt', 'a') as the_file:
   for i in range (N):
      ran = ''.join(random.choices(string.ascii_uppercase + string.digits, k = S))
      the_file.write(ran+'\n')

   
