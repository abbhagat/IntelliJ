package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLOperations {

  private static String xml = "<?xml version=\"1.0\"?>"
      + "<config>"
      + "<Request name=\"ValidateEmailRequest\">"
      + "<requestqueue>emailrequest</requestqueue>"
      + "<responsequeue>emailresponse</responsequeue>"
      + "<ns3:encodedKey>~1234-ACD~124~</ns3:encodedKey>"
      + "<ns3:encodedKey>acd~</ns3:encodedKey>"
      + "</Request>"
      + "<Request name=\"CleanEmail\">"
      + "<requestqueue>Cleanrequest</requestqueue>"
      + "<responsequeue>Cleanresponse</responsequeue>"
      + "<ns3:encodedKey>1234</ns3:encodedKey>"
      + " </Request>"
      + "</config>";

  public static void main(String[] args) {
    String patternString = "(encodedKey>)(.*)(<.*encodedKey>)";
    Pattern pattern = Pattern.compile(patternString);
    xml = xml.replaceAll("><", ">\n<");
    Matcher matcher = pattern.matcher(xml);
    System.out.println(matcher.replaceAll("XXX"));
  }
}
