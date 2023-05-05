package com.example.dormitory_manager.Controller;


import com.example.dormitory_manager.entities.Blog;
//import com.example.dormitory_manager.entities.Room;
import com.example.dormitory_manager.repositories.BlogRepository;
import com.example.dormitory_manager.services.BlogService;
import com.example.dormitory_manager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.security.Provider;
import java.util.Optional;

@Controller
public class BlogController {
	@Autowired
    BlogRepository blogRepository;

    @Autowired
    private UserService UserService;

    @Autowired
    private BlogService blogService;


//    @GetMapping("/blog")
//    public String homepageBlog(Model model){
//        model.addAttribute("blogs", blogRepository.findAllBlog());
//        return "Blog/blog";
//    }

//    private String getPrincipal(){
//       String userName = null;
//       Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//           userName = ((UserDetails)principal).getUsername();
//
//        } else {
//            userName = principal.toString();
//        }
//       return userName;
//   }


    @GetMapping("/all-blog")
    public String Blog(Model model){
        model.addAttribute("blogs", blogRepository.findAllBlog());
        return "Blog/all-blog";
    }

    @Value("C:/ListRoom/file/")
    private String fileUpload;

    @GetMapping("/createBlog")
    public String showFormCreateRoom( Model model){

        Blog blog = new Blog();

        model.addAttribute("blog", blog);

        return "Blog/add-blog";
    }

    @PostMapping("/saveBlog")
    public String saveRoom(Model model, @ModelAttribute("blog") Blog blog, RedirectAttributes redirect){
      
//        MultipartFile multipartFile = blog.getImage();
//        String fileName = multipartFile.getOriginalFilename();
//
//        try {
//            FileCopyUtils.copy(blog.getImage().getBytes(), new File(fileUpload + fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        blog.setImgSrc(fileName);
//        blog.setUser(UserService.findByUserName(getPrincipal()));
//
        blogRepository.save(blog);
        return "redirect:all-blog";
    }

    @GetMapping("/edit/{id}")
    public String findBlogById(@PathVariable("id") long id , Model model){
        model.addAttribute("blog", blogRepository.findById(id).get());

        return "/Blog/edit-blog";
    }


//    @GetMapping("/viewDetailBlog/{id}")
//    public String viewDetailBlog(@PathVariable("id") long id , Model model){
//        model.addAttribute("blog", blogRepository.findById(id).get());
//
//        return "Blog/blog-details";
//    }

    @PostMapping("/saveEditBlog")
    public String updateBlog(@ModelAttribute Blog blog){

//        MultipartFile multipartFile = blog.getImage();
//        String fileName = multipartFile.getOriginalFilename();
//
//        try {
//            FileCopyUtils.copy(blog.getImage().getBytes(), new File(fileUpload + fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        blog.setImgSrc(fileName);
        blogRepository.save(blog);


        return "redirect:/all-blog";
    }

    @GetMapping("/deleteBlog")
    public String deleteBlogById(long id){
        blogRepository.deleteById(id);
        return "redirect:/all-blog";
    }
	
}
