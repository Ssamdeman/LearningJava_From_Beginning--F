/* *****************************************************************************
 *  Name:              Ssam Samid
 *  Coursera User ID:  HW1
 *  Last modified: 02/31/2022
 *
 *
 **************************************************************************** */


public class RationalNumber {

    private int x;
    private int y;

    public RationalNumber(int x, int y) {
        this.x = x;
        if (y == 0) {
            System.out.println("Invalid Input. Try again");
            System.exit(1);
        }
        else {
            this.y = y;
        }
    }

    //setters;
    public void setNumerator(int x) {
        this.x = x;
    }

    public void setDenomintor(int y) {
        this.y = y;
    }

    //Getters
    public int getNumerator() {
        return this.x;
    }

    public int getDenominator() {
        return this.y;
    }

    //------------------------------------------
    public RationalNumber add(RationalNumber r1) {
        int endResultNumerator = this.x * r1.y + r1.x * this.y;
        int endResultDenominator = this.y * r1.y;

        return new RationalNumber(endResultNumerator, endResultDenominator);
    }

    public RationalNumber subract(RationalNumber r1) {
        int endResultNumerator = this.x * r1.y - r1.x * this.y;
        int endResultDenominator = this.y * r1.y;

        return new RationalNumber(endResultNumerator, endResultDenominator);
    }

    public RationalNumber mutiply(RationalNumber r1) {
        int endResultNumerator = this.x * r1.x;
        int endResultDenominator = this.y * r1.y;

        return new RationalNumber(endResultNumerator, endResultDenominator);
    }

    public RationalNumber divide(RationalNumber r1) {
        int endResultNumerator = this.x * r1.y;
        int endResultDenominator = this.y * r1.x;

        return new RationalNumber(endResultNumerator, endResultDenominator);
    }

    //Need help with it.
    public void print() {
        System.out.println(getNumerator() + "/" + getDenominator());

    }
}
