package com.example.phontest.Controller;



import com.example.phontest.Entity.EmployeeSearchBo;
import com.example.phontest.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.example.phontest.Repository.EmployeeRepository;
import com.example.phontest.Entity.Employee;

import java.util.List;

@Controller
public class EmployeeController {


    @Autowired
    final private EmployeeService employeeService;
//    @Autowired
    private EmployeeRepository eRepo;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({"/list"})
    public String listEmployee(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "formImployee/list-employees";
    }


    @GetMapping("/addEmployeeForm")
   public ModelAndView addEmployeeForm() {
       ModelAndView mav = new ModelAndView("formImployee/add-emplooyee-form");
        Employee newEmployee = new Employee();
        mav.addObject("employee", newEmployee);
      return mav;
   }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
       employeeService.saveEmployee(employee);
        return "redirect:/list";
    }
    @GetMapping("/home")
    public String home() {

        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployeeId(id);
        return "redirect:/list";
   }



    @PostMapping("/search")
    public ModelAndView searchEmployee(@ModelAttribute("someBean") EmployeeSearchBo req){
        if(!req.getSearchKey().isEmpty()){
            //List<Employee> employee = employeeService.findAllEmployeeBySearch(searchKey);
            ModelAndView mav = new ModelAndView("formImployee/list-employees");
            mav.addObject("employees", employeeService.findAllEmployeeBySearch(req.getSearchKey()));
            return mav;
        }
        return  null;
    }

}

