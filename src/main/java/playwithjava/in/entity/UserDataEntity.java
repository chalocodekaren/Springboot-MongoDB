package playwithjava.in.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("user_data")
public class UserDataEntity {

    @Id
   // @Field(name = "ID")
    private Long id;

   // @Field(name = "NAME")
    private String name;

   // @Field(name = "EMAIL")
    private String email;
}
