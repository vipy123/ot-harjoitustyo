Harjoitustyö (Ohjelmistotekniikka) Vilma Pylkkö

##Kasvitietokanta-ohjelma

Käyttäjät
---------

-   Tiedon lisääjät
-   Suunnittelijat, tiedon hakijat

Tarve / ongelma
---------------

Maisemansuunnittelussa suunnitellaan ulkotiloja kuten puistoja, aukioita ja katutiloja. Suunnittelussa tulee huomioida toiminnalliset, esteettiset, akrritehtoniset, ekologiset, biologiset, kulttuuriset ynnä muut kriteerit. Kasvillisuus on tärkeässä roolissa ulkotilojen muotoilussa. Halutaan luoda lajillisesti monimuotoisia, helppohoitoisia ja ekologisesti ja esteettisesti toimivia istutuksia. Kasvilajitieto on kuitenkin fragmentoitunut moniin eri lähteisiin, kuten kirjoihin, internetiin taimitarhojen sivustoille ja muutamien asiantuntijoiden päähän. Jotkin suunnitteluohjelmistot tajoavat kasvitietokantaa suunnittelutyökalun mukana, mutta ne ovat kalliiden lisenssien takana tai perustuvat ulkomaisiin, usein amerikkalaisiin tai muiden mantereiden ympäristöoloihin.

Viime vuosina maisemansuunnittelussa on alettu puhua enenevissä määrin dynaamisista istutuksista, joissa erilaisia kasveja sekoitetaan istutuksissa. Tavoitteena on luonnonläheisempi istutustapa, joka vaatii vähemmän intensiivistä hoitoa ja matkii luonnon omia tapoja. Istutusten suunnitteluun on olemassa hyvin vähänm työkaluja. Tällä harjoitustyöllä haluan tutkia, miten ohjelmoinnilla voidaan helpottaa dynaamisten istutusten suunnittelua.

Vaatimuksia ohjelmalle
----------------------

-   Ohjelmalla voidaan hallita kasvitietokantaa eli lisätä sinne suunnittelussa käytettävää tietoa istutettavista ja kylvettävistä kasvilajeista sekä hakea kasvilajeja tiettyjen kriteerien perusteella.
-   Tarvittavia kasvitietoja ovat mm. Lajin nimitiedot, kasvupaikkavaatimukset, menestymisvyöhykkeet, kuvat, “kaverilajit” ja yhteen sopimattomat lajit.
-   Kasvitiedot tallennetaan käyttäjän koneelle, jolloin käyttäjä voi muokata tietoja tarvittaessa myös taulukkomuodossa.
-   Ohjelma etsii myös ns. “kaverikasveja” halutun kasvukorkeuden / ekolokeron mukaisesti.

Jatkokehitysideat
-----------------

-   Lisäksi, jos aikaa jää, voi ohjelma ehdottaa istutuskuvioita valituille kasvilajeille. Tällöin ohjelma luo kullekin taimelle paikan xy-koordinaatistossa ja tulostaa sen esim. Txt- tai csv-muodossa.

Suunnittelu
-----------

Suuremmat rakennekomponentit

Miten komponentit yhdistetään

Riippuvuudet tietokantoihin tai rajapintoihin
