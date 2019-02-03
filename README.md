# rosbank-test

Данный jar повторяет часть API morpher.ru
http://morpher.ru/java/

А именно:
-умеет склонять словосочетание "воздушный шар"
-пытается определить род и число у существительных и прилагательных
-называть падеж и род для форм словосочетания "воздушный шар"
-выделять компоненты ФИО, но только в определённом порядке.

При этом названия классов, enum и пр. совпадают с morpher (чтобы не писать здесь описание).
Что нужно сделать:
Нужно написать вёб-сервис, который сможет предоставлять через HTTP данное API
Вёб-сервис должен быть REST
Желательно использовать Spring boot и Spring WS
Если хватит времени, то необходимо реализовать Basic Authentication
Обязательно написание тестов, полностью покрывающих API Сервиса

Примеры запросов:
@GetMapping("/gender")
http://localhost:8080/russian/message/gender?input=%D0%A1%D0%B5%D1%80%D0%B3%D0%B5%D0%B9

@GetMapping("/changeGender")
http://localhost:8080/russian/message/changeGender?input=%D0%92%D0%BE%D0%B7%D0%B4%D1%83%D1%88%D0%BD%D1%8B%D0%B9&toGender=Feminine

@GetMapping("/caseDefinition")
http://localhost:8080/russian/message/caseDefinition?formCase=Nom&isPlural=true

@GetMapping("/fio")
http://localhost:8080/russian/message/fio?input=%D0%9F%D1%83%D1%88%D0%BA%D0%B8%D0%BD%20%D0%90%D0%BB%D0%B5%D0%BA%D1%81%20%D0%A1%D0%B5%D1%80%D0%B3%D0%B5%D0%B5%D0%B2%D0%B8%D1%87
