package org.top.quotagen;

public class Parsed {
    public static String parseQuota (String string) {
        String quota;
        String author;
        int nuQ = string.indexOf("\"q\":\"");
        int nuA = string.indexOf(",\"a\":\"");
        int nuH = string.indexOf(",\"h\":");
        quota = string.substring(nuQ + 4, nuA);
        author = string.substring(nuA + 6, nuH - 1);
        string = quota + " - " + author;

        return string;
    }


    public static void main(String[] args) {
        System.out.println(parseQuota("'[ {\"q\":\"Life was meant to be lived, and curiosity must be kept alive. " +
                "One must never, for whatever reason, turn his back on life.\",\"a\":\"Eleanor Roosevelt\",\"h\":\"<blockquote>&ldquo;" +
                "Life was meant to be lived, and curiosity must be kept alive. One must never, for whatever reason," +
                " turn his back on life.&rdquo; &mdash; <footer>Eleanor Roosevelt</footer></blockquote>\"} ]'\n"));
    }
}