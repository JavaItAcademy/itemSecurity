package kg.itacademy.itemSecurity.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Item {
    Long id;
    @NotEmpty(message = "*Please provide a name")
    String name;
    @Email(message = "*Please provide valid email")
    String email;
    String category;
}
