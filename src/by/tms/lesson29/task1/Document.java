package by.tms.lesson29.task1;

import java.time.LocalDate;
import java.util.Objects;

public class Document {

    private String contractNumber;
    private LocalDate date;

    public Document(String contractNumber, LocalDate date) {
        this.contractNumber = contractNumber;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Document{" +
                "contractNumber='" + contractNumber + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(getContractNumber(), document.getContractNumber()) && Objects.equals(getDate(), document.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContractNumber(), getDate());
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
