package data.format;

import exceptions.InvalidXMLInputFieldValue;

/**
 * This class contains numeric parameters of MusicBand.FrontMans' location
 */
public class Location {
    private Integer x; //Поле не может быть null
    private int y;
    private int z;

    /**
     * Setter for Y paremeter
     * @param value - string representation of Y paremeter
     * @throws InvalidXMLInputFieldValue if value does not feat the conditions written in the Task
     */
    public void setY(String value) throws InvalidXMLInputFieldValue {
        if (!value.equals("")) {
            y=Integer.parseInt(value);
        } else {
            throw new InvalidXMLInputFieldValue("Недопустимое значение Person.Location.Y");
            //примитивный тип int не может принимать значение null
        }
    }

    /**
     * Setter for X paremeter
     * @param value - string representation of X paremeter
     * @throws InvalidXMLInputFieldValue if value does not feat the conditions written in the Task
     */
    public void setX(String value) throws InvalidXMLInputFieldValue {
        if (!value.equals("")) {
            x=Integer.valueOf(value);
        } else {
            throw new InvalidXMLInputFieldValue("Недопустимое значение Person.Location.X");
        }
    }

    /**
     * Setter for Y paremeter
     * @param value - string representation of Y paremeter
     * @throws InvalidXMLInputFieldValue if value does not feat the conditions written in the Task
     */
    public void setZ(String value) throws InvalidXMLInputFieldValue  {
        if (!value.equals("")) {
            z=Integer.parseInt(value);
        } else {
            throw new InvalidXMLInputFieldValue("Недопустимое значение Person.Location.Z");
            //примитивный тип int не может принимать значение null
        }
    }

    /**
     * Getter for Y parameter
     * @return string representation of Y parameter
     */
    public String getY() {
        return y + "";
    }

    /**
     * Getter for Z parameter
     * @return string representation of Z parameter
     */
    public String getZ() {
        return z + "";
    }

    /**
     * Getter for X parameter
     * @return string representation of X parameter
     */
    public String getX() {
        return x.toString();
    }

    /**
     * Method used to check if all of nessessary fileds are given a value
     * @return true if all of fields are given a value and false if not
     */
    public boolean Complete(){
        if (this.x==null){
            return false;
        } else{
            return true;
        }
    }
}