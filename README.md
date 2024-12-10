## Algoritmusok és adatszerkezetek gyakorlat beadandó feladat

### Nébl Annamária, Neptun: K04POD

### Dinamikus programozás

Link a feladathoz:
[Removal Game](https://cses.fi/problemset/task/1097/)

CSES tesztfileok a projektbe csatolva unit tesztekként

## Feladat:

Két játékos egy sorban elrendezett számokból álló játékot játszik.
Mindkét játékos felváltva eltávolít egy számot a sor bal vagy jobb végéről.
A játékos célja, hogy a lehető legnagyobb összpontszámot érje el,
miközben mindketten optimális stratégiát követnek.
A feladat az első játékos által elérhető maximális pontszám meghatározása.

## Input:

1. egy egész szám `n` (`1 ≤ n ≤ 5000`), amely a számok darabszámát jelzi
2. n db egész szám

## Algoritmus:

dinamikus programozás

## Kivitelezés:

1. **báziseset inicializálása**  
   a dp tábla főátlóját töltjük fel, ahol csak egy szám szerepel. ezek a cellák ( dp[i][i] ) az adott szám értékét
   tartalmazzák, mivel ha csak egy szám van, a játékos ezt választja

2. **rekurzív reláció használata**  
   a dp tábla többi celláját a következő formula segítségével töltjük ki:
    - ha a játékos a bal szélső számot választja, akkor az aktuális pontszám:
      
      numbers[i] + min(dp[i+2][j], dp[i+1][j-1])
      
    - ha a játékos a jobb szélső számot választja, akkor az aktuális pontszám:
      
      numbers[j] + min(dp[i][j-2], dp[i+1][j-1])
      
    - a dp[i][j]  értéke a kettő közül a nagyobb lesz:
      
      dp[i][j] = max(takeLeft, takeRight)
      

3. **iteráció tartományhossz alapján**  
   végigmegyünk az összes lehetséges tartományon a legrövidebbtől ( i = j ) a leghosszabbig ( i = 0, j = n-1 ),
   és kitöltjük a dp táblát a rekurzív reláció alkalmazásával

4. **végső eredmény**  
   a dp tábla ( dp[0][n-1] ) cellája tartalmazza az első játékos által elérhető maximális pontszámot az összes szám
   figyelembevételével


