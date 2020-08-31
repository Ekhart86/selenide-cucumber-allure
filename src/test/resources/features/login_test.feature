#language: ru
@all

Функция: Авторизация в приложении

  @loginPass
  Сценарий: Успешная авторизация
    Когда открываем страницу "http://the-internet.herokuapp.com/login"
    Когда авторизуемся в приложении с логином "tomsmith" и паролем "SuperSecretPassword!"
    Тогда пользователь успешно авторизовался
