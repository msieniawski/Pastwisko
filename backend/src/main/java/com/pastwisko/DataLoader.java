package com.pastwisko;

import com.pastwisko.model.*;
import com.pastwisko.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    private final CommentService commentService;
    private final CopyPastaService copyPastaService;
    private final RatingService ratingService;
    private final TagService tagService;
    private final UserService userService;

    @Autowired
    public DataLoader(CommentService commentService, CopyPastaService copyPastaService, UserService userService,
                      RatingService ratingService, TagService tagService) {
        this.commentService = commentService;
        this.copyPastaService = copyPastaService;
        this.userService = userService;
        this.ratingService = ratingService;
        this.tagService = tagService;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        User[] users = {
                new User("miki95", "jp2gmd", "mikolaj@gmail.com"),
                new User("kamil_komenda", "fifjsdlkfj", "kamil@gmail.com"),
                new User("radzix5000", "djjj123", "tomek@gmail.com"),
                new User("fredr0", "fredr0000xx", "fredro@gmail.com"),
                new User("tami", "aq12rf3", "tami@gmail.com"),
                new User("olo2137", "1488hh", "olaf_sniezek@gmail.com"),
                new User("paulinka_winkowska", "hubertlove", "paulina@gmail.com")
        };

        for (User user : users) {
            userService.saveOrUpdate(user);
        }

        Tag[] tags = {
                new Tag("#pasta"),
                new Tag("#bk"),
                new Tag("#przegryw"),
                new Tag("#wygryw"),
                new Tag("#klasyk")
        };

        CopyPasta[] pastas = {
                new CopyPasta("cejrowski", CEJROWSKI, Date.valueOf(LocalDate.now()), users[0]),
                new CopyPasta("krawczyk", KRAWCZYK, Date.valueOf(LocalDate.now()), users[1]),
                new CopyPasta("wedkarz", "wedkarz", Date.valueOf(LocalDate.now()), users[1]),
                new CopyPasta("rigcz", "rigcz", Date.valueOf(LocalDate.now()), users[2])
        };

        pastas[0].getTags().add(tags[0]);
        tags[0].getPastaList().add(pastas[0]);

        pastas[0].getTags().add(tags[1]);
        tags[1].getPastaList().add(pastas[0]);

        pastas[0].getTags().add(tags[2]);
        tags[2].getPastaList().add(pastas[0]);

        pastas[0].getTags().add(tags[3]);
        tags[3].getPastaList().add(pastas[0]);

        pastas[1].getTags().add(tags[3]);
        tags[3].getPastaList().add(pastas[1]);

        pastas[1].getTags().add(tags[0]);
        tags[0].getPastaList().add(pastas[1]);

        for (CopyPasta pasta : pastas) {
            copyPastaService.saveOrUpdate(pasta);
        }

        Comment[] comments = {
                new Comment("świetna pasta", users[5], pastas[3]),
                new Comment("ujdzie", users[5], pastas[3]),
                new Comment("hehe", users[3], pastas[2]),
                new Comment("złoto xD", users[3], pastas[1]),
                new Comment("MODEEE", users[2], pastas[0]),
                new Comment(".", users[1], pastas[0])
        };

        for (Comment comment : comments) {
            commentService.saveOrUpdate(comment);
        }

        Rating[] ratings = {
                new Rating(5, users[3], pastas[0]),
                new Rating(4, users[2], pastas[0]),
                new Rating(4, users[1], pastas[3]),
                new Rating(1, users[6], pastas[2]),
                new Rating(2, users[4], pastas[1])
        };

        for (Rating rating : ratings) {
            ratingService.saveOrUpdate(rating);
        }

        for (Tag tag : tags) {
            tagService.saveOrUpdate(tag);
        }
    }

    private static final String CEJROWSKI = "Wojciech Cejrowski odgrywa w świecie etnograficznego reportażu dokładnie tę samą rolę, jaka na peryferiach medycyny przypada w udziale znachorom zalecającym lewatywy z nafty i okłady ze smalcu. Udowadnia, jak wielka jest wciąż ufność ludzi w siłę anegdoty, chłopskich mądrości i dumnie obnoszonej ignorancji.\n" +
            "\n" +
            "Wyobraźmy sobie, że we Francji lub w którymś z krajów Beneluksu sporą popularnością cieszy się pewien obieżyświat i tzw. osobowość telewizyjna. Sławę zdobył za sprawą programu dokumentującego wycieczki do krajów, które jego rodakom jawią się zupełną egzotyką. Tak też jeden z odcinków zabiera niezmordowanego podróżnika do pięknej krainy w dorzeczu Odry i Wisły. Prosto z Polski płynie więc do telewidzów barwna narracja:\n" +
            "\"Państwo popatrzą. Jestem w jakimś polskim mieście. Nazwy nie wymówię, bo co se będę język łamał na tych ich „sz\" i „cz\". Tu mamy osiedle takie, bloki jak kopce termitów. Jak w tym można żyć w ogóle? Ano jakoś można. Są zresztą i tubylcy, siedzą na ławce, palą jakieś skręciska. Dosiadamy się. Bonjour, zdrastwuj, guten morgen! Panie kamerzysto, pan pokaże ich dokładnie – od stóp do głów. Biednie, oj biednie ubrani. To, co my wyrzucamy, oni kupują w lumpeksie. Ale państwo zwrócą uwagę – zdrowe chłopy, nie? W sile wieku, ręce, nogi mają. A nie pracują. Bo po co pracować mają? Złomu nazbierają, sprzedadzą, na piwo będzie... Zaradni znaczy. I widocznie im tak dobrze, bo na niezadowolonych nie wyglądają\".\n" +
            "[...]\n" +
            "\n" +
            "Formułowanie daleko idących wniosków przychodzi Cejrowskiemu z dużą łatwością. Jest wszak ekspertem od wszystkiego, a przy tym praktykiem, gardzącym wszelkim, przeżartym lewactwem akademizmem. Wiadomo o nim, że studiował aktorstwo, historię sztuki i socjologię, ale najwidoczniej nie dość gorliwie. Dopiero w słusznym wieku 46 lat zdołał obronić licencjat z socjologii na Katolickim Uniwersytecie Lubelskim. Uczelni – dodajmy – która nie ma problemów z legitymizowaniem rojeń antyszczepionkowców.\n" +
            "\n" +
            "Z pewnością nie zraża to samego Cejrowskiego, który sam deklaruje sceptycyzm wobec skuteczności wakcynacji. Nie bez powodu zresztą stał się guru zwolenników teorii spiskowych. Wymieńcie jakikolwiek fakultet współczesnej pseudonauki, a istnieje duże prawdopodobieństwo, że jest jego gorliwym promotorem. Usilnie lansuje wszak pogląd, że teoria ewolucji jest herezją, kwestionuje zmiany klimatyczne, by jednocześnie cieszyć się z topniejących lodowców, bo ludzie będą mogli sadzić pomidory na Grenlandii, a przeludnienie to kolejny mit upowszechniany przez jajogłowych. Demistyfikacji tego ostatniego podejmuje się zabierając widza na etiopską równinę. Tyle lebensraumu się marnuje... Nic tylko go zaludnić i czynić poddanym jak naucza Pismo:<idźcie zatem i zaludniajcie Ziemię>";

    private static final String KRAWCZYK = "Kiedyś w pracy zorganizowali bal przebierańców. Szef powiedział, że obecność obowiązkowa inaczej premii nie będzie. Sto złoty super premia kurwo. Każdy się zadeklarował, że przyjdzie, bo 100 zł to będą mieli na gaz do samochodu to też musiałem iść żeby nie wyjść na ostatniego przegrywa. Pojechałem od razu po pracy do wypożyczalni strojów żeby wybrać najlepszy zanim inni się obudzą a mi zostanie tylko myszka miki. Wbijam: Panie daj pan jakieś przebranie dla mnie. Muszkieter może być? Spoko biorę. Wziąłem i wyszedłem. Przez tydzień w pracy temat numer jeden, kto, za co się przebierze. Normalnie jak w podstawówce. Dziewczyny oczywiście króliczki playboya, jedna gruba powiedziała, że też chyba za to się przebierze, ale szybko dostała ripostę żeby się przebrała za komodę. Poryczała się i wzięła L4 na dwa tygodnie. Faceci oczywiście batmany, spajdermeny, kowboje itd. Nadszedł w końcu ten dzień, wbijam na party, heheszki, gruba jednak przyszła przebrana za Marilyn Monroł. Siedzimy sobie pijemy, nawet jedna blondynka przebrana za dee dee z dextera mnie pochwaliła za fajny stój muszkietera. Było lepiej niż się spodziewałem. Jednak cały czas miałem na oku jedną taką, co siedziała i piła soczek, taka 8/10. Pytałem się, kto to jest, ale nikt jej nie znał. Szefo powiedział, że to z góry kogoś przysłali. Alkohol szumiał już w głowie zdobyłem się na odwagę i podbijam. \n" +
            "- Siema Anon jestem a ty? \n" +
            "- Hehehe miło mi, Ewa\n" +
            "Jakoś poszło. Jeden drink, drugi. Nagle znaleźliśmy się na parkiecie. Tańczymy w najlepsze. Nawet nie wiedziałem, że umiem tak dobrze tańczyć. Jeden kawałek za drugim, wolne szybkie i nagle drzwi od sali otwierają się z hukiem. Muzyka milknie a tam unosi się charakterystyczne\n" +
            "MÓJ PRZYJACIELU!\n" +
            "Każdy wtf, o co chodzi.\n" +
            "ŻONY NIE DAŁEM!\n" +
            "Patrzę na drzwi a tam pojawia się Krawczyk w takim stroju jak ja. Ewka cała czerwona na twarzy mówi pod nosem \n" +
            "- Sorry Anon. \n" +
            "Wtedy dotarło do mnie że całą imprezę bawiłem się z Ewą Krawczyk.\n" +
            "ŻONĘ WZIĄŁEŚ SOBIE SAM!\n" +
            "Krawczyk wściekły wbiega na sale w stroju muszkietera z wyciągniętą szpadą prosto na mnie. Niewiele myśląc wyciągnąłem swoją i zaczynamy walczyć. Szybko zrobiło się kółeczko. Walczymy jednocześnie próbując mu wytłumaczyć, że to nie tak jak myśli\n" +
            "- Panie Krawczyk, ale ja nie wiedziałem, że to Pana Ewka\n" +
            "A ten nic, walczy dalej. Pchnięcia, zamachy, uniki. Zacząłem się wycofywać bo życie mi miłe. Czuje coś wielkiego za sobą, wyłożyłem się jak długi potykając się o psa Krawczyka który sprytnie stanął pod nogami. Krzyczę z rozpaczą: \n" +
            "- Poddaje się. Niech mnie Pan nie zabija \n" +
            "Krawczyk spojrzał na mnie i odpowiada: \n" +
            "Zatańczysz ze mną jeszcze raz, \n" +
            "Ostatni raz, \n" +
            "Nim skończy się ten bal.\n" +
            "Podał mi rękę. Wstałem. Krzyknął muzyka i zatańczyłem z Krawczykiem. Był to najlepszy taniec w życiu. Po wszystkim wziął Ewkę na ręce i wyszedłem dumnie ze sali.";
}
