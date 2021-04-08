package goldmansach;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XMLNode {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setExpandEntityReferences(false);
        Document doc = null;

        doc = factory.newDocumentBuilder().parse(new File("E:\\Java\\IntelliJ\\Resource\\Emp.xml"));
        NodeList list = doc.getElementsByTagName("*");
        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
        for (int i = 0; i < list.getLength(); i++) {
            int childNodes = list.item(i).getChildNodes().getLength();
            if (childNodes == 0 && list.item(i).getNodeValue() == null) {
                String str = "<" + list.item(i).getNodeName() + ">" + "</" + list.item(i).getNodeName() + ">";
                chm.put(list.item(i).getNodeName(), str);
            }
        }
        FileReader fr = new FileReader("E:\\Java\\IntelliJ\\Resource\\Emp.xml");
        BufferedReader R = new BufferedReader(fr);
        String s = R.readLine();
        StringBuilder sb = new StringBuilder();
        while ((s = R.readLine()) != null) {
            sb.append(s);
            // System.out.println(s.trim());
        }
        fr.close();
        s = sb.toString();
        //	    Iterator i = chm.entrySet().iterator();
        //	    while (i.hasNext()) {
        //	        s = s.replace(("<" + i.next().getKey() + "/>"), i.next().getValue());
        //	    }

        Iterator<Map.Entry<String, String>> iterator = chm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> m = iterator.next();
            s = s.replace(("<" + m.getKey() + "/>"), m.getValue());
        }

        FileWriter fw = new FileWriter("E:\\Java\\IntelliJ\\Resource\\Test1.xml");
        fw.write(s);
        fw.close();
        factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);

        DocumentBuilder builder = factory.newDocumentBuilder();

        builder.setErrorHandler(new SimpleErrorHandler());
        try {
            Document document = builder.parse(new InputSource("E:\\Java\\IntelliJ\\Resource\\Emp.xml"));
        } catch (SAXException e) {
            System.out.println(e.getCause());
            System.out.println("Parsing error");
            e.printStackTrace();
        }
        System.out.println(s);
    }

}
