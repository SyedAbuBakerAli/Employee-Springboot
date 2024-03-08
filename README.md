Tech Stack -> SpringBoot and MongoDB


create mydb database in mongodb then
Open This Project on intellij and open pom.xml file and on right corner you saw one circle 
button to download all maven dependency for project then navigate EmployeeDbApplication file
to start project.


Implement all Entry Level and Intermediate Level API End Points.

Entry Level
a. Add Employee -  http://localhost:8080/addemployee
b. Get All Employees - http://localhost:8080/employees
c. Delete Employee  - http://localhost:8080/delete/( pass employeeId)
d. Update Employee - http://localhost:8080/update  (also pass employeeId in Json body)

Intermediate Level

a. Get nth Level - http://localhost:8080/employees/manager?employeeId=(employeeId)&level=(level example 1)
b. Get Employees with Pagination and Sorting - http://localhost:8080/employees?page=1
page size is 5 so after adding 6 employee data you will se one data at page 1
