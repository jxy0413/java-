package cn.test.druid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther jxy
 * @Date 2020-05-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String bookName;
    private String author;
}
