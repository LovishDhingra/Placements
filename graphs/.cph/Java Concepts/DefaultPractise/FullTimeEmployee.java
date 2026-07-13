package DefaultPractise;

public class FullTimeEmployee extends Employee {
        //field declarations
        public double calculateSalary() {
            // calculating salary - full-time employeee
        }
     
        public double deductFoodFee() {
            // deducting food fee - full-time employeee
        }
        
        public double deductHealthInsurancePremium() {    //  Default method getting overridden
            return (HEALTH_INSURANCE_PERCENTAGE * employeeSalary) / 100;
        }
    }
    