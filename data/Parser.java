package data;
import java.io.FileNotFoundException;
import java.time.Month;
import java.util.Stack;
import data.format.*;
import java.io.File;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;

import exceptions.*;

/**
 *  This class makes conversion between MusicBand instances and XML structure
 */
public class Parser {
    private static Stack<MusicBand> mystack = new Stack<>();
    private static String data_path;
    /**
     * Static method used for convertating XML structure into MusicBand instances
     * @param indata_path - path of XML-document
     */
    public static Stack<MusicBand> serialize (String indata_path){
        //Конвертирует xml структуру в объекты класса MusicBand и наполняет ими коллекцию mystack
        data_path = indata_path;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File(data_path);
            if (file.exists()){

                Document document = builder.parse(new File(data_path));
                Element rootelement = document.getDocumentElement();
                NodeList bandList = rootelement.getChildNodes();

                for (int bandcounter =0; bandcounter < bandList.getLength(); bandcounter++) {
                    if (bandList.item(bandcounter) instanceof Element) {
                        MusicBand band = new MusicBand();
                        NodeList fieldList = bandList.item(bandcounter).getChildNodes();
                        for (int fieldcounter = 0; fieldcounter < fieldList.getLength(); fieldcounter++) {
                            if (fieldList.item(fieldcounter) instanceof Element){
                                String nodename = fieldList.item(fieldcounter).getNodeName();
                                if (fieldList.item(fieldcounter).hasChildNodes()) {

                                    switch (nodename) {
                                        case "coordinates" : {
                                            NodeList coordinatesfields = fieldList.item(fieldcounter).getChildNodes();
                                            Coordinates coordinates = new Coordinates();
                                            for (int coordfieldscounter = 0; coordfieldscounter < coordinatesfields.getLength(); coordfieldscounter++) {
                                                if (coordinatesfields.item(coordfieldscounter) instanceof Element) {
                                                    String cnodevalue = ((Element) coordinatesfields.item(coordfieldscounter)).getAttribute("value");
                                                    String cnodename = coordinatesfields.item(coordfieldscounter).getNodeName();
                                                    if (cnodename.equals("x")) {
                                                        coordinates.setX(cnodevalue);
                                                    } else if (cnodename.equals("y")) {
                                                        coordinates.setY(cnodevalue);
                                                    } else {
                                                        throw new InvalidXMLInputStructureException("Ошибка входных данных. Недопустимое поле.");
                                                    }
                                                }
                                            }
                                            band.setCoordinates(coordinates);
                                        } break;
                                        case "creationDate" : {
                                            band.setCreationDate();
                                        } break;
                                        case "frontMan" : {
                                            Person p = new Person();
                                            NodeList personfields = fieldList.item(fieldcounter).getChildNodes();
                                            for (int pfieldscounter = 0; pfieldscounter < personfields.getLength(); pfieldscounter++) {
                                                if (personfields.item(pfieldscounter) instanceof Element) {
                                                    String personnodename = personfields.item(pfieldscounter).getNodeName();
                                                    String personnodevalue = ((Element) personfields.item(pfieldscounter)).getAttribute("value");
                                                    switch (personnodename) {
                                                        case "name" : p.setName(personnodevalue);break;
                                                        case "passportID" : p.setPassportID(personnodevalue);break;
                                                        case "eyeColor" : p.setEyeColor(personnodevalue);break;
                                                        case "location" : {
                                                            Location loc = new Location();
                                                            NodeList locationcoords = personfields.item(pfieldscounter).getChildNodes();
                                                            for (int lcoord = 0; lcoord < locationcoords.getLength(); lcoord++) {
                                                                if (locationcoords.item(lcoord) instanceof Element) {
                                                                    String lcnodename = locationcoords.item(lcoord).getNodeName();
                                                                    String lcnodevalue = ((Element) locationcoords.item(lcoord)).getAttribute("value");
                                                                    switch (lcnodename) {
                                                                        case "x" : loc.setX(lcnodevalue); break;
                                                                        case "y" : loc.setY(lcnodevalue); break;
                                                                        case "z" : loc.setZ(lcnodevalue); break;
                                                                    }
                                                                }
                                                            }
                                                            p.setLocation(loc);
                                                        } break;
                                                        default : throw new InvalidXMLInputStructureException("Ошибка входных данных. Недопустимое поле.");
                                                    }
                                                }
                                            }
                                            band.setFrontMan(p);
                                        } break;
                                        default : throw new InvalidXMLInputStructureException("Ошибка входных данных. Недопустимое поле.");
                                    }
                                } else {
                                    String nodevalue = ((Element) fieldList.item(fieldcounter)).getAttribute("value");

                                    switch (nodename) {
                                        case "id" : band.setId(mystack); break;
                                        case "name" : band.setName(nodevalue); break;
                                        case "numberOfParticipants" : band.setNumberOfParticipants(nodevalue); break;
                                        case "description" : band.setDescription(nodevalue); break;
                                        case "genre" : band.setGenre(nodevalue); break;
                                        case "frontMan" : band.setFrontMan(nodevalue); break;
                                        case "establishmentDate" : band.setEstablishmentDate(nodevalue); break;
                                        default : throw new InvalidXMLInputStructureException("Ошибка входных данных. Недопустимое поле.");
                                    }
                                }
                            }
                        }
                        try {
                            if (band.Complete()) {
                                mystack.push(band);
                            } else{
                                throw new InvalidXMLInputStructureException("Ошибка при чтении из файла. Не найдены необходимые теги");
                            }
                        } catch ( InvalidXMLInputStructureException e){
                            System.out.println(e.getMessage());
                        }

                    }
                }
            } else {
                System.out.println("Файл не найден. Коллекция пуста.");
            }
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден. Коллекция пуста.");
        } catch (ParserConfigurationException | IOException e){
            System.out.println("ParserConfigurationException/IOException");
            System.out.println(e.getMessage());
        } catch (SAXException e) {
            System.out.println("Ошибка тегов.");
        } catch (InvalidInputValueException | InvalidXMLInputStructureException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return mystack;
    }
    /**
     * Static method used for convertating main collection (Stack<MusicBand>) content into  XML structure
     * @param indata_path - path of XML-document
     * @param somestack - main collection (Stack<MusicBand>)
     */
    public static void deserialize (String indata_path, Stack<MusicBand> somestack){
        data_path = indata_path;
        mystack = somestack;
        String xmlstructure = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        try{
            File file = new File(data_path);
            if (!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);

            pw.println(xmlstructure);
            pw.println("<MusicBands>");
            for (MusicBand band: mystack){
                pw.println("\t<MusicBand>");
                pw.printf("\t\t<id value=\"%s\"/>\n",band.getId().toString());
                pw.printf("\t\t<name value=\"%s\"/>\n",band.getName());
                pw.println("\t\t<coordinates>");
                pw.printf("\t\t\t<x value=\"%s\"/>\n",band.getCoordinates().getX() + "");
                pw.printf("\t\t\t<y value=\"%s\"/>\n",band.getCoordinates().getY().toString());
                pw.println("\t\t</coordinates>");
                pw.println("\t\t<creationDate>");
                pw.printf("\t\t\t<year value=\"%s\"/>\n",band.getCreationDate().getYear() + "");
                pw.printf("\t\t\t<month value=\"%s\"/>\n",band.getCreationDate().getMonth().name());
                pw.printf("\t\t\t<dayofmonth value=\"%s\"/>\n",band.getCreationDate().getDayOfMonth() + "");
                pw.println("\t\t</creationDate>");
                pw.printf("\t\t<numberOfParticipants value=\"%s\"/>\n",band.getNumberOfParticipants()+ "");
                pw.printf("\t\t<description value=\"%s\"/>\n",band.getDescription());

                if (band.getEstablishmentDate()==null){
                    pw.printf("\t\t<establishmentDate value=\"%s\"/>\n","");
                } else{
                    pw.printf("\t\t<establishmentDate value=\"%s\"/>\n",band.getEstablishmentDate().getTime()+"");
                }

                pw.printf("\t\t<genre value=\"%s\"/>\n",band.getGenre().name());
                if (band.getFrontMan() != null){
                    pw.println("\t\t<frontMan>");
                    pw.printf("\t\t\t<name value=\"%s\"/>\n",band.getFrontMan().getName());
                    pw.printf("\t\t\t<passportID value=\"%s\"/>\n",band.getFrontMan().getPassportID());
                    pw.printf("\t\t\t<eyeColor value=\"%s\"/>\n",band.getFrontMan().getEyeColor().name());
                    pw.println("\t\t\t<location>");
                    pw.printf("\t\t\t\t<x value=\"%s\"/>\n",band.getFrontMan().getLocation().getX().toString());
                    pw.printf("\t\t\t\t<y value=\"%s\"/>\n",band.getFrontMan().getLocation().getY() + "");
                    pw.printf("\t\t\t\t<z value=\"%s\"/>\n",band.getFrontMan().getLocation().getZ() + "");
                    pw.println("\t\t\t</location>");
                    pw.println("\t\t</frontMan>");
                } else {
                    pw.println("\t\t<frontMan value=\"\"/>");
                }
                pw.println("\t</MusicBand>");
            }
            pw.println("</MusicBands>");


            pw.close();
        } catch (IOException e){
            System.out.println("Ошибка " + e  );
        }

    }
}
