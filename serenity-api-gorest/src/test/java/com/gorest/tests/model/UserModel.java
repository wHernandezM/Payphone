
package com.gorest.tests.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private String name;
    private String gender;
    private String email;
    private String status;
}
