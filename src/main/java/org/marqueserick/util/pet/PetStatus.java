package org.marqueserick.util.pet;

public enum PetStatus {
    DISPONIVEL("DISPONIVEL"), PENDENTE("PENDENTE"), VENDIDO("VENDIDO");

    private String status;
    PetStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

}
