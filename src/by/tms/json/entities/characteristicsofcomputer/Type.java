package by.tms.json.entities.characteristicsofcomputer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Type {

    private boolean peripheral;
    private double energyConsumption;
    private boolean cooler;

    @JsonCreator
    public Type(
            @JsonProperty("peripheral") boolean peripheral,
            @JsonProperty("energyConsumption") double energyConsumption,
            @JsonProperty("cooler") boolean cooler) {
        this.peripheral = peripheral;
        this.energyConsumption = energyConsumption;
        this.cooler = cooler;
    }

    public boolean isPeripheral() {
        return peripheral;
    }

    public void setPeripheral(boolean peripheral) {
        this.peripheral = peripheral;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public boolean isCooler() {
        return cooler;
    }

    public void setCooler(boolean cooler) {
        this.cooler = cooler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return peripheral == type.peripheral && Double.compare(type.energyConsumption, energyConsumption) == 0 && cooler == type.cooler;
    }

    @Override
    public int hashCode() {
        return Objects.hash(peripheral, energyConsumption, cooler);
    }

    @Override
    public String toString() {
        return "Type{" +
                "peripheral=" + peripheral +
                ", energyConsumption=" + energyConsumption +
                ", cooler=" + cooler +
                '}';
    }
}
