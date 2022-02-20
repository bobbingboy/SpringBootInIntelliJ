package com.bobbingboy.springbootdemo.web;

import com.bobbingboy.springbootdemo.domain.Book;
import com.bobbingboy.springbootdemo.resource.exception.BookNotFoundException;
import com.bobbingboy.springbootdemo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping("/books")
    public String list(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                       Model model) {
//        List<Book> bookList = bookService.findAll();
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        Page<Book> page1 = bookService.findAllByPage(PageRequest.of(page, size, sort));
        Page<Book> page1 = bookService.findAllByPage(pageable);
        model.addAttribute("page", page1);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        if (book == null) {
            throw new BookNotFoundException("Information not found.");
        }
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/books/input")
    public String inputPage(Model model) {
        model.addAttribute("book", new Book());
        return "input";
    }

    //jump to update page
    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "input";
    }

    //submit a data then redirect to the page with search all data as list.
    @PostMapping("/books")
    public String post(Book book, final RedirectAttributes attributes) {
        Book book1 = bookService.add(book);
        if (book1 != null) {
            attributes.addFlashAttribute("message", "<" + book1.getName() + "> submit success!!");
        }

        return "redirect:/books";
        //use redirect + /xxxx to implement redirect to that page.
    }

    // POST ----> redirect ----> GET

    @GetMapping("/books/{id}/delete")
    public String delete(@PathVariable long id, final RedirectAttributes attributes) {
        bookService.deleteOne(id);
        attributes.addFlashAttribute("message", "delete success!!");
        return "redirect:/books";
    }

    @ExceptionHandler({Exception.class})
    public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Request URL : {}, Exception : {}" , request.getRequestURL(), e.getMessage());

        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("url", request.getRequestURL());
        mav.addObject("exception", e);
        mav.setViewName("error/error");

        return mav;
    }

}
