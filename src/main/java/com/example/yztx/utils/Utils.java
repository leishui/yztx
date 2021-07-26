package com.example.yztx.utils;

import com.example.yztx.constant.DefaultValues;
import com.example.yztx.constant.SourceType;
import com.example.yztx.domain.Lesson;
import com.example.yztx.domain.Stvd;

public class Utils {
    public static String generateVerificationCode() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
    }

    public static Lesson uploadLesson(Lesson lesson) {
        lesson.cover_url = DefaultValues.DEFAULT_COVER;
        lesson.name = "";
        lesson.description = "";
        lesson.lesson_type = 0;
        lesson.source_type = SourceType.SOURCE_ORIGINAL;
        lesson.upload_time = 0;
        return lesson;
    }
    public static Stvd uploadStvd(Stvd stvd) {
        stvd.cover_url = DefaultValues.DEFAULT_COVER;
        stvd.title = "";
        stvd.description = "";
        stvd.stvd_type = 0;
        stvd.source_type = SourceType.SOURCE_ORIGINAL;
        stvd.upload_time = 0;
        return stvd;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(generateVerificationCode());
        }
    }
}
