package org.wecancodeit.myfavoriteproducers;

public class Producer {

    private  Long id;
    private  String name;
    private  String description;
    private  String awards;
    private  String hits;



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAwards() {
        return awards;
    }

    public String getHits() {
        return hits;
    }

    public Producer(Long id, String name, String description, String awards, String hits){
        this.id=id;
        this.name= name;
        this.description= description;
        this.awards= awards;
        this.hits= hits;
    }



}
