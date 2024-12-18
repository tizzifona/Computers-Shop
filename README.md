# Computers Shop

## ✅Overview

This project models a Computer Shop, where the shop has certain attributes such as its name, owner, and tax identification number. The computers in the shop have attributes like brand, memory, processor details, operating system, and price. The program includes methods for managing computers in the shop, such as adding, deleting, searching, and listing computers.

## ✅Features

The program provides the following functionalities for managing the store and its computers:
- Add a computer to the shop.
- Remove a computer from the shop by its brand.
- Search for a computer by its brand.
- List all computers available in the store.

## ✅Technologies Used

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) 
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

## ✅Entities

- Store: Represents a store with attributes like name, owner, and taxId. It has a one-to-many relationship with computers.
- Computer: Represents a computer with attributes like brand, memory, processor, operatingSystem, and price. It is related to a store.

## ✅Endpoints

The project provides the following API endpoints:

Store Endpoints

``POST /stores/add``- Add a new store to the database. <br/>
``GET /stores/{id}``- Retrieve details of a store by its ID. <br/>
``GET /stores``- List all the stores in the database.

Computer Endpoints

``GET /computers``- List all computers in the store. <br/>
``POST /computers/add``- Add a new computer to the store. <br/>
``GET /computers/{brand}``- Find a computer by its brand. <br/>
``DELETE /computers/delete/{brand}``- Remove a computer from the store by its brand.

## ✅Database Models
The application uses JPA for persisting entities:

1. Computer:
- id (Long)
- brand (String)
- memory (int)
- processor (String)
- operatingSystem (String)
- price (double)
- store (ManyToOne, Store)

2. Store:
- id (Long)
- name (String)
- owner (String)
- taxId (String)

## ✅Contacts

<a href='https://www.linkedin.com/in/nadiia-alaieva/'><img src="https://i.postimg.cc/3RLmssnH/linkedin-3.png" alt="linkedin icon" width="30" height="30"></a>

