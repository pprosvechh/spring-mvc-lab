package email.model;

public class MedicationForm {
    private String medicament;
    private String instruction;

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "MedicationForm{" +
                "medicament='" + medicament + '\'' +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
