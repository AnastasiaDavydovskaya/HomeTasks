package by.tms.lesson42_task1.entities;

import by.tms.lesson42_task1.validation.NumberOfGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Positive(message = "Id cannot be negative number")
    private Long id;
    @Size(min = 1, max = 50, message = "First name length should be between 1 to 50 characters")
    private String firstName;
    @Size(min = 1, max = 100, message = "Last name length should be between 1 to 100 characters")
    private String lastName;
    @NumberOfGroup(message = "Number of group length should be between 3 to 20 characters and contains '-'")
    private String numberOfGroup;
    @Digits(integer = 2, fraction = 2, message = "GPA should be contain up to 2 integers and 2 fractions")
    private Double GPA;
}
