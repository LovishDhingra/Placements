package DefaultPractise;

public interface Salaray {
    public double deducFoodFee();
    public final double Health_Insurance_Percentage=5.0;
    public default double deductHealthInsurancePremium(){
        // this method is not necessarily to be overriden by the classes that implements this interface
        // the advantage of using it is i want only full time employees cajn avail this opportunity as the
        //  part time class is also implements this interface so it will have to define this function which is not good
        
    }
}
