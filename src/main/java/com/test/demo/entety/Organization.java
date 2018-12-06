package com.test.demo.entety;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Organization {
    @Id
    private String id;
    private String externalId;
    private OrgType type;
    private String parentId;
}
