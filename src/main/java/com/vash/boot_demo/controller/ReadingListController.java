package com.vash.boot_demo.controller;

import com.vash.boot_demo.dao.ReadingListRepository;
import com.vash.boot_demo.entity.Book;
import com.vash.boot_demo.property.AmazonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
/**
 * 如果单独加入此注解，将对应属性在application-dev.yml中定义，是可以取到并赋值给associateId的
 * 此注解下的红线报错不影响
 *
 * */
@ConfigurationProperties
@PropertySource(value = "classpath:application-dev.yml")
public class ReadingListController {

    // TODO: 2020/1/2 优化后，使用yml中对应的property类进行操作
//    @Value("#{associateId}")
//    private String associateId;

    private ReadingListRepository readingListRepository;

    private AmazonProperty amazonProperty;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks( @PathVariable("reader") String reader,Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }

//    @Autowired
//    public ReadingListController(ReadingListRepository readingListRepository, AmazonProperty amazonProperty) {
//        this.readingListRepository = readingListRepository;
//        this.amazonProperty = amazonProperty;
//    }

    /*public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }*/


//    @GetMapping("/{reader}")
//    public String readersBooks(@PathVariable String reader, Model model) {
//        List<Book> readingList = readingListRepository.findByReader(reader);
//        if (CollectionUtils.isEmpty(readingList)) {
//            readingList = new ArrayList<>();
//        }
//        System.err.println(readingList);
//        System.err.println(reader);
//        System.err.println(amazonProperty.getAssociateId());
//        model.addAttribute("books", readingList);
//        model.addAttribute("reader", reader);
//        model.addAttribute("amazonId", amazonProperty.getAssociateId());
//
//        return "readingList";
//    }

//    @PostMapping("/{reader}")
//    public String addToReadingList(Book book, @PathVariable String reader) {
//        book.setReader(reader);
//        readingListRepository.save(book);
//        return "redirect:/{reader}";
//    }
}
