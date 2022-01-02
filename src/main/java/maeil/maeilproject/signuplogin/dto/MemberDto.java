package maeil.maeilproject.signuplogin.dto;

import lombok.*;
import maeil.maeilproject.signuplogin.domain.entity.MemberEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter @Setter
@ToString
@NoArgsConstructor
public class MemberDto {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private Long id;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이내로 입력해주세요.")
    private String password;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public MemberEntity toEntity() {

        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
