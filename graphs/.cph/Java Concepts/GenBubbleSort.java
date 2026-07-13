

import java.util.Comparator;
class Car implements Comparable<Car>{
    int speed;
    int model;
    String color;
    Car(int speed,int model,String color){
        this.speed=speed;
        this.model=model;
        this.color=color;
    }

    @Override
    public String toString(){
        return " Speed: "+this.speed + " Model : "+ this.model +" Color: " +this.color;
    } 

    @Override

    public int compareTo(Car other){

        // this is the problem that we have to comment down the other return sorting thats why use comparator in java
        // return this.speed-other.speed;
        // return other.model-this.model;
        return this.color.compareTo(other.color);
      
    }
}
class CarSpeedComparator implements Comparator<Car>{
    @Override
    public int compare(Car tcar,Car ocar){
        return tcar.speed-ocar.speed;
    }

}
class CarModelComparator implements Comparator<Car>{
    @Override
    public int compare(Car tcar,Car ocar){
        return ocar.model-tcar.model;
    }

}
class CarColorComparator implements Comparator<Car>{
    @Override
    public int compare(Car tcar,Car ocar){
        return tcar.color.compareTo(ocar.color);
    }

}
public class GenBubbleSort  {
    // public static <T extends Comparable<T>> void bubbleSort(T[]arr){
    public static <T> void bubbleSort(T[]arr,Comparator<T> comparator){
        for(int counter=0;counter<arr.length-1;counter++)
    {
        for(int j=0;j<arr.length-1;j++){
            // if(arr[j].compareTo(arr[j+1])>0){
            if(comparator.compare(arr[j], arr[j+1])>0){
                T temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
    }
    public static void main(String[] args) {
        
        Integer[]  arr={10,20,30,40,340};
        display(arr);
        String[] strArr={"this","is","so","good"};
        display(strArr);

        


        Car[] car=new Car[5];
        car[0]=new Car(1000,2002,"red");
        car[1]=new Car(2000,2004,"Black");
        car[2]=new Car(5000,2005,"Yellow");
        car[3]=new Car(500,2001,"grey");
        car[4]=new Car(100,2014,"White"); 
      bubbleSort(car,new CarSpeedComparator());
        display(car);
        bubbleSort(car, new CarColorComparator());
        display(car);
        bubbleSort(car,new CarModelComparator());
        display(car);


        }
        public static <T> void display(T[] arr){
             for(T val:arr){
                 System.out.println(val+" ");
             }
             System.out.println();
        }
   
       
}


// jab bhi hum class type ki chijh ko print krvate hain  to automattically Object class ka   toString function call ho jata
