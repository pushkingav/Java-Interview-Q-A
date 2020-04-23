1. Может ли объект File соответствовать файлу, которого еще нет?  
Может. Объект `File` это не файл на файловой системе компьютера, а просто Java-объект, хоть и имеющий определенные 
свойства, например путь. При создании пустого файла так и происходит.

2. Как преобразовать объект File к типу Path?
    ```
    File file = new File("c:\\temp\\temp.txt");
    Path p = file.toPath();
    ```
3. Зачем нужен класс Files?
Класс `Files` это утилитный класс, в который вынесены статические методы класса File начиная с Java 7. Там собраны 
методы типа `createFile(...)`, `createTempFile(...)`, `isDirectory(...)` и т.п.  
[Collections->lvl01->lecture03](https://javarush.ru/quests/lectures/questcollections.level01.lecture03)
4. Какие классы для архивации вы знаете?  
`ZipInputStream` и `ZipOutputStream`.
[Collections->lvl01->lecture05](https://javarush.ru/quests/lectures/questcollections.level01.lecture05)
5.	Как добавить директорию в архив?  
    1. Создать ZipOutputStream для директории.  
    2. Пройтись в цикле по всем файлам из директории  
    3. Каждый файл добавить в архив.  
6.	Зачем нужны Properties?  
`Properties` нужны для хранения параметров, которые не следует хардкодить внутри программы. 
Например, если твое ПО снимает показатели погоды вокруг твоей дачи, архивирует данные на диск и отправляет тебе на 
е-мейл каждый час, то твой е-мейл, папку для архивации и много чего еще удобно и принято хранить в файле 
`application.properties`.  
[Collections->lvl01->lecture09](https://javarush.ru/quests/lectures/questcollections.level01.lecture09)
7.	В каком виде хранятся данные в файле `.properties`?  
В виде пар ключ-значение, например так:  
        ```
            server.port=8443
            server.ssl.enabled=true
            ts.rabbitmq.ui-queue-message-ttl=15000
            ts.rabbitmq.ui-queue-expires=60000
            ts.rabbitmq.use-ssl=false
        ```
8.	Можно ли изменять данные в объекте Properties после загрузки их из файла?
9.	Зачем нужен класс FileReader?
10.	Зачем нужен класс FileWriter?