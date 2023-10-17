`18. September 2023` `neueFische - Jave Development Bootcamp`
# Mocking
## Theoretische Fragen
1. Was ist ein Mock und warum ist Mocking in der Softwareentwicklung wichtig? Gebt Beispiele, warum Mocking in Tests verwendet wird.
> Mocking in der Softwareentwicklung verwendet Mock-Objekte, um Abhängigkeiten zu simulieren, ermöglicht die Isolation von Codeeinheiten und schafft kontrollierte Testumgebungen. Es verbessert die Testeffizienz, ermöglicht die Simulation von Datenbanken, Netzwerken und Zeit und ist entscheidend für zuverlässige und wiederholbare Tests.

> Mocking in Tests wird verwendet, um Abhängigkeiten wie Datenbanken oder APIs zu simulieren. Dies ermöglicht die Isolation des zu testenden Codes, um effiziente und zuverlässige Tests durchzuführen, unabhängig von realen Ressourcen oder externen Faktoren. Mocks helfen, Testgeschwindigkeit zu verbessern und die Testumgebung besser zu kontrollieren.
2. Mockito haben wir heute kennengelernt. Welche anderen Mocking-Frameworks gibt es noch? 
> EasyMock, PowerMock, JMock
3. Warum sollte die zu testende Klasse in Unit-Tests nicht selbst gemockt werden? Was sind mögliche Probleme, wenn dies dennoch geschieht?
> In Unit-Tests sollten Sie die zu testende Klasse normalerweise nicht selbst mocken, da dies die Isolation des Tests beeinträchtigt und die Zuverlässigkeit verringert. Das Mocken Ihrer eigenen Klasse führt zu mangelnder Isolation, erschwert die Fehlererkennung, erfordert mehr Wartung und führt zu weniger realistischen Tests. Stattdessen sollten Sie externe Abhängigkeiten der Klasse mithilfe von Mocks simulieren, um die Testqualität und -zuverlässigkeit zu verbessern.

## Aufgaben
[Services Repository](https://github.com/Flooooooooooorian/ffm-java-23-1-servies)
1. Erstelle Unit-Tests für die
    ```
    findAllProducts Methode,

    findById Methode,

    updateProduct Methode,

    deleteProductMethode
    ```
    des ProductService. Verwendet dabei Mockito, um die Abhängigkeit zum ProductRepository zu mocken.
##### Id-Generierung
2. Erstelle eine IdService-Klasse, in der du eine Methode bereitstellst um eine zufällige Id zu generieren.
3. Nutze diese Klasse im ProductService um die Id für ein neues Produkt zu erstellen. (Nutze Dependency Injection)
4. Erstelle einen Unit-Test für die addProduct Methode aus dem ProductService, mocke dazu auch den IdService.

## Bonus-Aufgaben
1. Prüfe in jedem Unit-Test das auch nur einmal die Methode von deinem Mock aufgerufen wurde und auch sonst keine.
### Static Mocking
#### Erstelle einen Unit-Test fpr die Klasse IdService
3. Recherchiere dazu wie du den statischen Methoden-Aufrufe `UUID.randomUUID()` mocken kannst.
### Datum/ArguementCaptor
3. Erweiter deine Product Klasse um den Zeitpunkt der Erstellung.
4. Nutze im ProductService die Methode addProduct, um den aktuellen Zeitpunk festzustellen und mit abzuspeichern.
5. Passe deinen Unit-Test an und prüfe das der Erstellzeitpunkt nach dem 01.01.2020 und vor 21Uhr ist. Nutze dafür den ArgumentCaptor von Mockito [Link](https://www.baeldung.com/mockito-argumentcaptor)
### Random Product
6. Erstelle im ProductService eine Methode `public void setSeed(long seed)`
7. Erstelle eine Methode `getRandomProduct` im ProductService, die einen Seed nutzt um ein zufälliges Produkt zurück zu geben.
8. Schreibe für diese Methode einen Unit-Test, setzte dazu den Seed auf einen festen Wert damit jedes mal das geiche Produkt ausgewählt wird.
### Ohne Mockito
9. Schreibe alle deine Tests ohne Mockito.





