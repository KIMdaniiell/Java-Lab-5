package data.format;
import exceptions.InvalidInputValueException;
import exceptions.InvalidXMLInputStructureException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
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
        mystack.sort(new Comparator<MusicBand> (){
            public int compare(MusicBand band1, MusicBand band2) {
                return band1.getId().compareTo(band2.getId());
            }
        } );
        for (MusicBand band: mystack){
            if (band.getId().intValue()>=idvalue){
                idvalue = band.getId().intValue() + 1;
            }
        }
        this.id = idvalue;
    }

    public void setName(String name) throws InvalidInputValueException{
        if (name.equals("")){
            throw new InvalidInputValueException("Недопустимое значение NAME.");
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

    public void setNumberOfParticipants(String num) throws InvalidInputValueException{
        int value = Integer.parseInt(num);
        if (value > 0) {
            this.numberOfParticipants = value;
        } else {
            throw new InvalidInputValueException("Недопустимое значение NumberOfParticipants.");
        }
    }

    public void setDescription(String description) throws InvalidInputValueException{
        if (!description.equals("")){
            this.description = description;}
        else {throw new InvalidInputValueException("Недопустимое значение Description.");}

    }

    public void setEstablishmentDate(String s) {
        if (s.equals("")) {
            this.establishmentDate = null;
        } else {
            this.establishmentDate = new java.util.Date(Long.parseLong(s));
        }
    }

    public void setGenre(String genre) throws InvalidInputValueException {
        if (MusicGenre.contains(genre)) {
            this.genre = MusicGenre.valueOf(genre);
        } else {
            throw new InvalidInputValueException("Недопустимое значение Genre.");
        }
    }

    public void setFrontMan(Person frontMan){
        this.frontMan = frontMan;
    }

    public void setFrontMan(String s) {
        this.frontMan = null;
    }

    public String getName() {
        return name;
    }

    public java.util.Date getEstablishmentDate() {
        //if (this.establishmentDate == null){
        //    return (null);
        //}else {
        //    //return establishmentDate.getTime() + "";
        //    return establishmentDate;
        //}
        return establishmentDate;
    }

    public int getNumberOfParticipants()  {
        return numberOfParticipants;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public Person getFrontMan() {
        return frontMan;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public java.time.LocalDate getCreationDate() {
        return creationDate;
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
        int result = this.name.compareTo(m.getName());
        if (result == 0){
            result = this.genre.compareTo(m.genre);
        }
        return result;
    }
}
