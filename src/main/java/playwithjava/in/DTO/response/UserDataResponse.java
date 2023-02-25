package playwithjava.in.DTO.response;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserDataResponse {

    private Long id;
    private String name;
    private String email;
}
