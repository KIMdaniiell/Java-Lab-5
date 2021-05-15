package data.format;

import exceptions.InvalidInputValueException;
import exceptions.InvalidXMLInputStructureException;

import java.time.LocalDate;
import java.util.*;

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

    public void setCreationDate() {
        Date date = new Date();
        this.creationDate = java.time.LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidInputValueException {
        if (name.equals("")) {
            throw new InvalidInputValueException("Недопустимое значение NAME.");
        } else {
            this.name = name;
        }

    }

    public java.util.Date getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(java.util.Date date) {
        this.establishmentDate = date;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(Integer num) {
        this.numberOfParticipants = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Stack<MusicBand> mystack) {
        HashSet<Integer> setofid = new HashSet<Integer>();
        for (MusicBand band : mystack) {
            setofid.add(band.getId());
        }
        int idvalue = mystack.size() + 1;
        for (int i = mystack.size(); i > 0; i--) {
            if (!setofid.contains(Integer.valueOf(i)) && (i <= idvalue)) {
                idvalue = i;
            }
        }
        this.id = idvalue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public Person getFrontMan() {
        return frontMan;
    }

    public void setFrontMan(Person frontMan) {
        this.frontMan = frontMan;
    }

    public void setFrontMan(String s) {
        this.frontMan = null;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public java.time.LocalDate getCreationDate() {
        return creationDate;
    }

    public void saveID(Integer defid) {
        this.id = defid;
    }

    /**
     * Method used to check if all of nessessary fileds are given a value
     *
     * @return true if all of fields are given a value and false if not
     */
    public boolean Complete() {
        if ((this.name == null) || (this.coordinates == null) || (this.description == null) || (this.genre == null)) {
            return false;
        } else return (this.frontMan == null) || (this.frontMan.Complete());
    }

    @Override
    public String toString() {
        return getClass().getName() + '-' + name + '-' + id;
    }

    /**
     * Overrided methor nessessary for comparing MusicBand instances
     *
     * @param m
     * @return
     */
    @Override
    public int compareTo(MusicBand m) {
        int result = this.name.compareTo(m.getName());
        if (result == 0) {
            result = this.genre.compareTo(m.genre);
        }
        return result;
    }
}
