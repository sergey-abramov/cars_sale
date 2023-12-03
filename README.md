# CarSale

## О проекте

---

Проект представляет собой сайт по продаже машин. В проекте используются: maven, spring boot, thymeleaf, liquibase.
На сайте будут объявления. В объявлении имеются поля: описание, марка машины, тип кузова, фото.
Объявление имеет статус продано или нет.

---

### Блок аутентификации

Аутентификация в приложении выполнена с помощью Spring Security в связке с Thymeleaf. Имя пользователя в приложении 
Thymeleaf получает из httpServletRequest:
![](https://github.com/sergey-abramov/cars_sale/blob/b74e2ba27726f32b8de8ff8e3605e208ec6ff098/files/project/httpServletRequest.PNG)

_**Страница входа**_:
![ ](https://github.com/sergey-abramov/cars_sale/blob/b74e2ba27726f32b8de8ff8e3605e208ec6ff098/files/project/login_page.png)

_**Страница регистрации**_:

Страница регистрации имеет выбор часового пояса, для коректного отображения даты и времени создания поста.
![](https://github.com/sergey-abramov/cars_sale/blob/b74e2ba27726f32b8de8ff8e3605e208ec6ff098/files/project/reg_page.png)

_**Страница атворизованного пользователя**_:

После авторизации пользователь получает дополнительный функионал: добавление поста и его изменение.
![](https://github.com/sergey-abramov/cars_sale/blob/b74e2ba27726f32b8de8ff8e3605e208ec6ff098/files/project/authentication.png)

