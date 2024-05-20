package ch.zhaw.iwi.devops.demo;

class ToDo {

    private int id;
    private String title;
    private String description;

    public ToDo() {
    }
    
    ToDo(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    int getId() {
        return id;
    }    

    void setId(int id) {
        this.id = id;
    }

    String getTitle() {
        return title;
    }

    String getDescription() {
        return description;
    }
    
}
