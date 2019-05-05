Harjoitustyö (Ohjelmistotekniikka) Vilma Pylkkö

## Kasvitietokanta-ohjelma

Käyttäjät
---------

-   Tiedon lisääjät
-   Suunnittelijat, tiedon hakijat

Tarve / ongelma
---------------

Maisemansuunnittelussa suunnitellaan ulkotiloja kuten puistoja, aukioita ja katutiloja. Suunnittelussa tulee huomioida toiminnalliset, esteettiset, arkkitehtoniset, ekologiset, biologiset, kulttuuriset ynnä muut kriteerit. Kasvillisuus on tärkeässä roolissa ulkotilojen muotoilussa. Halutaan luoda lajillisesti monimuotoisia, helppohoitoisia ja ekologisesti ja esteettisesti toimivia istutuksia. Kasvilajitieto on kuitenkin fragmentoitunut moniin eri lähteisiin, kuten kirjoihin, internetiin taimitarhojen sivustoille ja muutamien asiantuntijoiden päähän. Jotkin suunnitteluohjelmistot tarjoavat kasvitietokantaa suunnittelutyökalun mukana, mutta ne ovat kalliiden lisenssien takana tai perustuvat ulkomaisiin, usein amerikkalaisiin tai muiden mantereiden ympäristöoloihin.

Viime vuosina maisemansuunnittelussa on alettu puhua enenevissä määrin dynaamisista istutuksista, joissa erilaisia kasveja sekoitetaan istutuksissa. Tavoitteena on luonnonläheisempi istutustapa, joka vaatii vähemmän intensiivistä hoitoa ja matkii luonnon omia tapoja. Istutusten suunnitteluun on olemassa hyvin vähän työkaluja. Tällä harjoitustyöllä tutkitaan, miten ohjelmoinnilla voidaan helpottaa dynaamisten istutusten suunnittelua.

Vaatimuksia ohjelmalle
----------------------

-   Ohjelmalla voidaan hallita kasvitietotiedostoa eli lisätä sinne suunnittelussa käytettävää tietoa istutettavista ja kylvettävistä kasvilajeista sekä hakea kasvilajeja tiettyjen kriteerien perusteella.
-   Tarvittavia kasvitietoja ovat mm. Lajin nimitiedot, kasvupaikkavaatimukset ja menestymisvyöhykkeet.
-   Kasvitiedot tallennetaan käyttäjän koneelle, jolloin käyttäjä voi muokata tietoja tarvittaessa myös taulukkomuodossa.
-   Ohjelma etsii myös ns. “kaverikasveja” halutun ekolokeron mukaisesti.

Jatkokehitysideat
-----------------

-   Jatkossa ohjelmaa voidaan kehittää luomaan kolmiutotteisia, dynaamisia istutuksia. Se voisi ehdottaa istutuskuvioita valituille kasvilajeille. Tällöin ohjelma luo kullekin taimelle paikan xy-koordinaatistossa ja tulostaa sen esim. Txt- tai csv-muodossa.

Suunnittelu
-----------

Suuremmat rakennekomponentit
Ohjelma koostuu: 
-   javafx-käyttöliittymäluokasta
-   operations-paketin logic-luokasta, jossa hallitaan toimintoja
-   Components-paketin komponettiluokista eli kasvilajeista, kasvualustoista ja kasvityypeistä eli Species, PlantType ja GrowingMedia.
-   Kasvitieto-csv-tiedostosta, joka on nimeltään Pensasluettelo.csv

Miten komponentit yhdistetään
-   Main-metodi käynnistyy javafx-luokassa avaten samalla yhteyden logic-luokan kautta kasvitieto-tiedostoon. Käyttäjä valitsee painikkeita käyttöliittymässä, joiden mukaan ohjelma ohjaa uuteen näkymään, joko tiedon lisäys-näkymään tai tiedonhakunäkymään. Logic luokka luo tiedostosta lukemalla komponenttiluokat: Species, PlantType ja GrowingMedia sekä niiden väliset yhteydet. Logic lisäksi tallentaa speciesluokat listalle, josta niitä on helppo operoida. Käyttöliittymän kautta käyttäjä lisää tietoja, mistä logic-luokka joko hakee listalta tietoa tai luo komponenttiluokkiin uutta tietoa.

Riippuvuudet tietokantoihin tai rajapintoihin
-   Ohjelmassa haetaan ja viedään tietoa paikalliseen csv-tiedostoon Operations paketin logic-luokan kautta. Tällöin ohjelma säilyy yksinkertaisena eikä tietokantayhteyttä välttämättä tarvita. Se on sopiva yksittäisen ihmisen tai esim. yrityksen käyttöön. Jatkossa ohjelmaa on edelleen mahdollista kehittää tietokantaohjelmaksi.
