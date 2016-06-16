package masterTable;

/**
 * Created by TIMBULI REMUS K@puc!n on 08-Jun-16.
 */
public class Persons {

    // Details variables------------------------------------------------------------------------------------------------
    private String name, surname, post;
    private int ID, team;
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public Persons(String name, String surname, String post, int ID, int team) {
        this.name = name;
        this.surname = surname;
        this.post = post;
        this.ID = ID;
        this.team = team;
    }
    //------------------------------------------------------------------------------------------------------------------

    // Getters & Setters------------------------------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
    //------------------------------------------------------------------------------------------------------------------
}
