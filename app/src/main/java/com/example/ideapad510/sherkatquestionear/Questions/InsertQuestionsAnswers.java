package com.example.ideapad510.sherkatquestionear.Questions;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerController;

import java.util.ArrayList;

public class InsertQuestionsAnswers {
    public static ArrayList<QuestionAndAnswerObject> questionAndAnswerObjectArrayList = new ArrayList<>();

    public InsertQuestionsAnswers(Context context) {
        QuestionController questionController = new QuestionController(context);
        AnswerController answerController = new AnswerController(context);


//        sampleDB.execSQL("INSERT INTO " +
//                SAMPLE_TABLE_NAME +
//                " Values('"+LastName.get(i)+"','"+FirstName.get(i)+"',"+Age.get(i)+");");


        for(int i = 0; i <= 18; i++) {
            questionController.insertToDatabase(getQuestionAndAnswerObjectArrayList().get(i).getQuestion(),
                    "0", "1");
        }

        for(int i = 0; i <= 18; i++)
            for(int j = 0; j <= 9; j++)
               answerController.insertToDatabase(getQuestionAndAnswerObjectArrayList().get(i).getQuestionId() ,
                       getQuestionAndAnswerObjectArrayList().get(i).getAnswer().get(j), "0", "0");





    }

    public static ArrayList<QuestionAndAnswerObject> getQuestionAndAnswerObjectArrayList() {
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tعملكرد كارتخوان شرکت پککو به لحاظ سرعت در برقراري ارتباط و خطوط تلفن را چگونه ارزيابي مي\u200Cكنيد؟\n",
                "1: كاملاً نامناسب" , " 10: كاملاً مناسب" , "1" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tعملكرد بانک در واريز به موقع مبالغ فروش به حساب شما را چگونه ارزيابي مي\u200Cكنيد؟\n",
                "1: كاملاً ضعيف" , "  10: كاملاً خوب" , "2" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tقابليت\u200Cهاي كارتخوان پککو (خريد، دريافت موجودي، پرداخت قبض و ...) تا چه اندازه توانسته نيازهاي شما در حوزه پرداخت الكترونيك را برطرف نمايد؟\n",
                "1: اصلاً نتوانسته" , "   10: كاملاً توانسته" , "3" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tانجام مرتب و منظم بازرسي از كارتخوان پککو را چگونه ارزيابي مي\u200Cكنيد؟\n",
                "1: خيلي ضعيف" , "  10: خيلي خوب" , "4" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tتمايل و علاقهمندي كاركنان شركت و نمايندگيها و بازرسين در ارائه خدمات و پاسخگويي به نياز شما را چگونه ارزيابي ميكنيد؟\n",
                "1: خيلي ضعيف" , "  10: خيلي خوب" , "5" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tتمايل و علاقهمندي پرسنل شعب بانک در ارائه خدمات و پاسخگويي به نياز شما را چگونه ارزيابي ميكنيد؟\n",
                "1: خيلي ضعيف" , "  10: خيلي خوب" , "6" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tپاسخ به نيازها، خواستهها و مشكلات شما كه از جانب كاركنان شركت، نمايندگيها و بازرسين ارائه مي\u200Cشود تا چه اندازه مورد قبول و رضايتتان است؟\n",
                "1:اصلاً" , " 10: خيلي زياد" , "7" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tپاسخ به نيازها، خواستهها و مشكلات شما كه از جانب پرسنل شعب بانک ارائه مي\u200Cشود تا چه اندازه مورد قبول و رضايتتان است؟\n",
                "1:اصلاً" , " 10: خيلي زياد" , "8" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tنحوه آموزش و اطلاع رساني در خصوص استفاده و به كارگيري كارتخوان را از نظر خود و همكاران چگونه ارزيابي مينماييد؟",
                "1: خيلي ضعيف" , "  10: خيلي خوب" , "9" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tبه طور كلي همكاري با شركت تجارت الکترونيک پارسيان تا چه اندازه توانسته است اطمينان و آرامش خاطر شما را در استفاده از دستگاههاي كارتخوان پککو فراهم نمايد؟\n",
                "1: اصلاً موفق نبوده" , " 10: كاملاً موفق بوده" , "10" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tكاركنان و بازرسين شركت را (مثلاً در تعمير و راهاندازي كارتخوان پککو و ...)  تا چه اندازه ماهر مي\u200Cدانيد؟\n",
                "1:خيلي كم" , " 10: خيلي زياد" , "11" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tنحوه برخورد و گفتار كاركنان شركت، نمايندگي\u200Cها و بازرسين تا چه اندازه محترمانه بوده است؟\n",
                "1: كاملاً نامناسب" , " 10: كاملاً مناسب" , "12" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tنحوه برخورد و گفتار پرسنل شعب بانک تا چه اندازه محترمانه بوده است؟\n",
                "1: كاملاً نامناسب" , " 10: كاملاً مناسب" , "13" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\t طراحي و زيبايي كارتخوان پککو را در مقايسه با كارتخوان ساير بانكها چگونه ارزيابي مينماييد؟\n",
                "1: خيلي ضعيف" , "  10: خيلي خوب" , "14" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tتجهيزات مورد استفاده\u200Cي كاركنان شركت، نمايندگي\u200Cها و بازرسين را تا اندازه زيبا و حرفه\u200Cاي مي\u200Cدانيد؟\n",
                "1: كاملاً نامناسب" , " 10: كاملاً حرفه\u200Cاي" , "15" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("تا چه ميزان پوشش ظاهري كاركنان شركت و نمايندگي\u200Cها و بازرسين را مناسب و حرفه\u200Cاي مي\u200Cدانيد؟",
                "1: اصلاً" , " 10: كاملاً حرفه\u200Cاي" , "16" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tتا چه ميزان پوشش ظاهري پرسنل شعب بانک را مناسب و حرفه\u200Cاي مي\u200Cدانيد؟\n",
                "1: اصلاً" , " 10: كاملاً حرفه\u200Cاي" , "17" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\t تا چه ميزان  شركت براي شما به طور خاص، توجه ويژه\u200Cاي قائل شده است؟\n",
                "1: اصلاً در دسترس نيست" , " 10: كاملاً در دسترس است" , "18" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tشركت و نمايندگيهاي آن را ( مراكز پاسخگوئي به پذيرنده) چقدر در دسترس خود احساس ميكنيد؟",
                "1: اصلاً در دسترس نيست" , "  10: كاملاً در دسترس است" , "19" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\t شركت تا چه ميزان توانسته در شما به عنوان مشتري علاقه\u200Cي قلبي نسبت به خود ايجاد نمايد؟  ",
                "1: اصلاً" , " 10: خيلي زياد" , "20" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\tدرصورتيكه تاكنون انتقاد و شكايتي نسبت به عملكرد كارتخوان پککو به صورت تلفني يا حضوري مطرح نمودهايد، كيفيت پاسخ دريافت شده و ميزان توجه به اظهارات شما چگونه بوده است؟\n",
                "1: كاملاً نامناسب" , "  10: كاملاً مناسب" , "21" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("سرعت رسيدگي به شكايات و انتقاداتي  كه از كارتخوان پککو  ارايه نمودهايد، چگونه ارزيابي مينماييد؟",
                "1: كاملاً نامناسب" , " 10: كاملاً مناسب" , "22" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("⦁\t قبل از برقراري ارتباط با شركت و استفاده از خدمات آن به طور كلي ميزان انتظارات شما از شركت در چه سطحي قرار داشت؟\n",
                "1: بسيار  پايين" , "  10: بسيار بالا" , "23" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("",
                "1: خيلي ضعيف" , "  10: خيلي خوب" , "5" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("",
                "1: خيلي ضعيف" , "  10: خيلي خوب" , "5" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("",
                "1: خيلي ضعيف" , "  10: خيلي خوب" , "5" ));
        questionAndAnswerObjectArrayList.add(new QuestionAndAnswerObject("",
                "1: خيلي ضعيف" , "  10: خيلي خوب" , "5" ));

        return questionAndAnswerObjectArrayList;
    }

}
