package com.example.hua.yatnet.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZengHongHua on 2018/12/14.
 */
public class ZUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0 || "null".equals(str.trim());
    }

    /**
     * 是否是Emoji表情符号
     */
    public static boolean isEmojiT(String string) {
        Pattern p = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(string);
        return m.find();
    }

    public static String getStringS() {
        return "45458";
    }
}
