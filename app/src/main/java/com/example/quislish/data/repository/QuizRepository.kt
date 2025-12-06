package com.example.quislish.data.repository



import com.example.quislish.data.model.Question

object QuizRepository {
    fun getQuestionsForLevel(levelId: Int): List<Question> {
        return when(levelId) {
            1 -> listOf(
                Question(1, "What is the meaning of 'Cat'?", listOf("A. Dog","B. Bird","C. Cat","D. Fish"), 2),
                Question(2, "What color is the sky?", listOf("A. Blue","B. Red","C. Green","D. Yellow"), 0),
                Question(3, "'Hello' means...", listOf("A. Goodbye","B. Hello","C. Thanks","D. Sorry"), 1),
                Question(4, "What is 2 + 2?", listOf("A. 3","B. 4","C. 5","D. 6"), 1),
                Question(5, "'Apple' is a...", listOf("A. Fruit","B. Animal","C. Color","D. Drink"), 0),
                Question(6, "'Dog' means...", listOf("A. Kucing","B. Ayam","C. Anjing","D. Sapi"), 2),
                Question(7, "'Red' is a...", listOf("A. Shape","B. Food","C. Color","D. Animal"), 2),
                Question(8, "What is the opposite of 'Big'?", listOf("A. Small","B. Tall","C. Long","D. Wide"), 0),
                Question(9, "'Water' means...", listOf("A. Air","B. Tanah","C. Api","D. Angin"), 0),
                Question(10, "'Book' means...", listOf("A. Pensil","B. Buku","C. Meja","D. Kursi"), 1)
            )

            2 -> listOf(
                Question(1, "What is the meaning of 'Teacher'?", listOf("A. Guru","B. Polisi","C. Dokter","D. Pilot"), 0),
                Question(2, "'Fast' means...", listOf("A. Slow","B. Quick","C. Heavy","D. Cold"), 1),
                Question(3, "What is the opposite of 'Hot'?", listOf("A. Warm","B. Cool","C. Cold","D. Dry"), 2),
                Question(4, "Choose the meaning of 'Happy'", listOf("A. Angry","B. Sad","C. Happy","D. Tired"), 2),
                Question(5, "'They are students' means...", listOf("A. Mereka bekerja","B. Mereka makan","C. Mereka siswa","D. Mereka tidur"), 2),
                Question(6, "'House' means...", listOf("A. Rumah","B. Sekolah","C. Toko","D. Kantor"), 0),
                Question(7, "'Cold water' means...", listOf("A. Air panas","B. Air dingin","C. Air kotor","D. Air asin"), 1),
                Question(8, "'Big' means...", listOf("A. Kecil","B. Sedang","C. Besar","D. Panjang"), 2),
                Question(9, "What does 'Go to school' mean?", listOf("A. Pergi tidur","B. Pergi sekolah","C. Pergi makan","D. Pergi mandi"), 1),
                Question(10, "'Small' means...", listOf("A. Kecil","B. Besar","C. Tinggi","D. Lebar"), 0)
            )

            3 -> listOf(
                Question(1, "What is the synonym of 'Beautiful'?", listOf("A. Ugly","B. Pretty","C. Dirty","D. Loud"), 1),
                Question(2, "'He is running' means...", listOf("A. Dia berdiri","B. Dia tidur","C. Dia berlari","D. Dia makan"), 2),
                Question(3, "Choose the correct translation: 'I am studying'", listOf("A. Saya makan","B. Saya belajar","C. Saya minum","D. Saya pergi"), 1),
                Question(4, "'Difficult' means...", listOf("A. Easy","B. Hard","C. Soft","D. Light"), 1),
                Question(5, "What is the antonym of 'Early'?", listOf("A. Late","B. Fast","C. Soon","D. Slow"), 0),
                Question(6, "Choose the meaning of 'Improve'", listOf("A. Memburuk","B. Meningkat","C. Menghapus","D. Mengurangi"), 1),
                Question(7, "'Journey' means...", listOf("A. Perjalanan","B. Tugas","C. Masalah","D. Ingatan"), 0),
                Question(8, "'Silent' means...", listOf("A. Noisy","B. Quiet","C. Bright","D. Dark"), 1),
                Question(9, "What does 'Because' mean?", listOf("A. Karena","B. Tetapi","C. Meskipun","D. Jika"), 0),
                Question(10, "'Important' means...", listOf("A. Tidak berguna","B. Penting","C. Mudah","D. Sulit"), 1)
            )

            4 -> listOf(
                Question(1, "What is the synonym of 'Complex'?", listOf("A. Simple","B. Complicated","C. Basic","D. Clear"), 1),
                Question(2, "'He barely passed the exam' means...", listOf("A. Dia lulus dengan mudah","B. Dia gagal ujian","C. Dia hampir tidak lulus","D. Dia tidak mengikuti ujian"), 2),
                Question(3, "'Nevertheless' means...", listOf("A. Namun","B. Oleh karena itu","C. Bahkan","D. Tanpa"), 0),
                Question(4, "'Significant' means...", listOf("A. Tidak penting","B. Penting","C. Sementara","D. Tidak jelas"), 1),
                Question(5, "What does 'In contrast' mean?", listOf("A. Sebaliknya","B. Selain itu","C. Contohnya","D. Meskipun"), 0),
                Question(6, "Choose the meaning of 'Consequences'", listOf("A. Penyebab","B. Akibat","C. Rencana","D. Perintah"), 1),
                Question(7, "'Efficient' means...", listOf("A. Efektif dan cepat","B. Lambat","C. Berisik","D. Tidak jelas"), 0),
                Question(8, "'Predict' means...", listOf("A. Menebak masa depan","B. Menjelaskan masa lalu","C. Menghindari sesuatu","D. Mengubah keputusan"), 0),
                Question(9, "'Require' means...", listOf("A. Menolak","B. Menghapus","C. Membutuhkan","D. Mengikuti"), 2),
                Question(10, "'Approximately' means...", listOf("A. Tepat","B. Sekitar","C. Sangat jauh","D. Sering"), 1)
            )

            else -> emptyList()
        }
    }
}
