# TicketingSystemApplication
Project ini bertema tentang ticketing system. Dimana terdapat suatu perusahaan yang membutuhkan ticketing system untuk internal office saat
karyawan membutuhkan bantuan pelayanan tim teknis. Hal ini dapat berupa seperti perbaikan server, kebutuhan alat-alat kerja IT, perbaikan internet, dan lainnya yang akan membantu kinerja perusahaan.
Flow project ini sederhana yaitu CRUD employee dan CRUD ticket. Database SQL yang digunakan sudah disertakan di dalam project ini dengan nama Ticket.
Untuk melakukan testing, saya menggunakan Aplikasi Postman dengan URL, Method, dan Body.

<!--- If we have only one group/collection, then no need for the "ungrouped" heading -->


## Variables

| Key | Value | Type |
| --- | ------|-------------|
| base_url | localhost:8081 | string |



## Endpoints

* [Employee](#employee)
    1. [Menampilkan Seluruh Data Employee](#1-menampilkan-seluruh-data-employee)
    1. [Menambahkan Employee](#2-menambahkan-employee)
    1. [Update Employee](#3-update-employee)
    1. [Delete Employee](#4-delete-employee)
    1. [Menampilkan Seluruh Data Employee Technical Support](#5-menampilkan-seluruh-data-employee-technical-support)
    1. [Menampilkan Technical Support yang sedang bekerja](#6-menampilkan-technical-support-yang-sedang-bekerja)
    1. [Menampilkan Technical Support yang tidak bekerja](#7-menampilkan-technical-support-yang-tidak-bekerja)
* [Ticket](#ticket)
    1. [Menampilkan Seluruh Ticket](#1-menampilkan-seluruh-ticket)
    1. [Menambahkan Ticket](#2-menambahkan-ticket)
    1. [Update Ticket](#3-update-ticket)
    1. [Delete Ticket](#4-delete-ticket)
    1. [Menampilkan Ticket Berdasarkan Id](#5-menampilkan-ticket-berdasarkan-id)
    1. [Update Ticket Menjadi Canceled](#6-update-ticket-menjadi-canceled)
    1. [Update Ticket Menjadi Completed](#7-update-ticket-menjadi-completed)
    1. [Menampilkan Ticket History](#8-menampilkan-ticket-history)
    1. [Menampilkan Ticket Berdasarkan Duedate](#9-menampilkan-ticket-berdasarkan-duedate)
    1. [Menampilkan Ticket History Berdasarkan Status](#10-menampilkan-ticket-history-berdasarkan-status)
    1. [Menampilkan Ticket History Berdasarkan Urgency](#11-menampilkan-ticket-history-berdasarkan-urgency)

--------



## Employee



### 1. Menampilkan Seluruh Data Employee



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/employee/getAllEmployee
```



### 2. Menambahkan Employee



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/employee/insert
```



***Body:***

```js        
{
    "id" : "M03",
    "firstName" : "Kurnia",
    "lastName" : "Wijaya",
    "birthDate" : "06 September 1995",
    "phone" : "081294733849",
    "jobId" : "3"
}
```



### 3. Update Employee



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/employee/update/A01
```



***Body:***

```js        
{
    "firstName" : "Silla",
    "lastName" : "Aprilia",
    "birthDate" : "29 Juli 1998",
    "phone" : "081294857760"
}
```



### 4. Delete Employee



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/employee/delete/A03
```



### 5. Menampilkan Seluruh Data Employee Technical Support



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/employee/get-all-ts
```



### 6. Menampilkan Technical Support yang sedang bekerja



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/employee/get-all-ts-working
```



### 7. Menampilkan Technical Support yang tidak bekerja



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/employee/get-all-ts-not-work
```



## Ticket



### 1. Menampilkan Seluruh Ticket



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/ticket/getAllTicket
```



### 2. Menambahkan Ticket



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/ticket/insert
```



***Body:***

```js        
{
    "id" : "TC005",
    "title" : "Menggantikan modem pada ruangan 9",
    "details" : "Diperlukan karena modem yang saat ini sedang tidak berfungsi semestinya",
    "dueDate" : "13 Juni 2022",
    "urgency" : "HIGH",
    "createdById" : "A02",
    "appointedToId" : "T02"
}
```



### 3. Update Ticket



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/ticket/update/TC004
```



***Body:***

```js        
{
    "title" : "Perbaikan Server Lt. 5",
    "details" : "Server mengalami RTO setiap beberapa jam, kendala awalnya mulai saat suhu ruangan < 20 celcius",
    "dueDate" : "12 Juni 2022",
    "urgency" : "HIGH"
}
```



### 4. Delete Ticket



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/ticket/delete/TC004
```



### 5. Menampilkan Ticket Berdasarkan Id



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/ticket/getTicketById/TC003
```



### 6. Update Ticket Menjadi Canceled



***Endpoint:***

```bash
Method: PUT
Type: 
URL: {{base_url}}/ticket/updateCanceled/TC004
```



### 7. Update Ticket Menjadi Completed



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/ticket/updateCompleted/TC003
```



***Body:***

```js        
{
    "description" : "Kendala terselesaikan dengan reset server dan melakukan maintenance",
    "completedDate" : "16 Januari 2022",
    "approvedById" : "M01"
}
```



### 8. Menampilkan Ticket History



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/ticket/getAllTicketHistory
```



### 9. Menampilkan Ticket Berdasarkan Duedate



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/ticket/get-all-date/2022
```



### 10. Menampilkan Ticket History Berdasarkan Status



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/ticket/get-all-status/COMPLETED
```



### 11. Menampilkan Ticket History Berdasarkan Urgency



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/ticket/get-all-urgency/MEDIUM
```



---
[Back to top](#ticketing_system_application)
