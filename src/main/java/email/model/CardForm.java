package email.model;

public class CardForm {
    private String name;
    private String surname;
    private String disease;

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

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "CardForm{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", disease='" + disease + '\'' +
                '}';
    }
}
