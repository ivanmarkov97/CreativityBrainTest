package com.example.creativitybraintest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultsTextView;
    TextView description;
    final String [] descriptionText = {"Предметное мышление.Люди с практическим складом ума предпочитают предметное мышление, для которого характерны неразрывная связь с предметом в пространстве и времени,осуществление преобразования информации с помощью предметных действий, последовательное выполнение операций.Существуют физические ограничения на преобразование. Результатом такого типа мышления становится мысль, воплощенная в новой конструкции",
                                        "Символическое мышление. Люди с математическим складом ума отдают предпочтение символическому мышлению,когда происходит преобразование информации с помощью правил вывода (в частности, алгебраических правил или арифметических знаков и операций).Результатом является мысль, выраженная в виде структур и формул, фиксирующих существенные отношения между символами",
                                        "Знаковое мышление. Личности с гуманитарным складом ума предпочитают знаковое мышление.Оно характеризуется преобразованием информации с помощью умозаключений.Знаки объединяются в более крупные единицы по правилам единой грамматики.Результатом является мысль в форме понятия или высказывания, фиксирующего существенные отношения между обозначаемыми предметами",
                                        "Образное мышление. Люди с художественным складом ума предпочитают образный тип мышления.Это отделение от предмета в пространстве и времени, осуществление преобразования информации с помощью действий с образами.Нет физических ограничений на преобразование. Операции могут осуществляться как последовательно, так и одновременно.Результатом служит мысль, воплощенная в новом образе",
                                        "Креативность - творческие способности человека, характеризующиеся готовностью к созданию принципиально новых идей.По мнению П. Торренса, креативность включает в себя повышенную чувствительность к проблемам, к дефициту или противоречивости знаний,действия по определению этих проблем, по поиску их решений на основе выдвижения гипотез, по проверке и изменению гипотез,по формулированию результата решения. Для развития творческого мышления используются обучающие ситуации,которые характеризуются незавершенностью или открытостью для включения новых элементов, поощряется к формулировка множества вопросов"
    };
    int prioriry=0;

    int[] results = new int[5];

    public int searchMax(int mas[]){
        int max = mas[0];
        int index = 0;
        for(int i = 0; i < 5; i++){
            if(max < mas[i]) {
                max = mas[i];
                index = i;
            }
        }
        return index;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultsTextView = (TextView) findViewById(R.id.textView4);
        description = (TextView) findViewById(R.id.description);

        Intent intent = getIntent();

        results[0] = intent.getIntExtra("subject", 0);
        results[1] = intent.getIntExtra("symbol", 0);
        results[2] = intent.getIntExtra("sign", 0);
        results[3] = intent.getIntExtra("sample", 0);
        results[4] = intent.getIntExtra("creativity", 0);

        resultsTextView.setText("Предметное мышление: " + String.valueOf(results[0]) + "\n" +
                "Символическое мышление: " + String.valueOf(results[1]) + "\n" +
                "Знаковое мышление: " + String.valueOf(results[2]) + "\n" +
                "Образное мышление: " + String.valueOf(results[3]) + "\n" +
                "Креативность: " + String.valueOf(results[4]));

        prioriry = searchMax(results);
        description.setText(descriptionText[prioriry]);
    }

}
