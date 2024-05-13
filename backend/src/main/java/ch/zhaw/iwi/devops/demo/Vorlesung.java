package ch.zhaw.iwi.devops.demo;

public class Vorlesung {

    private int id;
    private String name;
    private String description;
    private String dozent;

    public Vorlesung() {
    }
    
    public Vorlesung(int id, String name, String description, String dozent) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dozent = dozent;
    }

    public int getId() {
        return id;
    }    

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDozent() {
        return dozent;
    }
    
    public void setDozent(String dozent) {
		this.dozent = dozent;
    }
}
