package entrega2.co.uparking.solid.clean.entidades.entities;

public class ValetParking {


    private int id;
    private String name;
    private String typeDoc;
    private long numDoc;
    private int age;
    private String experience;
    private String state;

    public ValetParking() {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    public long getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(long numDoc) {
        this.numDoc = numDoc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ValetParking{" +
                "name='" + name + '\'' +
                ", typeDoc='" + typeDoc + '\'' +
                ", numDoc=" + numDoc +
                ", age=" + age +
                ", experience='" + experience + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
