package data.format;
import exceptions.InvalidXMLInputFieldValue;
import exceptions.InvalidXMLInputStructure;

import java.time.LocalDate;
import java.util.Date;
import java.util.Stack;

/**
 * Class required for storing MusicBand instances
 */
public class MusicBand implements Comparable<MusicBand> {
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private java.time.LocalDate creationDate;
    private int numberOfParticipants;
    private String description;
    private java.util.Date establishmentDate;
    private MusicGenre genre;
    private Person frontMan;

    public void setId(Stack<MusicBand> mystack) {
        int idvalue = 1;
        for (MusicBand band: mystack){
            if (Integer.parseInt(band.getId())>=idvalue){
                idvalue = Integer.parseInt(band.getId()) + 1;
            }
        }
        this.id = idvalue;
    }
    public void setName(String name) throws InvalidXMLInputFieldValue{
        if (name.equals("")){
            throw new InvalidXMLInputFieldValue("Недопустимое значение NAME.");
        } else {
            this.name = name;
        }

    }
    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }
    public void setCreationDate(){
        Date date = new Date();
        this.creationDate = java.time.LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
    }

    public void setNumberOfParticipants(String num) throws InvalidXMLInputFieldValue{
        int value = Integer.parseInt(num);
        if (value > 0) {
            this.numberOfParticipants = value;
        } else {
            throw new InvalidXMLInputFieldValue("Недопустимое значение NumberOfParticipants.");
        }
    }
    public void setDescription(String description) throws InvalidXMLInputFieldValue{
        if (!description.equals("")){
            this.description = description;}
        else {throw new InvalidXMLInputFieldValue("Недопустимое значение Description.");}

    }

    public void setEstablishmentDate(String s) {
        if (s.equals("")) {
            this.establishmentDate = null;
        } else {
            this.establishmentDate = new java.util.Date(Long.parseLong(s));
        }
    }

    public void setGenre(String genre) throws InvalidXMLInputFieldValue {
        if (MusicGenre.contains(genre)) {
            this.genre = MusicGenre.valueOf(genre);
        } else {
            throw new InvalidXMLInputFieldValue("Недопустимое значение Genre.");
        }
    }
    public void setFrontMan(Person frontMan){
        this.frontMan = frontMan;
    }
    public void setFrontMan(String s) throws InvalidXMLInputFieldValue{
        if (s.equals("")) {
            this.frontMan = null;
        } else {
            throw new InvalidXMLInputFieldValue("Недопустимое значение FrontMan.");
        }
    }

    public String getName() {
        return name;
    }

    public String getEstablishmentDate() {
        if (this.establishmentDate == null){
            return ("");
        }else {
            return establishmentDate.getTime() + "";
        }
    }

    public String getNumberOfParticipants()  {
        return numberOfParticipants + "";
    }

    public String getId() {
        return id.toString();
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre.name();
    }

    public String[] getFrontMan() {
        if (this.frontMan == null) {
            return new String[] {""};
        } else {
            return new String[]{frontMan.getName(), frontMan.getPassportID(), frontMan.getEyeColor(), frontMan.getLocation()[0], frontMan.getLocation()[1], frontMan.getLocation()[2]};
        }
    }

    public String[] getCoordinates() {
        return new String[] {coordinates.getX(),coordinates.getY()};
    }

    public String[] getCreationDate() {
        String year = creationDate.getYear() + "";
        String month = creationDate.getMonth().name();
        String dayofmonth = creationDate.getDayOfMonth() + "";
        return new String[] {year,month,dayofmonth};
    }

    public void saveID(Integer defid){
        this.id = defid;
    }

    /**
     * Method used to check if all of nessessary fileds are given a value
     * @return true if all of fields are given a value and false if not
     */
    public boolean Complete(){
        if ((this.name==null)||(this.coordinates==null)||(this.description==null)||(this.genre==null)){
            return  false;
        } else if ((this.frontMan!=null)&&(!this.frontMan.Complete())) {
            return  false;
        } else {
            return true;
        }
    }

    @Override
    public String toString(){
        return getClass().getName()+'-'+name+'-'+id;
    }

    /**
     * Overrided methor nessessary for comparing MusicBand instances
     * @param m
     * @return
     */
    @Override
    public int compareTo( MusicBand m) {

        return this.id - m.id;
    }
}
