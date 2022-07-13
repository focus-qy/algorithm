package design;

public class Builder {
   public static class Person{
        private int id;
        private String name;
        private int age;
        private float weight;
        private int score;
        private Location location;

        private Person(){}

       static class Location{
           private String street;

           public Location(String street, String roomNo) {
               this.street = street;
               this.roomNo = roomNo;
           }

           private String roomNo;
       }
    }
   static class PersonBuild{
        private Person p = new Person();

        public Person build(){
            return  p;
        }
        public PersonBuild buildBasicInfo(int id,String name,int age){
            p.id = id;
            p.name = name;
            p.age = age;
            return  this;
        }

        public PersonBuild weight(float weight){
            p.weight = weight;
            return this;
        }
        public PersonBuild location(String street,String roomNo){
           Person.Location loc = new Person.Location(street,roomNo);
           p.location = loc;
           return this;
        }


    }

}

