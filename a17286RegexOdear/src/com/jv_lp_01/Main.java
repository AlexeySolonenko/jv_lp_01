package com.jv_lp_01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	    String string = "I am a string. Yes, I am";
        System.out.println(string);
        String newString = string.replaceAll("I","You");
        System.out.println(newString);

        String alphanumeric = "abcDeeeF12ghiiijk199z";
        System.out.println(alphanumeric.replaceAll(".","y"));
        System.out.println(alphanumeric.replaceAll("^abcdEEE","y"));


        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiijkl99z"));

        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));

        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);
        System.out.println(hasWhitespace.replaceAll("\\s", ""));
        System.out.println(hasWhitespace.replaceAll("\t", "X"));
        System.out.println(hasWhitespace.replaceAll("\\S", ""));
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhitespace.replaceAll("\\w", "X"));
        System.out.println(hasWhitespace.replaceAll("\\b", "X"));


        System.out.println("=====================================================");
        String thirdAlphanumericString = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = ".*<h2>.*";
        //h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);

        System.out.println(matcher.matches());


        System.out.println("=======================================================");

        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());

        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPatten = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPatten.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        System.out.println("=============================");
        /* OR operators  */
        System.out.println("harry".replaceAll("[Hh]arry","Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry","Larry"));
        System.out.println("HHHarry".replaceAll("[H|h]arry","Larry"));
        System.out.println("HHHarry".replaceAll("[Hh]","L"));
        System.out.println("HHHarry".replaceAll("[H|h]","L"));
        System.out.println("HhHarry".replaceAll("[H|h]","L"));

        System.out.println("=============================");

        /* negative look ahead expression */
        String tvTest = "tstvtkt";
        /* does not find the last one, because is greedey  */
        String tNotVRegexp = "t[^v]";
        /* negative look ahead does not consume */
        tNotVRegexp = "t(?!v)";
        /* positve look ahaead t(?=v) - all matches of t followed by v */
        Pattern tNotVpattern = Pattern.compile(tNotVRegexp);
        Matcher tNotVMatcher = tNotVpattern.matcher(tvTest);
        count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurence " + count + ": " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        // t(?=v)
        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        String phone1 = "1234567890";  // Shouldn't match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // Shouldn't match
        String phone4 = "(123)456-7890"; // Shouldn't match

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        // ^4[0-9]{12}([0-9]{3})?$
        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));

        /* challenge 1 */
        System.out.println("I want a bike".matches("I want a.*"));
        // I wnat a \\w+.
        // with group I want a (bike|ball)."
        System.out.println("I want a ball".matches("I want a.*"));
        /* challenge 2 */

        System.out.println("=3================================");
        String challengeRegex = "I want a \\w+";
        Pattern challengePattern  = Pattern.compile(challengeRegex);
        String text1 = "I want a bike";
        String text2 = "I want a ball";
        Matcher challengeMatcher = challengePattern.matcher(text1);
        System.out.println(challengeMatcher.matches());
        challengeMatcher = challengePattern.matcher(text2);
        System.out.println(challengeMatcher.matches());

        text1 = "Replace all blanks with underscores";
        text1.replaceAll(" ","_");
        System.out.println(text1.replaceAll("\\s","_"));

        System.out.println("=5================================");
        text1 = "aaabccccccccdddefffg";
        challengeRegex = "a+b+c+d+e+f+g";
        challengePattern = Pattern.compile(challengeRegex);
        System.out.println(challengePattern.matcher(text1).matches());
        // [abcdefg]+
        // [a-g]+
        System.out.println("=6================================");
        challengeRegex = "^a{3}b{1}c{8}d{3}e{1}f{3}g$";
        System.out.println(Pattern.compile(challengeRegex).matcher(text1).matches());



        System.out.println("=7================================");
        text1 = "abcd.135";
        text2 = "kjisl.22.135";
        String text3 = "f5.12a";
        challengeRegex = "^[a-zA-Z]+\\.\\d+.*";
        //challengeRegex = "^[a-zA-z]";
        challengePattern = Pattern.compile(challengeRegex);
        System.out.println(challengePattern.matcher(text1).matches());
        System.out.println(challengePattern.matcher(text2).matches());
        System.out.println(challengePattern.matcher(text3).matches());

        System.out.println("=8================================");
        challengeRegex = "(^[a-zA-Z])+(\\.)(\\d+).*";
        challengeRegex = "(\\d+)";
        challengeRegex = "[a-zA-Z]\\.(\\d+)";
        challengePattern = Pattern.compile(challengeRegex);
        text1 = "abcd.135uvqz.7tzik.999";
        challengeMatcher = challengePattern.matcher(text1);
        count = 0;

        while (challengeMatcher.find()) {
            count++;
            System.out.println("Occurence "+ count + " : " + challengeMatcher.group(1));
        }

        System.out.println("=9================================");
        challengeRegex = "(^[a-zA-Z])+(\\.)(\\d+).*";
        challengeRegex = "(\\d+)";
        challengeRegex = "[a-zA-Z]\\.(\\d+)";
        /* or */
        challengeRegex = "[a-zA-Z]\\.(\\d+)\\s";
        challengePattern = Pattern.compile(challengeRegex);
        text1 = "abcd.135\tuvqz.7\tttzik.99\n";
        challengeMatcher = challengePattern.matcher(text1);
        count = 0;

        while (challengeMatcher.find()) {
            count++;
            System.out.println("Occurence "+ count + " : " + challengeMatcher.group(1));
        }


        System.out.println("=10================================");
        challengeRegex = "(^[a-zA-Z])+(\\.)(\\d+).*";
        challengeRegex = "(\\d+)";
        challengeRegex = "[a-zA-Z]\\.(\\d+)";
        /* or */
        challengeRegex = "[a-zA-Z]\\.(\\d+)\\s";
        challengePattern = Pattern.compile(challengeRegex);
        text1 = "abcd.135\tuvqz.7\tttzik.99\n";
        challengeMatcher = challengePattern.matcher(text1);
        count = 0;

        while (challengeMatcher.find()) {
            count++;
            System.out.println("Occurence "+ count + " : " + challengeMatcher.group(1));
            System.out.println("From "+ challengeMatcher.start(1) + " to " + (challengeMatcher.end(1)-1));
            }


        System.out.println("=11================================");
        challengeRegex = "\\{(.*?)\\}";
        challengePattern = Pattern.compile(challengeRegex);
        text1 = "{0, 2}, {0, 5}, {1, 4}, {2, 4}";

        challengeMatcher = challengePattern.matcher(text1);
        count = 0;

        while (challengeMatcher.find()) {
            count++;
            System.out.println("Occurence "+ count + " : " + challengeMatcher.group(1));
            System.out.println("From "+ challengeMatcher.start(1) + " to " + (challengeMatcher.end(1)-1));
        }

        System.out.println("=11a================================");
        challengeRegex = "\\{(\\d+, \\d+)\\}";
        challengePattern = Pattern.compile(challengeRegex);
        text1 = "{0, 2}, {0, 5}, {1, 4}, {x, y}, {11, 12}, {2, 4}";

        challengeMatcher = challengePattern.matcher(text1);
        count = 0;

        while (challengeMatcher.find()) {
            count++;
            System.out.println("Occurence "+ count + " : " + challengeMatcher.group(1));
            System.out.println("From "+ challengeMatcher.start(1) + " to " + (challengeMatcher.end(1)-1));
        }

        System.out.println("=12================================");
        challengeRegex = "^\\d{5}$";
        challengePattern = Pattern.compile(challengeRegex);
        text1 = "11111";
        System.out.println(text1.matches(challengeRegex));
        challengeMatcher = challengePattern.matcher(text1);
        count = 0;


        System.out.println("=13================================");
        challengeRegex = "^\\d{5}(-\\d{4})*";
        challengeRegex = "^\\d{5}(-\\d{4})?";
        challengePattern = Pattern.compile(challengeRegex);
        text1 = "11111-1111";
        text1 = "11111";
        System.out.println(text1.matches(challengeRegex));
        challengeMatcher = challengePattern.matcher(text1);
        count = 0;

    }
}
