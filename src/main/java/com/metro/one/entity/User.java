package com.metro.one.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.metro.one.utils.enums.DocumentTypeEnum;
import com.metro.one.utils.enums.UserRoleEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Flux;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("users")
public class User {

    @Id
    @Column("user_id")
    private Long userId;

    private String name;

    @Column("last_name")
    private String lastName;

    @Column("document_type")
    private String documentType;

    private Long documentNumber;

    private String password;

    private Integer phone;

    private String email;

    @Column("card_number")
    private Long cardNumber;

    private String role;

    @JsonIgnore
    @Transient
    private Flux<TransportCard> transportCards; //METROPOLITANO LINEA 1,LINEA 2

    @Transient
    @JsonIgnore
    private Flux<BankCard> bankCards; //VISA,MASERCARD,AMEX



}
