// PACOTE
package Model;

public class Funcoes {

    // DECLARA AS VARIAVEIS
    private String lingua;
    private String lang;

    // FUNÇÃO PARA SUBSTITUIR A SIGLA PELO NOME DA LINGUA
    public String verificaLingua(String sigla) {
        lingua = "";
        sigla = sigla.trim();
        if (sigla.equals("pt")) {
            lingua = "Português";
        }
        if (sigla.equals("ab")) {
            lingua = "Abecásia";
        }
        if (sigla.equals("aa")) {
            lingua = "Afar";
        }
        if (sigla.equals("af")) {
            lingua = "Africânder";
        }
        if (sigla.equals("ay")) {
            lingua = "Aimará";
        }
        if (sigla.equals("ak")) {
            lingua = "Akan";
        }
        if (sigla.equals("sq")) {
            lingua = "Albanês";
        }
        if (sigla.equals("de")) {
            lingua = "Alemão";
        }
        if (sigla.equals("am")) {
            lingua = "Amárico";
        }
        if (sigla.equals("ar")) {
            lingua = "Árabe";
        }
        if (sigla.equals("an ")) {
            lingua = "Aragonês";
        }
        if (sigla.equals("hy")) {
            lingua = "Armênio";
        }
        if (sigla.equals("as")) {
            lingua = "Assamês";
        }
        if (sigla.equals("av")) {
            lingua = "Avárico";
        }
        if (sigla.equals("ae")) {
            lingua = "Avestan";
        }
        if (sigla.equals("az")) {
            lingua = "Azerbaijano";
        }
        if (sigla.equals("bm")) {
            lingua = "Bâmbara";
        }
        if (sigla.equals("eu")) {
            lingua = "Basco";
        }
        if (sigla.equals("ba")) {
            lingua = "Baxequir";
        }
        if (sigla.equals("bn")) {
            lingua = "Bengali";
        }
        if (sigla.equals("bh")) {
            lingua = "Biari";
        }
        if (sigla.equals("be")) {
            lingua = "Bielorusso";
        }
        if (sigla.equals("my")) {
            lingua = "Birmanês";
        }
        if (sigla.equals("bi")) {
            lingua = "Bislamá";
        }
        if (sigla.equals("bs")) {
            lingua = "Bósnio";
        }
        if (sigla.equals("br")) {
            lingua = "Bretão";
        }
        if (sigla.equals("bg")) {
            lingua = "Búlgaro";
        }
        if (sigla.equals("ks")) {
            lingua = "Cachemir";
        }
        if (sigla.equals("kr")) {
            lingua = "Canúri";
        }
        if (sigla.equals("es")) {
            lingua = "Castelhano";
        }
        if (sigla.equals("ca")) {
            lingua = "Catalão";
        }
        if (sigla.equals("kk")) {
            lingua = "Cazaque";
        }
        if (sigla.equals("ch")) {
            lingua = "Chamorro";
        }
        if (sigla.equals("zh")) {
            lingua = "Chinês";
        }
        if (sigla.equals("ts")) {
            lingua = "ChiTsonga";
        }
        if (sigla.equals("sn")) {
            lingua = "Chona";
        }
        if (sigla.equals("ny")) {
            lingua = "Cinyanja";
        }
        if (sigla.equals("ko")) {
            lingua = "Coreano";
        }
        if (sigla.equals("kw")) {
            lingua = "Córnico";
        }
        if (sigla.equals("co")) {
            lingua = "Corso";
        }
        if (sigla.equals("cr")) {
            lingua = "Cree";
        }
        if (sigla.equals("ht")) {
            lingua = "Criolo Haitiano";
        }
        if (sigla.equals("hr")) {
            lingua = "Croata";
        }
        if (sigla.equals("kj")) {
            lingua = "Cuanhama";
        }
        if (sigla.equals("ku")) {
            lingua = "Curdo";
        }
        if (sigla.equals("da")) {
            lingua = "Dinamarquês";
        }
        if (sigla.equals("dv")) {
            lingua = "Divehi";
        }
        if (sigla.equals("cu")) {
            lingua = "Eslavo Eclesiástico";
        }
        if (sigla.equals("sk")) {
            lingua = "Eslovaco";
        }
        if (sigla.equals("sl")) {
            lingua = "Esloveno";
        }
        if (sigla.equals("eo")) {
            lingua = "Esperanto";
        }
        if (sigla.equals("et")) {
            lingua = "Estoniano";
        }
        if (sigla.equals("fo")) {
            lingua = "Feroês";
        }
        if (sigla.equals("fj")) {
            lingua = "Fidijano";
        }
        if (sigla.equals("fi")) {
            lingua = "Finlandês";
        }
        if (sigla.equals("fr")) {
            lingua = "Francês";
        }
        if (sigla.equals("fy")) {
            lingua = "Frisão";
        }
        if (sigla.equals("ff")) {
            lingua = "Fula";
        }
        if (sigla.equals("gd")) {
            lingua = "Gaélico-Escocês";
        }
        if (sigla.equals("gl")) {
            lingua = "Galego";
        }
        if (sigla.equals("cy")) {
            lingua = "Galês";
        }
        if (sigla.equals("lg")) {
            lingua = "Ganda";
        }
        if (sigla.equals("ka")) {
            lingua = "Georgiano";
        }
        if (sigla.equals("el")) {
            lingua = "Grego Moderno";
        }
        if (sigla.equals("kl")) {
            lingua = "Groenlandês";
        }
        if (sigla.equals("gn")) {
            lingua = "Guarani";
        }
        if (sigla.equals("gu")) {
            lingua = "Gujarati";
        }
        if (sigla.equals("há")) {
            lingua = "Hauça";
        }
        if (sigla.equals("he")) {
            lingua = "Hebraico";
        }
        if (sigla.equals("hz")) {
            lingua = "Hereró";
        }
        if (sigla.equals("hi")) {
            lingua = "Hindi";
        }
        if (sigla.equals("ho")) {
            lingua = "Hiri Motu";
        }
        if (sigla.equals("nl")) {
            lingua = "Holandês";
        }
        if (sigla.equals("hu")) {
            lingua = "Húngaro";
        }
        if (sigla.equals("ig")) {
            lingua = "Ibo";
        }
        if (sigla.equals("io")) {
            lingua = "Ido";
        }
        if (sigla.equals("id")) {
            lingua = "Indonésio";
        }
        if (sigla.equals("en")) {
            lingua = "Inglês";
        }
        if (sigla.equals("ia")) {
            lingua = "Interlíngua";
        }
        if (sigla.equals("ie")) {
            lingua = "Interlíngue";
        }
        if (sigla.equals("iu")) {
            lingua = "Inuktitut";
        }
        if (sigla.equals("ik")) {
            lingua = "Inupiaq";
        }
        if (sigla.equals("ga")) {
            lingua = "Irlandés";
        }
        if (sigla.equals("is")) {
            lingua = "Islandês";
        }
        if (sigla.equals("it")) {
            lingua = "Italiano";
        }
        if (sigla.equals("ja")) {
            lingua = "Japonês";
        }
        if (sigla.equals("jv")) {
            lingua = "Javanês";
        }
        if (sigla.equals("ee")) {
            lingua = "Jeje";
        }
        if (sigla.equals("kn")) {
            lingua = "Kannada";
        }
        if (sigla.equals("km")) {
            lingua = "Khmer";
        }
        if (sigla.equals("ki")) {
            lingua = "Kikuyu";
        }
        if (sigla.equals("rw")) {
            lingua = "Kinyaruanda";
        }
        if (sigla.equals("kv")) {
            lingua = "Komi";
        }
        if (sigla.equals("lo")) {
            lingua = "Laociano";
        }
        if (sigla.equals("la")) {
            lingua = "Latim";
        }
        if (sigla.equals("lv")) {
            lingua = "Letão";
        }
        if (sigla.equals("li")) {
            lingua = "Limburguês";
        }
        if (sigla.equals("ln")) {
            lingua = "Lingala";
        }
        if (sigla.equals("lt")) {
            lingua = "Lituano";
        }
        if (sigla.equals("lu")) {
            lingua = "Luba-Katanga";
        }
        if (sigla.equals("lb")) {
            lingua = "Luxemburguês";
        }
        if (sigla.equals("mk")) {
            lingua = "Macedônio";
        }
        if (sigla.equals("ml")) {
            lingua = "Malaiala";
        }
        if (sigla.equals("ms")) {
            lingua = "Malaio";
        }
        if (sigla.equals("mg")) {
            lingua = "Malgaxe";
        }
        if (sigla.equals("mt")) {
            lingua = "Maltês";
        }
        if (sigla.equals("gv")) {
            lingua = "Manês";
        }
        if (sigla.equals("mi")) {
            lingua = "Maori";
        }
        if (sigla.equals("mr")) {
            lingua = "Marata";
        }
        if (sigla.equals("mh")) {
            lingua = "Marshallês";
        }
        if (sigla.equals("mo")) {
            lingua = "Moldávio";
        }
        if (sigla.equals("mn")) {
            lingua = "Mongol";
        }
        if (sigla.equals("na")) {
            lingua = "Nauru";
        }
        if (sigla.equals("nv")) {
            lingua = "Navajo";
        }
        if (sigla.equals("nd")) {
            lingua = "Ndebele do Norte";
        }
        if (sigla.equals("nr")) {
            lingua = "Ndebele do Sul";
        }
        if (sigla.equals("ng")) {
            lingua = "Ndonga";
        }
        if (sigla.equals("ne")) {
            lingua = "Nepali";
        }
        if (sigla.equals("no")) {
            lingua = "Norueguês";
        }
        if (sigla.equals("nb")) {
            lingua = "Norueguês Bokmal";
        }
        if (sigla.equals("nn")) {
            lingua = "Novo Norueguês";
        }
        if (sigla.equals("oc")) {
            lingua = "Occitano";
        }
        if (sigla.equals("oj")) {
            lingua = "Ojibwa";
        }
        if (sigla.equals("or")) {
            lingua = "Oriya";
        }
        if (sigla.equals("om")) {
            lingua = "Oromo";
        }
        if (sigla.equals("os")) {
            lingua = "Oseto";
        }
        if (sigla.equals("pi")) {
            lingua = "Páli";
        }
        if (sigla.equals("os")) {
            lingua = "Pashto";
        }
        if (sigla.equals("fa")) {
            lingua = "Persa";
        }
        if (sigla.equals("pl")) {
            lingua = "Polonês";
        }
        if (sigla.equals("pa")) {
            lingua = "Punjabi";
        }
        if (sigla.equals("qe")) {
            lingua = "Quebec";
        }
        if (sigla.equals("qu")) {
            lingua = "Quechua";
        }
        if (sigla.equals("kg")) {
            lingua = "Quicongo";
        }
        if (sigla.equals("ky")) {
            lingua = "Quirguiz";
        }
        if (sigla.equals("rm")) {
            lingua = "Reto-Romano";
        }
        if (sigla.equals("ro")) {
            lingua = "Romeno";
        }
        if (sigla.equals("rn")) {
            lingua = "Rundi";
        }
        if (sigla.equals("ru")) {
            lingua = "Russo";
        }
        if (sigla.equals("se")) {
            lingua = "Sami do Norte";
        }
        if (sigla.equals("sm")) {
            lingua = "Samoano";
        }
        if (sigla.equals("sg")) {
            lingua = "Sango";
        }
        if (sigla.equals("sa")) {
            lingua = "Sânscrito";
        }
        if (sigla.equals("sc")) {
            lingua = "Sardo";
        }
        if (sigla.equals("sr")) {
            lingua = "Sérvio";
        }
        if (sigla.equals("sh")) {
            lingua = "Servo-Croata";
        }
        if (sigla.equals("st")) {
            lingua = "SeSotho do Sul";
        }
        if (sigla.equals("ii")) {
            lingua = "Sichuan";
        }
        if (sigla.equals("sd")) {
            lingua = "Sindi";
        }
        if (sigla.equals("si")) {
            lingua = "Sinhalês";
        }
        if (sigla.equals("so")) {
            lingua = "Somali";
        }
        if (sigla.equals("sv")) {
            lingua = "Sueco";
        }
        if (sigla.equals("su")) {
            lingua = "Sundanês";
        }
        if (sigla.equals("sw")) {
            lingua = "Swahili";
        }
        if (sigla.equals("ss")) {
            lingua = "Swati";
        }
        if (sigla.equals("tg")) {
            lingua = "Tadjique";
        }
        if (sigla.equals("tl")) {
            lingua = "Tagalo";
        }
        if (sigla.equals("th")) {
            lingua = "Tailandés";
        }
        if (sigla.equals("ty")) {
            lingua = "Taitiano";
        }
        if (sigla.equals("ta")) {
            lingua = "Tâmil";
        }
        if (sigla.equals("tt")) {
            lingua = "Tártaro";
        }
        if (sigla.equals("ce")) {
            lingua = "Tchecheno";
        }
        if (sigla.equals("cs")) {
            lingua = "Tcheco";
        }
        if (sigla.equals("cv")) {
            lingua = "Tchuvache";
        }
        if (sigla.equals("te")) {
            lingua = "Telugu";
        }
        if (sigla.equals("bo")) {
            lingua = "Tibetano";
        }
        if (sigla.equals("ti")) {
            lingua = "Tigrinya";
        }
        if (sigla.equals("to")) {
            lingua = "Tonganês";
        }
        if (sigla.equals("tn")) {
            lingua = "Tswana";
        }
        if (sigla.equals("tr")) {
            lingua = "Turco";
        }
        if (sigla.equals("tk")) {
            lingua = "Turcomano";
        }
        if (sigla.equals("tw")) {
            lingua = "Twi";
        }
        if (sigla.equals("uk")) {
            lingua = "Ucraniano";
        }
        if (sigla.equals("ug")) {
            lingua = "Uigure";
        }
        if (sigla.equals("ur")) {
            lingua = "Urdu";
        }
        if (sigla.equals("uz")) {
            lingua = "Uzbeque";
        }
        if (sigla.equals("wa")) {
            lingua = "Valão";
        }
        if (sigla.equals("ve")) {
            lingua = "Venda";
        }
        if (sigla.equals("vi")) {
            lingua = "Vetnamita";
        }
        if (sigla.equals("vo")) {
            lingua = "Volapuk";
        }
        if (sigla.equals("wo")) {
            lingua = "Wolof";
        }
        if (sigla.equals("xh")) {
            lingua = "Xhosa";
        }
        if (sigla.equals("yi")) {
            lingua = "Yiddish";
        }
        if (sigla.equals("yo")) {
            lingua = "Yoruba";
        }
        if (sigla.equals("za")) {
            lingua = "Zhuang";
        }
        if (sigla.equals("dz")) {
            lingua = "Zoncá";
        }
        if (sigla.equals("zu")) {
            lingua = "Zulu";
        }
        return lingua;
    }

