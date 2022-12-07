public class Hallyu {
    String name;

    void setName(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }

    boolean isTrueUser(String name){
        String[] users = {"강현진","김외대"}; // 주석6: 참조 타입(배열)
        for(String user:users){
            return name.equals(user);
        }
        return false;
    }

}
