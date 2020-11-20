package guru.springframework.sfgpetclinic.model;

public class PetType extends BaseEntity {
    public String getGetType() {
        return getType;
    }

    public void setGetType(String getType) {
        this.getType = getType;
    }

    private String getType;
}
