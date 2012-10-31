1) Legg til i standalone.xml:

<drivers>
    <driver name="mysql" module="com.mysql"/>
</drivers>

2) Last ned mysql-connector-java-5.1.22-bin.jar og legg den sammen med module.xml
inn i jboss7\modules\com\mysql\main

module.xml:

<?xml version="1.0" encoding="UTF-8"?>

<module xmlns="urn:jboss:module:1.0" name="com.mysql">
  <resources>
    <resource-root path="mysql-connector-java-5.1.22-bin.jar"/>
  </resources>
  <dependencies>
    <module name="javax.api"/>
  </dependencies>
</module>

3) Last ned mysql og lag databasen book_db, brukeren <username> og gi den grants
create database BOOK_DB
CREATE USER '<username>'@'localhost' IDENTIFIED BY '<password>';
use book_db
GRANT ALL PRIVILEGES ON *.* TO 'myuser'@'%' WITH GRANT OPTION;

se på grants med
SHOW GRANTS FOR 'frode'@'localhost';
