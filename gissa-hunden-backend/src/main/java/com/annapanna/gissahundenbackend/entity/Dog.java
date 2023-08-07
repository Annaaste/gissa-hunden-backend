package com.annapanna.gissahundenbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(name = "dog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String breed;

    @Column
    private String dog_name;

    @Column
    private String anecdote;

    @Column
    @Lob // Use Lob annotation for large objects like images
    private byte[] image;

    @Column
    private String alt_text;

    @Column
    private String category;

    @Column(name="created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}


   /* <?xml version="1.0" encoding="UTF-8"?>
<project version="4">
<component name="VcsDirectoryMappings">
<mapping directory="$PROJECT_DIR$/.." vcs="Git" />
<mapping directory="$PROJECT_DIR$" vcs="Git" />
</component>
</project>*/

