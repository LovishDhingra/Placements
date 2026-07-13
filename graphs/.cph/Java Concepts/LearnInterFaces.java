
 interface first{
   void Bprint();   

   int love=34;
   static void lo8vish(){
       System.out.println("bto");
   }

   interface third{
       void thridKaMunda();
   }
   interface fourth{
       void fourthKa();
   }
}


class balle {
    interface vth{
        void thka();
    }
}

public class LearnInterFaces implements first.fourth,first.third,balle.vth{
 
    public void Bprint(){
        System.out.println("hey bro interface is here");
        System.err.println(first.love);
    }
   public void thridKaMunda(){
        System.out.println("this is nevvxsted bro");
    }
   public void fourthKa(){
       System.out.println("fourth ka munds");
   }

   public void thka() {
       // TODO Auto-generated method stub
       System.out.println("kkgvhvvnvmm");
   }
 
  
      public static void main(String[] args) {
          LearnInterFaces obj=new LearnInterFaces();

          obj.thka();
        obj.Bprint();
       obj.thridKaMunda();
       obj.fourthKa();
         first.lo8vish();
        
      


}
   

 
    }