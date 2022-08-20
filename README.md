# DDD Challenge
## Coffee House - Client Experience
### _By: Sofía Idárraga_

---
This repository contains the solution for DDD Challenge.

Here you will find the code implementation of the Model Domain solution.

You can find the diagrams of the problem here:
- [Diagrams](https://drive.google.com/file/d/1AxmTm0ZvmSWHiCkKMkenemRctcQIl4Ta/view?usp=sharing)

"Customer Feelings & Experiences" (CF&E) encompasses everything from product discovery to attraction, interaction, the feeling provided and transmitted, 
purchase, use, dependence and promotion of the product. In other words, it is the buyer's entire shopping experience, including his or her emotions 
about the process and the product" That's why Coffee Houses such as Starbucks, Urbania (Medellín), Rituales(Medellín) not only focus their customer experience 
in the sales but also in activities such as workshops and courses for their customers.

For that reason, in this project I model the **User Experience** bounded context. Selecting **two aggregates:**
- Sale: the basic activity of the user experience.
- Course: an important activity that many of the Coffee Houses are implementing in order to create more customer experiences

Each of these aggregates contains **three Entities**

- Sale:
    - Barista: The people who creates the experience for the client making the coffee, the drinks and the food.
    - Product: Is the object such as a drink, a pastry, a coffee. Any of the stuff sold in the Coffee Shop.
    - Client: Is the people who receive the experience. Sometimes there are more than one client in the same Sale.

- Course:
    - Instructor: An expert who guide the course, giving the experience.
    - Material: Are all the stuff required to make the activity, their permit to make the experience.
    - Attendee: Is the people who receive the experience.

Also you will find the value objects, the behaviors, domain events and other DDD elements that allows to make the solution.

---
## Installation

Download the project, open it in *IntelliJ Idea*. Wait until
all the dependencies are downloaded. Then you can run the tests
