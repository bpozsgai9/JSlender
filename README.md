# JSlender
###### SZTE - Programozás 1. - Kötelező program (feladat04.pdf)

```
░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ 
░░░░░░░░░▄▄███▄░░░░░░░░░░░░░░░░░░░░░░░░░▄███▄░░░░░░░░
░░░░░░░░░▄▄██▀▀░░░░░░░░▄█▀▀▀▀█▄░░░░░░▄██████▄░░░░░░░░
░░░░░░░█████████▄░░░░░░█░░░░░▀█░░░░░░░▄▄▄▀█▀▀░░░░░░░░
░░░░░░░░░▄███▀▀▀▀░░░░░░█░░░░░░█░░░░░░▀▀▀█████▄▄░░░░░░
░░░░░░░▄▄███████▀░░░░░░█▄░░░░▄█░░░░░░▄█▀███▄██░░░░░░░
░░░░░░░███████░░░░░░░░░░▀█░░█▀░░░░░██████████▄▄░░░░░░
░░░░░░░███▄███▀▀▀░░░░░██▀▀██▀▀██░░░░░░░▀▀█████░░░░░░░
░░░░░░░░░████▄▄▄░░░░░█████░█░████░░░░░▀▀█████░░░░░░░░
░░░░░░░▀▀▀███▄▀▀░░░░███▀███░██▀███░░░░▀▀██████░░░░░░░
░░░░░░░░░▀█████▀░░░░███░██████░███░░░░░░░░█░░░░░░░░░░
```

**Beüzemelés:** :electric_plug: 
- A projekt intellJ IDE-ben készült, ehhez tartozó projektfájlt tartalmaz
- Kicsomagolást követően 
> **IntelliJ** / File / Open / JSlender

## src/ felépítése:

###### Játék főosztályai:

>gameElements/Game.java<br>
>gameElements/GameMap.java<br>
>gameElements/Field.java

###### Térkép leképezéséhez szükséges osztályok:

>fieldElements/FieldElement.java<br>
>fieldElements/movable/Player.java<br>
>fieldElements/movable/SlenderMan.java<br>
>fieldElements/stable/Barrel.java<br>
>fieldElements/stable/Car.java<br>
>fieldElements/stable/EmptyField.java<br>
>fieldElements/stable/House.java<br>
>fieldElements/stable/LargeSizeTree.java<br>
>fieldElements/stable/Rock.java<br>
>fieldElements/stable/SmallSizeTree.java<br>
>fieldElements/stable/Truck.java


###### Egyéb működéshez szükséges elemek
>com.company/Main.java (futtatandó osztály)<br>
>beolvas.txt (fájlbeolvasáshoz tartozó példafájl)

## Beüzemelést követően

###### Osztály hierarchia:

```
com.company
    Main
    
gameElements
    Game
    GameMap
    Field
    
fieldElemets    
    FieldElement
    '->
    movable
        '-> Player
        '-> SlenderMan
    stable  
        '-> Barrel
        '-> Car
        '-> EmptyField
        '-> House
        '-> LargeSizeTree
        '-> Rock
        '-> SmallSizeTree
        '-> Truck
```

###### A játék működése:

A feladatod hogy 8 papírt összegyűjts az erdő mélyén.<br>
Magaddal vihetsz egy ZSEBLÁMPÁT ami VILÁGÍTJA neked az utat.<br>
Ha összegyűjtöd őket, talán sikerül megtudnod a titkot amit az erdő rejt.<br>
De légy óvatos! Lehet, hogy nem vagy egyedül...<br>

**MIELŐTT ELINDÍTOD A JÁTÉKOT!**

Jegyezd meg, a játékosod azonosító száma a `9`- es, ez jelzi ki az aktuális helyzeted,<br>
amit magad előtt látsz `háromszög` alakban mezőket az a zseblámpád által megvilágított terület<br>
amerre fordulsz arra fogsz látni a sötétségben!<br>
Lépni adatbekéréssel tudsz, a játék tájékoztatni fog!<br>

**Amit látni fogsz**:
```
                              
                              
                              
                              
                              
                              
                              
      0 0 0                   
        0                     
        9                     
                              
                              
                              
                              
                              

A te játékosod azonosítója: [9]
Merre szeretnél lépni?
	w - felfele
	a - balra
	s - lefele
	d - jobbra
	m - térkép
	k - kilépés
Válasz: 
```

# Jó játékot! :shipit:







