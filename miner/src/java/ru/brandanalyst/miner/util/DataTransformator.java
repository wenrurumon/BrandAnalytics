package ru.brandanalyst.miner.util;

/**
 * Created by IntelliJ IDEA.
 * User: Dmitry Batkovich
 * Date: 10/24/11
 * Time: 6:20 PM
 * help class to parse data
 */
public final class DataTransformator {

    private DataTransformator() {

    }

    public static String stringToQueryString(String str) {
        String query = "";
        for (int i = 0; i < str.length(); i++) {
            if ((int)str.charAt(i) == 32) {
                query += "+";
                continue;
            }
            query += str.charAt(i);
        }
        return query;
    }

    public static String stringToHexQueryString(String str) {
        String query = "";
        for (int i = 0; i < str.length(); i++) {
            if ((int)str.charAt(i) > 1000) {
                query += charToHex(str.charAt(i));
            }
            if ((int)str.charAt(i) == 32) {
                query += "+";
                continue;
            }
            if ((int)str.charAt(i) < 1000) {
                query += str.charAt(i);
            }
        }
        return query;
    }

    private static String charToHex(char character) {
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("%" + Integer.toHexString((int) character - 80).substring(1));
        return strBuffer.toString();
    }

    public static String clearString(String toClear) {
        int a, b;
        while (toClear.indexOf('<') != (-1)) {
            a = toClear.indexOf('<');
            b = toClear.indexOf('>');
            if (b > a) {
                toClear = toClear.substring(0, a) + toClear.substring(b, toClear.length());
                toClear = toClear.replaceFirst(">", " ");
            }
        }
        toClear = toClear.replaceAll("\n"," ");
        toClear = toClear.replaceAll("\t", "");
        toClear = toClear.replaceAll(" {2,}", " ");
        toClear = toClear.replaceAll(" {1,}[.]", ".");
        toClear = toClear.replaceAll(" {1,}[,]", ",");
        toClear = toClear.replaceAll("  "," ");
        return toClear;
    }
}
