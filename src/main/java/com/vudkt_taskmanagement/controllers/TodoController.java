package com.vudkt_taskmanagement.controllers;

import com.vudkt_taskmanagement.models.Todo;
import com.vudkt_taskmanagement.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping
    public String index(Model model) {
        ArrayList<Todo> todoList = (ArrayList<Todo>) todoService.getAll();
        model.addAttribute("todoList", todoList);
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("todo", new Todo());
        return "create";
    }

    @PostMapping("/create")
    public String store(@ModelAttribute Todo todo, RedirectAttributes redirectAttributes) {
        boolean check = todoService.createOrUpdate(todo);
        if (check) {
            redirectAttributes.addFlashAttribute("message", "Create Successfull");
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("message", "Something Wrong");
        return "redirect:/create";
    }

    @GetMapping("/update/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Todo todo) {
        if (!todoService.createOrUpdate(todo)) {
            return "redirect:/update/" + todo.getId();
        }
        return "redirect:/";
    }

    @PostMapping("/completed/{id}")
    public String completed(@PathVariable Long id) {
        if (todoService.updateCompleted(id)) {
            return "redirect:/";
        }
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String destroy(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (todoService.delete(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Successfull");
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("message", "Fail to Delete");
        return "redirect:/";
    }
}
