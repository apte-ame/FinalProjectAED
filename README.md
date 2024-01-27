# AED Final Project

## Team Members - 
Ameya Apte, Aditya Sawant, Nainil Maladkar

Nice Job is a one stop solution where students can view and apply to the job listings by the companies and also look for apartments listed by apartment rental enterprises.

It consists of 4 enterprises namely Universities, Companies, Government Services and House Rental Services.

**University Enterprise -** 
- It consists of Colleges where every college has its own Exam Cell, College Departments, and Career Advisor. Students are a part of departments.
- Exam Cell registers a student and creates student profile.
- Career Advisor verifies student on the basis of GPA and student's semester and accordingly grants or revokes student's access to Job listings
- Student can access the house rental listings and submit request for renting a particular apartment. Morever student has the access to the personal details as registered by the Exam cell. Registered students who have access to Job-Listings can apply to the jobs listed by the companies and also view the status of the applied jobs. 

**Company Enterprise -**
- It consists of Job-Listing Team, Interview Panel and HR Department.
- Job-Listings are posted by the Job-Listings Team.
- Once any student applies to a particular job their application gets reflected to the Interview Panel. Interview Panel decides the further status. If the student is accepted, the application goes to HR Department. The status of the application is reflected back to the student. 
- HR Department views the accepted student details and redirects the application to respective Government for final verification. The government sends back successful verification clearance or suggests changes which need to be considered. HR department accordingly handles the suggested changes and sends it back to Government for re-verification. Once the Government sends back successful verification clearance, the HR department can mark the student 'accepted' and accordingly the student can view the status update.

**Government Enterprise -** 
- It consists of Details Verification Team and Analytics Panel.
- It performs the student details verification for all the requests sent by the Company HR and accordingly suggests changes or gives back clearance to HR department of the respective company.

**Housing Enterprise -**
- It consists of Rental Services Team.
- Rental Services Team posts the apartment listings which the student can view and apply.
- The team can also access the students applications and accept or reject the same.

Every enterprise mentioned above has a separate System Admin which can perform CRUD operations on each enterprise.

Our application has 4 features integrated namely -- email notification, webcam image capture, google maps API integration and analytics pane which has pie chart, bar graph and line graph.
- **Email notification -** student gets email notification for successful registration by the Exam Cell. Also the students status update by the Career Advisor is sent to student via email
- **Webcam image capture -** registered student is able to capture real-time photo using laptop webcam and update the student profile.
- **OpenStreet maps API -** map can be viewed and used for location selection in the housing enterprise and also in the student panel where student can apply to rent a house.
- **Analytics pane -** has bar graph and line graph where the government can view average hourly rate v/s role and average hourly rate v/s level respectively. Also pie chart can be viewed by the government which gives the nation wise and city wise student count

We have used MySQL online database hosted by remotemysql.com which can be accessed using PHPMyAdmin

## Class and Sequence Diagram -
Below are the Class Diagram and Sequence Diagram for our application.

**CLASS DIAGRAM**

![alt text](https://github.com/sawant-adit/FinalProjectAED/blob/main/NiceJobApp/src/Images/AED_Final_Project_Class_Diagram.jpg?raw=true)

The Class diagram shows the structure of the application by showing the application's classes, their attributes, operations, and the relationships among objects.

**SEQUENCE DIAGRAM**

![alt text](https://github.com/sawant-adit/FinalProjectAED/blob/main/NiceJobApp/src/Images/AED_Final_Project_Sequence_Diagram.png?raw=true)

Flow of the data in the application is illustrated above. Different Admin operations are also illustrated in the diagram.
