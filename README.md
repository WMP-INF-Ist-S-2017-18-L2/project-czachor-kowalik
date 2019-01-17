
# Warsztat
Aplikacja mająca na celu ułatwienie prowadzenia warsztatu samochodowego. 

## Spis treści
1. Opis działania
2. Wprowadzanie danych
3. Funkcje aplikacji
4. Uruchamianie aplikacji
5. Informacja o autorach

### 1. Opis działania
Aplikacja została stworzona do obsługi wizyt w warsztacie samochodowym. Posiada trzy główne zakładki, w których jesteśmy w stanie dodać nowego klienta, jego pojad oraz przypisać do niego usterkę. Wszystkię informacje zostaną zapisane w bazie danych.  Program jest w stanie wyszukać dane o kliencie, samochodzie oraz poprzednich usterkach, jeśli klient korzystał już z usług danego warsztatu samochodowego.

### 2. Wprowadzanie danych
Pierwszą zakładką w aplikacji Warsztat jest <b>Klient</b>. W tym oknie wpisujemy informacje takie jak:
<li>Imię</li>
<li>Nazwisko</li>
<li>Adres zamieszkania</li>
<li>Numer telefonu</li>
Te dane są nam potrzebne w celu identyfikacji klienta oraz przypisywaniu do niego odpowiednich pojadów. Polę "Numer telefonu" zostało zabezpieczone. Numer musi zawierać 9 cyfr. Gdy wpiszemy inne znaki np. litery lub znaki specialne, wyświetli się komunikat, który informuje nas o nieprawidłowo wpisanym numerze telefonu.<br /><br />

Drugą zakładką jest <b>Samochód</b>. W tym oknie wpisujemy informacje takie jak:
<li>Marka</li>
<li>Model</li>
<li>Rok produkcji</li>
<li>Pojemność silnika (w cm^3)</li>
<li>Moc (w KM)</li>
Te dane są nam potrzebne do przypisania usterki do danego pojazdu. Podobnie jak w zakładce Klient niektóre pola zostały zabezpieczone przed wpisaniem nieprawidłowych wartości. Pola "Pojemność silnika" oraz "Moc" musimy wpisać używając wyłącznie cyfr, w przypadku wpisania liter lub znaków specialnych wyświetli się odpowiedni komunikat.<br /><br />

Ostatnią zakładką jest <b>Usterka</b>. W tym oknie wpisujemy informacje takie jak:
<li>Nazwa krótka</li>
<li>Data zgłoszenia</li>
<li>Data odbioru (przewidywana)</li>
<li>Wstępna wycena</li>
<li>Wstępny opis usterki</li>
W tym oknie pole "Wstępna wycena" zostało zabezpieczone przed wpisaniem liter oraz znaków specialnych.<br /><br />

W celu poprawnego funkcionowania aplikacji wszystkie pola w zakładce Klient, Samochód oraz Usterka, muszą być uzupełnione.

### Funkcje aplikacji
W głównych zakładkach aplikacji posiadamy kilka przydatnych funkcji. <br /><br />
<li>Pierwszą z nich jest funkcja "<b>Dodaj</b>", która umożliwia nam dodanie klienta, samochodu lub usterki, po wcześniejszym uzupełnieniu potrzebnych informacji.</li><br/>
<li>Przycisk "<b>Edytuj</b>" umożliwia nam edycje wpisanych informacji o kliencie, samochodzie lub usterce. W celu edycji, wybieramy dany obiekt z listy używając LPM. Następnie klikamy na przycisk "Edytuj". W tym momencie informacje o obiekcie zostały wyświetlone w odpowiednich polach tekstowych, które jesteśmy w stanie edytować. W celu zatwierdzenia wciskamy przycisk "Zapisz".</li><br />
<li>Kolejną funkcją do obsługi klientów, samochodów lub usterek jest ich usuwanie. Umożliwia nam to przycisk "<b>Usuń</b>. W celu użycia tej funkcji klikamy na wybrany obiekt z listy używajc LPM, a następnie klikamy na przycisk "Usuń". Przycisk posiada zabezpieczenie przed przypadkowym uzyciem, które wyświetla okienko żądające od nas potwierdzenia tej akcji.<b>UWAGA! Usuwając klienta, przepadają nam informacji o jego pojeździe oraz usterkach.</b></li><br />
<li>Nad listą znajduje się funkcja do wyszukiwania obiektów. Wpisując w polu poniżej "<b>Wyszukaj w liście:</b>" informacje o danym kliencie, samochodzie lub usterce, jesteśmy w stanie wyświetlić szukany przez nas obiekt klikając przycisk "<b>Szukaj</b>".</li><br />
<li>Zaraz obok funkcji szukaj znajduje się przycisk "<b>Pokaż wszystkie</b>". Służy on do odświeżania listy po wcześniejszym wyszukiwaniu danych obiektów. Po użyciu tej funkcji na liście zostaną nam wyświetlone wszystkie obiekty znajdujące się na liście. </li><br />
<li>W celu wprowadzenia samochodu który należy do danego klienta, należy wybrać go z listy klikając dwukrotnie LPM. Po wpisaniu danych pojazdu funkcja przypisze wprowadzony w ten sposób samochód do jego właściciela. W ten sam sposób łączymy samochód z jego usterką.</li><br />
<li>Chcąc udokumentować przebieg prac nad wybranymi usterkami klikamy na nią dwukrotnie LPM. W nowo ukazanym oknie jesteśmy w stanie zweryfikować informacje o kliencie, samochodzie oraz usterce. Pod polem sprawozdanie widnieje "<b>Cena końcowa</b>", którą ustalamy wycenę końcową usterki. Funkcją "<b>Status</b>" możemy wybrać etap pracy nad danym pojazdem. Mamy do wyboru opcje takie jak: "W trakcie", "Do odbioru", "Odebrane". Po zakończonych działaniach w tym oknie używamy przycisku "Zapisz".</li><br />

### Uruchamianie aplikacji

blah blah

### Informacje o autorach

Pracę nad projektem wykonali: Czachor Krzysztof i Kowalik Kacper.