    // FUNÇÃO PARA SUBSTITUIR O NOME DA LINGUA PELA SIGLA
    public String pegaSiglaLingua(String linguaExtensa) {
        lang = "";
        linguaExtensa = linguaExtensa.trim();
        if (!linguaExtensa.equals("")) {
            if (linguaExtensa.equals(".Todos.")) {
                lang = "";
            }
            if (linguaExtensa.equals("Português")) {
                lang = "pt";
            }
            if (linguaExtensa.equals("Abecásia")) {
                lang = "ab";
            }
            if (linguaExtensa.equals("Afar")) {
                lang = "aa";
            }
            if (linguaExtensa.equals("Africânder")) {
                lang = "af";
            }
            if (linguaExtensa.equals("Aimará")) {
                lang = "ay";
            }
            if (linguaExtensa.equals("Akan")) {
                lang = "ak";
            }
            if (linguaExtensa.equals("Albanês")) {
                lang = "sq";
            }
            if (linguaExtensa.equals("Alemão")) {
                lang = "de";
            }
            if (linguaExtensa.equals("Amárico")) {
                lang = "am";
            }
            if (linguaExtensa.equals("Árabe")) {
                lang = "ar";
            }
            if (linguaExtensa.equals("Aragonês")) {
                lang = "an ";
            }
            if (linguaExtensa.equals("Armênio")) {
                lang = "hy";
            }
            if (linguaExtensa.equals("Assamês")) {
                lang = "as";
            }
            if (linguaExtensa.equals("Avárico")) {
                lang = "av";
            }
            if (linguaExtensa.equals("Avestan")) {
                lang = "ae";
            }
            if (linguaExtensa.equals("Azerbaijano")) {
                lang = "az";
            }
            if (linguaExtensa.equals("Bâmbara")) {
                lang = "bm";
            }
            if (linguaExtensa.equals("Basco")) {
                lang = "eu";
            }
            if (linguaExtensa.equals("Baxequir")) {
                lang = "ba";
            }
            if (linguaExtensa.equals("Bengali")) {
                lang = "bn";
            }
            if (linguaExtensa.equals("Biari")) {
                lang = "bh";
            }
            if (linguaExtensa.equals("Bielorusso")) {
                lang = "be";
            }
            if (linguaExtensa.equals("Birmanês")) {
                lang = "my";
            }
            if (linguaExtensa.equals("Bislamá")) {
                lang = "bi";
            }
            if (linguaExtensa.equals("Bósnio")) {
                lang = "bs";
            }
            if (linguaExtensa.equals("Bretão")) {
                lang = "br";
            }
            if (linguaExtensa.equals("Búlgaro")) {
                lang = "bg";
            }
            if (linguaExtensa.equals("Cachemir")) {
                lang = "ks";
            }
            if (linguaExtensa.equals("Canúri")) {
                lang = "kr";
            }
            if (linguaExtensa.equals("Castelhano")) {
                lang = "es";
            }
            if (linguaExtensa.equals("Catalão")) {
                lang = "ca";
            }
            if (linguaExtensa.equals("Cazaque")) {
                lang = "kk";
            }
            if (linguaExtensa.equals("Chamorro")) {
                lang = "ch";
            }
            if (linguaExtensa.equals("Chinês")) {
                lang = "zh";
            }
            if (linguaExtensa.equals("ChiTsonga")) {
                lang = "ts";
            }
            if (linguaExtensa.equals("Chona")) {
                lang = "sn";
            }
            if (linguaExtensa.equals("Cinyanja")) {
                lang = "ny";
            }
            if (linguaExtensa.equals("Coreano")) {
                lang = "ko";
            }
            if (linguaExtensa.equals("Córnico")) {
                lang = "kw";
            }
            if (linguaExtensa.equals("Corso")) {
                lang = "co";
            }
            if (linguaExtensa.equals("Cree")) {
                lang = "cr";
            }
            if (linguaExtensa.equals("Criolo Haitiano")) {
                lang = "ht";
            }
            if (linguaExtensa.equals("Croata")) {
                lang = "hr";
            }
            if (linguaExtensa.equals("Cuanhama")) {
                lang = "kj";
            }
            if (linguaExtensa.equals("Curdo")) {
                lang = "ku";
            }
            if (linguaExtensa.equals("Dinamarquês")) {
                lang = "da";
            }
            if (linguaExtensa.equals("Divehi")) {
                lang = "dv";
            }
            if (linguaExtensa.equals("Eslavo Eclesiástico")) {
                lang = "cu";
            }
            if (linguaExtensa.equals("Eslovaco")) {
                lang = "sk";
            }
            if (linguaExtensa.equals("Esloveno")) {
                lang = "sl";
            }
            if (linguaExtensa.equals("Esperanto")) {
                lang = "eo";
            }
            if (linguaExtensa.equals("Estoniano")) {
                lang = "et";
            }
            if (linguaExtensa.equals("Feroês")) {
                lang = "fo";
            }
            if (linguaExtensa.equals("Fidijano")) {
                lang = "fj";
            }
            if (linguaExtensa.equals("Finlandês")) {
                lang = "fi";
            }
            if (linguaExtensa.equals("Francês")) {
                lang = "fr";
            }
            if (linguaExtensa.equals("Frisão")) {
                lang = "fy";
            }
            if (linguaExtensa.equals("Fula")) {
                lang = "ff";
            }
            if (linguaExtensa.equals("Gaélico-Escocês")) {
                lang = "gd";
            }
            if (linguaExtensa.equals("Galego")) {
                lang = "gl";
            }
            if (linguaExtensa.equals("Galês")) {
                lang = "cy";
            }
            if (linguaExtensa.equals("Ganda")) {
                lang = "lg";
            }
            if (linguaExtensa.equals("Georgiano")) {
                lang = "ka";
            }
            if (linguaExtensa.equals("Grego Moderno")) {
                lang = "el";
            }
            if (linguaExtensa.equals("Groenlandês")) {
                lang = "kl";
            }
            if (linguaExtensa.equals("Guarani")) {
                lang = "gn";
            }
            if (linguaExtensa.equals("Gujarati")) {
                lang = "gu";
            }
            if (linguaExtensa.equals("Hauça")) {
                lang = "há";
            }
            if (linguaExtensa.equals("Hebraico")) {
                lang = "he";
            }
            if (linguaExtensa.equals("Hereró")) {
                lang = "hz";
            }
            if (linguaExtensa.equals("Hindi")) {
                lang = "hi";
            }
            if (linguaExtensa.equals("Hiri Motu")) {
                lang = "ho";
            }
            if (linguaExtensa.equals("Holandês")) {
                lang = "nl";
            }
            if (linguaExtensa.equals("Húngaro")) {
                lang = "hu";
            }
            if (linguaExtensa.equals("Ibo")) {
                lang = "ig";
            }
            if (linguaExtensa.equals("Ido")) {
                lang = "io";
            }
            if (linguaExtensa.equals("Indonésio")) {
                lang = "id";
            }
            if (linguaExtensa.equals("Inglês")) {
                lang = "en ";
            }
            if (linguaExtensa.equals("Interlíngua")) {
                lang = "ia";
            }
            if (linguaExtensa.equals("Interlíngue")) {
                lang = "ie";
            }
            if (linguaExtensa.equals("Inuktitut")) {
                lang = "iu";
            }
            if (linguaExtensa.equals("Inupiaq")) {
                lang = "ik";
            }
            if (linguaExtensa.equals("Irlandés")) {
                lang = "ga";
            }
            if (linguaExtensa.equals("Islandês")) {
                lang = "is";
            }
            if (linguaExtensa.equals("Italiano")) {
                lang = "it";
            }
            if (linguaExtensa.equals("Japonês")) {
                lang = "ja ";
            }
            if (linguaExtensa.equals("Javanês")) {
                lang = "jv";
            }
            if (linguaExtensa.equals("Jeje")) {
                lang = "ee";
            }
            if (linguaExtensa.equals("Kannada")) {
                lang = "kn";
            }
            if (linguaExtensa.equals("Khmer")) {
                lang = "km";
            }
            if (linguaExtensa.equals("Kikuyu")) {
                lang = "ki";
            }
            if (linguaExtensa.equals("Kinyaruanda")) {
                lang = "rw";
            }
            if (linguaExtensa.equals("Komi")) {
                lang = "kv";
            }
            if (linguaExtensa.equals("Laociano")) {
                lang = "lo";
            }
            if (linguaExtensa.equals("Latim")) {
                lang = "la";
            }
            if (linguaExtensa.equals("Letão")) {
                lang = "lv";
            }
            if (linguaExtensa.equals("Limburguês")) {
                lang = "li";
            }
            if (linguaExtensa.equals("Lingala")) {
                lang = "ln";
            }
            if (linguaExtensa.equals("Lituano")) {
                lang = "lt";
            }
            if (linguaExtensa.equals("Luba-Katanga")) {
                lang = "lu";
            }
            if (linguaExtensa.equals("Luxemburguês")) {
                lang = "lb";
            }
            if (linguaExtensa.equals("Macedônio")) {
                lang = "mk";
            }
            if (linguaExtensa.equals("Malaiala")) {
                lang = "ml";
            }
            if (linguaExtensa.equals("Malaio")) {
                lang = "ms";
            }
            if (linguaExtensa.equals("Malgaxe")) {
                lang = "mg";
            }
            if (linguaExtensa.equals("Maltês")) {
                lang = "mt";
            }
            if (linguaExtensa.equals("Manês")) {
                lang = "gv";
            }
            if (linguaExtensa.equals("Maori")) {
                lang = "mi";
            }
            if (linguaExtensa.equals("Marata")) {
                lang = "mr";
            }
            if (linguaExtensa.equals("Marshallês")) {
                lang = "mh";
            }
            if (linguaExtensa.equals("Moldávio")) {
                lang = "mo";
            }
            if (linguaExtensa.equals("Mongol")) {
                lang = "mn";
            }
            if (linguaExtensa.equals("Nauru")) {
                lang = "na";
            }
            if (linguaExtensa.equals("Navajo")) {
                lang = "nv";
            }
            if (linguaExtensa.equals("Ndebele do Norte")) {
                lang = "nd";
            }
            if (linguaExtensa.equals("Ndebele do Sul")) {
                lang = "nr";
            }
            if (linguaExtensa.equals("Ndonga")) {
                lang = "ng";
            }
            if (linguaExtensa.equals("Nepali")) {
                lang = "ne";
            }
            if (linguaExtensa.equals("Norueguês")) {
                lang = "no";
            }
            if (linguaExtensa.equals("Norueguês Bokmal")) {
                lang = "nb";
            }
            if (linguaExtensa.equals("Novo Norueguês")) {
                lang = "nn";
            }
            if (linguaExtensa.equals("Occitano")) {
                lang = "oc";
            }
            if (linguaExtensa.equals("Ojibwa")) {
                lang = "oj";
            }
            if (linguaExtensa.equals("Oriya")) {
                lang = "or";
            }
            if (linguaExtensa.equals("Oromo")) {
                lang = "om";
            }
            if (linguaExtensa.equals("Oseto")) {
                lang = "os";
            }
            if (linguaExtensa.equals("Páli")) {
                lang = "pi";
            }
            if (linguaExtensa.equals("Pashto")) {
                lang = "os";
            }
            if (linguaExtensa.equals("Persa")) {
                lang = "fa";
            }
            if (linguaExtensa.equals("Polonês")) {
                lang = "pl";
            }
            if (linguaExtensa.equals("Punjabi")) {
                lang = "pa";
            }
            if (linguaExtensa.equals("Quechua")) {
                lang = "qu";
            }
            if (linguaExtensa.equals("Quicongo")) {
                lang = "kg";
            }
            if (linguaExtensa.equals("Quirguiz")) {
                lang = "ky";
            }
            if (linguaExtensa.equals("Reto-Romano")) {
                lang = "rm";
            }
            if (linguaExtensa.equals("Romeno")) {
                lang = "ro";
            }
            if (linguaExtensa.equals("Rundi")) {
                lang = "rn";
            }
            if (linguaExtensa.equals("Russo")) {
                lang = "ru";
            }
            if (linguaExtensa.equals("Sami do Norte")) {
                lang = "se";
            }
            if (linguaExtensa.equals("Samoano")) {
                lang = "sm";
            }
            if (linguaExtensa.equals("Sango")) {
                lang = "sg";
            }
            if (linguaExtensa.equals("Sânscrito")) {
                lang = "sa ";
            }
            if (linguaExtensa.equals("Sardo")) {
                lang = "sc";
            }
            if (linguaExtensa.equals("Sérvio")) {
                lang = "sr";
            }
            if (linguaExtensa.equals("Servo-Croata")) {
                lang = "sh";
            }
            if (linguaExtensa.equals("SeSotho do Sul")) {
                lang = "st";
            }
            if (linguaExtensa.equals("Sichuan")) {
                lang = "ii";
            }
            if (linguaExtensa.equals("Sindi")) {
                lang = "sd";
            }
            if (linguaExtensa.equals("Sinhalês")) {
                lang = "si";
            }
            if (linguaExtensa.equals("Somali")) {
                lang = "so";
            }
            if (linguaExtensa.equals("Sueco")) {
                lang = "sv";
            }
            if (linguaExtensa.equals("Sundanês")) {
                lang = "su";
            }
            if (linguaExtensa.equals("Swahili")) {
                lang = "sw";
            }
            if (linguaExtensa.equals("Swati")) {
                lang = "ss";
            }
            if (linguaExtensa.equals("Tadjique")) {
                lang = "tg";
            }
            if (linguaExtensa.equals("Tagalo")) {
                lang = "tl";
            }
            if (linguaExtensa.equals("Tailandés")) {
                lang = "th";
            }
            if (linguaExtensa.equals("Taitiano")) {
                lang = "ty";
            }
            if (linguaExtensa.equals("Tâmil")) {
                lang = "ta";
            }
            if (linguaExtensa.equals("Tártaro")) {
                lang = "tt";
            }
            if (linguaExtensa.equals("Tchecheno")) {
                lang = "ce";
            }
            if (linguaExtensa.equals("Tcheco")) {
                lang = "cs";
            }
            if (linguaExtensa.equals("Tchuvache")) {
                lang = "cv";
            }
            if (linguaExtensa.equals("Telugu")) {
                lang = "te";
            }
            if (linguaExtensa.equals("Tibetano")) {
                lang = "bo";
            }
            if (linguaExtensa.equals("Tigrinya")) {
                lang = "ti";
            }
            if (linguaExtensa.equals("Tonganês")) {
                lang = "to";
            }
            if (linguaExtensa.equals("Tswana")) {
                lang = "tn";
            }
            if (linguaExtensa.equals("Turco")) {
                lang = "tr";
            }
            if (linguaExtensa.equals("Turcomano")) {
                lang = "tk";
            }
            if (linguaExtensa.equals("Twi")) {
                lang = "tw";
            }
            if (linguaExtensa.equals("Ucraniano")) {
                lang = "uk";
            }
            if (linguaExtensa.equals("Uigure")) {
                lang = "ug";
            }
            if (linguaExtensa.equals("Urdu")) {
                lang = "ur";
            }
            if (linguaExtensa.equals("Uzbeque")) {
                lang = "uz";
            }
            if (linguaExtensa.equals("Valão")) {
                lang = "wa";
            }
            if (linguaExtensa.equals("Venda")) {
                lang = "ve";
            }
            if (linguaExtensa.equals("Vetnamita")) {
                lang = "vi";
            }
            if (linguaExtensa.equals("Volapuk")) {
                lang = "vo";
            }
            if (linguaExtensa.equals("Wolof")) {
                lang = "wo";
            }
            if (linguaExtensa.equals("Xhosa")) {
                lang = "xh";
            }
            if (linguaExtensa.equals("Yiddish")) {
                lang = "yi";
            }
            if (linguaExtensa.equals("Yoruba")) {
                lang = "yo";
            }
            if (linguaExtensa.equals("Zhuang")) {
                lang = "za";
            }
            if (linguaExtensa.equals("Zoncá")) {
                lang = "dz";
            }
            if (linguaExtensa.equals("Zulu")) {
                lang = "zu";
            }
        }
        return lang;
    }
}
