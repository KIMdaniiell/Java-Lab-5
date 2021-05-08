package data.format;

import exceptions.InvalidXMLInputFieldValue;

/**
 * Contains numeric parameters of MusicBands' coordinates
 */
public class Coordinates {
    private long x;
    private Double y;

    /**
     * Setter for X paremeter
     * @param value - string representation of X paremeter
     */
    public void setX(String value){
        this.x = Long.parseLong(value);
    }
    /**
     * Setter for Y paremeter
     * @param value - string representation of Y paremeter
     */
    public void setY(String value) throws InvalidXMLInputFieldValue {
        if (!value.equals("")){
            if ((Double.parseDouble(value) <= 407)&&(Double.parseDouble(value) <= 407)){
                this.y = Double.parseDouble(value);
            }else {
                throw new InvalidXMLInputFieldValue("Недопустимое значение Coordinates.Y");
            }
        } else {
            throw new InvalidXMLInputFieldValue("Недопустимое значение Coordinates.Y");
        }
    }
    /**
     * Getter for X paremeter
     */
    public String getX() {
        return x + "" ;
    }
    /**
     * Getter for Y paremeter
     */
    public String getY() {
        return y + "" ;
    }
}
