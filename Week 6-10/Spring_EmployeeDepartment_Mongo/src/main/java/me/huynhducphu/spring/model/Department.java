package me.huynhducphu.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Admin 9/21/2025
 *
 **/
@Document(collection = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    @Id
    private String id;

    private String name;
}
