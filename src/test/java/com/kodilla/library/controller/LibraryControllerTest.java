package com.kodilla.library.controller;

import com.google.gson.*;
import com.kodilla.library.domain.*;
import com.kodilla.library.config.*;
import com.kodilla.library.mapper.BookDescriptionMapper;
import com.kodilla.library.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.swing.text.StyledEditorKit;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(LibraryController.class)
public class LibraryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DbService service;

    @MockBean
    BookDescriptionMapper descriptionMapper;

    @Test
    public void testgetBookDescription() throws Exception {
        //given
        List<BookDescription> descriptionList = new ArrayList<>();
        descriptionList.add(new BookDescription(0L,"książka nr 1","autor 1",2018));
        List<BookDescriptionDto> descriptionDtoList = new ArrayList<>();
        descriptionDtoList.add(new BookDescriptionDto(0L,"książka nr 1","autor 1",2018));

        when(service.getAllTBookDescription()).thenReturn(descriptionList);
        when(descriptionMapper.mapToBookDescriptionDtoList(descriptionList)).thenReturn(descriptionDtoList);

        //when & then
        mockMvc.perform(get("/library/getBooksDesc")
                .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$",hasSize(1)))
                    .andExpect(jsonPath("$[0].idTitle", is(0)))
                    .andExpect(jsonPath("$[0].title",is("książka nr 1")))
                    .andExpect(jsonPath("$[0].author", is("autor 1")))
                    .andExpect(jsonPath("$[0].yearOfPublication", is(2018)));

    }

    @Test
    public void testcreateBookDescription() throws Exception {
        //given
        BookDescriptionDto descriptionDto = new BookDescriptionDto(0L,"książka nr 2","autor 2", 2018);
        BookDescription description = new BookDescription(0L,"książka nr 2","autor 2", 2018);


        when(descriptionMapper.mapToBookDescription(ArgumentMatchers.any(BookDescriptionDto.class))).thenReturn(description);
        when(service.saveBookDescription(description)).thenReturn(description);
        when(descriptionMapper.mapToBookDescriptionDto(description)).thenReturn(descriptionDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(descriptionDto);

        //when & then
        mockMvc.perform(post("/library/createBookDescription")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                    .andExpect(jsonPath("$.idTitle",is(0)))
                    .andExpect(jsonPath("$.title",is("książka nr 2")))
                    .andExpect(jsonPath("$.author", is("autor 2")))
                    .andExpect(jsonPath("$.yearOfPublication", is(2018)));
    }

    @Test
    public void testcreateReader() throws Exception {
        //given
        Reader reader = new Reader(0L,"name 1","last name 1","1975-07-12");
        ReaderDto readerDto = new ReaderDto(0L,"name 1","last name 1","1975-07-12");

        when(descriptionMapper.mapToReader(ArgumentMatchers.any(ReaderDto.class))).thenReturn(reader);
        when(service.saveReader(reader)).thenReturn(reader);
        when(descriptionMapper.mapToReaderDto(reader)).thenReturn(readerDto);
        Gson gson = new Gson();
         String jsonContent = gson.toJson(readerDto);

        //when & then
        mockMvc.perform(post("/library/createReader")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.idReader",is(0)))
                .andExpect(jsonPath("$.firstNameReader",is("name 1")))
                .andExpect(jsonPath("$.lastNameReader",is("last name 1")))
                .andExpect(jsonPath("$.dateOfAccountCreation",is("1975-07-12")));

    }

    @Test
    public void testcreateBook() throws Exception{
        //given
        BookDescription description = new BookDescription(1L,"Title 1", "Author 1",2009);
        BookDescriptionDto descriptionDto = new BookDescriptionDto(1L,"Title 1", "Author 1",2009);
        Book book = new Book(0L, StatusBookDesc.Circulation.getStatus(), description);
        BookDto bookDto = new BookDto(0L, StatusBookDesc.Circulation.getStatus(), descriptionDto);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(bookDto);

        when(descriptionMapper.mapToBook(ArgumentMatchers.any(BookDto.class))).thenReturn(book);
        when(service.saveBook(book)).thenReturn(book);
        when(descriptionMapper.mapToBookDto(book)).thenReturn(bookDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto);


        //when then
        mockMvc.perform(post("/library/createBook")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(jsonContent))
                .andExpect(jsonPath("$.idBook",is(0)))
                .andExpect(jsonPath("$.status", is(StatusBookDesc.Circulation.getStatus())));
    }

    @Test
    public void testgetBook() throws Exception{
        BookDescription description = new BookDescription(1L,"Title 1", "Author 1",2009);
        BookDescriptionDto descriptionDto = new BookDescriptionDto(1L,"Title 1", "Author 1",2009);

        Book book = new Book(0L, StatusBookDesc.Circulation.getStatus(), description);
        BookDto bookDto = new BookDto(0L, StatusBookDesc.Circulation.getStatus(), descriptionDto);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(bookDto);

        when(service.findBooksByIdTitleAndStatus(ArgumentMatchers.any(BookDescription.class),ArgumentMatchers.any(String.class))).thenReturn(bookList);
        when(descriptionMapper.mapToBookDtoList(bookList)).thenReturn(bookDtoList);

        //when then
        mockMvc.perform(get("/library/getBooks")
                .param("idTitle","1")
                .param("status","w obiegu")
                .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$",hasSize(0)))
                    .andExpect(jsonPath("$[0].idBook",is(0)))
                    .andExpect(jsonPath("$[0].status",is("w obiegu")));
    }

    @Test
    public void testupdateStatusBook() throws Exception{
        //given
        BookDescription description = new BookDescription(1L,"Title 1", "Author 1",2009);
        BookDescriptionDto descriptionDto = new BookDescriptionDto(1L,"Title 1", "Author 1",2009);
        Book book = new Book(0L, StatusBookDesc.Circulation.getStatus(), description);
        BookDto bookDto = new BookDto(0L, StatusBookDesc.Circulation.getStatus(), descriptionDto);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(bookDto);

        when(descriptionMapper.mapToBook(ArgumentMatchers.any(BookDto.class))).thenReturn(book);
        when(service.saveBook(book)).thenReturn(book);
        when(descriptionMapper.mapToBookDto(book)).thenReturn(bookDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto);


        //when then
        mockMvc.perform(put("/library/updateStatusBook")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.idBook",is(0)))
                .andExpect(jsonPath("$.status", is(StatusBookDesc.Circulation.getStatus())));
    }

}