
package com.example.myapplication

data class Word(
    val original: String, val translate: String, var learned: Boolean = false
)

data class Question(
    val variants: List<Word>,
    val correctAnswer: Word,

    )

class LearnWordsTrainer {
    private val dictionary = listOf(
//
//
//        Word("Elma", "Apple"),
//        Word("Portakal", "Orange"),
//        Word("Muz", "Banana"),
//        Word("Üzüm", "Grape"),
//        Word("Armut", "Pear"),
//        Word("Şeftali", "Peach"),
//        Word("Erik", "Plum"),
//        Word("Limon", "Lemon"),
//        Word("Mango", "Mango"),
//        Word("Papaya", "Papaya"),
//        Word("Kavun", "Melon"),
//        Word("Kivi", "Kiwi"),
//        Word("Yaban mersini", "Berry"),
//        Word("Fındık", "Nut"),
//        Word("İncir", "Fig"),
//        Word("Hurma", "Date"),
//        Word("Hindistan cevizi", "Coconut"),
//        Word("Avokado", "Avocado"),
//        Word("Domates", "Tomato"),
//        Word("Patates", "Potato"),
//        Word("Soğan", "Onion"),
//        Word("Sarımsak", "Garlic"),
//        Word("Havuç", "Carrot"),
//        Word("Pancar", "Beet"),
//        Word("Mısır", "Corn"),
//        Word("Fasulye", "Bean"),
//        Word("Bezelye", "Pea"),
//        Word("Pirinç", "Rice"),
//        Word( "Galaksi", "Galaxy"),
//        Word( "Kuyruklu yıldız", "Comet"),
//        Word( "Meteor", "Meteor"),
//        Word( "Yörünge", "Orbit"),
//        Word("Tutulma", "Eclipse"),
//        Word("Yerçekimi", "Gravity"),
//        Word("Vakum", "Vacuum"),
//        Word("Spektrum", "Spectrum"),
//        Word("Parçacık", "Particle"),
//        Word("Atom", "Atom"),
//        Word("Molekül", "Molecule"),
//        Word("Kristal", "Crystal"),
//        Word("Voltaj", translate = "Voltage"),
//        Word("Devre", translate = "Circuit"),
//        Word(original = "Signal", translate = "Sinyal"),
//        Word(original = "Data", translate = "Veri"),
//        Word(original = "Algorithm", translate = "Algoritma"),
//        Word(original = "Variable", translate = "Değişken"),
//        Word(original = "Function", translate = "Fonksiyon"),
//        Word(original = "Library", translate = "Kütüphane"),
//        Word(original = "Compiler", translate = "Derleyici"),
//        Word(original = "Server", translate = "Sunucu"),
//        Word(original = "Client", translate = "İstemci"),
//        Word(original = "Protocol", translate = "Protokol"),
//        Word(original = "Network", translate = "Ağ"),
//        Word(original = "Bandwidth", translate = "Bant genişliği"),
////        Word(original = "Storage", translate = "Depolama"),
//        Word(original = "Encryption", translate = "Şifreleme"),
//        Word(original = "Decryption", translate = "Şifre çözme"),
//        Word(original = "Firewall", translate = "Güvenlik duvarı"),
//        Word(original = "Kernel", translate = "Çekirdek"),
//        Word(original = "Thread", translate = "İş parçacığı"),
//        Word(original = "Database", translate = "Veritabanı"),
//        Word(original = "Query", translate = "Sorgu"),
//        Word(original = "Index", translate = "İndeks"),
//        Word(original = "Transaction", translate = "İşlem"),
//        Word(original = "Cache", translate = "Önbellek"),
//        Word(original = "Backup", translate = "Yedekleme"),
//        Word(original = "Restore", translate = "Geri yükleme"),
//        Word(original = "Virtual", translate = "Sanal"),
//        Word(original = "Cloud", translate = "Bulut"),
//        Word(original = "Token", translate = "Jeton"),
//        Word(original = "Hash", translate = "Hash"),
//        Word(original = "Signature", translate = "İmza"),
//        Word(original = "Interface", translate = "Arayüz"),
//        Word(original = "Module", translate = "Modül"),
//        Word(original = "Package", translate = "Paket"),
//        Word(original = "Script", translate = "Betik"),
//        Word(original = "Syntax", translate = "Sözdizimi"),
//        Word("Ekmek", "Bread"),
//        Word("Vogon", "Vogon"),
//        Word("Babel fish", "Babel balığı"),
//        Word("Hyperdrive", "Hızlandırıcı"),
//        Word("Hooloovoo", "Hooloovoo"),
//        Word("Nagrathae", "Nagrathae"),
//        Word("Hyper Space", "Hiperuzay"),
//        Word("Guidebook", "Rehber kitap"),
//        Word("Starship", "Uzay gemisi"),
//        Word("Towel", "Havlu"),
        // A2 Level Words
        Word("Cat", "Kedi"),
        Word("Dog", "Köpek"),
        Word("House", "Ev"),
        Word("School", "Okul"),
        Word("Book", "Kitap"),
        Word("Pen", "Kalem"),
        Word("Table", "Masa"),
        Word("Chair", "Sandalye"),
        Word("Car", "Araba"),
        Word("Bicycle", "Bisiklet"),
        Word("Flower", "Çiçek"),
        Word("Tree", "Ağaç"),
        Word("Sea", "Deniz"),
        Word("Lake", "Göl"),
        Word("Mountain", "Dağ"),
        Word("Road", "Yol"),
        Word("Hand", "El"),
        Word("Foot", "Ayak"),
        Word("Eye", "Göz"),
        Word("Ear", "Kulak"),
// B1 Level Words
        Word("Discuss", "Tartışmak"),
        Word("Decide", "Karar vermek"),
        Word("Develop", "Gelişmek"),
        Word("Achieve", "Başarmak"),
        Word("Advice", "Tavsiye"),
        Word("Experience", "Deneyim"),
        Word("Opportunity", "Fırsat"),
        Word("Security", "Güvenlik"),
        Word("Solution", "Çözüm"),
        Word("Communication", "İletişim"),
        Word("Participate", "Katılmak"),
        Word("Debate", "Tartışma"),
        Word("Improvement", "Gelişim"),
        Word("Success", "Başarı"),
        Word("Recommend", "Tavsiye etmek"),
        Word("Experience (verb)", "Deneyimlemek"),
        Word("Offer an opportunity", "Fırsat sunmak"),
        Word("Safe", "Güvenli"),
        Word("Solve", "Çözmek"),
        Word("Convey", "İletmek"),
// B2 Level Words
        Word("Assume", "Varsaymak"),
        Word("Persuade", "İkna etmek"),
        Word("Claim", "İddia etmek"),
        Word("Interpret", "Yorumlamak"),
        Word("Assert", "İleri sürmek"),
        Word("Observe", "Gözlemlemek"),
        Word("Estimate", "Tahmin etmek"),
        Word("Exception", "İstisna"),
        Word("Scope", "Kapsam"),
        Word("Stability", "İstikrar"),
        Word("Sustainable", "Sürdürülebilir"),
        Word("Diversity", "Çeşitlilik"),
        Word("Interaction", "Etkileşim"),
        Word("Comment", "Yorum"),
        Word("Assumption", "Varsayım"),
        Word("Persuasion", "İkna"),
        Word("Allegation", "İddia"),
        Word("Interpretation", "Yorumlama"),
        Word("Assertion", "İleri sürme"),
        Word("Observation", "Gözlem"),
        Word("Prediction", "Tahmin"),
        Word("Exceptional", "İstisnai"),
        Word("Comprehensive", "Kapsamlı"),
        Word("Stable", "İstikrarlı"),
        Word("Sustainability", "Sürdürülebilirlik"),
        Word("Various", "Çeşitli"),
        Word("Interactive", "Etkileşimli"),
// More B2 Level Words
        Word("Forecast", "Öngörü"),
        Word("Prevalent", "Yaygın"),
        Word("Complex", "Karmaşık"),
        Word("Functional", "İşlevsel"),
        Word("Probability", "Olasılık"),
        Word("Statistics", "İstatistik"),
        Word("Competence", "Yeterlilik"),
        Word("Process", "Süreç"),
        Word("Global", "Küresel"),
        Word("Regional", "Bölgesel"),
        Word("Collaboration", "İşbirliği"),
        Word("Innovative", "Yenilikçi"),
        Word("Responsibility", "Sorumluluk"),
        Word("Contribution", "Katkı"),
        Word("Effective", "Etkili"),
        Word("Efficient", "Verimli"),
        Word("Indicate", "İşaret etmek"),
        Word("Emphasize", "Vurgulamak"),
        Word("Detailed", "Ayrıntılı"),
        Word("Contradiction", "Çelişki"),
        Word("Consistency", "Tutarlılık"),
        Word("Analyze", "Çözümlemek"),
        Word("Evaluate", "Değerlendirmek"),
        Word("Review", "Gözden geçirmek"),
        Word("Commentator", "Yorumcu"),
        Word("Express", "İfade etmek"),
        Word("State", "Belirtmek"),
        Word("Make an assumption", "Varsayımda bulunmak"),
        Word("Convincing", "İkna edici"),
        Word("Ambitious", "İddialı"),
        Word("Interpreter", "Yorumcu"),
        Word("Observer", "Gözlemci"),
        Word("Forecaster", "Tahminci"),
        Word("Without exception", "İstisnasız"),
        Word("Inclusive", "Kapsayıcı"),
        Word("Unstable", "İstikrarsız"),
        Word("Diversifying", "Çeşitlendirici"),
        Word("Non-interactive", "Etkileşimsiz"),
        )


    private var currentQuestion: Question? = null
    fun getNextQuestion(): Question? {
        val notLearnedList = dictionary.filter { !it.learned }
        if (notLearnedList.isEmpty()) return null
        val questionWords = if (notLearnedList.size < NUMBER_OF_ANSWERS) {
            val learnedList = dictionary.filter { it.learned }.shuffled()
            notLearnedList.shuffled()
                .take(NUMBER_OF_ANSWERS) + learnedList.take(NUMBER_OF_ANSWERS - notLearnedList.size)
        } else {
            notLearnedList.shuffled().take(NUMBER_OF_ANSWERS)
        }.shuffled()
        val correctAnswer: Word = questionWords.random()
        currentQuestion = Question(
            variants = questionWords, correctAnswer = correctAnswer
        )
        return currentQuestion
    }

    fun checkAnswer(userAnswerIndex: Int?): Boolean {


        return currentQuestion?.let {
            it.variants.getOrNull(userAnswerIndex ?: -1) == it.correctAnswer
        } ?: false

    }
}

const val NUMBER_OF_ANSWERS: Int = 4