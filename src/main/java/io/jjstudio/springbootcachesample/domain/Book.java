package io.jjstudio.springbootcachesample.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TABLE_BOOK")
public class Book {

    @Id
    private String isbn;
    private String name;
    private boolean isInStock;
    private boolean isUsed;
}
