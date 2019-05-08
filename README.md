# vivi

Ablauf/Import:
1. bootRun
2. Import data.sql (src/main/resources, DB-Name= vivis)
3. ddl-auto ausklammern

Die Dummy-Daten können/müssen noch erweitert werden.
Was zum Beispiel noch fehlt: Certificate
Beim ongoing_exam sind die certificate_id und user_id noch null und müssen für die Präsentation noch nachgetragen werden (am besten direkt im data.sql).

Damit die Testdaten nach einem Neustart nicht mehr verschwinden, einfach im application.properties folgendes mit einem # auskommentieren: spring.jpa.hibernate.ddl-auto=create-drop