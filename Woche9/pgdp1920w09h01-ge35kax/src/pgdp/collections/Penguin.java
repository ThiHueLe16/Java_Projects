package pgdp.collections;

public class Penguin {
    private final int birthYear;
    private final String name;
    private final Gender gender;
    private Fish favoriteFish;

    public Penguin(int birthYear, String name, Gender gender, Fish favoriteFish) {
        this.birthYear = birthYear;
        this.name = name;
        this.gender = gender;
        this.favoriteFish = favoriteFish;
    }

    public boolean equals(Object other) {
        // TODO
    	if(other==null|| !(other instanceof Penguin))
    		return false;
    	Penguin current =(Penguin) other;// cast other in Penguin 
        return birthYear==current.birthYear&& name==current.name && gender==current.gender;  
    }

    public int hashCode() {
        // TODO
    	
    	/*if(equals(this))
    		return 0;
        return -1;*/
    	
        return 53*Integer.hashCode(birthYear);
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Fish getFavoriteFish() {
        return favoriteFish;
    }

    public void setFavoriteFish(Fish favoriteFish) {
        this.favoriteFish = favoriteFish;
    }

}
