# TicketingSystemApplication
Project ini bertema tentang ticketing system. Dimana terdapat suatu perusahaan yang membutuhkan ticketing system untuk internal office saat
karyawan membutuhkan bantuan pelayanan tim teknis. Hal ini dapat berupa seperti perbaikan server, kebutuhan alat-alat kerja IT, perbaikan internet, dan lainnya yang akan membantu kinerja perusahaan.
Flow project ini sederhana yaitu CRUD employee dan CRUD ticket. Database SQL yang digunakan sudah disertakan di dalam project ini dengan nama Ticket.
Untuk melakukan testing, saya menggunakan Aplikasi Postman dengan URL, Method, dan Body.
Berikut untuk link Postman Documentation https://documenter.getpostman.com/view/20494928/Uz5MGZbi
Untuk penjelasannya sebagai berikut:
1. 	Find All Employee URL	: http://localhost8081/employee/getAllEmployee
    Method			: GET
	  Body				: -
2.	Insert New Employee URL	: http://localhost8081/employee/insert
	  Method			: POST
	  Body				: {"id" : "T04", "firstName" : "Bambang", "lastName" :  "Wijaya", "birthDate" : "04 Februari 1994", "phone" : "089723644820", "jobId" : "2"}
3.	Update Employee By Id URL: http://localhost8081/employee/update/A01
	  Method			: PUT
	  Body				: {"firstName" : "Silla", "lastName" : "Aprilia", "birthDate" : "29 Juli 1998", "phone" : "0813927388497"}
4.	Delete Employee By Id URL: http://localhost8081/employee/delete/A03
	  Method			: DELETE
	  Body				: -
5.	Find All Employee Technical Support	URL : http://localhost8081/employee/get-all-ts
	  Method			: GET
	  Body				: -
7.	Find All Employee Technical Support Yang Sedang Bekerja URL: http://localhost8081/employee/get-all-ts-working
	  Method			: GET
	  Body				: -
8.	Find All Employee Technical Support Yang Tidak Bekerja: http://localhost8081/employee/get-all-ts-not-work
	  Method			: GET
	  Body				: -
9.	Find All Ticket URL	: http://localhost8081/ticket/getAllTicket
	  Method			: GET
	  Body				: -
10.	Insert New Ticket URL	: http://localhost8081/ticket/insert
	  Method			: POST
	  Body				: {"id" : "TC005", "title" : "Menggantikan modem pada ruangan 17", "details" : "Diperlukan karena modem yang saat ini sedang tidak berfungsi semestinya", "dueDate" : "11 Juni 2022", "urgency" : "MEDIUM", "createdById" : "A01", "appointedToId" : "T02"}
11.	Update Ticket By Id URL	: http://localhost/ticket/update/TC001
	  Method			: PUT
	  Body				: {"title" : "Perbaikan Server Lt. 5", "details" : "Server mengalami RTO setiap beberapa jam, kendala awalnya mulai saat suhu ruangan < 20 celcius", "dueDate" : "11 Juni 2022", "urgency" : "HIGH"}
12.	Delete Ticket By Id URL	: http://localhost8081/ticket/update/TC005
	  Method			: DELETE
	  Body				: -
	  (Untuk ticket dengan status completed tidak dapat didelete)
13.	Find Ticket By Id URL	: http://localhost8081/ticket/getTicketById/TC002
    Method			: GET
    Body				: -
14.	Update Ticket To Canceled By Id URL	: http://localhost/ticket/updateStatus/TC003
    Method			: PUT
    Body				: -
14.	Update Ticket To Completed By Id URL	: http://localhost8081/ticket/updateStatus/TC003
    Method			: PUT
    Body				: -
15.	Find All Ticket History URL	: http://localhost8081/ticket/getAllTicketHistory
    Method			: GET
    Body				: -
16.	Find Ticket Berdasarkan Due Date URL	: http://localhost8081/ticket/get-all-date/2022
    Method			: GET
    Body				: -
    (Dapat menemukan berdasarkan tanggal, bulan, dan tahun)
17.	Find Ticket Berdasarkan Status URL	: http://localhost8081/ticket/get-all-status/IN_PROGRESS
    Method			: GET
    Body				: -
18.	Find Ticket Berdasarkan Urgency URL	: http://localhost8081/ticket/get-all-urgency/MEDIUM
    Method			: GET
    Body				: -
