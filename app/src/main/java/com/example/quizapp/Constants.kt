package com.example.quizapp

object Constants {
    var userName: String = ""
    var score: Int = 0
    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val question1 = Question(1, "What country does this flag belont to?", R.drawable.ic_flag_of_argentina, "Argentina",
        "Austria", "Australia", "Serbia", 1)
        questionList.add(question1)

        val question2 = Question(1, "What country does this flag belont to?", R.drawable.ic_flag_of_australia, "Argentina",
            "Austria", "Australia", "Serbia", 3)
        questionList.add(question2)

        val question3 = Question(1, "What country does this flag belont to?", R.drawable.ic_flag_of_belgium, "Belgium",
            "Austria", "Armenia", "Serbia", 1)
        questionList.add(question3)

        val question4 = Question(1, "What country does this flag belont to?", R.drawable.ic_flag_of_brazil, "Brazil",
            "Austria", "Armenia", "Serbia", 1)
        questionList.add(question4)

        val question5 = Question(1, "What country does this flag belont to?", R.drawable.ic_flag_of_denmark, "Denmark",
            "Austria", "Armenia", "Serbia", 1)
        questionList.add(question5)

        val question6 = Question(1, "What country does this flag belont to?", R.drawable.ic_flag_of_fiji, "Fiji",
            "Austria", "Armenia", "Serbia", 1)
        questionList.add(question6)

        val question7 = Question(1, "What country does this flag belont to?", R.drawable.ic_flag_of_germany, "Germany",
            "Austria", "Armenia", "Serbia", 1)
        questionList.add(question7)

        val question8 = Question(1, "What country does this flag belont to?", R.drawable.ic_flag_of_india, "India",
            "Austria", "Armenia", "Serbia", 1)
        questionList.add(question8)

        val question9 = Question(1, "What country does this flag belont to?", R.drawable.ic_flag_of_kuwait, "Kuwait",
            "Austria", "Armenia", "Serbia", 1)
        questionList.add(question9)

        val question10 = Question(1, "What country does this flag belont to?", R.drawable.ic_flag_of_new_zealand, "New Zealand",
            "Austria", "Armenia", "Serbia", 1)
        questionList.add(question10)
        return questionList
    }
}
