package com.pairprogramming.aboutbook.book.dto;

import com.pairprogramming.aboutbook.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private int id;
    private String title;
    private String author;
    private String publicationDate;
    private int isbn;

    @Autowired
    private static ModelMapper modelMapper;

    static {
        modelMapper=new ModelMapper();
    }
    public static Book convertDtoToEntity(BookDto bookDto) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(bookDto,Book.class);
    }
    public static BookDto convertEntityToDto(Book book){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(book,BookDto.class);
    }

}
