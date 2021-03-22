#Spring Boot project to find longest palindromic substring


1. Database configuration:<br />
database username: springstudent<br />
database password: springstudent<br />
database name: palindromic_substring_problem<br />
table name: palindromicsubstr<br />
Table has three columns: id(PK), input_str, answer(longest palindromic substring in input_str)<br/>
Refer to palindromesub.sql


2. api<br />
http://localhost:8080/api/palindrome?term={term}: <br />
POST: store the longest palindrome in provided database, client need to put input string in request parameter, it will 
return JSON {id, input, answer} to client <br/>
GET: return the stored longest palindrome, client need to put input string in request parameter, it will return a 
string to client, if client never POST the input string before, it will return 404.


#BinaryReversal
Refer to Main.java under root directory
