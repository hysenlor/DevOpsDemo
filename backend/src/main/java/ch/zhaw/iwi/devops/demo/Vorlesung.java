package ch.zhaw.iwi.devops.demo;

class Vorlesung {

    private int id;
    private String name;
    private String description;
    private String dozent;

    Vorlesung() {
    }
    
    public Vorlesung(int id, String name, String description, String dozent) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dozent = dozent;
    }

    int getId() {
        return id;
    }    

    void setId(int id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    String getDozent() {
        return dozent;
    }
    
    void setDozent(String dozent) {
		this.dozent = dozent;
    }
}
