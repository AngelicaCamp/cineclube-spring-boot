package br.com.cineclube.controller;
import br.com.cineclube.dao.FilmeRepository;
import br.com.cineclube.model.Category;
import br.com.cineclube.model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping(value={"", "/", "filmes"})
public class FilmeController {

    @Autowired
    private FilmeRepository filmeDao;

    @PostMapping("/save")
    public String save(Filme filme, Model model){
        filmeDao.save(filme);

        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list( Model model){
        List<Filme> filmeList = filmeDao.findAll();
        model.addAttribute( "filmeList", filmeList);
        model.addAttribute("categories",Category.values());

        return  "filmes/list.html";
    }

    @RequestMapping("/new")
    public String newForm( Model model){
        Filme filme = new Filme();
        model.addAttribute("filme", filme);
        model.addAttribute("categories",Category.values());

        return  "filmes/manter.html";
    }

    @RequestMapping("/delete/{id}")
    public String deleteForm(Model model, @PathVariable Long id ){
            filmeDao.deleteById(id);

        return "redirect:/list";
    }

    @RequestMapping("/editar/{id}")
    public String editarForm (Model model, @PathVariable Long id){
        Filme filme = filmeDao.findById(id).orElse(null);
        model.addAttribute( "filme", filme);
        model.addAttribute("categories",Category.values());

        return "filmes/editar.html";
    }

    @PostMapping("/update")
    public String update(Filme filme){
        filme = filmeDao.save(filme);

        return "redirect:/list";
    }

    @RequestMapping("/home") //cadastro
    public String home( Model model){
        Calendar cal = Calendar.getInstance();
        //model - permite passar uma variavel para a view (html)
        model.addAttribute("today", cal.getTime());
        return  "index.html";
    }


}
